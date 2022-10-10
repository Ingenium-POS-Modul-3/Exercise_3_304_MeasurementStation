package at.measurement.station;

import at.measurement.observer.SensorSubject;
import at.receiver.FileLogger;
//import at.receiver.GraphicResult;
//import java.io.IOException;
import java.util.Random;

public class WindStation extends BaseStation {
  private Random rand = new Random();

//  private GraphicResult gr = new GraphicResult();
//  private FileLogger fl;

//  public WindStation(){
//    try{
//      fl = new FileLogger("windstation.log");
//    }catch(Exception e){
//      e.printStackTrace(); // gibt im Fehlerfall den Aufrufbaum aus
//    }
//  }


  @Override
  public void doStationWork() {
    float windSpeed = rand.nextFloat() * 50 +5;
    System.out.printf("Windspeed: %.2f %n", windSpeed);

    notifyObserver("Wind Station", windSpeed);

//    gr.logResult("Wind Station", windSpeed);
//    fl.logResult("Wind Station", windSpeed);
  }

}
