package org.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by heqingfu on 2020/3/1.
 */
@Component
@Order(1)
public class Run3 implements CommandLineRunner {

    @Autowired
    //@Resource
    //@Inject
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run-3");


        Environment env = applicationContext.getEnvironment();

        String[] nonOptionArgs = env.getProperty("nonOptionArgs", String[].class);

        Arrays.stream(nonOptionArgs).forEach(System.out::println);

        //启动参数
        System.out.println(env.getProperty("optionArg.name"));
    }
}
