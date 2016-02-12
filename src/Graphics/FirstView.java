package Graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXProgressBar;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
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
		//Group root = new Group();
	    Parent root = FXMLLoader.load(getClass().getResource("./main.fxml"));

		Scene scene = new Scene(root,1280,640,Color.ALICEBLUE);
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
		button.setLayoutX(100);

		JFXCheckBox checkBox = new JFXCheckBox("JFX CheckBox");
		checkBox.getStyleClass().add("custom-jfx-check-box");
		checkBox.setLayoutY(200);
		//primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(2));
		//primaryStage.minHeightProperty().bind(scene.widthProperty().divide(4));

		 primaryStage.titleProperty().bind(
		            scene.widthProperty().asString().
		            concat(" : ").
		            concat(scene.heightProperty().asString()));

		//root.getChildren().add(button);
		//root.getChildren().add(checkBox);
		//root.getChildren().add(btn);
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.sizeToScene();
		primaryStage.show();


	}

}