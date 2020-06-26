package me.shiteship.depmospringmvc.executor;

import java.time.LocalTime;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedSizeThreadPoolExecutorExample {

    public static void main(String[] args){

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executor.newFixedThreadPool(4);
        for(int i=0; i<10; i++){
            final int jobId = i;
            System.out.println(LocalTime.now() + " Execute tase " + jobId);

            executor.execute(() -> {
                System.out.println(LocalTime.now() + " Doing job "+jobId);
                System.out.println(LocalTime.now() + " Done job "+jobId);
            });
        }

        executor.shutdown();
    }
}
