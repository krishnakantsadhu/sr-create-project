package com.eai.srcreate.outbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessageHeaders;

import com.eai.srcreate.outbound.CreateRequest.SRCreateRequest.Output;
import com.eai.srcreate.outbound.CreateRequest.SRCreateRequest.Output.IncidentNumbers;


public class ServiceActivator {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceActivator.class);

	public Message<CreateRequest> processRequest(Message<CreateRequest> requestMessage) {
		
		LOGGER.info("requestMessage : " + requestMessage);
		
		LOGGER.info("Copy body in header for further processing ");
		 
		MessageHeaders headers = requestMessage.getHeaders();
		
		LOGGER.info("header : " + headers);
		 	
		CreateRequest message = (CreateRequest)requestMessage.getPayload();
		
		LOGGER.info("payload : " + message);
		
		LOGGER.info("payload MSISDN: " + message.getSRCreateRequest().getPCellno());
		 	
		//requestMessage.getHeaders().put("requestMessage", message);
		 	
		 Message<CreateRequest> messagewithHeader =  MessageBuilder.withPayload(message).copyHeaders(headers).setHeader("requestBody", message).build();
		
		 LOGGER.info("New message with header : " + messagewithHeader);
		 
		 return messagewithHeader;
		 
	}
	
	public Message<CreateRequest> processSuccessResponse(Message<Body> requestMessage) {
		
		MessageHeaders headers = requestMessage.getHeaders();
		
		CreateRequest createRequest = (CreateRequest) headers.get("requestBody");
				
		LOGGER.info("Header : "+requestMessage.getHeaders().toString());
						
		@SuppressWarnings("rawtypes")
		Map payLoadBody = (Map)requestMessage.getPayload();
		
		LOGGER.info("Body : "+payLoadBody.toString());
		ObjectFactory objFactory = new ObjectFactory();
		Output output = objFactory.createCreateRequestSRCreateRequestOutput();
		IncidentNumbers incidentNumber = objFactory.createCreateRequestSRCreateRequestOutputIncidentNumbers();
		incidentNumber.setPIncidentNo(payLoadBody.get("PO_INCIDENT_NO").toString());
		output.setIncidentNumbers(incidentNumber);
		
		//TODO check whether we are passing SUCESS or D/P/E
		createRequest.getSRCreateRequest().setErrorStatus(payLoadBody.get("PO_STATUS").toString());
		createRequest.getSRCreateRequest().setErrorCode(payLoadBody.get("PO_RETURN_CODE").toString());
		createRequest.getSRCreateRequest().setErrorDesc(payLoadBody.get("PO_RETURN_MESSAGE").toString());
		createRequest.getSRCreateRequest().setOutput(output);
		
		Message<CreateRequest> messagewithHeader =  MessageBuilder.withPayload(createRequest).copyHeaders(headers).removeHeader("requestBody").build();
				
		return messagewithHeader;
	}
	
public void processErrorResponse(Message<MessageHandlingException> errorMessage) {
	
	String errorDesc = errorMessage.getPayload().getMessage();
	
	CreateRequest createRequest = (CreateRequest) errorMessage.getPayload().getFailedMessage().getPayload();
	MessageHeaders headers = errorMessage.getPayload().getFailedMessage().getHeaders();
	
	LOGGER.info("Error Message header : "+errorMessage.getHeaders());
	LOGGER.info("Error Message payload : "+createRequest.getSRCreateRequest().getPCellno());
	LOGGER.info("Error errorDesc : "+errorDesc);
	
		/*
		 * ObjectFactory objFactory = new ObjectFactory(); Output output =
		 * objFactory.createCreateRequestSRCreateRequestOutput(); IncidentNumbers
		 * incidentNumber =
		 * objFactory.createCreateRequestSRCreateRequestOutputIncidentNumbers();
		 * 
		 * //setting blank incident id in same for error
		 * incidentNumber.setPIncidentNo(""); output.setIncidentNumbers(incidentNumber);
		 * 
		 * //TODO check whether we are passing SUCESS or D/P/E
		 * createRequest.getSRCreateRequest().setErrorStatus("E");
		 * createRequest.getSRCreateRequest().setErrorCode("1");
		 * createRequest.getSRCreateRequest().setErrorDesc(errorDesc);
		 * createRequest.getSRCreateRequest().setOutput(output);
		 * 
		 * Message<CreateRequest> errorMessagewithHeader =
		 * MessageBuilder.withPayload(createRequest).copyHeaders(headers).build();
		 * 
		 * 
		 * 
		 * return errorMessagewithHeader;
		 */
	
	}

}
