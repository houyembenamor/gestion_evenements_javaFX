/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entites;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Date;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author HOUYEM BENAMOR
 */
public class Evenement {
    private int id_event;
 private String nom_event;
 private Date date_d;
 private Date date_f;


 private String descrip_event;
 private String formatdate_d;
 private String formatdate_f;


    public Evenement() {
   
    }

    public Evenement(int id_event, String nom_event, Date date_d, Date date_f, String descrip_event) {
        this.id_event = id_event;
         
        this.nom_event =nom_event;
        this.date_d = date_d;
        this.date_f = date_f;
        this.descrip_event = descrip_event;
         
    }

  

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public Date getDate_d() {
        return date_d;
    }

    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }

    

   

 

    public Date getDate_f() {
        return date_f;
    }

    public void setDate_f(Date date_f) {
        this.date_f = date_f;
    }

    public String getDescrip_event() {
        return descrip_event;
    }

    public void setDescrip_event(String descrip_event) {
        this.descrip_event = descrip_event;
    }

   public String getFormatdate_d() {
       Date date_d = getDate_d();
        SimpleDateFormat dd = new SimpleDateFormat("dd-MM-yyyy");
        String format = dd.format(date_d);
        return format;
    }

    public void setFormatdate_d(String formatdate_d) {
        this.formatdate_d = formatdate_d;
    }
    
     public String getFormatdate_f() {
        Date date_f = getDate_f();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String format = df.format(date_f);
        return format;
    }

    public void setFormatdate_f(String formatdate_f) {
        this.formatdate_f = formatdate_f;
    }
    
    
    

    @Override
    public String toString() {
        return "Evenements{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", date_d=" + date_d + ", date_f=" + date_f + ", descrip_event=" + descrip_event + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }


   


    @Override
    public boolean equals(Object obj) {//equals() vaut VRAI si les 2 objets ont un contenu équivalent.
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        return true;
    }

   
    
 
    
    
    
    
}
