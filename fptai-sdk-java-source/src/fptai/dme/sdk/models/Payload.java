package fptai.dme.sdk.models;

import java.io.IOException;
import java.util.HashMap;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Payload {

	private HashMap<String, String> set_attributes;

	public HashMap<String, String> getSet_attributes() {
		return set_attributes;
	}

	public void setSet_attributes(HashMap<String, String> set_attributes) {
		this.set_attributes = set_attributes;
	}

	public Payload(HashMap<String, String> set_attributes) {
		this.set_attributes = set_attributes;
	}

	public String build() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper Obj = new ObjectMapper();
		return Obj.writeValueAsString(this);
	}

}
