package graphics;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FirstView extends Application{

	public static void main (String[] args){
		Application.launch(FirstView.class,args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("./main.fxml"));
		Scene scene = new Scene(root, 1280, 768, Color.ALICEBLUE);

		primaryStage.getIcons().add(new Image("file:../../Ressources_Graphiques/Logo/app.png"));
		primaryStage.setTitle("Logirail - Alpha version");;

		primaryStage.setScene(scene);
		primaryStage.setMinWidth(1040);
		primaryStage.setMinHeight(782);
		primaryStage.setResizable(true);
		primaryStage.sizeToScene();
		primaryStage.show();




	}

}

