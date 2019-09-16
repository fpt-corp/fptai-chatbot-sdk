package fptai.chatbot.sdk.models;

import java.io.IOException;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fptai.chatbot.sdk.exc.InValidMessageTypeException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	@JsonProperty("type")
	private String type;

	@JsonProperty("content")
	private Object content;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Message() {
		super();
	}

	public Message(String type, Object content) {
		this.type = type;
		this.content = content;
	}

//	Get content as Message type
	@JsonIgnore
	public TextContent getContentAsTextMessage() throws InValidMessageTypeException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
			return (TextContent) objectMapper.readValue(json, TextContent.class);
		} catch (IOException e) {
			throw new InValidMessageTypeException("Message content is not text message", e);
		}
	}

	@JsonIgnore
	public ImageContent getContentAsImageMessage() throws InValidMessageTypeException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
			return (ImageContent) objectMapper.readValue(json, ImageContent.class);
		} catch (IOException e) {
			throw new InValidMessageTypeException("Message content is not image message", e);
		}
	}

	@JsonIgnore
	public CarouselContent getContentAsCarouselMessage() throws InValidMessageTypeException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
			return (CarouselContent) objectMapper.readValue(json, CarouselContent.class);
		} catch (IOException e) {
			throw new InValidMessageTypeException("Message content is not carousel message", e);
		}
	}

	@JsonIgnore
	public TextContent getContentAsFormMessage() throws InValidMessageTypeException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
			return (TextContent) objectMapper.readValue(json, TextContent.class);
		} catch (IOException e) {
			throw new InValidMessageTypeException("Message content is not form message", e);
		}
	}

	@JsonIgnore
	public TextContent getContentAsQuickReplyMessage() throws InValidMessageTypeException {
		ObjectMapper objectMapper = new ObjectMapper();
		String json;
		try {
			json = objectMapper.writeValueAsString(content);
			return (TextContent) objectMapper.readValue(json, TextContent.class);
		} catch (IOException e) {
			throw new InValidMessageTypeException("Message content is not quick reply message", e);
		}
	}

}
