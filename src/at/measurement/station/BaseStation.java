package at.measurement.station;

import at.measurement.observer.SensorSubject;

public abstract class BaseStation extends SensorSubject implements Runnable{
  private boolean isEnd = false;

  public void end(){
    isEnd = true;
  }

  public abstract void doStationWork();

  @Override
  public void run() {
    while(!isEnd){
      doStationWork();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
