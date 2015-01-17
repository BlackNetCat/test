package weathermonitor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class WeatherStationSW implements ActionListener{	
	
	JLabel jlab1, jlab2, jlab3, jlabFinal;
	JTextField jtf1, jtf2, jtf3;	

	WeatherData weatherData = new WeatherData();
	
	CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
	
	ForecastDisplay forecastDisplay =
			new ForecastDisplay(weatherData);
	
	StatisticsDisplay statisticsDisplay =
			new StatisticsDisplay(weatherData);
	
	
	public static void main(String[] args){
		WeatherStationSW example = new WeatherStationSW();		
		example.go();
	}
	
	public void go() {	
		
			
		
		JFrame jframe = new JFrame("Weather Station");
		
		jframe.setSize(640,480);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridLayout(3,3));
		JPanel panelSub = new JPanel(new GridLayout(1,2));
		JPanel panelButton = new JPanel(new GridLayout(1,1));
		
		jlab1 = new JLabel("Input Temperature");
		jlab2 = new JLabel("Input Humidity");
		jlab3 = new JLabel("Input Pressure");
		
		jtf1 = new JTextField(2);
		jtf2 = new JTextField(2);
		jtf3 = new JTextField(2);
		
		jlabFinal = new JLabel("Welcome to Weather Station");
		
		JButton button = new JButton("Submit");
		JButton button2 = new JButton("CurrentDisplay");
		JButton button3 = new JButton("Forecast");
		JButton button4 = new JButton("Statistics");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		panel.add(jlab1);
		panel.add(jtf1);
		panel.add(jlab2);
		panel.add(jtf2);
		panel.add(jlab3);
		panel.add(jtf3);
		
		panelSub.add(button);		
		panelButton.add(button2);		
		panelButton.add(button3);
		panelButton.add(button4);
		
		panelSub.add(jlabFinal);
		
		jframe.add(panel, BorderLayout.NORTH);
		jframe.add(panelSub, BorderLayout.CENTER);
		jframe.add(panelButton, BorderLayout.SOUTH);
		
		jframe.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getActionCommand().equals("Submit")){			
			
			String t = jtf1.getText();
			String h = jtf2.getText();
			String p = jtf3.getText();
			weatherData.setMeasumentsChanged(Float.parseFloat(t), Float.parseFloat(h), Float.parseFloat(p));
				
			jlabFinal.setText("Send Complete");
		}
		if(ae.getActionCommand().equals("CurrentDisplay"))	{
			jlabFinal.setText("CurrentDisplay");
			CurrentConditionsDisplay.go();
		}
		
		if(ae.getActionCommand().equals("Forecast"))	{
			jlabFinal.setText("Forecast");
			ForecastDisplay.go();
		}
		
		if(ae.getActionCommand().equals("Statistics"))	{
			jlabFinal.setText("Statistics");
			StatisticsDisplay.go();
		}		
				
		
	}

}