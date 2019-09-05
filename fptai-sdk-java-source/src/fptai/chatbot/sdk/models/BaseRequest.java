package fptai.chatbot.sdk.models;

import org.codehaus.jackson.annotate.JsonProperty;

public class BaseRequest {
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("app_code")
	private String app_code;
	
	@JsonProperty("sender_id")
	private String sender_id;
	
	@JsonProperty("message")
	private Message message;
	
	
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAppCode() {
		return app_code;
	}

	public void setAppCode(String app_code) {
		this.app_code = app_code;
	}

	public String getSenderId() {
		return sender_id;
	}

	public void setSenderId(String sender_id) {
		this.sender_id = sender_id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public BaseRequest(String channel, String app_code, String sender_id, Message message) {
		this.channel = channel;
		this.app_code = app_code;
		this.sender_id = sender_id;
		this.message = message;
	}
	
	public BaseRequest(String channel, String app_code) {
		this.channel = channel;
		this.app_code = app_code;
	}

}
