/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicorn;

import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.css.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.*;
import javafx.geometry.*;
//import javafx.event.;target

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author brisa
 */
public class UnicornController implements Initializable {

    @FXML
    private Label label;
    private Button prev;


    @Override
    public void initialize(URL url, ResourceBundle rb)
     {
        // TODO

      assert prev != null : "fx:id=\"prev\" was not injected: check your FXML file 'Unicorn.fxml'.";
      prev.setOnAction(new EventHandler<ActionEvent>()
      {
        @Override
        public void handle(ActionEvent event)
        {
          System.out.println("That was easy, wasn't it?");
        }
      });
    }

    /*@FXML*/

}
