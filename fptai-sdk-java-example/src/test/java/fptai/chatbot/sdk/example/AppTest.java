package fptai.chatbot.sdk.example;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import fptai.chatbot.sdk.manage.BotConstant;
import fptai.chatbot.sdk.manage.BotManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
	// Địa chỉ của chat bot
	String bot_host = "https://dev-local-v3.fpt.ai";

	// Token của chat bot
	String bot_token = "2b0c6cf6ced17d46791c20d4dc76ef1c";

	// Channel của chat bot bao gồm:
	// CHANNEL_API, CHANNEL_FACEBOOK, CHANNEL_LIVECHAT,
	// CHANNEL_ZALO,CHANNEL_VIBER,CHANNEL_FACEBOOK_AT_WORK
	String channel = BotConstant.CHANNEL_API;
	BotManager bmn = new BotManager(bot_host, bot_token, channel);

	// Gửi tin nhắn dạng payload
	@Test
	public void testSendPayLoadRequest() {

		// Tạo nội dung payload
		HashMap<String, String> attributes = new HashMap<>();

		// Gán biến name = chatbot trên
		attributes.put("name", "chatbot");

		// Đi đến bước Step
		String step_name = "Step";

		// ID của người tham gia chat
		String sender_id = "5d7d5b30acb2a068698aeb2ed7176075";
		// Gửi message tới sender_id đã được chỉ định
		assertEquals(bmn.buildPayLoadMessage(step_name, attributes).sendMessage(sender_id), "Success");
	}

	// Gửi tin nhắn dạng text
	@Test
	public void testSendTextRequest() {

		// Nội dung tin nhắn
		String content = "hi";

		// ID của người tham gia chat
		String sender_id = "5d7d5b30acb2a068698aeb2ed7176075";
		// Gửi message tới sender_id đã được chỉ định
		assertEquals(bmn.buildTextMessage(content).sendMessage(sender_id), "Success");
	}

}
