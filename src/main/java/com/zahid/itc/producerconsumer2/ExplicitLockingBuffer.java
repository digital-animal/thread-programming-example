package com.zahid.itc.producerconsumer2;

import java.util.LinkedList;
import java.util.Queue;

public class ExplicitLockingBuffer {
    private static final int N = 10;
    private Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    public void addItem(int item) {
        synchronized(lock) {
            while (queue.size() == N) {
                try { lock.wait();}
                catch (InterruptedException e) {}
            }
            queue.add(item);
            lock.notifyAll();
        }
    }

    public synchronized Integer getItem() {
        synchronized(lock) {
            while (queue.isEmpty()) {
                try { lock.wait();}
                catch (InterruptedException e) {}
            }
            Integer value = queue.poll();
            lock.notifyAll();
            return value;
        }
    }
}
