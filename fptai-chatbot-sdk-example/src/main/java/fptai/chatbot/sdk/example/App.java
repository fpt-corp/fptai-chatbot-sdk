package fptai.chatbot.sdk.example;

import static spark.Spark.*;

import fptai.chatbot.sdk.manage.BotManager;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		post("/receive-response", (request, response) -> {
			BotManager bmn = new BotManager();
			System.out.println(bmn.parseResponse(request.body()).getMessages());
			return "";
		});
		get("/receive-response", (request, response) -> {
			return "0df2e72e-cef8-11e9-bb65-2a2ae2dbcce4";
		});
	}
}
