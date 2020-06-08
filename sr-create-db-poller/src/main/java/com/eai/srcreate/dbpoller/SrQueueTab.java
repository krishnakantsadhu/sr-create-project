package com.eai.srcreate.dbpoller;

import java.io.Serializable;
import java.sql.Date;

public class SrQueueTab implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long sequenceNo;
	private String userName;
	private String typeVal;
	private String subtypeVal;
	private String cellno;
	private String circleId;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String attribute6;
	private String attribute7;
	private String attribute8;
	private String attribute9;
	private String attribute10;
	private String attribute11;
	private String attribute12;
	private String attribute13;
	private String attribute14;
	private String attribute15;
	private String attribute16;
	private String status;
	private String createdByUser;
	private String media;
	private Date createDate;
	private Date updateDate;
	private long incidentNo;
	private String returnCode;
	private String returnMessage;
	private long requestId;
	private String channel;
	
	public long getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(long sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTypeVal() {
		return typeVal;
	}
	public void setTypeVal(String typeVal) {
		this.typeVal = typeVal;
	}
	public String getSubtypeVal() {
		return subtypeVal;
	}
	public void setSubtypeVal(String subtypeVal) {
		this.subtypeVal = subtypeVal;
	}
	public String getCellno() {
		return cellno;
	}
	public void setCellno(String cellno) {
		this.cellno = cellno;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	public String getAttribute6() {
		return attribute6;
	}
	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}
	public String getAttribute7() {
		return attribute7;
	}
	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}
	public String getAttribute8() {
		return attribute8;
	}
	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}
	public String getAttribute9() {
		return attribute9;
	}
	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}
	public String getAttribute10() {
		return attribute10;
	}
	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}
	public String getAttribute11() {
		return attribute11;
	}
	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}
	public String getAttribute12() {
		return attribute12;
	}
	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}
	public String getAttribute13() {
		return attribute13;
	}
	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}
	public String getAttribute14() {
		return attribute14;
	}
	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}
	public String getAttribute15() {
		return attribute15;
	}
	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}
	public String getAttribute16() {
		return attribute16;
	}
	public void setAttribute16(String attribute16) {
		this.attribute16 = attribute16;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public long getIncidentNo() {
		return incidentNo;
	}
	public void setIncidentNo(long incidentNo) {
		this.incidentNo = incidentNo;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String toString() {
		return "SrQueueTab [sequenceNo=" + sequenceNo + ", userName=" + userName + ", typeVal=" + typeVal
				+ ", subtypeVal=" + subtypeVal + ", cellno=" + cellno + ", circleId=" + circleId + ", attribute1="
				+ attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3 + ", attribute4="
				+ attribute4 + ", attribute5=" + attribute5 + ", attribute6=" + attribute6 + ", attribute7="
				+ attribute7 + ", attribute8=" + attribute8 + ", attribute9=" + attribute9 + ", attribute10="
				+ attribute10 + ", attribute11=" + attribute11 + ", attribute12=" + attribute12 + ", attribute13="
				+ attribute13 + ", attribute14=" + attribute14 + ", attribute15=" + attribute15 + ", attribute16="
				+ attribute16 + ", status=" + status + ", createdByUser=" + createdByUser + ", media=" + media
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", incidentNo=" + incidentNo
				+ ", returnCode=" + returnCode + ", returnMessage=" + returnMessage + ", requestId=" + requestId
				+ ", channel=" + channel + "]";
	}

	
}
