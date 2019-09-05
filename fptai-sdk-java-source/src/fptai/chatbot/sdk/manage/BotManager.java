package fptai.chatbot.sdk.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;

import fptai.chatbot.sdk.models.BaseRequest;
import fptai.chatbot.sdk.models.BotInfo;
import fptai.chatbot.sdk.models.BotResponse;
import fptai.chatbot.sdk.models.Message;
import fptai.chatbot.sdk.models.Payload;

public class BotManager {
	private static Logger logger = LoggerFactory.getLogger(BotManager.class);

	private String botHost = "https://bot.fpt.ai";
	private String botToken;
	private String apiChatBot = "/api/get_answer/";
	private String apiBotInfo = "/api/bot_info/";
	private String channel = "api";
	private String botCode;


	private BaseRequest baseRequest;

	public String getBotHost() {
		return botHost;
	}

	public void setBotHost(String botHost) {
		this.botHost = botHost;
	}

	public String getBotToken() {
		return botToken;
	}

	public void setBotToken(String botToken) {
		this.botToken = botToken;
	}

	public String getApiChatBot() {
		return apiChatBot;
	}

	public void setApiChatBot(String apiChatBot) {
		this.apiChatBot = apiChatBot;
	}

	public String getApiBotInfo() {
		return apiBotInfo;
	}

	public void setApiBotInfo(String apiBotInfo) {
		this.apiBotInfo = apiBotInfo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	public void setBotCode(String botCode) {
		this.botCode = botCode;
	}

	public BotManager(String bot_host, String api_chat_bot, String api_bot_info, String bot_token, String channel) {
		this.botHost = bot_host;
		this.botToken = bot_token;
		this.apiChatBot = api_chat_bot;
		this.apiBotInfo = api_bot_info;
		this.channel = channel;
		this.botCode = getBotCode();
		this.baseRequest = new BaseRequest(this.channel, this.botCode);
	}

	public BotManager(String bot_host, String bot_token, String channel) {
		this.botHost = bot_host;
		this.botToken = bot_token;
		this.channel = channel;
		this.botCode = getBotCode();
		this.baseRequest = new BaseRequest(this.channel, this.botCode);
	}

	public BotManager(String bot_token, String channel) {
		this.botToken = bot_token;
		this.channel = channel;
		this.botCode = getBotCode();
		this.baseRequest = new BaseRequest(this.channel, this.botCode);
	}
	
	public BotManager(String bot_token) {
		this.botToken = bot_token;
		this.botCode = getBotCode();
		this.baseRequest = new BaseRequest(this.channel, this.botCode);
	}

	public BotManager() {

	}

	public BotManager buildTextMessage(String content)
			throws JsonGenerationException, JsonMappingException, IOException {
		Message ms = new Message("text", content);
		this.baseRequest.setMessage(ms);
		return this;
	}

	public BotManager buildPayLoadMessage(String step_name, HashMap<String, String> attributes)
			throws JsonGenerationException, JsonMappingException, IOException {
		String payload = new Payload(attributes).build();
		String content = "";
		if (step_name != null) {
			content = String.valueOf(content) + step_name + "#";
		}
		content = String.valueOf(content) + Base64.getEncoder().encodeToString(payload.getBytes());
		Message ms = new Message("payload", content);
		this.baseRequest.setMessage(ms);
		return this;
	}

	public String sendMessage(String sender_id){
		this.baseRequest.setSenderId(sender_id);
		ObjectMapper Obj = new ObjectMapper();
		String request;
		try {
			request = Obj.writeValueAsString(this.baseRequest);
			URL url = new URL(String.valueOf(this.botHost) + this.apiChatBot);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + this.botToken);
			OutputStream os = conn.getOutputStream();
			os.write(request.getBytes());
			os.flush();
			if (conn.getResponseCode() != 200) {
				logger.error("Failed to sent message: {}", conn.getResponseCode());
			}
			os.close();
			conn.disconnect();
			return "Success";
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Failed";
		
	}

	public BotResponse parseResponse(String response) {
		ObjectMapper objectMapper = new ObjectMapper();
		BotResponse res = null;
		try {
			res = (BotResponse) objectMapper.readValue(response, BotResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}

	private String getBotCode() {
		URL url;
		try {
			url = new URL(String.valueOf(this.botHost) + this.apiBotInfo);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + this.botToken);
			if (conn.getResponseCode() != 200) {
				logger.warn("Cannot get bot info from {}, HTTP code: {}", this.botHost + this.apiBotInfo, conn.getResponseCode());
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(df);
			BotInfo botInfo = mapper.readValue(br, BotInfo.class);
			br.close();
			conn.disconnect();
			return botInfo.getCode();
		} catch (IOException e) {
			logger.error("Bot info empty or invalid bot host");
			e.printStackTrace();
		}
		return "";
	}

}
