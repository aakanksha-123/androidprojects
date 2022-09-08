package com.example.letsgo999.models;

public class ModelHistory {
    String rideId, time;

    public ModelHistory() {
    }

    public ModelHistory(String rideId, String time) {
        this.rideId = rideId;
        this.time = time;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
