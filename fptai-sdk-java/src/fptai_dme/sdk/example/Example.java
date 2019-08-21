package fptai_dme.sdk.example;

import java.io.IOException;
import java.util.HashMap;

import fptai_dme.sdk.manage.DMEManager;
import fptai_dme.sdk.models.DMEPayloadRequest;
import fptai_dme.sdk.models.DMETextRequest;
import fptai_dme.sdk.models.Payload;

public class Example {
	public static void main(String [] args) throws IOException {
		String text_req = new DMETextRequest("api", "8cf4e606bd78ac5ca468060b330ed83b", "773d1a250cfbab281a300b685db4f081", "hi").build();
		DMEManager dmg = new DMEManager();
		System.out.println(text_req);
		System.out.println(dmg.sendRequest("https://bot.fpt.ai", "ec17489b2b4d164130c90d0d9ad7c4b0",text_req));
		HashMap<String, String> set_attributes = new HashMap<>();
		set_attributes.put("sender", "tuantk");
		String payload = new Payload(set_attributes).build();
		System.out.println(payload);
		String payload_req = new DMEPayloadRequest("api", "8cf4e606bd78ac5ca468060b330ed83b", "773d1a250cfbab281a300b685db4f081","nextStep", payload).build();
		System.out.println(payload_req);
		dmg.sendRequest("https://bot.fpt.ai", "ec17489b2b4d164130c90d0d9ad7c4b0",payload_req);

	}

}
