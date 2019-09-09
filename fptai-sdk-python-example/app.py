from flask import Flask, request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)


class BotResponse(Resource):
    def get(self):
        return '62b1de06-d2f8-11e9-bb65-2a2ae2dbcce4'

    def post(self):
        print(request.json)
        return 'a'

api.add_resource(BotResponse, '/receive-response')
if __name__ == '__main__':
    app.run()
