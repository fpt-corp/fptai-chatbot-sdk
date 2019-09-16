package fptai.chatbot.sdk.models;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextContent {

	@JsonProperty("text")
	private String text;
	
	@JsonProperty("buttons")
	private ArrayList<Button> buttons;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}
	
}
