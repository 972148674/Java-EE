package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.server.ConferenceService;

public class TestDemo {
	
	public static void main(String[] args) {
				
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("application.xml");
		
		
		ConferenceService conferenceService = (ConferenceService)applicationContext.getBean("conferenceService");
		conferenceService.conference();
		
		
	}
	
	
}
