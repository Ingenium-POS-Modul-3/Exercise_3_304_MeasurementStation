package at.measurement;

import at.measurement.station.BaseStation;
import at.measurement.station.TempStation;
import at.measurement.station.WindStation;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Runner {

  private List<Entry<Thread, BaseStation>> threadList = new ArrayList<>();

  public Runner(){

  }

  public void runTillQuit(){
    threadList.add(startThread(new WindStation()));
    threadList.add(startThread(new TempStation()));

    Scanner scanner = new Scanner(System.in);

    System.err.println("End all Stations with q + ENTER: ");
    scanner.next();
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

  public static void main(String[] args) {
    new Runner().runTillQuit();
  }

}
