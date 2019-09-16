import base64
import json
from collections import namedtuple
import requests

from fptai_chatbot_sdk.models import BotResponse


class BotManager(object):

    def __init__(self, bot_token, channel='api', bot_host='https://bot.fpt.ai', api_chat_bot='/api/get_answer/',
                 api_bot_info='/api/bot_info/', ):
        self.bot_host = bot_host
        self.bot_token = bot_token
        self.api_chat_bot = api_chat_bot
        self.api_bot_info = api_bot_info
        self.channel = channel
        self.bot_code = self.get_bot_code()
        self.message = {
            'channel': self.channel,
            'app_code': self.bot_code,
        }

    def build_text_message(self, content):
        self.message['message'] = {
            'type': 'text',
            'content': content
        }
        return self

    def build_payload_message(self, step_name, attributes):
        payload = ''
        if step_name is not None:
            payload = payload + step_name + '#'
        attribute_data = {
            'set_attributes': attributes
        }
        base64_payload = base64.b64encode(str(attribute_data).replace('\'', '\'').encode()).decode()
        payload = payload + base64_payload
        self.message['message'] = {
            'type': 'payload',
            'content': payload
        }
        return self

    def send_message(self, sender_id):
        headers = {'Authorization': 'Bearer ' + self.bot_token, 'Content-Type': 'application/json'}
        self.message['sender_id'] = sender_id
        res = requests.post("{}{}".format(self.bot_host, self.api_chat_bot), json=self.message, headers=headers)
        if res.status_code == 200:
            return 'Success'
        else:
            return 'Failed'

    def parse_response(bot_response):
        return BotResponse.from_json(bot_response)

    def get_bot_code(self):
        headers = {'Authorization': 'Bearer ' + self.bot_token, 'Content-Type': 'application/json'}
        res = requests.get('{}{}'.format(self.bot_host, self.api_bot_info), headers=headers)
        return res.json()['code']
