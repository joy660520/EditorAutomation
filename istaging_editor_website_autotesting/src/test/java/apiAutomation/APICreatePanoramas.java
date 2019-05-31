package apiAutomation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;


import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class APICreatePanoramas {
	public static void main(String[] args) throws Exception {
		APICreatePanoramas p = new APICreatePanoramas();
		String panoId = p.createPanorama();
	}

	public String createPanorama() throws JSONException {
		APILogin login = new APILogin();
		String token = login.loginIn();

		APICreateBuilding createBuilding = new APICreateBuilding();
		String buildingId = createBuilding.createBuilding();
		
		JSONObject bid = new JSONObject();
		bid.put("buildingId", "1");
		System.out.println(bid);
		
		JSONObject rotation = new JSONObject();
		rotation.put("x", 0);
		rotation.put("y", 12.1500061);
		rotation.put("z", 0);
		System.out.println(rotation);
		
		JSONObject position = new JSONObject();
		position.put("x", 15.1515616);
		position.put("y", 5166161.141235161);
		System.out.println(position);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "istg-rd-test-stereo-panorama-001122");
		obj2.put("index", 0);
		obj2.put("floorplanRotation", 12.413551616);
		obj2.put("category", "kitchen");
		obj2.put("isTopLogo", true);
		obj2.put("iamgeWidth", 8192);
		obj2.put("filesize", 7726737);
		obj2.put("rawUrl", "https://s3-us-west-1.amazonaws.com/panorama-pool-dev/DoNotDelete_TESTPanoForJoy.jpg");
		obj2.put("geo_longitude", 24.77828);
		obj2.put("geo_latitude", 120.98810);
		obj2.put("position", position);
		obj2.put("rotation", rotation);
		System.out.println(obj2);
		
		JSONArray array=new JSONArray();
		array.add(0, obj2);
		System.out.println(array);
		
		JSONObject panoInfo = new JSONObject();
		panoInfo.put("buildingId", buildingId);
		panoInfo.put("panoramas", array);
		System.out.println(panoInfo);
		
		String urlParameters = panoInfo.toString();;
		
		
//		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
//		int postDataLength = postData.length;
		String checkurl = "https://vrcam-test-api.istaging.com/api/v2/panoramas";

		try {
			URL connectto = new URL(checkurl);
			HttpURLConnection conn = (HttpURLConnection) connectto.openConnection();
			conn.setRequestMethod("POST");
			//conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setRequestProperty("iStaging-Token", token);
			conn.setRequestProperty("iStaging-Token-Type", "istaging");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 设置参数类型是json格式
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
			System.out.println(sb.toString());

			String thePanoramaId = panoramaId(sb);
			System.out.println("PanoramaId return value is : " + thePanoramaId);
			return thePanoramaId;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String panoramaId(StringBuilder sb) {
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(sb.toString()).getAsJsonArray();
		String objectId = jsonArray.get(0).getAsJsonObject().get("objectId").getAsString();
		return objectId;

	}
	
}
