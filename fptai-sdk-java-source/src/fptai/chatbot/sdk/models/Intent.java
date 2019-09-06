package fptai.chatbot.sdk.models;

import org.codehaus.jackson.annotate.JsonProperty;

public class Intent {
	
	@JsonProperty("label")
	private String label;

	@JsonProperty("confidence")
	private int confidence;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}
	
	
	
}
