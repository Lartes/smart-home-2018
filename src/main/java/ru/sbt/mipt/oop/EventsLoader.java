package ru.sbt.mipt.oop;

public class EventsLoader {
    public static void runEvents (SmartHome smartHome, EventsManager eventsManager) {
        eventsManager.addEventProcessor(new EventProcessorAlarmDecorator(new LightsEventProcessor()));
        eventsManager.addEventProcessor(new EventProcessorAlarmDecorator(new DoorEventProcessor()));
        eventsManager.addEventProcessor(new AlarmEventProcessor());
        eventsManager.addEventProcessor(new EventProcessorAlarmDecorator(new HallDoorEventProcessor()));
        eventsManager.runEventsCycle(smartHome);
    }
}
