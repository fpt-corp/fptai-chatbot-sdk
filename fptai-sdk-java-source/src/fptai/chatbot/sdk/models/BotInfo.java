package fptai.chatbot.sdk.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BotInfo {
	private String name;
	private String description;
	private String code;
	private String token;
	private String language;
	private Date last_activity;
	private Date last_train_time;
	private Date created_time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLast_activity() {
		return last_activity;
	}

	public void setLast_activity(Date last_activity) {
		this.last_activity = last_activity;
	}

	public Date getLast_train_time() {
		return last_train_time;
	}

	public void setLast_train_time(Date last_train_time) {
		this.last_train_time = last_train_time;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

}
