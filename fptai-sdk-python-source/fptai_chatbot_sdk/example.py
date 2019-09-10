import json

from fptai_chatbot_sdk.manage import BotManager
from fptai_chatbot_sdk.models import BotResponse


class Example():
    a = BotManager("ec17489b2b4d164130c90d0d9ad7c4b0").build_text_message("hi").send_message(
        "773d1a250cfbab281a300b685db4f081")
    res = '{"messages": [{"type": "text", "content": {"text": "OK babe value"}}], "sender_id": "5d7d5b30acb2a068698aeb2ed7176075", "channel": "api", "answer_source": 1, "sender_data": "", "predict_history": {"status": {"message": "User click button", "code": 200, "button_title": "#Step"}, "type": "click_button"}, "conversation_input": {"type": "payload", "content": "Step#eyJzZXRfYXR0cmlidXRlcyI6eyJrZXkiOiJ2YWx1ZSJ9fQ=="}, "app_code": "109f3bd16526d20dd7b932192bdb8c8b"}'

    a = BotManager("ec17489b2b4d164130c90d0d9ad7c4b0").parse_response(res).messages
    print(type(BotResponse.from_json(json.loads(res)).messages[0].get_as_text_message().content))
    print(BotResponse.from_json(json.loads(res)).messages[0].get_as_text_message().content.text)
