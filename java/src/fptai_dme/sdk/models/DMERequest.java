package fptai_dme_sdk.models;

import java.util.Base64;

import org.json.simple.JSONObject;

public class DMERequest {
	private String channel;
	private String app_code;
	private String sender_id;
	
	
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
	
	public DMERequest(String channel, String app_code, String sender_id) {
		this.channel = channel;
		this.app_code = app_code;
		this.sender_id = sender_id;
	}
	
	@SuppressWarnings("unchecked")
	public String buildTextMessage(String content) {
		JSONObject message = new JSONObject();
		message.put("type", "text");
		message.put("content", content);
		
		
		JSONObject textMessObj = new JSONObject();
		textMessObj.put("channel", this.channel);
		textMessObj.put("app_code", this.app_code);
		textMessObj.put("sender_id", this.sender_id);
		textMessObj.put("message", message);
		return textMessObj.toJSONString();
	}
	
	@SuppressWarnings("unchecked")
	public String buildPayloadMessage(String step_name, String payload) {
		String content = "";
		if(!step_name.isEmpty() && step_name !=null) {
			content = content + step_name + "#";
		}
		content = content + Base64.getEncoder().encodeToString(payload.getBytes());
		
		JSONObject message = new JSONObject();
		message.put("type", "payload");
		message.put("content", content);
		
		JSONObject payloadMessObj = new JSONObject();
		payloadMessObj.put("channel", this.channel);
		payloadMessObj.put("app_code", this.app_code);
		payloadMessObj.put("sender_id", this.sender_id);
		payloadMessObj.put("message", message);
		
		return payloadMessObj.toJSONString();
	}

}
