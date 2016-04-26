/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicorn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;

/**
 *
 * @author brisa
 */
public class Unicorn extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {



        primaryStage.setTitle("~Unicorn Media Player~");

        Parent root = FXMLLoader.load(getClass().getResource("Unicorn.fxml"));

        Scene scene = new Scene(root);

        scene.getStylesheets().add(
        Unicorn.class.getResource("Unicorn.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
