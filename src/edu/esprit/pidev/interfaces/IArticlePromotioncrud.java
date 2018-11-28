/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import java.util.List;
import javafx.collections.ObservableList;
import edu.esprit.pidev.entites.ArticlePromotion;
import edu.esprit.pidev.entites.ArticlePromotion;

/**
 *
 * @author omarblythe
 */
public interface IArticlePromotioncrud {
     ;

    ObservableList<ArticlePromotion> DisplayAllArticlePromotion();
 
      public int getRemise(int id);
      public int getRemiseGros(int id);

    
}
