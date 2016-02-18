/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author A
 */
public class FirstViewController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private JFXHamburger menu;

    @FXML
    private JFXSlider zoom;

    @FXML
    private JFXButton test;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main.fxml'.";
        assert x2 != null : "fx:id=\"x2\" was not injected: check your FXML file 'main.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
        assert zoom != null : "fx:id=\"zoom\" was not injected: check your FXML file 'main.fxml'.";
        assert test != null : "fx:id=\"test\" was not injected: check your FXML file 'main.fxml'.";
        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	      assert x1 != null : "fx:id=\"x1\" was not injected: check your FXML file 'main.fxml'.";
	        assert x2 != null : "fx:id=\"x2\" was not injected: check your FXML file 'main.fxml'.";
	        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'main.fxml'.";
	        assert zoom != null : "fx:id=\"zoom\" was not injected: check your FXML file 'main.fxml'.";
	        assert test != null : "fx:id=\"test\" was not injected: check your FXML file 'main.fxml'.";
	        assert x3 != null : "fx:id=\"x3\" was not injected: check your FXML file 'main.fxml'.";
	        assert x4 != null : "fx:id=\"x4\" was not injected: check your FXML file 'main.fxml'.";
	}
	public void wsh(){

	System.out.println("test\n");
	test.setText("lol");
	}
	}



