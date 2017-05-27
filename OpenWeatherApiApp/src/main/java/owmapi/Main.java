package owmapi;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
	
		URLconnect urLconnect = new URLconnect();
		NewThread newThread = new NewThread(urLconnect,
		"http://api.openweathermap.org/data/2.5/weather?q=Lviv&units=metric&APPID=*********************");
/*		***************** put your APPID for using this url Register on openweatherapi to get APPID */
		
		try {
			newThread.t.join();
			
			System.out.println(newThread.getResult().toString());
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String str = newThread.getResult().toString();
	
		WeatherData weatherData = gson.fromJson(str, WeatherData.class);
//		for (int i = 0; i<=weatherData.getWeather().size()-1;i++) {
			
		System.out.println("Now in " + weatherData.getName() + " temperature is " + weatherData.getMain().getTemp() + " C");
//		}
	
//		
//		
//		
//		
//		
//		
//		
//		
//	
	
}
}
