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
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private GridPane root;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbutton;

    @FXML
    private Button registerbutton;

    @FXML
    private Label status;

    @FXML
    void onLogin(ActionEvent event) {
        String u = username.getText();
        String p = password.getText();

        if(u.isEmpty()){
            status.setText("Username cannot be empty");
        }else if(p.isEmpty()){
            status.setText("Password cannot be empty");
        }else {

            try {
                String query = "SELECT * FROM `users` WHERE" +
                        " `username` = '%s' AND `password` = '%s'";

                boolean found = DBconnect.getConnection().createStatement().executeQuery(
                        String.format(query, u, p)
                ).next();

                if(found){
                    status.setText("Logged in successfully");
                }else{
                    status.setText("Incorrect username/password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void onRegister(ActionEvent event) {
        try {
            Stage stage = Main.stage;
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/codex/fxmls/register.fxml"));
            stage.setTitle("Register");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
