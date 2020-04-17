package es.ulpgc.eite.cleancode.advclickcounter.counters;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class CounterListPresenter implements CounterListContract.Presenter {

  public static String TAG = CounterListPresenter.class.getSimpleName();

  private WeakReference<CounterListContract.View> view;
  private CounterListState state;
  private CounterListContract.Model model;
  private CounterListContract.Router router;

  public CounterListPresenter(CounterListState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new CounterListState();
    }

    /*
    // use passed state if is necessary
    CounterListState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.data);
    }
    */
  }

  @Override
  public void onRestart() {
    // Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.data);
  }

  @Override
  public void onResume() {
    // Log.e(TAG, "onResume()");

    // use passed state if is necessary
    ClickToCounterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      //model.onDataFromNextScreen(savedState.data);
    }

    // call the model and update the state
    state.data = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    // Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onCounterButtonPressed() {
    List<CounterData> nuevoCounter = model.addNewCounter(state.datasource);
    state.datasource = nuevoCounter;
    view.get().onDataUpdated(state);
  }

  @Override
  public void selectCounterItem(CounterData counter) {
    CounterToClickState counterToClickState = new CounterToClickState(counter.clicks);
    router.passStateToNextScreen(counterToClickState);
    router.navigateToNextScreen();
  }

  @Override
  public void injectView(WeakReference<CounterListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CounterListContract.Router router) {
    this.router = router;
  }
}
