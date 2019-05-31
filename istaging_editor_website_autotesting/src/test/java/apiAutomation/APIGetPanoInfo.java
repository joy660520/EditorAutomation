package apiAutomation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testSuitesLoginPage.JsLoginPageTest;

public class APIGetPanoInfo {

	public static void main(String[] args) throws Exception {
		
		APIGetPanoInfo pi = new APIGetPanoInfo();
		pi.panoInfo();

	}

	public void panoInfo() throws JSONException, Exception {
		APILogin login = new APILogin();
		String token = login.loginIn();

		APICreatePanoramas p = new APICreatePanoramas();
		String panoId = p.createPanorama();

		TimeUnit.SECONDS.sleep(30);

		String checkurl = "https://vrcam-test-api.istaging.com/api/v2/panoramas/" + panoId;
		URL connectto = new URL(checkurl);
		HttpURLConnection conn = (HttpURLConnection) connectto.openConnection();
		conn.setRequestMethod("GET");// optional default is GET
		conn.setRequestProperty("iStaging-Token", token);
		conn.setRequestProperty("iStaging-Token-Type", "istaging");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 设置参数类型是json格式
		conn.setRequestProperty("charset", "utf-8");
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + checkurl);
		System.out.println("Response Code : " + responseCode);
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(conn.getInputStream()));
		// String inputLine;
		// StringBuffer response = new StringBuffer();
		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }
		//// in.close();
		//
		// System.out.println(response.toString());// print in
		// String，印出所有回傳資訊，但是跟下面那段不能一起用
		

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		br.close();
		System.out.println(sb.toString());

		// JsonParser parser = new JsonParser();
		// JsonArray jsonArray = parser.parse(sb.toString()).getAsJsonArray();
		// String cubemapReady =
		// jsonArray.get(0).getAsJsonObject().get("cubemapReady").getAsString();
		// return cubemapReady;

		String isCubemapReady = cubemapReady(sb);
		System.out.println("isCubemapReady return value is : " + isCubemapReady);
		
		Assert.assertTrue(Boolean.valueOf(isCubemapReady));
		Assert.assertTrue(true);
		

	}

	public String cubemapReady(StringBuffer sb) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(sb.toString()).getAsJsonObject();
		String cubemapReady = jsonObject.get("cubemapReady").toString();
		return cubemapReady;

	}

}
