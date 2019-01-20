package com.example.wpihack2019;

public class Routine {

    private int _id;
    String Name;
    int priority;
    int order;
    int minHours;
    int minMins;
    int maxHours;
    int maxMins;

    public Routine(int id, String Name, int priority, int order, int minHours, int minMins, int maxHours, int maxMins){
        this._id = id;
        this.Name = Name;
        this.priority = priority;
        this.order = order;
        this.minHours = minHours;
        this.minMins = minMins;
        this.maxHours = maxHours;
        this.maxMins = maxMins;
    }

    
}
