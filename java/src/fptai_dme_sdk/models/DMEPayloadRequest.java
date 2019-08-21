package fptai_dme_sdk.models;
import java.io.IOException;
import java.util.Base64;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DMEPayloadRequest {
	private String channel;
	private String app_code;
	private String sender_id;
	private DMEMessage message;
	
	
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
	
	public DMEMessage getMessage() {
		return message;
	}
	public void setMessage(DMEMessage message) {
		this.message = message;
	}
	
	
	public DMEPayloadRequest(String channel, String app_code, String sender_id, String step_name, String payload) {
		this.channel = channel;
		this.app_code = app_code;
		this.sender_id = sender_id;
		
		String content = "";
		if(!step_name.isEmpty() && step_name !=null) {
			content = content + step_name + "#";
		}
		content = content + Base64.getEncoder().encodeToString(payload.getBytes());
		DMEMessage message = new DMEMessage("payload", content);	
		this.message = message;
	}
	
	public String build() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper Obj = new ObjectMapper(); 
		String payloadMessage = Obj.writeValueAsString(this); 
		return payloadMessage;
	}
	
}
