package weathermonitor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WeatherStationFX extends Application {
	
	WeatherData weatherData = new WeatherData();
	
	CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
	
	ForecastDisplay forecastDisplay =
			new ForecastDisplay(weatherData);
	
	StatisticsDisplay statisticsDisplay =
			new StatisticsDisplay(weatherData);

	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Weather Station FX");
		
		GridPane grid = new GridPane();
	//	grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
				
		Scene scene = new Scene(grid, 640,480);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Weather Station 2.0");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label labInTemp = new Label("Input Temperature:");
		grid.add(labInTemp, 0, 1);

		final TextField userTemp = new TextField();
		grid.add(userTemp, 1, 1);				

		Label labInHum = new Label("Input Humidity:");
		grid.add(labInHum, 0, 2);
		
		final TextField userHum = new TextField();
		grid.add(userHum, 1, 2);
		
		Label labInPre = new Label("Input Pressure:");
		grid.add(labInPre, 0, 3);
		
		final TextField userPre = new TextField();
		grid.add(userPre, 1, 3);
		
		Button btnSubmit = new Button("Submit");
		HBox hbBtn = new HBox(5);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSubmit);
		grid.add(hbBtn, 1, 4);
		
		Button btnCurrent = new Button("Current Display ");
		HBox hbBtn2 = new HBox(10);
		hbBtn2.setAlignment(Pos.TOP_LEFT);
		hbBtn2.getChildren().add(btnCurrent);
		grid.add(hbBtn2, 0, 7);
		
		Button btnForecast = new Button("Forecast Display");
		HBox hbBtn3 = new HBox(10);
		hbBtn3.setAlignment(Pos.TOP_LEFT);
		hbBtn3.getChildren().add(btnForecast);
		grid.add(hbBtn3, 0, 8);
		
		Button btnStatistics = new Button("Statistics Display");
		HBox hbBtn4 = new HBox(10);
		hbBtn4.setAlignment(Pos.TOP_LEFT);
		hbBtn4.getChildren().add(btnStatistics);
		grid.add(hbBtn4, 0, 9);
		
		 
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        final Text text11 = new Text();
        grid.add(text11, 2, 10);        
        final Text text12 = new Text();
        grid.add(text12, 3, 10);        
        final Text text13 = new Text();
        grid.add(text13, 4, 10);
        final Text text14 = new Text();
        grid.add(text14, 5, 10);
        final Text text15 = new Text();
        grid.add(text15, 6, 10);
        final Text text16 = new Text();
        grid.add(text16, 7, 10);
        
        
        final Text text21 = new Text();
        grid.add(text21, 2, 11);        
        final Text text22 = new Text();
        grid.add(text22, 3, 11);
        final Text text23 = new Text();
        grid.add(text23, 4, 11);
        final Text text24 = new Text();
        grid.add(text24, 5, 11);
        final Text text25 = new Text();
        grid.add(text25, 6, 11);
        final Text text26 = new Text();
        grid.add(text26, 7, 11);
        
        final Text text31 = new Text();
        grid.add(text31, 2, 12);        
        final Text text32 = new Text();
        grid.add(text32, 3, 12);
        final Text text33 = new Text();
        grid.add(text33, 4, 12);
        final Text text34 = new Text();
        grid.add(text34, 5, 12);
        final Text text35 = new Text();
        grid.add(text35, 6, 12);
        final Text text36 = new Text();
        grid.add(text36, 7, 12);
        
        final Text textPacket = new Text();
        grid.add(textPacket, 0, 10);
		
		
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	String t = userTemp.getText();
    			String h = userHum.getText();
    			String p = userPre.getText();
    			
    			if (t.isEmpty() || h.isEmpty() || p.isEmpty()) {
    				actiontarget.setFill(Color.FIREBRICK);
    				actiontarget.setText("Incorrect Data, try Again");
    			}
    			    			
    			else {
    			weatherData.setMeasumentsChanged(Float.parseFloat(t), Float.parseFloat(h), Float.parseFloat(p));
            	
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Tranfer Data Complete");
    			}
                
            }
        });
        
        btnCurrent.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	 
            	
                actiontarget.setFill(Color.DARKBLUE);
                actiontarget.setText("Current Display");
                
                text11.setFill(Color.BLUE);
                text11.setText("Temperature (C):");
                
                String tr = Float.toString(CurrentConditionsDisplay.getTemperature());   	
                text12.setFill(Color.BLACK);
                text12.setText(tr);
                
                text13.setFill(Color.BLUE);
                text13.setText(" ");
                
                text14.setFill(Color.BLUE);
                text14.setText(" ");
                
                text15.setFill(Color.BLUE);
                text15.setText(" ");
                
                text16.setFill(Color.BLUE);
                text16.setText(" ");
                
                text21.setFill(Color.BLUE);
                text21.setText("Humidity (%):");
                
                String hr = Float.toString(CurrentConditionsDisplay.getHumidity());   	
                text22.setFill(Color.BLACK);
                text22.setText(hr);
                
                text23.setFill(Color.BLUE);
                text23.setText("  ");
                
                text24.setFill(Color.BLUE);
                text24.setText("  ");
                
                text25.setFill(Color.BLUE);
                text25.setText("  ");
                
                text26.setFill(Color.BLUE);
                text26.setText("  ");
                
                text31.setFill(Color.BLUE);
                text31.setText("Pressure (bar):");
                
                String pr = Float.toString(CurrentConditionsDisplay.getPressure());   	
                text32.setFill(Color.BLACK);
                text32.setText(pr);
                
                text33.setFill(Color.BLUE);
                text33.setText("  ");
                
                text34.setFill(Color.BLUE);
                text34.setText("  ");
                
                text35.setFill(Color.BLUE);
                text35.setText("  ");
                
                text36.setFill(Color.BLUE);
                text36.setText("  ");
            }
        });
        
        btnForecast.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            		
                actiontarget.setFill(Color.DARKBLUE);
                actiontarget.setText("Forecast Display");
                
                text11.setFill(Color.BLUE);
                text11.setText("Next Temperature (C):");
                
                String tr = Float.toString(ForecastDisplay.getCurrentTemperature());   	
                text12.setFill(Color.BLACK);
                text12.setText(tr);            
                
                text13.setFill(Color.BLUE);
                text13.setText(" ");
                
                text14.setFill(Color.BLUE);
                text14.setText(" ");
                
                text15.setFill(Color.BLUE);
                text15.setText(" ");
                
                text16.setFill(Color.BLUE);
                text16.setText(" ");
                
                text21.setFill(Color.BLUE);
                text21.setText("Next Humidity (%):");
                
                String hr = Float.toString(ForecastDisplay.getCurrentHumidity());   	
                text22.setFill(Color.BLACK);
                text22.setText(hr);     
                
                text23.setFill(Color.BLUE);
                text23.setText(" ");
                
                text24.setFill(Color.BLUE);
                text24.setText("  ");
                
                text25.setFill(Color.BLUE);
                text25.setText("  ");
                
                text26.setFill(Color.BLUE);
                text26.setText("  ");
                
                text31.setFill(Color.BLUE);
                text31.setText("Next Pressure (bar):");
                
                String pr = Float.toString(ForecastDisplay.getCurrentPressure());   	
                text32.setFill(Color.BLACK);
                text32.setText(pr);          
                
                text33.setFill(Color.BLUE);
                text33.setText(" ");                

                text34.setFill(Color.BLUE);
                text34.setText("  ");
                
                text35.setFill(Color.BLUE);
                text35.setText("  ");
                
                text36.setFill(Color.BLUE);
                text36.setText("  ");
                
               
            }
        });
        
        btnStatistics.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.DARKBLUE);
                actiontarget.setText("Statistics Display");
                
                textPacket.setFill(Color.DARKBLUE);
                textPacket.setText("packets sends : " + StatisticsDisplay.getCountTemp().size());
                
                text11.setFill(Color.BLUE);
                text11.setText("Ave. Temp(%) ");
                
                String tar = Float.toString(StatisticsDisplay.getResultTAve());   	
                text12.setFill(Color.BLACK);
                text12.setText(tar);          
                
                text13.setFill(Color.BLUE);
                text13.setText("Min. Temp(%) ");
                
                String tminr = Float.toString(StatisticsDisplay.getResultTMin());   	
                text14.setFill(Color.BLACK);
                text14.setText(tminr);     
                
                text15.setFill(Color.BLUE);
                text15.setText("Max Temp(%) ");
                
                String tmaxr = Float.toString(StatisticsDisplay.getResultTMax());   	
                text16.setFill(Color.BLACK);
                text16.setText(tmaxr);    
                
                
                text21.setFill(Color.BLUE);
                text21.setText("Ave. Hum(%) ");
                
                String har = Float.toString(StatisticsDisplay.getResultHAve());   	
                text22.setFill(Color.BLACK);
                text22.setText(har);          
                
                text23.setFill(Color.BLUE);
                text23.setText("Min. Hum(%) ");
                
                String hminr = Float.toString(StatisticsDisplay.getResultHMin());   	
                text24.setFill(Color.BLACK);
                text24.setText(hminr);     
                
                text25.setFill(Color.BLUE);
                text25.setText("Max Hum(%) ");
                
                String hmaxr = Float.toString(StatisticsDisplay.getResultHMax());   	
                text26.setFill(Color.BLACK);
                text26.setText(hmaxr);    
                
                
                text31.setFill(Color.BLUE);
                text31.setText("Ave. Press(%) ");
                
                String par = Float.toString(StatisticsDisplay.getResultPAve());   	
                text32.setFill(Color.BLACK);
                text32.setText(par);          
                
                text33.setFill(Color.BLUE);
                text33.setText("Min. Press(%) ");
                
                String pminr = Float.toString(StatisticsDisplay.getResultPMin());   	
                text34.setFill(Color.BLACK);
                text34.setText(pminr);     
                
                text35.setFill(Color.BLUE);
                text35.setText("Max Press(%) ");
                
                String pmaxr = Float.toString(StatisticsDisplay.getResultPMax());   	
                text36.setFill(Color.BLACK);
                text36.setText(pmaxr);    
            }
        });
               
        
		primaryStage.show();
		
		
	}

}
