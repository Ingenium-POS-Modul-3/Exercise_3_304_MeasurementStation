package at.measurement;

import at.measurement.station.TempStation;
import at.measurement.station.WindStation;

public class StationsRunnerTester {

  public static void main(String[] args) {
    StationsRunner runner = new StationsRunner();

    runner.addStation(new WindStation());
    runner.addStation(new TempStation());

    runner.runTillQuit();
  }
}
