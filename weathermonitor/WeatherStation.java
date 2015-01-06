package weathermonitor;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionsDisplay currentDisplay = 
				new CurrentConditionsDisplay(weatherData);
		
		ForecastDisplay forecastDisplay =
				new ForecastDisplay(weatherData);
		
		StatisticsDisplay statisticsDisplay =
				new StatisticsDisplay(weatherData);
		
		weatherData.setMeasumentsChanged(80, 63, 30);
		weatherData.setMeasumentsChanged(76, 64, 32);
		weatherData.setMeasumentsChanged(78, 63, 33);
		weatherData.setMeasumentsChanged(77, 68, 35);
		
		//currentDisplay.display();
		//forecastDisplay.display();

	}

}
