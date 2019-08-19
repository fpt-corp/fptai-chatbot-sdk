import json
from collections import namedtuple
import requests


class DMEManager(object):
    api = 'api/get_answer/'

    def send_request(self, fptai_host, app_token, message):
        headers = {'Authorization': 'Bearer ' + app_token, 'Content-Type': 'application/json'}
        res = requests.post("{}/{}".format(fptai_host, self.api), headers=headers, json=message)
        return res

    def parse_response(self, response):
        res_obj = json.loads(response, object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
        return res_obj