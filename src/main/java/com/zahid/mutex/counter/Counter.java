package com.zahid.mutex.counter;

public class Counter {
    private final Object lock = new Object(); // explicit lock object
    private int count; // shard data among threads
    
    public Counter() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // public void incremet() { // no lock i.e. no synchronization
    //     count++;
    // }

    public void incremet() { // explicit lock object, but costly
        synchronized(lock) {
            count++;
        }
    }

    // public void decremet() { // no lock i.e. no synchronization
    //     count--;
    // }

    public void decremet() { // explicit lock object, but costly
        synchronized(lock) {
            count--;
        }
    }
}
