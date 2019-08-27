package fptai.chatbot.example;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import fptai.chatbot.sdk.manage.BotManager;

public class Example {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
//		Khoi tao bot
		BotManager botmnt = new BotManager("ec17489b2b4d164130c90d0d9ad7c4b0", "livechat",
				"8cf4e606bd78ac5ca468060b330ed83b");
		
//		Build Text Message
		String textms = botmnt.buildTextMessage("hi", "a76fe7ffb738e8f46494706a284498b5");
		System.out.println(textms);
//		Send Text Message To Bot
		botmnt.sendMessage(textms);
		
		
//		Build attributes
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put("sender", "sender");
//		Build PayLoad Message
		String payloadms = botmnt.buildPayLoadMessage("step_test", attributes, "a76fe7ffb738e8f46494706a284498b5");
		System.out.println(payloadms);
//		Send PayLoad Message to Bot
		botmnt.sendMessage(payloadms);
	}

}
