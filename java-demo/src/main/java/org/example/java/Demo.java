package org.example.java;

import static java.util.Optional.ofNullable;

/**
 * Created by heqingfu on 2020/2/11.
 */
public class Demo {
    public static void main (String [] args) {

        ServiceInfo serviceInfo = null;
//        ofNullable(serviceInfo).map(ServiceInfo::getServiceTime)
//                .ifPresent(serviceTime -> System.out.print(serviceTime));

        System.out.println(ofNullable(serviceInfo).map(ServiceInfo::getServiceTime).map(String::valueOf).orElse(""));
    }

    public static class ServiceInfo {

        private Integer serviceTime;

        public ServiceInfo(Integer serviceTime) {
            this.serviceTime = serviceTime;
        }

        public Integer getServiceTime() {
            return serviceTime;
        }

        public void setServiceTime(Integer serviceTime) {
            this.serviceTime = serviceTime;
        }
    }
}
