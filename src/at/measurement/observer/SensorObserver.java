package at.measurement.observer;

public interface SensorObserver {

  void notify(String name, float value);
}
