/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.gui;

import com.sun.javaws.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author HOUYEM BENAMOR
 */
public class Event extends Application {
    
 
    
    @Override
    public void start(Stage stage)  {
                
        
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("/edu/esprit/pidev/gui/FXMLhomepage.fxml"));
            
            Scene scene = new Scene(root);
            
            
            stage.setScene(scene);
            stage.setTitle("Gestion des evenement");
            stage.show();
    
        } catch (IOException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
