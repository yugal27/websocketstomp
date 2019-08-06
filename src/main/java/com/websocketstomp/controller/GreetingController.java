package com.websocketstomp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.websocketstomp.models.Greeting;
import com.websocketstomp.models.HelloMessage;

@Controller
public class GreetingController {

	@Autowired 
	private SimpUserRegistry simpUserRegistry;
	
    @MessageMapping("/hello")
    @SendTo("/temp-topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
    


}
