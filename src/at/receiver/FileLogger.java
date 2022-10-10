package at.receiver;

import at.measurement.observer.SensorObserver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements SensorObserver {

  private BufferedWriter bw;

  public FileLogger(String path) throws IOException {
    bw = new BufferedWriter(new FileWriter(new File(path)));
  }

  public void logResult(String sensorName, float sensorData) {

    try {
      bw.write(sensorName);
      bw.write(": ");
      bw.write(String.format("%.4f%n", sensorData));
      bw.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void notify(String name, float value) {
    logResult(name, value);
  }
}
