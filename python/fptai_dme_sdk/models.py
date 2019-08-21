import base64


class BaseDMEMessage(object):

    def __init__(self, channel, app_code, sender_id):
        self.channel = channel
        self.app_code = app_code
        self.sender_id = sender_id


class DMERequest(BaseDMEMessage):

    def build_text_message(self, content):
        dme_req = {
            "channel": self.channel,
            "app_code": self.app_code,
            "sender_id": self.sender_id,
            "message": {
                "content": content,
                "type": "text",
            }
        }
        return dme_req

    def build_payload_message(self, step_name, payload):
        content = ''
        if step_name and step_name is not None:
            content = content + step_name + '#'
        content = content + base64.b64encode(str(payload).replace('\'', '\"').encode()).decode()

        dme_req = {
            "channel": self.channel,
            "app_code": self.app_code,
            "sender_id": self.sender_id,
            "message": {
                "content": content,
                "type": "payload",
            }
        }

        return dme_req



