package fptai.dme.sdk.models;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;




public class DMETextRequest
{
  private String channel;
  private String app_code;
  private String sender_id;
  private DMEMessage message;
  
  public String getChannel() { return this.channel; }

  
  public void setChannel(String channel) { this.channel = channel; }

  
  public String getApp_code() { return this.app_code; }

  
  public void setApp_code(String app_code) { this.app_code = app_code; }

  
  public String getSender_id() { return this.sender_id; }

  
  public void setSender_id(String sender_id) { this.sender_id = sender_id; }


  
  public DMEMessage getMessage() { return this.message; }

  
  public void setMessage(DMEMessage message) { this.message = message; }


  
  public DMETextRequest(String channel, String app_code, String sender_id, String content) {
    this.channel = channel;
    this.app_code = app_code;
    this.sender_id = sender_id;
    DMEMessage message = new DMEMessage("text", content);
    this.message = message;
  }
  
  public String build() throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper Obj = new ObjectMapper();
    return Obj.writeValueAsString(this);
  }
}