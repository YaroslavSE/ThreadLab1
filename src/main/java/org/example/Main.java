package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] steps = {1,2,5};
        long[] delays = {3000,5000,2000};

        AtomicBoolean[] flags = new AtomicBoolean[delays.length];
        for(int i = 0; i < flags.length; i++){
            flags[i] = new AtomicBoolean();
        }

        for(int i = 0; i < delays.length; i++){
            new CalculateThread(i+1, steps[i], flags[i]).start();
        }

        new Thread(new BreakThread(flags, delays)).start();
    }
}