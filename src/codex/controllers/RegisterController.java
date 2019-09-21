package codex.controllers;

import codex.DBconnect;
import codex.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private GridPane root;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private Button registerbutton;

    @FXML
    private Button backlogin;

    @FXML
    private Label status;

    @FXML
    void back2login(ActionEvent event) {
        try {
            Stage stage = Main.stage;
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/codex/fxmls/login.fxml"));
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void userRegister(ActionEvent event) {
        String u = username.getText();
        String p = password.getText();

        if(u.isEmpty()){
            status.setText("Username cannot be empty");
        }else if(p.isEmpty()){
            status.setText("Password cannot be empty");
        }else if(!p.equals(confirmpassword.getText())){
            status.setText("Passwords not same");
        }else{

            try {
                String query = "INSERT INTO `users`(`username`, `password`)" +
                        "VALUES ('%s','%s')";
                DBconnect.getConnection().createStatement().executeUpdate(
                        String.format(query, u, p)
                );
                status.setText("Registration successful");
            } catch (SQLException e) {
                status.setText("Error occurred");
                e.printStackTrace();
            }

        }
    }

}










