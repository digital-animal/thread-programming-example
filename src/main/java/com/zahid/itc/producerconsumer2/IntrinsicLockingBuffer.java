package com.zahid.itc.producerconsumer2;

import java.util.LinkedList;
import java.util.Queue;

public class IntrinsicLockingBuffer {
    private static final int N = 10;
    private Queue<Integer> queue = new LinkedList<>();

    public synchronized void addItem(int item) {
        while (queue.size() == N) {
            try { wait();}
            catch (InterruptedException e) {}
        }
        queue.add(item);

        notifyAll();
    }

    public synchronized Integer getItem() {
        while (queue.isEmpty()) {
            try { wait();}
            catch (InterruptedException e) {}
        }
        Integer value = queue.poll();
        notifyAll();

        return value;
    }
}
