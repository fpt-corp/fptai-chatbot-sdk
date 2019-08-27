package fptai.chatbot.sdk.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonParseException;

import fptai.chatbot.sdk.models.BaseRequest;
import fptai.chatbot.sdk.models.BotResponse;
import fptai.chatbot.sdk.models.Message;
import fptai.chatbot.sdk.models.Payload;

public class BotManager {
	private static String api = "/api/get_answer/";
	private String bot_host = "https://bot.fpt.ai";
	private String bot_token;
	private String channel;
	private String bot_code;

	public String getBot_host() {
		return bot_host;
	}

	public void setBot_host(String bot_host) {
		this.bot_host = bot_host;
	}

	public String getBot_token() {
		return bot_token;
	}

	public void setBot_token(String bot_token) {
		this.bot_token = bot_token;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getBot_code() {
		return bot_code;
	}

	public void setBot_code(String bot_code) {
		this.bot_code = bot_code;
	}

	public BotManager(String bot_host, String bot_token, String channel, String bot_code) {
		this.bot_host = bot_host;
		this.bot_token = bot_token;
		this.channel = channel;
		this.bot_code = bot_code;
	}

	public BotManager(String bot_token, String channel, String bot_code) {
		this.bot_token = bot_token;
		this.channel = channel;
		this.bot_code = bot_code;
	}

	public String buildTextMessage(String content, String sender_id)
			throws JsonGenerationException, JsonMappingException, IOException {
		Message ms = new Message("text", content);
		BaseRequest brq = new BaseRequest(this.channel, this.bot_code, sender_id, ms);
		ObjectMapper Obj = new ObjectMapper();
		return Obj.writeValueAsString(brq);
	}
	
	public String buildPayLoadMessage(String step_name, HashMap<String, String> attributes, String sender_id) throws JsonGenerationException, JsonMappingException, IOException {
		String payload = new Payload(attributes).build();
		String content = "";
		if (step_name != null) {
			content = String.valueOf(content) + step_name + "#";
		}
		content = String.valueOf(content) + Base64.getEncoder().encodeToString(payload.getBytes());
		Message ms = new Message("payload", content);
		BaseRequest brq = new BaseRequest(this.channel, this.bot_code, sender_id, ms);
		ObjectMapper Obj = new ObjectMapper();
		return Obj.writeValueAsString(brq);
	}
	public int sendMessage(String message) throws IOException {
		URL url = new URL(String.valueOf(this.bot_host) + api);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + this.bot_token);

		OutputStream os = conn.getOutputStream();
		os.write(message.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

		return conn.getResponseCode();
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

}
