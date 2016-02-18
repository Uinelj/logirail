package Graphics;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSlider;
import javafx.scene.layout.*;
import javafx.scene.control.*;
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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FirstView extends Application{
	private Label h;
	private JFXHamburger menu;
	 private JFXSlider zoom;
	 private Button test;

	public static void main (String[] args){
		Application.launch(FirstView.class,args);
	}

    void initialize() {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
        assert zoom != null : "fx:id=\"zoom\" was not injected: check your FXML file 'main.fxml'.";
        assert h != null : "fx:id=\"h\" was not injected: check your FXML file 'main.fxml'.";
        assert test != null : "fx:id=\"test\" was not injected: check your FXML file 'main.fxml'.";

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		//primaryStage.setTitle("Logirail la lourdeur");
		// Group root = new Group();
        //final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("./main.fxml"));
        //Parent root = fxmlLoader.load();
		Scene scene = new Scene(root, 1280, 768, Color.ALICEBLUE);


		//primaryStage.setScene(new Scene (view));

		primaryStage.titleProperty()
				.bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));

		primaryStage.setScene(scene);
		primaryStage.setMinWidth(1040);
		primaryStage.setMinHeight(782);
		primaryStage.setResizable(true);
		primaryStage.sizeToScene();
		primaryStage.show();

	}

}

