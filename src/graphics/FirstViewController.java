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
    private AnchorPane mainView;

    @FXML
    private AnchorPane view;

    @FXML
    private JFXHamburger menu;

    @FXML
    private JFXCheckBox filtreTous;

    @FXML
    private JFXCheckBox filtreArrivee;

    @FXML
    private JFXCheckBox filtreDepart;

    @FXML
    private JFXCheckBox filtreIncident;

    @FXML
    private JFXCheckBox filtreRetard;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
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

        Rectangle train = new Rectangle(10,20,Color.LIGHTCORAL);
        view.getChildren().add(train);

        Path path = new Path();
        path.getElements().addAll(new MoveTo(50, 50), new HLineTo(350));
        path.setFill(null);
        view.getChildren().add(path);

        PathTransition pt = new PathTransition(Duration.millis(40), path, train);
        pt.setCycleCount(Animation.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
	}

	public void filtre(ActionEvent e){
	}

	public void gare (ActionEvent e){

		System.out.println("lolll");
	}

	}



