package org.example.java.performance_optimization;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by heqingfu on 2020/7/4.
 */
public class JmapCase {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        while(true) {
            String [] strArry = new String[100];
            String key = UUID.randomUUID().toString();

            map.put(key, strArry);
        }
    }


}
