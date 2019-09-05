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
	BotManager bmn = new BotManager("https://dev-local-v3.fpt.ai","2b0c6cf6ced17d46791c20d4dc76ef1c", BotConstant.CHANNEL_API);
	@Test
	public void testSendTextRequest() {
		assertEquals(bmn.buildTextMessage("hi").sendMessage("5d7d5b30acb2a068698aeb2ed7176075"), "Success");
	}

	@Test
	public void testSendPayLoadRequest() {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("key", "value");
		assertEquals(bmn.buildPayLoadMessage("Step", attributes).sendMessage("5d7d5b30acb2a068698aeb2ed7176075"), "Success");
	}
}
