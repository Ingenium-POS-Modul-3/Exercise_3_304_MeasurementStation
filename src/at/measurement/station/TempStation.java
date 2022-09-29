package at.measurement.station;

import java.util.Random;

public class TempStation extends BaseStation{
  private Random rand = new Random();
  @Override
  public void doStationWork() {
    float temp = rand.nextFloat()*40 - 10;
    System.out.printf("Temperature: %.2f %n", temp);
  }
}
