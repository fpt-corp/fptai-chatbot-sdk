package fptai.chatbot.sdk.example;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.List;

import fptai.chatbot.sdk.manage.BotConstant;
import fptai.chatbot.sdk.manage.BotManager;
import fptai.chatbot.sdk.models.BotResponse;
import fptai.chatbot.sdk.models.Message;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		post("/receive-response", (request, response) -> {
			BotManager bmn = new BotManager();

			// Nội dung phản hổi từ bot nhận được qua cài đặt webhooks trên chat bot
			String bot_response = request.body();

			// Chuyển đổi nội dung phản hồi sang dạng đối tượng
			BotResponse bot_res_obj = bmn.parseResponse(bot_response);

			// Danh sách tin nhắn phản hồi từ bot
			List<Message> messages = bot_res_obj.getMessages();
			// Nhận message phản hồi
			for (Message message : messages) {
				String message_type = message.getType();

				switch (message_type) {
				case BotConstant.TEXT_MESSAGE:
					// Text Message Object
					System.out.println(message.getContentAsTextMessage().getText());
					break;
				case BotConstant.IMAGE_MESSAGE:
					// Image Message Object
					System.out.println(message.getContentAsImageMessage().getUrl());
					break;
				case BotConstant.CAROUSEL_MESSAGE:
					// Carousel Message Object
					System.out.println(message.getContentAsCarouselMessage().getCarouselCards());
					break;
				case BotConstant.QUICK_REPLY_MESSAGE:
					// Quick reply Message Object
					System.out.println(message.getContentAsQuickReplyMessage().getText());
					break;

				default:
					break;
				}
			}
			return "";
		});

		// Kiểm tra kết nối của chat bot với webhook khi cấu hình
		get("/receive-response", (request, response) -> {
			return "0df2e72e-cef8-11e9-bb65-2a2ae2dbcce4";
		});
	}
}
