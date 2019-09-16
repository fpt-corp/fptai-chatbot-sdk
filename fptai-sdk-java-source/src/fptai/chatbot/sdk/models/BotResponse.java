package fptai.chatbot.sdk.models;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BotResponse {
	
	@JsonProperty("app_code")
	private String appCode;
	
	@JsonProperty("sender_id")
	private String sender_id;
	
	@JsonProperty("channel")
	private String channel;
	
	@JsonProperty("sender_data")
	private String senderData;
	
	@JsonProperty("answer_source")
	private String answerSource;
	
	@JsonProperty("conversation_input")
	private ConversationInput conversationInput;
	
	@JsonProperty("predict_history")
	private PredictHistory predictHistory;
	
	private ArrayList<Message> messages;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
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

	public String getSenderData() {
		return senderData;
	}

	public void setSenderData(String senderData) {
		this.senderData = senderData;
	}

	public String getAnswerSource() {
		return answerSource;
	}

	public void setAnswerSource(String answerSource) {
		this.answerSource = answerSource;
	}

	public ConversationInput getConversationInput() {
		return conversationInput;
	}

	public void setConversationInput(ConversationInput conversationInput) {
		this.conversationInput = conversationInput;
	}

	public PredictHistory getPredictHistory() {
		return predictHistory;
	}

	public void setPredictHistory(PredictHistory predictHistory) {
		this.predictHistory = predictHistory;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	
	
}
