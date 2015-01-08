package weathermonitor;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StatisticsDisplay implements Observer, DisplayElement{

	private static ArrayList<Float> countTemp = new ArrayList<Float>();
	private static ArrayList<Float> countHum = new ArrayList<Float>();
	private static ArrayList<Float> countPre = new ArrayList<Float>();
	private static float resultTAve;
	private static float resultTMin;
	private static float resultTMax;
	private static float resultHAve;
	private static float resultHMin;
	private static float resultHMax;
	private static float resultPAve;
	private static float resultPMin;
	private static float resultPMax;
	
		
	public static ArrayList<Float> getCountTemp() {
		return countTemp;
	}

	public static float getResultTAve() {
		return resultTAve;
	}

	public static float getResultTMin() {
		return resultTMin;
	}

	public static float getResultTMax() {
		return resultTMax;
	}

	public static float getResultHAve() {
		return resultHAve;
	}

	public static float getResultHMin() {
		return resultHMin;
	}

	public static float getResultHMax() {
		return resultHMax;
	}

	public static float getResultPAve() {
		return resultPAve;
	}


	public static float getResultPMin() {
		return resultPMin;
	}


	public static float getResultPMax() {
		return resultPMax;
	}

		
	
	public StatisticsDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	
	public float average (ArrayList<Float> array) {
		int count = 0;
		float sum = 0;
		float result = 0;
		
		for (Float d: array) {
			sum += d.floatValue();
			count++;
			result = sum/count;
		
		}
		return result;
	}
	
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;		
				
				countTemp.add(((WeatherData) obs).getTemperature());				
				resultTAve = average(countTemp);
				resultTMin = Collections.min(countTemp);
				resultTMax = Collections.max(countTemp);
				
				countHum.add(((WeatherData) obs).getHumidity());	
				resultHAve = average(countHum);
				resultHMin = Collections.min(countHum);
				resultHMax = Collections.max(countHum);
				
				countPre.add(((WeatherData) obs).getPressure());
				resultPAve = average(countPre);
				resultPMin = Collections.min(countPre);
				resultPMax = Collections.max(countPre);
       
		}
		display();
		
	}
	
	public void display() {
		System.out.println("N packet : " + countPre.size() + " min Temp "+ resultTMin + " max Temp " + resultTMax + " average temp " + resultTAve );
		
	}
	
	public static void go() {	
		
		JLabel jAveTemp, jrezTempAve, jminTemp, jmaxTemp, jrezTempMin, jrezTempMax;
		JLabel jAveHum, jrezHumAve,jminHum, jmaxHum, jrezHumMin, jrezHumMax;
		JLabel jAvePre, jrezPreAve, jminPre, jmaxPre, jrezPreMin, jrezPreMax;
		
		jAveTemp = new JLabel("Aver. Temperature : ");
		jminTemp = new JLabel("Min. Temperature : ");
		jmaxTemp = new JLabel("Max. Temperature : ");
		jrezTempAve = new JLabel("");
		jrezTempMin = new JLabel("");
		jrezTempMax = new JLabel("");
		
		jAveHum = new JLabel("Aver. Humidity : ");
		jminHum = new JLabel("Min. Humidity : ");
		jmaxHum = new JLabel("Max. Humidity : ");
		jrezHumAve = new JLabel("");
		jrezHumMin = new JLabel("");
		jrezHumMax = new JLabel("");
		
		jAvePre = new JLabel("Aver. Pressure : ");
		jminPre = new JLabel("Min. Pressure : ");
		jmaxPre = new JLabel("Max. Pressure : ");
		jrezPreAve = new JLabel("");
		jrezPreMin = new JLabel("");
		jrezPreMax = new JLabel("");
		
		JFrame jf = new JFrame("Statistics: ");
		jf.setSize(640,240);
		jf.setVisible(true);

		jf.setLayout(new GridLayout(3,6));	
		
		
		jf.add(jAveTemp);
		jf.add(jrezTempAve);
		jf.add(jminTemp);
		jf.add(jrezTempMin);
		jf.add(jmaxTemp);
		jf.add(jrezTempMax);
		
		jf.add(jAveHum);
		jf.add(jrezHumAve);
		jf.add(jminHum);
		jf.add(jrezHumMin);
		jf.add(jmaxHum);
		jf.add(jrezHumMax);
		
		jf.add(jAvePre);
		jf.add(jrezPreAve);
		jf.add(jminPre);
		jf.add(jrezPreMin);
		jf.add(jmaxPre);
		jf.add(jrezPreMax);
		
		String srtave = Float.toString(resultTAve);
		jrezTempAve.setText(srtave);
		
		String srtmin = Float.toString(resultTMin);
		jrezTempMin.setText(srtmin);
		
		String srtmax = Float.toString(resultTMax);
		jrezTempMax.setText(srtmax);
		
		String srhave = Float.toString(resultHAve);
		jrezHumAve.setText(srhave);
		
		String srhmin = Float.toString(resultHMin);
		jrezHumMin.setText(srhmin);
		
		String srhmax = Float.toString(resultHMax);
		jrezHumMax.setText(srhmax);

		String srpave = Float.toString(resultPAve);
		jrezPreAve.setText(srpave);
		
		String srpmin = Float.toString(resultPMin);
		jrezPreMin.setText(srpmin);
		
		String srpmax = Float.toString(resultPMax);
		jrezPreMax.setText(srpmax);
				
		}
	
}
