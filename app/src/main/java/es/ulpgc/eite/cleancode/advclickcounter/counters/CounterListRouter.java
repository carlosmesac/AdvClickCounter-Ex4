package es.ulpgc.eite.cleancode.advclickcounter.counters;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.clicks.ClickListActivity;

public class CounterListRouter implements CounterListContract.Router {

  public static String TAG = CounterListRouter.class.getSimpleName();

  private AppMediator mediator;

  public CounterListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ClickListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passStateToNextScreen(CounterToClickState state) {
    mediator.setCounterToClickState(state);
  }

  /*
  @Override
  public void passStateToPreviousScreen(CounterListState state) {
    mediator.setPreviousCounterScreenState(state);
  }

  @Override
  public CounterListState getStateFromPreviousScreen() {
    return mediator.getPreviousCounterScreenState();
  }
  */

  @Override
  public ClickToCounterState getStateFromNextScreen() {
    return mediator.getNextCounterScreenState();
  }
}
