package com.zahid.itc.producerconsumer3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Buffer {
    private BlockingQueue<Integer> numberQueue = new LinkedBlockingDeque<>(10);

    public void addItem(Integer item) {
        try { numberQueue.put(item);
        } catch (InterruptedException e) {}
    }

    public Integer getItem() {
        int randomNumber = 0;
        while (numberQueue.isEmpty()) {
            BufferTest.sleep(100);
        }
        try { randomNumber = numberQueue.take();
        } catch (InterruptedException e) {}
        return randomNumber;
    }
}
