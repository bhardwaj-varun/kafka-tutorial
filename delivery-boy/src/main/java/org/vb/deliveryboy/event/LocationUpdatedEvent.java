package org.vb.deliveryboy.event;

import org.springframework.stereotype.Component;



public class LocationUpdatedEvent {
    private String location;

    public LocationUpdatedEvent(String location) {
        this.location = location;
    }
    public LocationUpdatedEvent(){

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationUpdatedEvent{" +
                "location='" + location + '\'' +
                '}';
    }
}
