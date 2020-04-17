package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.app.ClickToCounterState;
import es.ulpgc.eite.cleancode.advclickcounter.app.CounterToClickState;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public interface ClickListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ClickListViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onClickButtonPressed();

    void itemClicked(ClickData data);
  }

  interface Model {
    String getStoredData();

    void onDataFromNextScreen(String data);

    void onRestartScreen(String data);

    void onDataFromPreviousScreen(List<ClickData> data);

      List<ClickData> addNewClickObject(List<ClickData> datasource);

    ClickData increaseItemValue(ClickData value);
  }

  interface Router {
    //void navigateToNextScreen();

    //void passStateToNextScreen(ClickListState state);

    CounterToClickState getStateFromPreviousScreen();

    //ClickListState getStateFromNextScreen();

    void passStateToPreviousScreen(ClickToCounterState state);
  }
}
