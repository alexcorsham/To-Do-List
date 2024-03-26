package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.springboot.ListItem.ListItem;
import com.example.springboot.ListItem.ListItemRepository;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ListItemRepository listItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		listItemRepository.deleteAll();

		// save a couple of customers
		listItemRepository.save(new ListItem("Do washing", "Put the washing in the machine"));
		listItemRepository.save(new ListItem("Do shopping", "Buy some milk"));

		// fetch all customers
		System.out.println("List items found with findAll():");
		System.out.println("-------------------------------");
		for (ListItem listItem : listItemRepository.findAll()) {
			System.out.println(listItem);
		}
		System.out.println();

		// fetch an individual list item
		System.out.println("List item found with findByName('Do washing'):");
		System.out.println("--------------------------------");
		System.out.println(listItemRepository.findByName("Do washing"));

		System.out.println("List items found with findByDescription('Buy some milk'):");
		System.out.println("--------------------------------");
		for (ListItem listItem : listItemRepository.findByDescription("Buy some milk")) {
			System.out.println(listItem);
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}