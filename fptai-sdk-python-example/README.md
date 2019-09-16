# SDK Python
### Tổng quan
Trong ví dụ này sử dụng <a href="https://flask-restful.readthedocs.io">Flask Framework</a> làm webhook
### Thực hiện
- Cài đặt SDK  
```pip install -i https://test.pypi.org/simple/ fptai-chatbot-sdk```
- **Gửi tin nhắn tới chat bot engine**  
Xem thêm tại example.py
    + Khởi tạo BotManager  
    ```bot_manager = BotManager(bot_token)```  
        - Tham số bot_token được mô tả ở <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#bot-information">đây</a>  
    + Build tin nhắn  
        - **Tin nhắn text**  
        ```bot_manager.build_text_message(content)```
            + Tham số content là nội dung tin nhắn: Ví dụ: "Hi"
        - **Tin nhắn payload**  
        ```bot_manager.build_payload_message(step_name,attributes)```
            + Tham số:  
                + *step_name: Là bước sẽ được chuyển tới (Trong tiến trình bot xử lý). Ví dụ: "NextStep""*  
                + *attributes*: Là payload  để gán biến trên bot
    + Gửi tin nhắn  
        ```bot_manager.build_payload_message(step_name,attributes).send_message(sender_id)```  
        ```bmn.buildPayLoadMessage(step_name, attributes).sendMessage(sender_id)```  
        - Tham số: 
            + *sender_id: Là id của người dùng sẽ nhận tin nhắn*
- **Xây dựng webhook nhận phản hồi**  
Xem thêm tại app.py
    + Tạo API method GET để xác nhận cấu hình webhook trên bot  
    ```
    def get(self):
        response = flask.make_response("62b1de06-d2f8-11e9-bb65-2a2ae2dbcce4")
        response.headers['content-type'] = 'application/octet-stream'
        return response
    ```  
    + Tạo API method POST để nhận phản hồi từ bot
    ```
    def post(self):
        return "nothing"
    ```
    + Cấu hình router  
    ```api.add_resource(BotResponse, '/receive-response')```
    + <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#webhook">Cấu hình webhook</a> cho bot để bot gửi phản hồi về webhook vừa tạo
        + Link: là địa chỉ API vừa tạo ở bước trên (Phải là địa chỉ public, có thể sử dụng <a href="https://ngrok.com/">ngrok</a> để public API và sử dụng địa chỉ được public để cấu hình)
        + Secret Key: là khóa để xác minh giữa bot và webhook(Là giá trị trả về của phương thức GET được tạo ở trên)
    + Nhận phản hồi  
        ```request.json```
        + Parse response  
        ```BotManager.parse_response(request.json)```