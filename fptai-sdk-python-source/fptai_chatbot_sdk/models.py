import json
from typing import List


class Status(object):
    def __init__(self, code: int = None, message: str = None, module: str = None, api_code: str = None,
                 err_code: str = None, detail: str = None, app_code: str = None,
                 button_title: str = None):
        self.code = code
        self.message = message
        self.module = module
        self.api_code = api_code
        self.err_code = err_code
        self.detail = detail
        self.app_code = app_code
        self.button_title = button_title

    @classmethod
    def from_json(cls, data):
        return cls(**data)


class Intent(object):
    def __init__(self, label: str = None, confidence: str = None):
        self.label = label
        self.confidence = confidence

    @classmethod
    def from_json(cls, data):
        return cls(**data)


class Data(object):
    def __init__(self, intents: List[Intent] = [], entities=[]):
        self.intents = intents
        self.entities = entities

    @classmethod
    def from_json(cls, data):
        intents = list(map(Intent.from_json, data["intents"]))
        data["intents"] = intents
        return cls(**data)


class PredictHistory(object):
    def __init__(self, type: str = None, status: Status = Status(), data: Data = Data(), history_id: int = None):
        self.status = status
        self.data = data
        self.history_id = history_id
        self.type = type

    @classmethod
    def from_json(cls, data):
        status = Status.from_json(data["status"])
        data["status"] = status
        return cls(**data)


class ConversationInput(object):
    def __init__(self, type: str = None, content: str = None):
        self.type = type
        self.content = content

    @classmethod
    def from_json(cls, data):
        return cls(**data)


class Button(object):
    def __init__(self, title: str = None, payload: str = None, url: str = None, phone_number: str = None):
        self.title = title
        self.payload = payload
        self.url = url
        self.phone_number = phone_number

    @classmethod
    def from_json(cls, data):
        return cls(**data)


class TextContent(object):
    def __init__(self, text: str = None, buttons: List[Button] = []):
        self.text = text
        self.buttons = buttons

    @classmethod
    def from_json(cls, data):
        try:
            btns = data["buttons"]
        except KeyError:
            btns = []
        buttons = list(map(Button.from_json, btns))
        data["buttons"] = buttons
        return cls(**data)


class TextMessage(object):
    def __init__(self, type: str = "text", content: TextContent = TextContent()):
        self.type = type
        self.content = content

    @classmethod
    def from_json(cls, data):
        content = TextContent.from_json(data["content"])
        data["content"] = content
        return cls(**data)


class ImageContent(object):
    def __init__(self, title: str = None, url: str = None, buttons: List[Button] = []):
        self.title = title
        self.url = url
        self.buttons = buttons

    @classmethod
    def from_json(cls, data):
        try:
            btns = data["buttons"]
        except KeyError:
            btns = []
        buttons = list(map(Button.from_json, btns))
        data["buttons"] = buttons
        return cls(**data)


class ImageMessage(object):
    def __init__(self, type: str = "image", content: ImageContent = ImageContent()):
        self.type = type
        self.content = content


class CarouselCard(object):
    def __init__(self, image_url: str = None, subtitle: str = None, title: str = None, buttons: List[Button] = [],
                 item_url: str = None):
        self.image_url = image_url
        self.subtitle = subtitle
        self.title = title
        self.buttons = buttons
        self.item_url = item_url

    @classmethod
    def from_json(cls, data):
        try:
            btns = data["buttons"]
        except KeyError:
            btns = []
        buttons = list(map(Button.from_json, btns))
        data["buttons"] = buttons
        return cls(**data)


class CarouselContent(object):
    def __init__(self, carousel_cards: List[CarouselCard] = []):
        self.carousel_cards = carousel_cards

    @classmethod
    def from_json(cls, data):
        try:
            carousel_cards_data = data["carousel_cards"]
        except KeyError:
            carousel_cards_data = []
        carousel_cards = list(map(CarouselCard.from_json, carousel_cards_data))
        data["carousel_cards"] = carousel_cards
        return cls(**data)


class CarouselMessage(object):
    def __init__(self, type: str = "carousel", content: CarouselContent = CarouselContent()):
        self.type = type
        self.content = content


class Message(object):
    def __init__(self, type: str = None, content=None):
        self.type = type
        self.content = content

    @classmethod
    def from_json(cls, data):
        return cls(**data)

    def get_as_text_message(self):
        text_content = TextContent.from_json(self.content)
        return TextMessage(content=text_content)

    def get_as_image_message(self):
        image_content = ImageContent.from_json(self.content)
        return ImageMessage(content=image_content)

    def get_as_carousel_message(self):
        carousel_content = CarouselContent.from_json(self.content)
        return CarouselMessage(content=carousel_content)

    def get_as_form_message(self):
        text_content = TextContent.from_json(self.content)
        return TextMessage(content=text_content)

    def get_as_quick_reply_message(self):
        text_content = TextContent.from_json(self.content)
        return TextMessage(content=text_content)


class BotResponse(object):
    def __init__(self, app_code: str, sender_id: str, channel: str, sender_data: str, answer_source: str,
                 conversation_input: ConversationInput = ConversationInput(),
                 predict_history: PredictHistory = PredictHistory(),
                 messages: List[Message] = []):
        self.app_code = app_code
        self.sender_id = sender_id
        self.channel = channel
        self.sender_data = sender_data
        self.answer_source = answer_source
        self.conversation_input = conversation_input
        self.predict_history = predict_history
        self.messages = messages

    @classmethod
    def from_json(cls, data):
        try:
            predict_history = PredictHistory.from_json(data["predict_history"])
            data["predict_history"] = predict_history
        except KeyError:
            pass
        try:
            conversation_input = ConversationInput.from_json(data["conversation_input"])
            data["conversation_input"] = conversation_input
        except KeyError:
            pass
        try:
            messages = list(map(Message.from_json, data["messages"]))
            data["messages"] = messages
        except KeyError:
            pass
        return cls(**data)
