package fptai.chatbot.sdk.models;

public class BaseRequest {
	private String channel;
	private String app_code;
	private String sender_id;
	private Message message;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getApp_code() {
		return app_code;
	}
	public void setApp_code(String app_code) {
		this.app_code = app_code;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
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

}
