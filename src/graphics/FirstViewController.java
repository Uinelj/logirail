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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FirstViewController implements Initializable {

    @FXML
    private AnchorPane mainView;

    @FXML
    private JFXHamburger menu;
    @FXML
    private VBox mainWindow;
    @FXML
    private JFXSlider zoom;

    @FXML
    private ImageView rer;

    @FXML
    private Font x3;

    @FXML
    private Circle gare1;

    @FXML
    private JFXCheckBox filtreTous,filtreArrivee,filtreDepart,filtreRetard,filtreIncident;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
        assert zoom != null : "fx:id=\"zoom\" was not injected: check your FXML file 'main.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";

       rer.fitWidthProperty().bind(mainWindow.widthProperty());
       rer.fitHeightProperty().bind(mainWindow.heightProperty());

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
	        assert zoom != null : "fx:id=\"zoom\" was not injected: check your FXML file 'main.fxml'.";
	        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
	        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";
	}

	public void filtre(ActionEvent e){

		 if (filtreTous.isSelected()){
		        filtreArrivee.setSelected(false);
		        filtreDepart.setSelected(false);
		        filtreRetard.setSelected(false);
		        filtreIncident.setSelected(false);
		    }

	}

	public void gare (ActionEvent e){

		System.out.println("lolll");
	}

	}



