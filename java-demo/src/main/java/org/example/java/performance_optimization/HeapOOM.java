package org.example.java.performance_optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heqingfu on 2020/7/14.
 *
 * -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintGCTimeStamps -XX:+DisableExplicitGC -XX:+TraceClassLoading -XX:+PrintClassHistogram -Xms20M -Xmx20M -Xmn10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="/Users/heqingfu/tmp"
 *
 */
public class HeapOOM {

    static class OOMObject{
        private  Object obj;

        public OOMObject(Object obj) {
            this.obj = obj;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject(new String [50]));
            Thread.sleep(5);
        }
    }
}
