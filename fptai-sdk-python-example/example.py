from fptai_chatbot_sdk import constant
from fptai_chatbot_sdk.manage import BotManager


class Example():
    bot_host = "https://dev-local-v3.fpt.ai"
    bot_token = "2b0c6cf6ced17d46791c20d4dc76ef1c"
    channel = constant.CHANNEL_API
    bot_manager = BotManager(bot_token, channel, bot_host)

    # SEND PAYLOAD MESSAGE
    # Set variable name = chat bot
    attributes = {
        "name": "chatbot"
    }
    # Step name
    step_name = "NextStep"

    # Sender Id
    sender_id = "5d7d5b30acb2a068698aeb2ed7176075"
    res = bot_manager.build_payload_message(step_name,attributes).send_message(sender_id)
    # Response success or failed
    print(res)

    # SEND TEXT MESSAGE
    # content
    content = "hi"
    sender_id = "5d7d5b30acb2a068698aeb2ed7176075"
    res = bot_manager.build_text_message(content).send_message(sender_id)
    print(res)
