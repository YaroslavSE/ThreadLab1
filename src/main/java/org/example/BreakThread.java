package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class BreakThread implements Runnable{
    private final AtomicBoolean[] flags;   // || HashMap з передачою breakThread в CalculateThread
    private final long[] delays;

    public BreakThread(AtomicBoolean[] flags ,long[] delays){
        this.flags = flags;
        this.delays = delays;
    }

    @Override
    public void run() {
        for (int i = 0; i < flags.length; i++){
            final int indexThread = i;
            new Thread(() -> {
                try{
                    Thread.sleep(delays[indexThread]);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                flags[indexThread].set(true);
            }).start();
        }

    }

}
