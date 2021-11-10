package com.zahid.basic.intro;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.println(this.getClass().getSimpleName() + ": "+ i);
        }
    }
}
