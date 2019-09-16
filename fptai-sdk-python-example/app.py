import json

import flask
from flask import Flask, request
from flask_restful import Resource, Api
from fptai_chatbot_sdk import constant
from fptai_chatbot_sdk.manage import BotManager

app = Flask(__name__)
api = Api(app)


class BotResponse(Resource):
    def get(self):
        response = flask.make_response("62b1de06-d2f8-11e9-bb65-2a2ae2dbcce4")
        response.headers['content-type'] = 'application/octet-stream'
        return response

    def post(self):
        # Bot Response

        # Bot Manager
        # Bot Response Object
        bot_response_obj = BotManager.parse_response(request.json)
        messages = bot_response_obj.messages
        for message in messages:
            type = message.type
            if type == constant.TEXT_MESSAGE:
                # Text message obj
                text_message = message.get_as_text_message()
            elif type == constant.IMAGE_MESSAGE:
                # Text image obj
                image_message = message.get_as_image_message()
            elif type == constant.CAROUSEL_MESSAGE:
                # Text message obj
                carousel_message = message.get_as_carousel_message()
            elif type == constant.QUICK_REPLY_MESSAGE:
                # Text message obj
                quick_reply_message = message.get_as_quick_reply_message()
            else:
                # Text message obj
                form_message = message.get_as_form_message()
        return "nothing"

api.add_resource(BotResponse, '/receive-response')
if __name__ == '__main__':
    app.run()
