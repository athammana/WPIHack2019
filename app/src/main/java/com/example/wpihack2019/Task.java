package com.example.wpihack2019;

public class Task {

    private int _id;
    String Name;
    int priority;
    int order;
    int minMins;
    int maxMins;

    public Task(int id, String Name, int priority, int order, int minMins, int maxMins){
        this._id = id;
        this.Name = Name;
        this.priority = priority;
        this.order = order;
        this.minMins = minMins;
        this.maxMins = maxMins;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return Name;
    }

    public int getPriority() {
        return priority;
    }

    public int getOrder() {
        return order;
    }

    public int getMinMins() {
        return minMins;
    }

    public int getMaxMins() {
        return maxMins;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setMinMins(int minMins) {
        this.minMins = minMins;
    }

    public void setMaxMins(int maxMins) {
        this.maxMins = maxMins;
    }
}
