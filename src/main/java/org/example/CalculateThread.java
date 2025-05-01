package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class CalculateThread extends Thread{
    private final int id;
    private final AtomicBoolean flag;
    private final int step;
    public CalculateThread(int id, int step, AtomicBoolean flag){
        this.id = id;
        this.flag = flag;
        this.step = step;
    }
    @Override
    public void run(){
        long sum = 0;
        long count = 0;
        int currentStep = 0;
        while(!flag.get()){
            sum += currentStep;
            count++;
            currentStep += step;
        }

        System.out.println("Поток " + id + ": сума = " + sum + ", доданків = " + count + ", крок = " + step);
    }
}
