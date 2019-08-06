package com.websocketstomp.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.websocketstomp.models.Greeting;

@Component
public class EventSender {

	@Autowired 
	private SimpMessagingTemplate  template;

	
    public void sendGreeting(final int i)  {
    	try {
    		template.convertAndSend("/temp-topic/greetings", new Greeting("Message-"+Integer.toString(i)));
    	}catch(Exception e) {
    		e.printStackTrace();
            System.out.println("exception in processing message");    		
    	}
        System.out.println("processing message");
    }

}
