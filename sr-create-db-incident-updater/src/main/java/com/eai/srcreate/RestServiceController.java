package com.eai.srcreate;

import java.net.URI;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RestServiceController {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//private SrQueueTab srQueueTab;
	
	@Value("${db.incident.update.sql.query}")
	private String updateQuery;
	
	@Value("${db.incident.select.sql.query}")
	private String selectQuery;
	
	@Autowired
	private SrQueueTabRowMapper srQueueTabRowMapper;
	
	@PostMapping("/sr-incident")
	public ResponseEntity<Object> updateSrIncident(@RequestBody CreateRequest request) {
		 long incidentNo = Long.parseLong(request.getSRCreateRequest().getOutput().getIncidentNumbers().getPIncidentNo());
		 String returnCode = request.getSRCreateRequest().getErrorCode();
		 String returnMessage = request.getSRCreateRequest().getErrorDesc();
		 String status = request.getSRCreateRequest().getErrorStatus();
		 Date updateDate = new Date(new java.util.Date().getTime());
		 long sequenceNo = Long.parseLong(request.getMetaInfo().getKey().get(0));
		
	     jdbcTemplate.update(updateQuery, incidentNo, returnCode, returnMessage, status, updateDate, sequenceNo);
	     
	     URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sequenceNo}").buildAndExpand(sequenceNo).toUri();
	    
	     return  ResponseEntity.noContent().location(location).build();
	}
	
	@GetMapping(path="/sr-incident/{sequenceNo}")
	public ResponseEntity<SrQueueTab> retrieveUser(@PathVariable long sequenceNo) {
		
		SrQueueTab srQueueTab = (SrQueueTab) jdbcTemplate.queryForObject(selectQuery,new Object[] {sequenceNo}, srQueueTabRowMapper);
		
		return ResponseEntity.ok(srQueueTab);
	}

}
