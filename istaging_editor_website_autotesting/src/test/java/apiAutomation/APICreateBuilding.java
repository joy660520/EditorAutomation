package apiAutomation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APICreateBuilding {
	public static void main(String[] args) {
		APICreateBuilding createBuilding = new APICreateBuilding();
		String buildingId = createBuilding.createBuilding();

	}

	public String createBuilding() {
		APILogin login = new APILogin();
		String sessiontoken = login.loginIn();
		String urlParameters = "name=joytest&description=AAAAAAAA"; // Body
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		String checkurl = "https://vrcam-test-api.istaging.com/api/v2/buildings";

		try {
			URL connectto = new URL(checkurl);
			HttpURLConnection conn = (HttpURLConnection) connectto.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setRequestProperty("iStaging-Token", sessiontoken);
			conn.setRequestProperty("iStaging-Token-Type", "istaging");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
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

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			br.close();

			String theBuildingId = getObjectId(sb);
			System.out.println("buildingId return value is : " + theBuildingId);
			return theBuildingId;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getObjectId(StringBuilder sb) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(sb.toString()).getAsJsonObject();
		String objectId = jsonObject.get("objectId").getAsString();
		return objectId;
		
		
		
		

	}
}
