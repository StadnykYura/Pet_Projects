package owmapi;

import java.util.ArrayList;

public class WeatherData {

	private Coord coord;
	private ArrayList <Weather> weather;
	private String base;
	private MainWeatherInfo main;
	private Wind wind;
	private Clouds clouds;
	private double dt;
	private Sys sys;
	private double id;
	private String name;
		
	
	public WeatherData() {
		// TODO Auto-generated constructor stub
	}


	public Coord getCoord() {
		return coord;
	}


	public void setCoord(Coord coord) {
		this.coord = coord;
	}


	public ArrayList<Weather> getWeather() {
		return weather;
	}


	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}


	public String getBase() {
		return base;
	}


	public void setBase(String base) {
		this.base = base;
	}


	public MainWeatherInfo getMain() {
		return main;
	}


	public void setMain(MainWeatherInfo main) {
		this.main = main;
	}


	public Wind getWind() {
		return wind;
	}


	public void setWind(Wind wind) {
		this.wind = wind;
	}


	public Clouds getClouds() {
		return clouds;
	}


	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}


	public double getDt() {
		return dt;
	}


	public void setDt(double dt) {
		this.dt = dt;
	}


	public Sys getSys() {
		return sys;
	}


	public void setSys(Sys sys) {
		this.sys = sys;
	}


	public double getId() {
		return id;
	}


	public void setId(double id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	
}
