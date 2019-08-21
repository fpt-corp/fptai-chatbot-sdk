from fptai_dme_sdk.manage import DMEManager
from fptai_dme_sdk.models import DMERequest


class Example:
    channel = 'api'
    app_code = '8cf4e606bd78ac5ca468060b330ed83b'
    sender_id = '5781137873b1743a3c7f82e2aabdccf2'
    message_type = 'text'
    message_content = 'hi'
    fptai_host = 'https://bot.fpt.ai'
    app_token = 'ec17489b2b4d164130c90d0d9ad7c4b0'
    payload = {
        "set_attributes": {
            "voucher_code": "AKKSKKSKkSODS"
        }
    }
    message = DMERequest(channel, app_code, sender_id).build_payload_message(None, payload)

    status = DMEManager().send_request(fptai_host, app_token, message)
    print(status)