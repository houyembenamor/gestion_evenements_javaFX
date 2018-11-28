/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.gui;

import edu.esprit.pidev.impl.ArticlePromotioncrud;
import edu.esprit.pidev.impl.CrudClass;
import edu.esprit.pidev.technique.MyConnection;
import edu.esprit.pidev.entites.ArticlePromotion;
import edu.esprit.pidev.entites.Evenement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.esprit.pidev.interfaces.IArticlePromotioncrud;

/**
 * FXML Controller class
 *
 * @author HOUYEM BENAMOR
 */
public class FXMLAfficherArticlePromotionController implements Initializable {

    @FXML
    private TableView<ArticlePromotion> tblViewArtPromo;
    @FXML
    private TableColumn<ArticlePromotion, Float> tblClmIDAr;
    @FXML
    private TableColumn<ArticlePromotion, String> tblClmIDPr;
    
    @FXML
    private TableColumn<ArticlePromotion, Float> tblClmRedG;
    @FXML
    private TableColumn<ArticlePromotion, Float> tblClmRedD;
    @FXML
    private TableColumn<ArticlePromotion, Integer> tblClmPoint;
     private ObservableList<ArticlePromotion> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
  
  
    private void refreshaction(ActionEvent event) {
   
       
        ArticlePromotion articlepromotion = new ArticlePromotion();
  buildData() ;
        tblClmIDPr.setCellValueFactory(new PropertyValueFactory<>("nom_article"));
         tblClmIDAr.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
       
        tblClmRedG.setCellValueFactory(new PropertyValueFactory<>("tauxReductionGros"));
        tblClmRedD.setCellValueFactory(new PropertyValueFactory<>("tauxReductionDetail"));
        tblClmPoint.setCellValueFactory(new PropertyValueFactory<>("nombrePointFidele"));
        tblViewArtPromo.setItems(null);
        tblViewArtPromo.setItems(data);
        
        System.out.println("liste affiché");
    }

    
  
        
        

    public void buildData() {
     
         Connection conn = MyConnection.getInstance().getConection();  
         

        data = FXCollections.observableArrayList();

        try {
            String req = "select * from articlepromotion";
            PreparedStatement ps = conn.prepareStatement(req);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
               ArticlePromotion s = new ArticlePromotion();

                 s.setNom_article(r.getString("nom_article"));
                s.setPrix(r.getFloat("prix"));
                
                s.setTauxReductionDetail(r.getFloat("tauxReductionGros"));
                s.setTauxReductionDetail(r.getFloat("tauxReductionDetail"));
                 s.setNombrePointFidele(r.getInt("nombrePointFidele"));       
                
                
              
                
                
                data.add(s);
               
            }
          
          tblViewArtPromo .setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(ArticlePromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}