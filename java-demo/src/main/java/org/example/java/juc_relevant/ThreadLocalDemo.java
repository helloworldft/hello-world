package org.example.java.juc_relevant;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by heqingfu on 2020/7/23.
 */
public class ThreadLocalDemo {

    static volatile ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    static volatile ThreadLocal<Integer> intThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThreadId.get());
                System.out.println(ThreadId.get());
                System.out.println(ThreadId.get());
                System.out.println(ThreadUUID.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ThreadId.get());
                System.out.println(ThreadId.get());
            }
        });



        thread1.start();
        Thread.sleep(2000);
        thread2.start();

    }

    public static class ThreadId {
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return nextId.getAndIncrement();
         }
     };

        // Returns the current thread's unique ID, assigning it if necessary
        public static int get() {
                return threadId.get();
        }
  }

    public static class ThreadUUID {


        // Thread local variable containing each thread's ID
        private static final ThreadLocal<String> threadId =
                new ThreadLocal<String>() {
                    @Override protected String initialValue() {
                        return UUID.randomUUID().toString();
                    }
                };

        // Returns the current thread's unique ID, assigning it if necessary
        public static String get() {
            return threadId.get();
        }
    }
}
