package es.ulpgc.eite.cleancode.advclickcounter.app;

import java.util.List;
import java.util.Objects;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class ClickToCounterState {

  public CounterData counterData;
  public ClickToCounterState(CounterData counterData) {
    this.counterData = counterData;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ClickToCounterState that = (ClickToCounterState) obj;
    return Objects.equals(counterData, that.counterData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(counterData);
  }

  @Override
  public String toString() {
    return "counterData: " + counterData;
  }
}
