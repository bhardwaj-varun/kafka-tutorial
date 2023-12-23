package org.vb.enduser.event;

public class LocationListenerEvent {
    private String location;

    public LocationListenerEvent(String location) {
        this.location = location;
    }

    public LocationListenerEvent() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "LocationListenerEvent{" +
                "location='" + location + '\'' +
                '}';
    }
}
