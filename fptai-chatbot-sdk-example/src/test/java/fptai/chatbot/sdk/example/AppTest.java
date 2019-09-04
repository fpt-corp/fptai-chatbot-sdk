package fptai.chatbot.sdk.example;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import fptai.chatbot.sdk.manage.BotManager;
/**
 * Unit test for simple App.
 */
public class AppTest {

	BotManager bmn = new BotManager("ec17489b2b4d164130c90d0d9ad7c4b0");
	@Test
	public void testSendTextRequest() throws JsonGenerationException, JsonMappingException, IOException {
		assertEquals(bmn.buildTextMessage("hi").sendMessage("773d1a250cfbab281a300b685db4f081"), 200);
	}

	@Test
	public void testSendPayLoadRequest() throws JsonGenerationException, JsonMappingException, IOException {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("key", "value");
		assertEquals(bmn.buildPayLoadMessage("Step", attributes).sendMessage("773d1a250cfbab281a300b685db4f081"), 200);
	}
}
