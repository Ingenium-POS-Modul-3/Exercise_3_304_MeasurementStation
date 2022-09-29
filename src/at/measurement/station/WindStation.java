package at.measurement.station;

import at.receiver.GraphicResult;
import java.util.Random;

public class WindStation extends BaseStation{
  private Random rand = new Random();
  @Override
  public void doStationWork() {
    float windSpeed = rand.nextFloat() * 50 +5;
    System.out.printf("Windspeed: %.2f %n", windSpeed);
  }

}
