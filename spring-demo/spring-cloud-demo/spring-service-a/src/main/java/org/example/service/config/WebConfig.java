package org.example.service.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.strategy.HystrixPlugins;
import feign.Feign;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig {


	@Bean
	public Feign.Builder feignHystrixBuilder() {
		return HystrixFeign.builder().setterFactory(new SetterFactory() {
			@Override
			public HystrixCommand.Setter create(Target<?> target, Method method) {
				String groupKey = target.name();
				String commandKey = Feign.configKey(target.type(), method);
				return HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
						.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
						.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(commandKey));
			}
		});
	}

//	@Bean
//	public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
//		return new FeignHystrixConcurrencyStrategy();
//	}
//@PostConstruct
//public void init() {
//	HystrixPlugins.getInstance().registerConcurrencyStrategy(new FeignHystrixConcurrencyStrategy());
//}

//	@Bean
//	public void test(Feign.Builder feignHystrixBuilder) {
//
//	}

//	@PostConstruct
//	public void init() {
//		HystrixPlugins.getInstance().registerConcurrencyStrategy(new FeignHystrixConcurrencyStrategy());
//	}

//	@Bean
//	public HystrixCallableWrapper requestAttributeAwareCallableWrapper() {
//		return new RequestAttributeAwareCallableWrapper();
//	}

//	@Bean
//	public HystrixCallableWrapper mdcAwareCallableWrapper(){
//		return new SessionLocaleAwareCallableWrapper();
//	}
//
//	@Autowired(required = false)
//	private List<HystrixCallableWrapper> wrappers = new ArrayList<>();
//
//	@PostConstruct
//	public void init() {
//		HystrixPlugins.getInstance().registerConcurrencyStrategy(new RequestContextHystrixConcurrencyStrategy(wrappers));
//	}

	@PostConstruct
	public void init() {
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new FeignHystrixConcurrencyStrategy());
	}

}
