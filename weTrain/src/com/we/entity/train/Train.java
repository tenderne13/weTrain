package com.we.entity.train;

import java.util.List;

public class Train {
	private String validateMessagesShowId;
	private String status;
	private String httpstatus;
	private ValidateMessages validateMessages;
	private List<Data> data;
	private List<Message> messages;
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public String getValidateMessagesShowId() {
		return validateMessagesShowId;
	}
	public void setValidateMessagesShowId(String validateMessagesShowId) {
		this.validateMessagesShowId = validateMessagesShowId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHttpstatus() {
		return httpstatus;
	}
	public void setHttpstatus(String httpstatus) {
		this.httpstatus = httpstatus;
	}
	
	
	public ValidateMessages getValidateMessages() {
		return validateMessages;
	}
	public void setValidateMessages(ValidateMessages validateMessages) {
		this.validateMessages = validateMessages;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Train [validateMessagesShowId=" + validateMessagesShowId
				+ ", status=" + status + ", httpstatus=" + httpstatus
				+ ", validateMessages=" + validateMessages + ", data=" + data
				+ ", messages=" + messages + "]";
	}
	
	
}
