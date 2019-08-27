package fptai.chatbot.sdk.models;

public class Message {
	private String type;
	private String content;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Message(String type, String content) {
		this.type = type;
		this.content = content;
	}

}
