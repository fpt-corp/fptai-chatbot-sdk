# FPT AI CHAT BOT SDK  
## Tổng quan  
Chat bot SDK được sử dụng để gửi tin nhắn tới chat bot engine và chuyển đổi phản hồi từ chat bot.  
![Introduction](docs/Attribute.png "title")
- Gửi tin nhắn tới chat bot engine sử dụng SDK
- Tin nhắn được SDK gửi tới chat bot engine
- Chat bot sau khi xử lý phản hồi lại webhook (API để hứng phản hồi từ bot)
- Tại webhook ứng dụng có thể sử dụng SDK để phân tích phản hồi

## Sử dụng  
**Tạo một bot trên bot.fpt.ai**
   + Truy cập https://bot.fpt.ai thực hiện đăng nhập (Hoặc đăng ký nếu chưa có tài khoản)  
   + Tạo <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/bot">bot mới</a>
   + Lấy thông tin <a href="https://docs.fpt.ai/docs/en/conversation/documentation/bot-creator/settings#bot-information">bot token</a>

**Sử dụng SDK Java**  
Đọc thêm tại [đây](fptai-sdk-java-example/README.md)  
**Sử dụng SDK Python**  
Đọc thêm tại [đây](fptai-sdk-python-example/README.md)   