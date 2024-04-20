package com.moweritnow.model;

public interface IEventListener {
    void update(EventType eventType, int id);
    void manageUpdate(EventType eventType, int id);
    int getID();
}
