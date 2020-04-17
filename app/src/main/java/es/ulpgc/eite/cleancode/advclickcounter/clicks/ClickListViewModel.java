package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;
import es.ulpgc.eite.cleancode.advclickcounter.data.CounterData;

public class ClickListViewModel {

  // put the view state here
  public String data;
  public List<ClickData> datasource = new ArrayList<>();
  public int value;
  public CounterData counterData = new CounterData();
}
