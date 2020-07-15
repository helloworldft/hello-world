package org.example.java.performance_optimization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heqingfu on 2020/7/4.
 */
public class JstackCase {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(new Task());
        executor.submit(new Task());
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                calculate();
            }
        }

        public void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }
}
