package ru.sbt.mipt.oop;

public interface EventsManager {
    void runEventsCycle(SmartHome smartHome);
    void addEventProcessor(EventProcessor eventProcessor);
}
