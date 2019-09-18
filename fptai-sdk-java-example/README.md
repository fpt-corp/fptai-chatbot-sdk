# SDK JAVA
### Overview
In this example, use <a href="http://sparkjava.com/documentation#getting-started">Framework Spark Java</a> as webhook
### Perform
- Add the library fptai-chatbot-sdk-java.jar at folder /libs
- Add dependency for Framework and to use in SDK
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
- **Send message to chat bot engine**  
Read more at src/test/java/fptai.chatbot.sdk.example.AppTest
    + Initialize BotManager 
    ```BotManager bmn = new BotManager(bot_token);```  
        - Description of the parameter bot_token <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#bot-information">here</a>  
    + Build the message  
        - **Text message**  
        ```bmn.buildTextMessage(content)```
            + The content parameter is the message content: For example: "Hi"
        - **Payload message**  
        ```bmn.buildPayLoadMessage(step_name, attributes)```
            + Parameters:  
                + *step_name*: The step will be move to (In the process of processing bot). For example: "NextStep"  
                + *attributes*: A payload to assign variables on the bot
    + Send message  
        ```bmn.buildTextMessage(content).sendMessage(sender_id)```  
        ```bmn.buildPayLoadMessage(step_name, attributes).sendMessage(sender_id)```  
        - Parameters: 
            + *sender_id*: The id of user who will receive the message
- **Build webhook to get response**  
Read more at src/main/java/fptai.chatbot.sdk.example.App
    + Create the GET method API to confirm webhook configuration on bot  
    ```
    get("/receive-response", (request, response) -> {
			return "0df2e72e-cef8-11e9-bb65-2a2ae2dbcce4";
		});
    ```  
    + Create the POST method API to get response from the bot
    ```
    post("/receive-response", (request, response) -> {
        return "Sucess"
    })
    ```
    + <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#webhook">Configure the webhook</a> for the bot to let the bot send feedback about the newly created webhook
        + Link: is the API address created in the previous step (Must be a public address, you can use <a href="https://ngrok.com/">ngrok</a> to public API and use the public address to configure)
        + Secret Key: is the key to verify between bot and webhook(The return value of the GET method created above)
    + Get response  
        ```String bot_response = request.body();```
        + Parse response  
        ```BotResponse bot_res_obj = BotManager.parseResponse(bot_response);```