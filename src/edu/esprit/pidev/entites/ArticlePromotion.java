/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entites;


/**
 *
 * @author omarblythe
 */
public class ArticlePromotion {
   Float prix;
    String nom_article;
    float tauxReductionGros;
    float tauxReductionDetail;
    int nombrePointFidele;

    public ArticlePromotion() {
    }

    public ArticlePromotion(float prix, String nom_article, float tauxReductionGros, float tauxReductionDetail, int nombrePointFidele) {
        this.prix = prix;
        this.nom_article = nom_article;
        this.tauxReductionGros = tauxReductionGros;
        this.tauxReductionDetail = tauxReductionDetail;
        this.nombrePointFidele = nombrePointFidele;
    }

  
    public float getTauxReductionGros() {
        return tauxReductionGros;
    }

    public float getTauxReductionDetail() {
        return tauxReductionDetail;
    }

    public int getNombrePointFidele() {
        return nombrePointFidele;
    }

   

    public void setTauxReductionGros(float tauxReductionGros) {
        this.tauxReductionGros = tauxReductionGros;
    }

    public void setTauxReductionDetail(float tauxReductionDetail) {
        this.tauxReductionDetail = tauxReductionDetail;
    }

    public void setNombrePointFidele(int nombrePointFidele) {
        this.nombrePointFidele = nombrePointFidele;
    }

    @Override
    public String toString() {
        return "ArticlePromotion{" + "prix=" + prix + ", nom_article=" + nom_article + ", tauxReductionGros=" + tauxReductionGros + ", tauxReductionDetail=" + tauxReductionDetail + ", nombrePointFidele=" + nombrePointFidele + '}';
    }

    public String getNom_article() {
        return nom_article;
    }

    public void setNom_article(String nom_article) {
        this.nom_article = nom_article;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
    
    
    
}
