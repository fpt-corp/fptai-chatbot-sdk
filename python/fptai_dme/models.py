class BaseDMEMessage(object):

    def __init__(self, channel, app_code, sender_id):
        self.channel = channel
        self.app_code = app_code
        self.sender_id = sender_id


class DMERequest(BaseDMEMessage):

    def build(self, message_type, content):
        dme_req = {
            "channel": self.channel,
            "app_code": self.app_code,
            "sender_id": self.sender_id,
            "message": {
                "content": content,
                "type": message_type,
            }
        }
        return dme_req

