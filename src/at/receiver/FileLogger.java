package at.receiver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

  private BufferedWriter bw;

  public FileLogger(String path) throws IOException {
    bw = new BufferedWriter(new FileWriter(new File(path)));
  }

  public void logResult(String sensorName, float sensorData) {

    try {
      bw.write(sensorName);
      bw.write(": ");
      bw.write(String.format("%.4f%n", sensorData));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
