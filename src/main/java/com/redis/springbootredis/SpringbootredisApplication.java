package com.redis.springbootredis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableCaching
public class SpringbootredisApplication {

	@Value("${server.port}")
	private String serverPort;

	private String getServerPort(){
		return serverPort;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootredisApplication.class, args);

		SpringbootredisApplication redisApp = context.getBean(SpringbootredisApplication.class);
		System.out.println("Application is running at http://localhost:"+redisApp.getServerPort());
		System.out.println("Application is running");
	}

}
