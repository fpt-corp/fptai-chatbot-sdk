# SDK JAVA
### Tổng quan
Trong ví dụ này sử dụng <a href="http://sparkjava.com/documentation#getting-started">Framework Spark Java</a> làm webhook
### Thực hiện
- Thêm thư viện fptai-chatbot-sdk-java.jar tại thư mục /libs
- Thêm dependency cho Framework và phục vụ cho SDK
```python
<dependencies>  
    ...  
    <dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>com.sparkjava</groupId>
		<artifactId>spark-core</artifactId>
		<version>2.8.0</version>
	</dependency>
	<dependency>
		<groupId>org.codehaus.jackson</groupId>
		<artifactId>jackson-core-asl</artifactId>
		<version>1.9.0</version>
	</dependency>
	<dependency>
		<groupId>org.codehaus.jackson</groupId>
		<artifactId>jackson-mapper-asl</artifactId>
		<version>1.9.0</version>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-core</artifactId>
		<version>2.9.8</version>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>2.9.8</version>
	</dependency>
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-api</artifactId>
		<version>1.7.28</version>
	</dependency>
	<dependency>
		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-jdk14</artifactId>
		<version>1.7.28</version>
	</dependency>
	...
	</dependencies>
```
- **Gửi tin nhắn tới chat bot engine**  
Xem thêm tại src/test/java/fptai.chatbot.sdk.example.AppTest
    + Khởi tạo BotManager  
    ```BotManager bmn = new BotManager(bot_token);```  
        - Tham số bot_token được mô tả ở <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#bot-information">đây</a>  
    + Build tin nhắn  
        - **Tin nhắn text**  
        ```bmn.buildTextMessage(content)```
            + Tham số content là nội dung tin nhắn: Ví dụ: "Hi"
        - **Tin nhắn payload**  
        ```bmn.buildPayLoadMessage(step_name, attributes)```
            + Tham số:  
                + *step_name: Là bước sẽ được chuyển tới (Trong tiến trình bot xử lý). Ví dụ: "NextStep""*  
                + *attributes*: Là payload  để gán biến trên bot
    + Gửi tin nhắn  
        ```bmn.buildTextMessage(content).sendMessage(sender_id)```  
        ```bmn.buildPayLoadMessage(step_name, attributes).sendMessage(sender_id)```  
        - Tham số: 
            + *sender_id: Là id của người dùng sẽ nhận tin nhắn*
- **Xây dựng webhook nhận phản hồi**  
Xem thêm tại src/main/java/fptai.chatbot.sdk.example.App
    + Tạo API method GET để xác nhận cấu hình webhook trên bot  
    ```
    get("/receive-response", (request, response) -> {
			return "0df2e72e-cef8-11e9-bb65-2a2ae2dbcce4";
		});
    ```  
    + Tạo API method POST để nhận phản hồi từ bot
    ```
    post("/receive-response", (request, response) -> {
        return "Sucess"
    })
    ```
    + <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#webhook">Cấu hình webhook</a> cho bot để bot gửi phản hồi về webhook vừa tạo
        + Link: là địa chỉ API vừa tạo ở bước trên (Phải là địa chỉ public, có thể sử dụng <a href="https://ngrok.com/">ngrok</a> để public API và sử dụng địa chỉ được public để cấu hình)
        + Secret Key: là khóa để xác minh giữa bot và webhook(Là giá trị trả về của phương thức GET được tạo ở trên)
    + Nhận phản hồi  
        ```String bot_response = request.body();```
        + Parse response  
        ```BotResponse bot_res_obj = BotManager.parseResponse(bot_response);```