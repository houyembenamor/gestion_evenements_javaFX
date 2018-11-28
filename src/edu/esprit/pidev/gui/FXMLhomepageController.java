/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HOUYEM BENAMOR
 */
public class FXMLhomepageController implements Initializable {

    @FXML
    private Button envoyerbtn;
    @FXML
    private Button envoyersms_bttn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouteraction(ActionEvent event) {
              try
        {
            ((Node)event.getSource()).getScene().getWindow();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("FXMLAjout.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter Evenement--");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
    }


    @FXML
    private void consulterButtonAction(ActionEvent event) {
            try
        {
            ((Node)event.getSource()).getScene().getWindow();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("FXMLAfficherArticlePromotion.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Afficher Article En Promotion--");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
    }

    @FXML
    private void envoyerButtonAction(ActionEvent event) {
         
             try
        {
            ((Node)event.getSource()).getScene().getWindow();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("sendMail.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Envoyer mail--");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
             
    }

    @FXML
    private void envoyersmsaction(ActionEvent event) {
              try
        {
            ((Node)event.getSource()).getScene().getWindow();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("sendsms.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Envoyer sms--");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    }
    
}
