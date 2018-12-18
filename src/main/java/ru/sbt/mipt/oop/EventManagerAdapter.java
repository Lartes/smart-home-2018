package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.SensorEventsManager;

import java.util.ArrayList;
import java.util.Collection;

public class EventManagerAdapter implements EventsManager {

    private SensorEventsManager eventManager;
    private final Collection<EventProcessor> eventProcessors = new ArrayList<>();

    public EventManagerAdapter(SensorEventsManager sensorEventsManager) {
       this.eventManager = sensorEventsManager;
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        eventManager.registerEventHandler(event -> {
            System.out.println("Event: " + event);
            SensorEvent sensorEvent = transformEvent(event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, sensorEvent);
            }
        });
        eventManager.start();
    }

    private SensorEvent transformEvent(CCSensorEvent event) {
        String id = event.getObjectId();
        String type = event.getEventType().replace("Is", "_").toUpperCase();
        SensorEventType sensorEventType = SensorEventType.valueOf(type);
        return new SensorEvent(sensorEventType, id);
    }

    @Override
    public void addEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }
}
