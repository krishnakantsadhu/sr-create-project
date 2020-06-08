package com.eai.service.mq.poller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class ServiceInvoker {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInvoker.class);
	
	@Autowired
	SrCreateServiceProxy srCreateServiceProxy;
	
	@Autowired
	UpdateIncidentServiceProxy updateIncidentServiceProxy;
	
	public Message<CreateRequest> invokeSrCreate(Message<CreateRequest> message) {
		
		LOGGER.info("Request Message Header : " + message.getHeaders());
		
		CreateRequest srCreateRequest = message.getPayload();
		
		LOGGER.info("Microservice sr-create-sp-caller calling");
				
		ResponseEntity<CreateRequest> srCreateResponse = srCreateServiceProxy.createSR(srCreateRequest);
		
		LOGGER.info("Microservice sr-create-sp-caller calling successfully. ");
		
		LOGGER.info("Sr created --> incident No = " + srCreateResponse.getBody().getSRCreateRequest().getOutput().getIncidentNumbers().getPIncidentNo());
		
		
		Object messageId = message.getHeaders().get("jms_messageId").toString();
		Object correlationId = message.getHeaders().get("jms_correlationId");
		//Object responseCorrelationId ;
		
		if(correlationId == null)
			correlationId = messageId;
		
		LOGGER.info("Response send --> destination : " + message.getHeaders().get("jms_replyTo"));
		LOGGER.info("Response send --> jms_correlationId : " + correlationId);
				
		return MessageBuilder.withPayload(srCreateResponse.getBody()).setHeader("jms_correlationId", correlationId).build();
		
	}
		
		
	public void invokeUpdateIncidentInDB(Message<CreateRequest> message) {
		
		LOGGER.info("Microservice sr-create-db-incident-updater calling");
		
		LOGGER.info("sequence no = "+message.getPayload().getMetaInfo().getKey().get(0));
		
		ResponseEntity<Object> updateIncidentResponse = updateIncidentServiceProxy.updateSrIncident(message.getPayload());
		  
		LOGGER.info("Incident updated in table " + updateIncidentResponse.getStatusCode());
		  	
	}
		

}
