package org.example.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by heqingfu on 2020/3/1.
 */
@Component
@Order(-1)
public class Run1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run-1");
    }
}
