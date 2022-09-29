package at.measurement;

import at.measurement.station.BaseStation;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class StationsRunner {

  private final List<Entry<Thread, BaseStation>> threadList = new ArrayList<>();

  public StationsRunner(){

  }

  public void addStation(BaseStation station){
    threadList.add(startThread(station));
  }

  public void runTillQuit(){
    System.err.println("End all Stations with ENTER: ");
    try {
      //noinspection ResultOfMethodCallIgnored
      System.in.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.err.println("Ending...");

    try {
      for (Entry<Thread,BaseStation> entry:threadList) {
        entry.getValue().end();
      }
      for (Entry<Thread,BaseStation> entry:threadList) {
        entry.getKey().join();
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static Entry<Thread, BaseStation> startThread(BaseStation b){
    Thread t = new Thread(b);
    t.start();
    return new SimpleEntry<>(t, b);
  }

}
