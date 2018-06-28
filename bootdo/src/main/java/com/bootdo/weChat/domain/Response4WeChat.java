package com.bootdo.weChat.domain;

public class Response4WeChat {
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	private String responseMessage;

	public Response4WeChat(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
