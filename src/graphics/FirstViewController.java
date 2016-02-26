/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Path all,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12;

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane view;

    @FXML
    private JFXHamburger menu;

    @FXML
    private JFXCheckBox filtreTous,filtreRetard,filtreArrivee,filtreDepart,filtreIncident;



    @FXML
    private Font x3;

    @FXML
    private Color x4;

    final Rectangle train = new Rectangle(20,10);

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

//        Path path = new Path();
//        path.getElements().addAll(new MoveTo(50, 50), new HLineTo(350));
//        path.setFill(null);
//        view.getChildren().add(path);


		  //TA1.setPath(A2);
		 // TA1.play();
        launchTrain();
	}


	public void launchTrain(){
		  PathTransition TA1 = new PathTransition(Duration.millis(1000), all, train);
		  TA1.setCycleCount(10);
		  TA1.setAutoReverse(true);
		  TA1.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent finishHim) {view.getChildren().remove(train); }
			});
		  TA1.play();

		  TA1.setPath(A2);
		  TA1.play();
	}

	public void filtre(ActionEvent e){
	}

	}



