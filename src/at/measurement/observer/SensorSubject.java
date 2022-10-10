package at.measurement.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class SensorSubject {

  private List<SensorObserver> observerList = new ArrayList<>();

  public void addObserver(SensorObserver observer){
    observerList.add(observer);
  }

  public void removeObserver(SensorObserver observer){
    observerList.remove(observer);
  }

  public void notifyObserver(String name, float value){
    for(SensorObserver o : observerList){
      o.notify(name, value);
    }
  }

}
