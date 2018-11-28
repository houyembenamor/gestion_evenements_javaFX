/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.impl;

import edu.esprit.pidev.entites.DateService;
import edu.esprit.pidev.entites.Evenement;
import edu.esprit.pidev.interfaces.IEvenementServices;
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


/**
 *
 * @author HOUYEM BENAMOR
 */
public class CrudClass implements IEvenementServices{

 
     Connection cnx;

    public CrudClass() {
        cnx = MyConnection.getInstance().getConection();
        
    }

    public void ajouterEvenement(Evenement E) {
       try {
       
       String requete="INSERT INTO evenements  (id_event,nom_event,date_d,date_f,descrip_event)VALUES(?,?,?,?,?)";
      PreparedStatement pst;
        pst = cnx.prepareStatement(requete);
        pst.setInt(1,E.getId_event());
        pst.setString(2,E.getNom_event());
         pst.setDate(3, (Date) E.getDate_d());
       pst.setDate(4, (Date) E.getDate_f());
        pst.setString(5,E.getDescrip_event());
     
        pst.executeUpdate();
        System.out.println("requete etablie");
        
        
        
       
        
        
    }
    catch (SQLException ex) {
         ex.printStackTrace();;
    }
        
    }
    
    
    
    
   
    public void modifierEvenement(Evenement E){
       
    
      try {
         
            String req = "UPDATE `evenements` SET  "
                    + "`id_event`=?,"
                    + "`nom_event`=?,"
                   + "`date_d`=?,"
                    + "`date_f`=?,"
                    + "`descrip_event`=?,"
                    + "WHERE `id_event`=?";
            PreparedStatement pst = cnx.prepareStatement(req);
           pst.setInt(1,E.getId_event());
        pst.setString(2,E.getNom_event());
         pst.setDate(3, (Date) E.getDate_d());
       pst.setDate(4, (Date) E.getDate_f());
        pst.setString(5,E.getDescrip_event());
     
        pst.executeUpdate();
        System.out.println("evenement modifié");
       
  
              
        } catch (SQLException ex) {
            ex.printStackTrace();
         
        }
    
    
    
        
    }
    
    
    
  
    
    
       public List<Evenement> getAll() {
        List<Evenement> evenements = new ArrayList<>();
        try {
            String req = "select * from evenements";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                Evenement e= new Evenement(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getDate(4),rs.getString(5));
                evenements.add(e);
                System.out.println("affichage etablie");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return evenements;
       
    }
       

         
       
    
    
    
       
       
       
    
    
    
    
     public void supprimerEvenement(int id_event) {
        String requette = "DELETE FROM evenements where ('" + id_event+ "'=id_event)";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requette);
            System.out.println("evenement supprimé");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
   
     
     
     
     
      public Evenement findById(Integer id_event) {
        Evenement e = new Evenement();
          String req = "select * from evenements where id_event ='"+id_event+"'";
        try {
          
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                e.setId_event(id_event);
                e.setNom_event(rs.getString(2));
              
                e.setDate_d(rs.getDate(3));
                 e.setDate_f(rs.getDate(4));
                 e.setDescrip_event(rs.getString(5));
               
           
            }
        } catch (SQLException ex) {
              System.out.println(req);
            ex.printStackTrace();
        }
        return e;
    }
      
    
     
}


