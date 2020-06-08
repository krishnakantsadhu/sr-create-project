package com.eai.srcreate.outbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eai.srcreate.outbound.CreateRequest.SRCreateRequest.Output;
import com.eai.srcreate.outbound.CreateRequest.SRCreateRequest.Output.IncidentNumbers;

@RestController
public class SrCreateRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SrCreateRestController.class);
	
	@Autowired
	private StoreProcedureExecutor storeProcedureExecutor;
	
	@Autowired
	private ObjectFactory objectFactory;
	
	
	@PostMapping("/sr-create")
	public ResponseEntity<CreateRequest>  createSR(@RequestBody CreateRequest request) {
		
		LOGGER.info("Request received : "+request.getSRCreateRequest().getPCellno());
		
		Message<?> storeProcedureResponse = storeProcedureExecutor.executeSP(request);
												
		@SuppressWarnings("rawtypes")
		Map payLoadBody = (Map)storeProcedureResponse.getPayload();
		
		LOGGER.info("Body : "+payLoadBody.toString());
		
		Output output = objectFactory.createCreateRequestSRCreateRequestOutput();
		IncidentNumbers incidentNumber = objectFactory.createCreateRequestSRCreateRequestOutputIncidentNumbers();
		incidentNumber.setPIncidentNo(payLoadBody.get("PO_INCIDENT_NO").toString());
		output.setIncidentNumbers(incidentNumber);
		
		CreateRequest response = objectFactory.createCreateRequest();
		
		response.setMetaInfo(request.getMetaInfo());
		response.setSRCreateRequest(request.getSRCreateRequest());
		response.getSRCreateRequest().setErrorStatus(payLoadBody.get("PO_STATUS").toString());
		response.getSRCreateRequest().setErrorCode(payLoadBody.get("PO_RETURN_CODE").toString());
		response.getSRCreateRequest().setErrorDesc(payLoadBody.get("PO_RETURN_MESSAGE").toString());
		response.getSRCreateRequest().setOutput(output);
		
		return new ResponseEntity<CreateRequest>(response,HttpStatus.CREATED);
		
	}

}
