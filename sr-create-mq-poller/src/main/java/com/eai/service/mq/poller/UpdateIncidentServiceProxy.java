package com.eai.service.mq.poller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId="updateSrIncident", name="api-gateway-server")
@RibbonClient(name="sr-create-db-incident-updater")
public interface UpdateIncidentServiceProxy {
	
	@PostMapping("/sr-create-db-incident-updater/sr-incident")
	public ResponseEntity<Object> updateSrIncident(@RequestBody CreateRequest request);

}
