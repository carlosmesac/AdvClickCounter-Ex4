package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import es.ulpgc.eite.cleancode.advclickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;

public class ClickListRouter implements ClickListContract.Router {

  public static String TAG = ClickListRouter.class.getSimpleName();

  private AppMediator mediator;

  public ClickListRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passStateToPreviousScreen(ClickToCounterState state) {
    mediator.setPreviousClickScreenState(state);
  }

  @Override
  public CounterToClickState getStateFromPreviousScreen() {
    CounterToClickState counterToClickState = mediator.getCounterToClickState();
    return counterToClickState;
  }

  /*
  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ClickListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }


  @Override
  public ClickListState getStateFromNextScreen() {
    return mediator.getNextClickScreenState();
  }


  @Override
  public void passStateToNextScreen(ClickListState state) {
    mediator.setNextClickScreenState(state);
  }
  */


}
