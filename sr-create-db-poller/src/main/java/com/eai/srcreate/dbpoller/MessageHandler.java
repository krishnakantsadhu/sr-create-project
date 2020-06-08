package com.eai.srcreate.dbpoller;

import java.util.List;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class MessageHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandler.class);

	public void handleJdbcMessage(List<CreateRequest> messages) {
		
	
		 for (CreateRequest createRequest : messages) {
			 
			 LOGGER.info(createRequest.toString());
			
		 }
		 
	}
}
