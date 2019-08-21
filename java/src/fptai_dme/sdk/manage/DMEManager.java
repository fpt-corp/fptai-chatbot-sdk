package fptai_dme_sdk.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fptai_dme_sdk.models.DMEResponse;

public class DMEManager {

	static String api = "/api/get_answer/";

	public int sendRequest(String fptai_host, String app_token, String message) throws IOException {
		URL url = new URL(fptai_host + api);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + app_token);

		OutputStream os = conn.getOutputStream();
		os.write(message.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		conn.disconnect();

		return conn.getResponseCode();

	}

	public DMEResponse parseResponse(String response) {

		ObjectMapper objectMapper = new ObjectMapper();
		DMEResponse res = null;
		try {
			res = objectMapper.readValue(response, DMEResponse.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
