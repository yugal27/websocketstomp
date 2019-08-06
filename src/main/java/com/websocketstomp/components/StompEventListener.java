package com.websocketstomp.components;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class StompEventListener implements ApplicationListener<SessionConnectEvent> {
	 
	 @Override
	 public void onApplicationEvent(SessionConnectEvent event) {
		 StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		 boolean isConnect = sha.getCommand()== StompCommand.CONNECT;
		 boolean isDisconnect = sha.getCommand()== StompCommand.DISCONNECT;
		 System.out.println("Connect: "+ isConnect +",disconnect:" +isDisconnect +
				 ", event [sessionId: " + sha.getSessionId() +";" + ",command=" +sha.getCommand() );
	 }
	 
	 @EventListener
	 public void onSocketConnected(SessionConnectedEvent event) {
		 StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		 System.out.println("[Connected] " + sha.getSessionId() +"-"+ sha.getDestination() +"-"+ sha.getHost() +"-"+ sha.getLogin() +"-"+ sha.getMessageId());
	 }
	 @EventListener
	 public void onSocketDisconnected(SessionDisconnectEvent event) {
		 StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
		 System.out.println("[Connected] " + sha.getSessionId() +"-"+ sha.getDestination() +"-"+ sha.getHost() +"-"+ sha.getLogin() +"-"+ sha.getMessageId());
	 }
}