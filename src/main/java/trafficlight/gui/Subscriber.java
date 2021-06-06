package trafficlight.gui;

import trafficlight.states.State;

public interface Subscriber {
    <T extends Observer> void addObserver(T t);
    <T extends Observer> void removeObserver(T t);
    void update();
}
