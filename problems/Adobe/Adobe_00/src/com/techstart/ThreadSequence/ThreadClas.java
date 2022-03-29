package com.techstart.ThreadSequence;

public class ThreadClas extends Thread{

    public  static int maxValue = 20;

    public void oddManager() throws InterruptedException {

        for (int i = 0; i < maxValue; i++) {
            if(i%2==0){
                wait();
            }
            System.out.println("Odd number:"+i);
            // notify

        }
    }

}
