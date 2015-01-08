package weathermonitor;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ForecastDisplay implements Observer, DisplayElement{
	private static float currentPressure = 29.92f;
	private float lastPressure;
	private static float currentTemperature = 25.00f;
	private float lastTemperature;
	private static float currentHumidity = 60.0f;
	private float lastHumidity;
	
	public static float getCurrentPressure() {
		return currentPressure;
	}

	public static float getCurrentTemperature() {
		return currentTemperature;
	}

	public static float getCurrentHumidity() {
		return currentHumidity;
	}

	public ForecastDisplay(Observable observable){
		observable.addObserver(this);
	}
	
	public void update(Observable observable, Object arg){
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
		
			lastTemperature = currentTemperature;
			currentTemperature = weatherData.getTemperature();	
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			lastHumidity = currentHumidity;
			currentHumidity = weatherData.getHumidity();
		}
		display();
		
	}
	
	public void display(){
		System.out.println("Forecast : " + "next temperature : " + currentTemperature + "F degrees " 
				+ "next humidity : " + currentHumidity + " %; " 
				+ "next pressure : " + currentPressure);
		
		
	}
	
	public static void go() {	
		
		JLabel nextTemp, jct, nextHum, jch, nextPre, jcp;
		nextTemp = new JLabel("Next temperature :");	
		nextHum = new JLabel("Next Humidity :");
		nextPre = new JLabel("Next Pressure :");	
		jct = new JLabel();
		jch = new JLabel();
		jcp = new JLabel();
		
		JFrame jf = new JFrame("Forecast: ");
		jf.setSize(320,240);
		jf.setVisible(true);

		jf.setLayout(new GridLayout(3,3));	
		
		jf.add(nextTemp);
		jf.add(jct);
		jf.add(nextHum);
		jf.add(jch);
		jf.add(nextPre);
		jf.add(jcp);
		
		String tr = Float.toString(currentTemperature);
		jct.setText(tr);
		
		String th = Float.toString(currentHumidity);
		jch.setText(th);
		
		String tp = Float.toString(currentPressure);
		jcp.setText(tp);
		}

}
