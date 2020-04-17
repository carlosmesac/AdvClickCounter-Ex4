package es.ulpgc.eite.cleancode.advclickcounter.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.advclickcounter.clicks.ClickListState;
import es.ulpgc.eite.cleancode.advclickcounter.counters.CounterListState;

public class AppMediator extends Application {

  private CounterListState counterListState;
  private ClickListState clickListState;

  private CounterToClickState counterToClickState;
  private ClickToCounterState clickToCounterState;

  public CounterToClickState getCounterToClickState() {
    return counterToClickState;
  }

  public void setCounterToClickState(CounterToClickState counterToClickState) {
    this.counterToClickState = counterToClickState;
  }

  public ClickToCounterState getClickToCounterState() {
    return clickToCounterState;
  }

  public void setClickToCounterState(ClickToCounterState clickToCounterState) {
    this.clickToCounterState = clickToCounterState;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    counterListState = new CounterListState();
    clickListState = new ClickListState();
  }

  public CounterListState getCounterListState() {
    return counterListState;
  }

  public ClickListState getClickListState() {
    return clickListState;
  }

  public void setNextCounterScreenState(CounterToClickState state) {

  }

  public ClickToCounterState getNextCounterScreenState() {
    return clickToCounterState;
  }

  public void setPreviousClickScreenState(ClickToCounterState state) {
    this.clickToCounterState = state;
  }

  public CounterToClickState getPreviousClickScreenState() {
    return null;
  }
}
