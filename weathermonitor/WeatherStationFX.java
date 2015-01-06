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
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		Scene scene = new Scene(grid, 640,480);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Welcome");
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
		HBox hbBtn = new HBox(10);
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
        
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 1, 10);
		
        
        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	String t = userTemp.getText();
    			String h = userHum.getText();
    			String p = userPre.getText();
    			weatherData.setMeasumentsChanged(Float.parseFloat(t), Float.parseFloat(h), Float.parseFloat(p));
            	
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Tranfer Data Complete");
                
            }
        });
        
        btnCurrent.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	 
            	
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Current Display");
                actiontarget2.setFill(Color.BLACK);
                actiontarget2.setText("Current Data :");
            }
        });
        
        btnForecast.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	 
            	
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Forecast Display");
            }
        });
        
        btnStatistics.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Statistics Display");
            }
        });
        
        
       
        
		primaryStage.show();
		
		
	}

}
