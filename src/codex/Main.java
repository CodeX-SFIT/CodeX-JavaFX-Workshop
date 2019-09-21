package codex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Parent root = FXMLLoader.load(getClass()
				.getResource("fxmls/login.fxml"));
		stage.setTitle("Login");
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void main(String[] args) throws SQLException {
		DBconnect.initDB();
		launch(args);
	}

}
