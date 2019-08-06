package com.websocketstomp.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventGenerator extends Thread {

	@Autowired
	EventSender sender;
	@Override
	public void run() {
		int i =1;
		while(true) {
			System.out.println("sending message---");
			try {
				Thread.sleep(5000);
				sender.sendGreeting(i);
				i++;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in sending message");
				e.printStackTrace();
			}
			System.out.println("message sent---");			
		}
	}
	
		
}
