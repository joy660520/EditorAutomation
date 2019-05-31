package apiAutomation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APILogin {
	public static void main(String[] args) {
		APILogin login = new APILogin();
		String token = login.loginIn();

	}

	public String loginIn() {
		String urlParameters = "email=joyautomation@staging.com.tw&password=000000"; // Body
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		String checkurl = "https://vrcam-test-api.istaging.com/api/v1/users/login";

		try {
			URL connectto = new URL(checkurl);
			HttpURLConnection conn = (HttpURLConnection) connectto.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("application", "json");
			conn.setUseCaches(false);
			conn.setAllowUserInteraction(false);
			conn.setInstanceFollowRedirects(false);
			conn.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = conn.getResponseCode();
			

			System.out.println("\nSending 'POST' request to URL : " + checkurl);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			
//			System.out.println(response.toString());// print in String，印出所有回傳資訊，但是跟下面那段不能一起用
			

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			br.close();

			String theToken = getSessionToken(sb);
			System.out.println("token return value is : " + theToken);
			return theToken;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getSessionToken(StringBuilder sb) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(sb.toString()).getAsJsonObject();
		String sessionToken = jsonObject.get("sessionToken").getAsString();
		return sessionToken;

	}

}
