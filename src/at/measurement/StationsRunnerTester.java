package at.measurement;

import at.measurement.station.TempStation;
import at.measurement.station.WindStation;
import at.receiver.FileLogger;
import at.receiver.GraphicResult;
import java.io.IOException;

public class StationsRunnerTester {

  public static void main(String[] args) {
    StationsRunner runner = new StationsRunner();

    WindStation w = new WindStation();
    w.addObserver(new GraphicResult());
    w.addObserver(new GraphicResult());
    w.addObserver(new GraphicResult());

    TempStation t = new TempStation();
    t.addObserver(new GraphicResult());
    try {
      t.addObserver(new FileLogger("temp.txt"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    runner.addStation(w);
    runner.addStation(t);

    runner.runTillQuit();
  }
}
