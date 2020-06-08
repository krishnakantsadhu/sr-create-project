package com.eai.srcreate.dbpoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class RequestTranformation {
	
	@Autowired
	ObjectFactory objectFactory;
	
	public List<CreateRequest> transform(List<SrQueueTab> messages){
		
		List<CreateRequest> transformedMessage = new ArrayList<CreateRequest>();
		
		 for (SrQueueTab inboundMessage : messages) {
			 CreateRequest createRequest = objectFactory.createCreateRequest();
			 CreateRequest.MetaInfo metaInfo = objectFactory.createCreateRequestMetaInfo();
			 CreateRequest.SRCreateRequest srCreateRequest = objectFactory.createCreateRequestSRCreateRequest();
			 
			 metaInfo.setServiceName("SRCreate");
			 metaInfo.setChannelName("SAG");
			 metaInfo.setCircleId(inboundMessage.getCircleId());
			 metaInfo.getKey().add(String.valueOf(inboundMessage.getSequenceNo()));
			 metaInfo.getKey().add(inboundMessage.getCellno());
			 
			 createRequest.setMetaInfo(metaInfo);
			 			 
			 srCreateRequest.setPUserName(inboundMessage.getUserName());
			 srCreateRequest.setPTypeVal(inboundMessage.getTypeVal());
			 srCreateRequest.setPSubtypeVal(inboundMessage.getSubtypeVal());
			 srCreateRequest.setPCellno(inboundMessage.getCellno());
			 srCreateRequest.setPAttribute1(inboundMessage.getAttribute1());
			 srCreateRequest.setPAttribute2(inboundMessage.getAttribute2());
			 srCreateRequest.setPAttribute3(inboundMessage.getAttribute3());
			 srCreateRequest.setPAttribute4(inboundMessage.getAttribute4());
			 srCreateRequest.setPAttribute5(inboundMessage.getAttribute5());
			 srCreateRequest.setPAttribute6(inboundMessage.getAttribute6());
			 srCreateRequest.setPAttribute7(inboundMessage.getAttribute7());
			 srCreateRequest.setPAttribute8(inboundMessage.getAttribute8());
			 srCreateRequest.setPAttribute9(inboundMessage.getAttribute9());
			 srCreateRequest.setPAttribute10(inboundMessage.getAttribute10());
			 srCreateRequest.setPAttribute11(inboundMessage.getAttribute11());
			 srCreateRequest.setPAttribute12(inboundMessage.getAttribute12());
			 srCreateRequest.setPAttribute13(inboundMessage.getAttribute13());
			 srCreateRequest.setPAttribute14(inboundMessage.getAttribute14());
			 srCreateRequest.setPAttribute15(inboundMessage.getAttribute15());
			 srCreateRequest.setPAttribute16(inboundMessage.getAttribute16());
			 srCreateRequest.setPMedia(inboundMessage.getMedia());
			 srCreateRequest.setPCreateDate(inboundMessage.getCreateDate().toString());
			 srCreateRequest.setPCircleId(inboundMessage.getCircleId());
			 
			 createRequest.setSRCreateRequest(srCreateRequest);
			 
			 transformedMessage.add(createRequest);
		 }
		 
		 return transformedMessage;
	}
	
	// for unit testing purpose
	public static List<CreateRequest> getStaticDummyRequest(){
		
		List<CreateRequest> requests = new ArrayList<CreateRequest>();
		
		 for(int i=0; i < 5 ;i++) {
			 ObjectFactory objectFactory = new ObjectFactory();
			 CreateRequest createRequest = objectFactory.createCreateRequest();
			 CreateRequest.MetaInfo metaInfo = objectFactory.createCreateRequestMetaInfo();
			 CreateRequest.SRCreateRequest srCreateRequest = objectFactory.createCreateRequestSRCreateRequest();
			 
			 metaInfo.setServiceName("SRCreate");
			 metaInfo.setChannelName("SAG");
			 metaInfo.setCircleId("0017");
			 metaInfo.getKey().add("00000_"+i);
			 metaInfo.getKey().add("123456789");
			 
			 createRequest.setMetaInfo(metaInfo);
			 			 
			 srCreateRequest.setPUserName("UserName");
			 srCreateRequest.setPTypeVal("TypeVal");
			 srCreateRequest.setPSubtypeVal("SubtypeVal");
			 srCreateRequest.setPCellno("Cellno");
			 srCreateRequest.setPAttribute1("Attribute1");
			 srCreateRequest.setPAttribute2("Attribute2");
			 srCreateRequest.setPAttribute3("Attribute3");
			 srCreateRequest.setPAttribute4("Attribute4");
			 srCreateRequest.setPAttribute5("Attribute5");
			 srCreateRequest.setPAttribute6("Attribute6");
			 srCreateRequest.setPAttribute7("Attribute7");
			 srCreateRequest.setPAttribute8("Attribute8");
			 srCreateRequest.setPAttribute9("Attribute9");
			 srCreateRequest.setPAttribute10("Attribute10");
			 srCreateRequest.setPAttribute11("Attribute11");
			 srCreateRequest.setPAttribute12("Attribute12");
			 srCreateRequest.setPAttribute13("Attribute13");
			 srCreateRequest.setPAttribute14("Attribute14");
			 srCreateRequest.setPAttribute15("Attribute15");
			 srCreateRequest.setPAttribute16("Attribute16");
			 srCreateRequest.setPMedia("Media");
			 srCreateRequest.setPCreateDate(new java.util.Date().toString());
			 srCreateRequest.setPCircleId("CircleId");
			 
			 createRequest.setSRCreateRequest(srCreateRequest);
			 
			 requests.add(createRequest);
		 }
		 
		 return requests;
	}

}
