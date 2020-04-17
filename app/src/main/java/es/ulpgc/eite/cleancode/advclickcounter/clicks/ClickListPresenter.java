package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class ClickListPresenter implements ClickListContract.Presenter {

  public static String TAG = ClickListPresenter.class.getSimpleName();

  private WeakReference<ClickListContract.View> view;
  private ClickListState state;
  private ClickListContract.Model model;
  private ClickListContract.Router router;

  public ClickListPresenter(ClickListState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    // Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ClickListState();
    }

    // use passed state if is necessary
    CounterToClickState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {
      state.counterData = savedState.counterData;
      state.datasource = savedState.counterData.clicks;
      // update the model if is necessary
      //model.onDataFromPreviousScreen(savedState.counterData);
    }
    view.get().onDataUpdated(state);
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

    /*
    // use passed state if is necessary
    ClickListState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromNextScreen(savedState.data);
    }
    */

    // call the model and update the state
    state.data = model.getStoredData();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");
    ClickToCounterState clickToCounterState = new ClickToCounterState(state.counterData);
    router.passStateToPreviousScreen(clickToCounterState);
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
  public void onClickButtonPressed() {
    List<ClickData> newList = model.addNewClickObject(state.datasource);
    state.datasource = newList;
    view.get().onDataUpdated(state);
  }

  @Override
  public void globalValueAdd() {
    state.counterData.value++;
    Log.d(TAG, String.valueOf(state.value));
  }


  @Override
  public void injectView(WeakReference<ClickListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ClickListContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ClickListContract.Router router) {
    this.router = router;
  }
}
