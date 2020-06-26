package me.shiteship.depmospringmvc.executor;

import java.time.LocalTime;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedSizeThreadPoolExecutorExample {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executor.newFixedThreadPool(4);
        for(int i=0; i<10; i++){
            final int jobId = i;
            System.out.println(LocalTime.now() + " Execute tase " + jobId);

            executor.execute(() -> {
                System.out.println(LocalTime.now() + " Doing job "+jobId);
                sleepSec(3);
                System.out.println(LocalTime.now() + " Done job "+jobId);
            });
        }

        executor.shutdown();

        if(executor.awaitTermination(20, TimeUnit.SECONDS)){
            System.out.println(LocalTime.now() + " All jobs are terminated ");
        } else {
            System.out.println(LocalTime.now() + " some jobs are not terminated ");

            executor.shutdown();
        }
    }

    private static void sleepSec(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
