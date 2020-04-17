package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class ClickListModel implements ClickListContract.Model {

  public static String TAG = ClickListModel.class.getSimpleName();

  private String data;

  public ClickListModel(String data) {
    this.data = data;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredData()");
    return data;
  }

  @Override
  public void onRestartScreen(String data) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(List<ClickData> data) {
    // Log.e(TAG, "onDataFromPreviousScreen()");

  }

  @Override
  public List<ClickData> addNewClickObject(List<ClickData> datasource) {
    datasource.add(new ClickData());
    return datasource;
  }

  @Override
  public ClickData increaseItemValue(ClickData value) {
    value.value++;
    return value;
  }
}
