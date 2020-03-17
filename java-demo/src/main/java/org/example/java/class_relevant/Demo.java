package org.example.java.class_relevant;

/**
 * Created by heqingfu on 2020/3/4.
 */
public class Demo {

    public static void main (String [] args) throws ClassNotFoundException {
        String demoClassStr = "org.example.java.class_relevant.Demo";
        Class demoClass = Class.forName(demoClassStr);

        System.out.println(demoClass.toString());
    }
}
