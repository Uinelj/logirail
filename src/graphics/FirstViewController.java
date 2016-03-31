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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

/**
 * FXML Controller class
 *  This class control every interaction with GUI.
 * @author Arya JEMO
 */
public class FirstViewController implements Initializable {

	// Declaration of all FXML elements in order to control them.
    @FXML
    private VBox mainWindow;
    @FXML
    private Path all,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,ubal;
    @FXML
    private AnchorPane mainView,anchorText,view;
    @FXML
    private JFXHamburger menu;
    @FXML
    private JFXCheckBox filtreTous,filtreRetard,filtreArrivee,filtreDepart,filtreIncident;
    @FXML
    private Label hour,min,sec;
    @FXML
    private JFXButton x1,x2,x5,x10;
    @FXML
    private Font x3;
    @FXML
    private Color x4;
    @FXML
    private TextFlow textflow;


    // We had a train.
    final Rectangle train = new Rectangle(20,10);
    // We create a clock object.
    private Clock clock = new Clock();
    private ClockThread clockR = new ClockThread(1, clock);

    /**
	 * This class is called by the main.fxml
	 * @param The path of FXML.
	 * @param All nodes and elements in the FXML.
	 * */
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

        // We initialize a train.
        train.setFill(Color.web("#969696"));
        view.getChildren().add(train);
        // We initialize a clock.
		Thread clockT = new Thread(clockR);
		clockT.start();
		System.out.println("thread demarre");
        //launchTrain();
		  Timer changeClock = new Timer(true); //set it as a deamon
		     changeClock.schedule(new changeTime(), 0, 100);

		     Timer textFlow = new Timer(true); //set it as a deamon
		     textFlow.schedule(new textFlow(), 0, 2000);

		     Text welcome = new Text(String.valueOf(clock.getHour())+":"+ String.valueOf(clock.getMinute())+":"+String.valueOf(clock.getSecond())+" : "+ "Welcome into logirail, the simulation of RER A is going to start.\n");
		     welcome.setFont(Font.font("Helvetica", FontPosture.REGULAR, 13));
		     welcome.setFill(Color.GREEN);
		     TextFlow textflow = new TextFlow(welcome);
		     anchorText.getChildren().add(textflow);

		     Timer train = new Timer(true); //set it as a deamon
		     train.schedule(new launchTrain(), 0, 2000);

       	}

    /**
	 * This class modify the GUI hour.
	 * */
	public class textFlow extends TimerTask{
	    @Override
	    public void run() {

		     //Text text1 = new Text("Big italic red text\n");
		     //text1.setFill(Color.RED);
//		     text1.setFont(Font.font("Helvetica", FontPosture.REGULAR, 10));
//		     Text text2 = new Text(" little bold blue text");
//		     text2.setFill(Color.BLUE);
//		     text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
//		     TextFlow textflow = new TextFlow(text1, text2);
//System.out.println("test");

	       ;

	    }
	}


    /**
	 * This class modify the GUI hour.
	 * */
	public class changeTime extends TimerTask{
	    @Override
	    public void run() {

	        Platform.runLater(() -> {
	    		hour.setText("0"+String.valueOf(clock.getHour()));
	    		if(clock.getMinute()>=10){
		    		min.setText(String.valueOf(clock.getMinute()));
	    		}
	    		else{
		    		min.setText("0"+String.valueOf(clock.getMinute()));
	    		}
	    		sec.setText(String.valueOf(clock.getSecond()));
	        });

	    }
	}

	public class launchTrain extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
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

	}

	public void filtre(ActionEvent e){
	}


    /**
	 * This method control the x1 speed hour button.
	 * @param The event that call the method.
	 * */

	public void buttonTimex1(ActionEvent e){
		 System.out.println("Vitesse normale");
		 clockR.setSpeed(1);

	}
	 /**
		 * This method control the x2 speed hour button.
		 * @param The event that call the method.
		 * */

	public void buttonTimex2(ActionEvent e){
		 System.out.println("Vitesse 2");
		 clockR.setSpeed(2);

	}
	 /**
		 * This method control the x5 speed hour button.
		 * @param The event that call the method.
		 * */

	public void buttonTimex5(ActionEvent e){
		 System.out.println("Vitesse 5");
		 clockR.setSpeed(5);
	}

/**
	 * This method control the x10 speed hour button.
	 * @param The event that call the method.
	 * */
	public void buttonTimex10(ActionEvent e){
		 System.out.println("Vitesse 10");
		 clockR.setSpeed(10);
	}

	}



