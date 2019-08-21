package fptai_dme_sdk.manage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

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

		conn.disconnect();

		return conn.getResponseCode();

	}

}
