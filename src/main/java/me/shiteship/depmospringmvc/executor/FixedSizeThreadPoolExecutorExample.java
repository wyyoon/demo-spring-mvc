package me.shiteship.depmospringmvc.executor;

import org.apache.tomcat.jni.Local;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FixedSizeThreadPoolExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executor.newFixedThreadPool(4);
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        for(int i=0; i<10; i++){
            final int jobId = i;
            final int sleepSec = 10 - i;
            System.out.println(LocalTime.now() + " Execute task " + jobId);

            executor.submit(() -> {
                System.out.println(LocalTime.now() + " Doing Task " + jobId + ", sleepSec : " + sleepSec);

                try {
                    TimeUnit.SECONDS.sleep(sleepSec);
                    String result = "finished job " + jobId;
                    queue.put(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        for(int i = 0; i<10; i++){
            String result = queue.take();
            System.out.println(LocalTime.now()+" "+ result);
        }

        executor.shutdown();
    }
}
