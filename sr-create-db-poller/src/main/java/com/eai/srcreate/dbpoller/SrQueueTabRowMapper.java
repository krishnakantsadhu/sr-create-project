package com.eai.srcreate.dbpoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SrQueueTabRowMapper implements RowMapper<SrQueueTab> {
	
	@Autowired
	SrQueueTab srQueueTab;
	
	 public SrQueueTab mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		 long sequenceNo =  rs.getLong("sequence_no");
		 String userName =  rs.getString("user_name");
		 String typeVal =  rs.getString("type_val");
		 String subtypeVal =  rs.getString("subtype_val");
		 String cellno =  rs.getString("cellno");
		 String circleId =  rs.getString("circle_id");
		 String attribute1 =  rs.getString("attribute_1");
		 String attribute2 =  rs.getString("attribute_2");
		 String attribute3 =  rs.getString("attribute_3");
		 String attribute4 =  rs.getString("attribute_4");
		 String attribute5 =  rs.getString("attribute_5");
		 String attribute6 =  rs.getString("attribute_6");
		 String attribute7 =  rs.getString("attribute_7");
		 String attribute8 =  rs.getString("attribute_8");
		 String attribute9 =  rs.getString("attribute_9");
		 String attribute10 =  rs.getString("attribute_10");
		 String attribute11 =  rs.getString("attribute_11");
		 String attribute12 =  rs.getString("attribute_12");
		 String attribute13 =  rs.getString("attribute_13");
		 String attribute14 =  rs.getString("attribute_14");
		 String attribute15 =  rs.getString("attribute_15");
		 String attribute16 =  rs.getString("attribute_16");
		 String status =  rs.getString("status");
		 String createdByUser =  rs.getString("created_by_user");
		 String media =  rs.getString("media");
		 Date createDate =  rs.getDate("create_date");
		 Date updateDate =  rs.getDate("update_date");
		 long incidentNo =  rs.getLong("incident_no");
		 String returnCode =  rs.getString("return_code");
		 String returnMessage =  rs.getString("return_message");
		 long requestId =  rs.getLong("request_id");
		 String channel =  rs.getString("channel");
		 
		 srQueueTab.setSequenceNo(sequenceNo);
		 srQueueTab.setUserName(userName);
		 srQueueTab.setTypeVal(typeVal);
		 srQueueTab.setSubtypeVal(subtypeVal);
		 srQueueTab.setCellno(cellno);
		 srQueueTab.setCircleId(circleId);
		 srQueueTab.setAttribute1(attribute1);
		 srQueueTab.setAttribute2(attribute2);
		 srQueueTab.setAttribute3(attribute3);
		 srQueueTab.setAttribute4(attribute4);
		 srQueueTab.setAttribute5(attribute5);
		 srQueueTab.setAttribute6(attribute6);
		 srQueueTab.setAttribute7(attribute7);
		 srQueueTab.setAttribute8(attribute8);
		 srQueueTab.setAttribute9(attribute9);
		 srQueueTab.setAttribute10(attribute10);
		 srQueueTab.setAttribute11(attribute11);
		 srQueueTab.setAttribute12(attribute12);
		 srQueueTab.setAttribute13(attribute13);
		 srQueueTab.setAttribute14(attribute14);
		 srQueueTab.setAttribute15(attribute15);
		 srQueueTab.setAttribute16(attribute16);
		 srQueueTab.setStatus(status);
		 srQueueTab.setCreatedByUser(createdByUser);
		 srQueueTab.setMedia(media);
		 srQueueTab.setCreateDate(createDate);
		 srQueueTab.setUpdateDate(updateDate);
		 srQueueTab.setIncidentNo(incidentNo);
		 srQueueTab.setReturnCode(returnCode);
		 srQueueTab.setReturnMessage(returnMessage);
		 srQueueTab.setRequestId(requestId);
		 srQueueTab.setChannel(channel);
	 
		 return srQueueTab;
	 }

}
