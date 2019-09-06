package fptai.chatbot.sdk.models;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictHistory {
	
	@JsonProperty("status")
	private Status status;
	
	@JsonProperty("data")
	private Data data;
	
	@JsonProperty("history_id")
	private int historyId;
	
	@JsonProperty("type")
	private String type;
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	

}
