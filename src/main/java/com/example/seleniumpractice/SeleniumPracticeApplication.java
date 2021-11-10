package com.example.seleniumpractice;

import com.example.seleniumpractice.queue.QueueConsumer;
import com.example.seleniumpractice.queue.QueueConsumerModuleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class SeleniumPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumPracticeApplication.class, args);
	}

	@Bean
	public QueueConsumer queueConsumerModuleServiceBean(QueueConsumerModuleService queueConsumerModuleService, PlatformTransactionManager transactionManager) {
		return new QueueConsumer(queueConsumerModuleService, transactionManager, 5, 5);
	}

}
