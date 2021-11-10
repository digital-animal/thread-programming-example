package com.zahid.deadlock.diningphilosopher1;

public class DiningTable {
    public static void main(String[] args) {
        Fork[] forkList = new Fork[5];
        Philosopher[] philosopherList = new Philosopher[5];

        for(int i=0; i<forkList.length; i++) {
            forkList[i] = new Fork();
        }

        for(int i=0; i<philosopherList.length; i++) {
            Fork leftFork = forkList[i];
            Fork rightFork = forkList[(i + 1) % forkList.length];

            // this arrangement causes circular dependency i.e. deadlock
            // philosopherList[i] = new Philosopher("Philosopher" + (i+1), leftFork, rightFork);

            // breaking circular dependency, so no deadlock
            if(i == philosopherList.length - 1) {
                philosopherList[i] = new Philosopher("Philosopher" + (i+1), rightFork, leftFork);
 
            } else {
                philosopherList[i] = new Philosopher("Philosopher" + (i+1), leftFork, rightFork);
            }
        }

        for (int j = 0; j < philosopherList.length; j++) {
            philosopherList[j].start();
        }
    }
}
