package com.eai.srcreate.outbound;

import org.springframework.messaging.Message;

public interface StoreProcedureExecutor {
	
	public Message<?> executeSP(CreateRequest req);

}
