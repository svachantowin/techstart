package com.techstart.ThreadSequence;

public class SequenceThread {

    public SequenceThread(int maxValue) {
        this.maxValue = maxValue;
    }

    public  int maxValue = 20;
    public  int counter=1;

    public synchronized void oddManager(){

        System.out.println("Starting Odd Thread");
        while(counter<=maxValue){
                try {
                    while (counter % 2 == 0) {
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName()+ ":"+counter);
//                    System.out.print( counter+",");
                    counter++;
                    notify();

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }

        }
    }

    public synchronized  void evenManager(){

        System.out.println("Starting Even Thread");
        while(counter<=maxValue){

            try{
                while(counter%2==1) {
                    wait();
                    Thread.sleep(100);
                }
                System.out.println(Thread.currentThread().getName()+ ":"+counter);
//                System.out.print( counter+",");
                counter++;
                notify();

            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        SequenceThread sequenceThread = new SequenceThread(20);

        Thread oddThread = new Thread( () -> sequenceThread.oddManager() );
        Thread evenThread = new Thread( () -> sequenceThread.evenManager() );
        oddThread.start();
        evenThread.start();


    }
}

