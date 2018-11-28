/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.entites.Evenement;

import java.sql.ResultSet;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author HOUYEM BENAMOR
 */
public interface IEvenementServices {
    

	
        
      
      void  ajouterEvenement(Evenement E);
      void modifierEvenement(Evenement E);
      void supprimerEvenement(int id_event);
      Evenement findById(Integer id_event);
   
   
	
}
