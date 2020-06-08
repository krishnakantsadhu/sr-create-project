package com.eai.service.mq.poller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId="createSR", name="api-gateway-server")
@RibbonClient(name="sr-create-sp-caller")
public interface SrCreateServiceProxy {
	
	@PostMapping("/sr-create-sp-caller/sr-create")
	public ResponseEntity<CreateRequest>  createSR(@RequestBody CreateRequest request);
	
	
}
