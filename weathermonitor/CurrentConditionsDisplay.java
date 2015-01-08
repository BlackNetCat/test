package weathermonitor;


import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CurrentConditionsDisplay implements Observer, DisplayElement{
	Observable observable;
	private static float temperature = 0;
	private static float humidity = 0;
	private static float pressure = 0;
	
	
	public CurrentConditionsDisplay(Observable observable){
		this.observable = observable;
		observable.addObserver(this);
	}
	public void update(Observable obs, Object arg ){
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;		
			this.temperature  = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
		}
	
 		display();
	}
	
	
	public static float getTemperature() {
		return temperature;
	}
	public static void setTemperature(float temperature) {
		CurrentConditionsDisplay.temperature = temperature;
	}
	
	public static float getHumidity() {
		return humidity;
	}
	public static void setHumidity(float humidity) {
		CurrentConditionsDisplay.humidity = humidity;
	}
	public static float getPressure() {
		return pressure;
	}
	public static void setPressure(float pressure) {
		CurrentConditionsDisplay.pressure = pressure;
	}
	
	public void display(){
		System.out.println("Current conditions: " + " temperature " + temperature + "F degrees; " + 
	humidity + "% humidity; " + pressure + " Pressure ");
		
	}   
	
	public static void go() {	
		
	JLabel jtemperature, jdegree, jlabcur1, jhumidity, jlabcur2,jpersent, jpressure, jbar, jlabcur3;
		
	JFrame jf = new JFrame("Current conditions: ");
	jf.setSize(320,240);
	jf.setVisible(true);

	jf.setLayout(new GridLayout(3,3));	
	
	jtemperature = new JLabel("Temperature ");	
	jlabcur1 = new JLabel();
	jdegree = new JLabel("F degrees ");
	jhumidity = new JLabel("Humidity");
	jlabcur2 = new JLabel();
	jpersent = new JLabel(" % ");
	jpressure = new JLabel("Pressure");
	jlabcur3 = new JLabel();
	jbar = new JLabel(" bar ");
		
	jf.add(jtemperature);
	jf.add(jlabcur1);	
	jf.add(jdegree);	
	jf.add(jhumidity);
	jf.add(jlabcur2);
	jf.add(jpersent);
	jf.add(jpressure);
	jf.add(jlabcur3);
	jf.add(jbar);

		
	String tr = Float.toString(temperature);
	jlabcur1.setText(tr);
	
	String hr = Float.toString(humidity);
	jlabcur2.setText(hr);
	
	String pr = Float.toString(pressure);
	jlabcur3.setText(pr);
	}
	
	

}

