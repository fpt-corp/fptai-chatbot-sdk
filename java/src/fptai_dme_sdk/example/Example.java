package fptai_dme_sdk.example;

import java.io.IOException;

import fptai_dme_sdk.manage.DMEManager;
import fptai_dme_sdk.models.DMERequest;

public class Example {
	public static void main(String [] args) throws IOException {
		DMERequest dme_request = new DMERequest("livechat", "8cf4e606bd78ac5ca468060b330ed83b", "773d1a250cfbab281a300b685db4f081");
		String textRq = dme_request.buildTextMessage("hi");
		DMEManager mng = new DMEManager();
		int responseCode = mng.sendRequest("https://bot.fpt.ai", "ec17489b2b4d164130c90d0d9ad7c4b0", textRq);
		System.out.println(responseCode);
	}

}
