package ru.sbt.mipt.oop;

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
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }

    @Override
    public void addEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }
}
