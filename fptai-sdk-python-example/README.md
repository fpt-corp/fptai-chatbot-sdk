# SDK Python
### Overview
In this example, use <a href="https://flask-restful.readthedocs.io">Flask Framework</a> as webhook
### Perform
- Create virtual environment
    - On macOS and Linux:  
    ```python3 -m venv venv```
    - On Windows:  
    ```py -m venv venv```
- Activating a virtual environment
    - On macOS and Linux:  
    ```source venv/bin/activate```
    - On Windows:  
    ```.\venv\Scripts\activate```
- Install SDK  
```pip install -r requirements.txt```
- **Send message to chat bot engine**  
Read more at example.py
    + Initialize BotManager  
    ```bot_manager = BotManager(bot_token)```  
        - Description of the parameter bot_token <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#bot-information">here</a>  
    + Build the message  
        - **Text message**  
        ```bot_manager.build_text_message(content)```
            + The content parameter is the message content: For example: "Hi"
        - **Payload message**  
        ```bot_manager.build_payload_message(step_name,attributes)```
            + Parameters:  
                + *step_name*: The step will be move to (In the process of processing bot). For example: "NextStep"  
                + *attributes*: A payload to assign variables on the bot
    + Send message  
        ```bot_manager.build_payload_message(step_name,attributes).send_message(sender_id)```  
        ```bmn.buildPayLoadMessage(step_name, attributes).sendMessage(sender_id)```  
        - Parameters: 
            + *sender_id: The id of user who will receive the message*
- **Build webhook to get response**  
Read more at app.py
    + Create the GET method API to confirm webhook configuration on bot  
    ```
    def get(self):
        response = flask.make_response("62b1de06-d2f8-11e9-bb65-2a2ae2dbcce4")
        response.headers['content-type'] = 'application/octet-stream'
        return response
    ```  
    + Create the POST method API to get response from the bot
    ```
    def post(self):
        return "nothing"
    ```
    + Configure router  
    ```api.add_resource(BotResponse, '/receive-response')```
    + <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#webhook">Configure the webhook</a> for the bot to let the bot send feedback about the newly created webhook
        + Link: is the API address created in the previous step (Must be a public address, you can use <a href="https://ngrok.com/">ngrok</a> to public API and use the public address to configure)
        + Secret Key: is the key to verify between bot and webhook(The return value of the GET method created above)
    + Get response  
        ```request.json```
        + Parse response  
        ```BotManager.parse_response(request.json)```