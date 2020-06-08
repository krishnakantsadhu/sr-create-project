package com.eai.srcreate.outbound;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.integration.jdbc.SqlParameterSourceFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


public class StoreProcedureParameterMapping implements SqlParameterSourceFactory{

	@Override
	public SqlParameterSource createParameterSource(Object input) {
		
	//org.springframework.integration.jdbc.ExpressionEvaluatingSqlParameterSourceFactory;
		//Message message = (Message)input;  
		
		//CreateRequest request = (CreateRequest)message.getPayload();
		
		CreateRequest request = (CreateRequest)input;
		
		MapSqlParameterSource source = new MapSqlParameterSource(); 
		source.addValue("pi_sequence_no", request.getMetaInfo().getKey().get(0), java.sql.Types.BIGINT);
		source.addValue("pi_user_name", request.getSRCreateRequest().getPUserName(), java.sql.Types.VARCHAR);
		source.addValue("pi_type_val", request.getSRCreateRequest().getPTypeVal(), java.sql.Types.VARCHAR);
		source.addValue("pi_subtype_val", request.getSRCreateRequest().getPSubtypeVal(), java.sql.Types.VARCHAR);
		source.addValue("pi_cellno", request.getSRCreateRequest().getPCellno(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute1", request.getSRCreateRequest().getPAttribute1(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute2", request.getSRCreateRequest().getPAttribute2(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute3", request.getSRCreateRequest().getPAttribute3(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute4", request.getSRCreateRequest().getPAttribute4(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute5", request.getSRCreateRequest().getPAttribute5(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute6", request.getSRCreateRequest().getPAttribute6(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute7", request.getSRCreateRequest().getPAttribute7(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute8", request.getSRCreateRequest().getPAttribute8(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute9", request.getSRCreateRequest().getPAttribute9(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute10", request.getSRCreateRequest().getPAttribute10(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute11", request.getSRCreateRequest().getPAttribute11(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute12", request.getSRCreateRequest().getPAttribute12(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute13", request.getSRCreateRequest().getPAttribute13(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute14", request.getSRCreateRequest().getPAttribute14(), java.sql.Types.VARCHAR);
		source.addValue("pi_attribute15", request.getSRCreateRequest().getPAttribute15(), java.sql.Types.VARCHAR);
		
		//request.getSRCreateRequest().getOutput().getIncidentNumbers()
		//TODO
		source.addValue("pi_created_by_user", "krishnakant", java.sql.Types.VARCHAR);
		source.addValue("pi_media", request.getSRCreateRequest().getPMedia(), java.sql.Types.VARCHAR);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.sql.Date sqlDate = null;
		try {
			java.util.Date parsed = format.parse(request.getSRCreateRequest().getPCreateDate());
			sqlDate = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		source.addValue("pi_create_date", sqlDate, java.sql.Types.DATE);
		
		/*
		 * source.addValue("po_status", null, java.sql.Types.VARCHAR);
		 * source.addValue("po_incident_no", null, java.sql.Types.BIGINT);
		 * source.addValue("po_return_code", null, java.sql.Types.BIGINT);
		 * source.addValue("po_return_message", null, java.sql.Types.VARCHAR);
		 */
		
		return source;
	}

}
