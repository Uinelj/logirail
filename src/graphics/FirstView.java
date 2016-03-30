package graphics;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class who load the FXML.
 * @author Arya JEMO
 */

public class FirstView extends Application{



    /**
	 * This main launch the FXML loader.
	 * @param Some args for the main if needed.
	 * */

	public static void main (String[] args){
		Application.launch(FirstView.class,args);
	}


	 	/**
		 * This method create a new stage and load the FXML into.
		 * @param A stage to put the FXML into.
		 * */

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

