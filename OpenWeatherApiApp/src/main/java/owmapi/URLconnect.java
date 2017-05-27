package owmapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class URLconnect {

	public StringBuffer sendGet(String url) throws Exception{
		
		
				
			URL obj = new URL(url);
			
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader inSt = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String inputLine;
			
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = inSt.readLine()) != null ) {
				response.append(inputLine);
			}
			
			inSt.close();
			
			return response;
		
		
	}
	
	public void sendPost(){
		
		
		
		
	}
	
	
}
