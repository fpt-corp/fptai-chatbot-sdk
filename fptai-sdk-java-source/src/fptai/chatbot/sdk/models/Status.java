package fptai.chatbot.sdk.models;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
	@JsonProperty("code")
	private int code;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("module")
	private String module;
	
	@JsonProperty("api_code")
	private int apiCode;
	
	@JsonProperty("err_code")
	private int errCode; 
	
	@JsonProperty("detail")
	private String detail;
	
	@JsonProperty("app_code")
	private String appCode;
	
	@JsonProperty("button_title")
	private String buttonTitle;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public int getApiCode() {
		return apiCode;
	}

	public void setApiCode(int apiCode) {
		this.apiCode = apiCode;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getButtonTitle() {
		return buttonTitle;
	}

	public void setButtonTitle(String buttonTitle) {
		this.buttonTitle = buttonTitle;
	}
	
	
	
}
