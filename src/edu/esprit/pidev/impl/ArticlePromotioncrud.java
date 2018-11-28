/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.impl;

import edu.esprit.pidev.technique.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.esprit.pidev.entites.ArticlePromotion;
import edu.esprit.pidev.interfaces.IArticlePromotioncrud;


/**
 *
 * @author omarblythe
 */
public class ArticlePromotioncrud implements IArticlePromotioncrud {

        private Connection connection;

    public ArticlePromotioncrud() {
                connection = MyConnection.getInstance().getConection();

    }

   
        @Override
    public ObservableList<ArticlePromotion> DisplayAllArticlePromotion() {

        ObservableList<ArticlePromotion> listearticlepromo =FXCollections.observableArrayList() ;
        String requete = "select * from articlepromotion";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                ArticlePromotion apr = new ArticlePromotion();
                apr.setNom_article(resultat.getString(1));
                apr.setPrix(resultat.getFloat(2));
                apr.setTauxReductionDetail(resultat.getFloat(3));
                apr.setTauxReductionGros(resultat.getFloat(4));
                apr.setNombrePointFidele(resultat.getInt(5));

                listearticlepromo.add(apr);
            }
            return listearticlepromo;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des articles en promotion " + ex.getMessage());
           return null;
        }
    }
   
    

    
    @Override
    public int getRemise(int id) {
int remise=0 ;
        String requete = "SELECT tauxReductionDetail FROM `articlepromotion` WHERE `idArticle` = ?;";
        try {
 PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
             ResultSet resultat = ps.executeQuery();

            if(resultat.next());
            {
                remise=resultat.getInt(1);
                            return remise;}

            } catch (SQLException ex) {
                Logger.getLogger(ArticlePromotion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return remise;
    }
     @Override
    public int getRemiseGros(int id) {
int remise=0 ;
        String requete = "SELECT tauxReductionGros FROM `articlepromotion` WHERE `idArticle` = ?;";
        try {
 PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
             ResultSet resultat = ps.executeQuery();

            resultat.next();
                remise=resultat.getInt(1);
                            return remise;

            } catch (SQLException ex) {
                Logger.getLogger(ArticlePromotion.class.getName()).log(Level.SEVERE, null, ex);
            }
        return remise;
    }



  

 
}
    

