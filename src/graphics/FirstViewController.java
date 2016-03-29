/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;

import data.Clock;
import engine.ClockThread;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FirstViewController implements Initializable {

    @FXML
    private VBox mainWindow;

    @FXML
    private Path all,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,ubal	;

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane view;

    @FXML
    private JFXHamburger menu;

    @FXML
    private JFXCheckBox filtreTous,filtreRetard,filtreArrivee,filtreDepart,filtreIncident;

    @FXML
    private Label hour,min,sec;

    @FXML
    private JFXButton x1,x2,x5;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    final Rectangle train = new Rectangle(20,10);
    private Clock clock = new Clock();
    private ClockThread clockR = new ClockThread(1, clock);
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

        assert mainWindow != null : "fx:id=\"mainWindow\" was not injected: check your FXML file 'main.fxml'.";
        assert mainView != null : "fx:id=\"mainView\" was not injected: check your FXML file 'main.fxml'.";
        assert view != null : "fx:id=\"view\" was not injected: check your FXML file 'main.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
        assert filtreTous != null : "fx:id=\"filtreTous\" was not injected: check your FXML file 'main.fxml'.";
        assert filtreArrivee != null : "fx:id=\"filtreArrivee\" was not injected: check your FXML file 'main.fxml'.";
        assert filtreDepart != null : "fx:id=\"filtreDepart\" was not injected: check your FXML file 'main.fxml'.";
        assert filtreIncident != null : "fx:id=\"filtreIncident\" was not injected: check your FXML file 'main.fxml'.";
        assert filtreRetard != null : "fx:id=\"filtreRetard\" was not injected: check your FXML file 'main.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";

        train.setFill(Color.web("#969696"));

        view.getChildren().add(train);


		Thread clockT = new Thread(clockR);
		clockT.start();
		System.out.println("thread demarre");
        //launchTrain();
		  Timer timer = new Timer(true); //set it as a deamon
		     timer.schedule(new changeTime(), 0, 200);

       	}

	public class changeTime extends TimerTask{
	    @Override
	    public void run() {

	        Platform.runLater(() -> {
	    		hour.setText("0"+String.valueOf(clock.getHour()));
	    		min.setText("0"+String.valueOf(clock.getMinute()));
	    		sec.setText(String.valueOf(clock.getSecond()));
	        });

	    }
	}

	public void changeTime(){
		hour.setText(String.valueOf(clock.getHour()));
		min.setText(String.valueOf(clock.getMinute()));
		sec.setText(String.valueOf(clock.getSecond()));
	}

	public void launchTrain(){
		  PathTransition TA1 = new PathTransition(Duration.millis(1000), A1, train);
		  TA1.setCycleCount(2);
		  //TA1.setOnFinished(new EventHandler<ActionEvent>() {
				//@Override
				//public void handle(ActionEvent finishHim) {view.getChildren().remove(train); }
			//});
		  TA1.play();
		  TA1.setNode(train);
		  TA1.setPath(A2);
		  System.out.println("breh");
		  TA1.play();
	}

	public void filtre(ActionEvent e){
	}

	public void buttonTimex1(ActionEvent e){
		 System.out.println("Vitesse normale");
		 clockR.setSpeed(1);

	}
	public void buttonTimex2(ActionEvent e){
		 System.out.println("Vitesse 2");
		 clockR.setSpeed(2);

	}
	public void buttonTimex5(ActionEvent e){
		 System.out.println("Vitesse 5");
		 clockR.setSpeed(5);

	}

	}



