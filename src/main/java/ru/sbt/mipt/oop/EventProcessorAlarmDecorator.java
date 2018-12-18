package ru.sbt.mipt.oop;

public class EventProcessorAlarmDecorator implements EventProcessor {
    private EventProcessor eventProcessor;

    public EventProcessorAlarmDecorator(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm().getState() == AlarmStateEnum.ON) {
            smartHome.getAlarm().startAlarm();
        }
        eventProcessor.processEvent(smartHome, event);
    }
}