package ru.sbt.mipt.oop;

public class EventsLoader {
    public static void runEvents (SmartHome smartHome, EventsManager eventsManager) {
        eventsManager.addEventProcessor(new LightsEventProcessor());
        eventsManager.addEventProcessor(new DoorEventProcessor());
        eventsManager.addEventProcessor(new AlarmEventProcessor());
        eventsManager.addEventProcessor(new HallDoorEventProcessor());
        eventsManager.runEventsCycle(smartHome);
    }
}
