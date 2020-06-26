package me.shiteship.depmospringmvc.executor;

import java.time.LocalTime;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedSizeThreadPoolExecutorExample {

    public static void main(String[] args) {

        final int maxCore = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executor.newFixedThreadPool(maxCore);
        System.out.println("Max thread pool size : " + executor.getMaximumPoolSize());

        for(int i=0; i<10; i++){
            final int jobId = i;
            System.out.println(" Execute tase " + jobId);

            executor.execute(() -> {
                System.out.println(" Doing job "+jobId);
            });
        }

        executor.shutdown();
    }
}
