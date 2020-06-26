package me.shiteship.depmospringmvc.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static ExecutorService newFixedThreadPool(int nThreads){
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

//    ExecutorService executor = Executor.newFixedThreadPool(4);
//    ThreadPoolExecutor executor2 = (ThreadPoolExecutor)Executor.newFixedThreadPool(4);

}
