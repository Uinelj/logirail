package Graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXProgressBar;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FirstView extends Application{
	
	public static void main (String[] args){
		Application.launch(FirstView.class,args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Logirail la lourdeur");
		Group root = new Group();
		Scene scene = new Scene(root,300,250,Color.ALICEBLUE);
		Button btn = new Button();
		btn.setLayoutX(100);
		btn.setLayoutY(80);
		btn.setText("Wsh frr");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				System.out.println("Wsh frr tu me clik dsssu la");
			}
		});
		
		JFXButton jfoenixButton = new JFXButton("JFoenix Button");
		
		JFXButton button = new JFXButton("Raised Button".toUpperCase());
		button.getStyleClass().add("button-raised");
		
		JFXCheckBox checkBox = new JFXCheckBox("JFX CheckBox");
		checkBox.getStyleClass().add("custom-jfx-check-box");
		
		
		JFXProgressBar jfxBar = new JFXProgressBar();
		jfxBar.setPrefWidth(500);
		JFXProgressBar jfxBarInf = new JFXProgressBar();
		jfxBarInf.setPrefWidth(500);
		jfxBarInf.setProgress(-1.0f);
		Timeline timeline = new Timeline(
		    new KeyFrame(Duration.ZERO, new KeyValue(jfxBar.progressProperty(), 0), new KeyValue(jfxBar.progressProperty(), 0)),
		    new KeyFrame(Duration.seconds(2), new KeyValue(jfxBar.progressProperty(), 1), new KeyValue(jfxBar.progressProperty(), 1)));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		root.getChildren().add(button);
		root.getChildren().add(checkBox);
		root.getChildren().add(btn);
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
		
		
	}
	
}