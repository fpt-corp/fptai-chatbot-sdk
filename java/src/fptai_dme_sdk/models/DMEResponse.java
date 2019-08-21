package fptai_dme_sdk.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DMEResponse {
	private String app_code;
	private String sender_id;
	private String channel;
	private ArrayList<Object> messages;
	private String answer_source;
	private String sender_data;
	private Object conversation_input;
	private Object predict_history;
	
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
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public  ArrayList<Object> getMessages() {
		return messages;
	}
	public void setMessages( ArrayList<Object> messages) {
		this.messages = messages;
	}
	
	public String getAnswer_source() {
		return answer_source;
	}
	public void setAnswer_source(String answer_source) {
		this.answer_source = answer_source;
	}
	public String getSender_data() {
		return sender_data;
	}
	public void setSender_data(String sender_data) {
		this.sender_data = sender_data;
	}
	public Object getConversation_input() {
		return conversation_input;
	}
	public void setConversation_input(Object conversation_input) {
		this.conversation_input = conversation_input;
	}
	public Object getPredict_history() {
		return predict_history;
	}
	public void setPredict_history(Object predict_history) {
		this.predict_history = predict_history;
	}

	public DMEResponse() {
        super();
    }
	

}
