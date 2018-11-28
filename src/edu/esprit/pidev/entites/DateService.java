/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.entites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;

/**
 *
 * @author HOUYEM BENAMOR
 */
public class DateService {
     
    static public long convertirDateToLong(Date date) {
        return date.getTime();
    }
    
    static public long convertirDateJourToLong(Date date) {
        String dateInString=convertirDateJourToString(date);
        return convertirStringToLong(dateInString);
    }
    
    static public long convertirStringToLong(String dateInString) {
        Date date=convertirStringJourToDate(dateInString);
        return convertirDateToLong(date);
    }
    
    static public Date convertirLongToDate(long date) {
        return new Date(date);
    }
        
    static public Date convertirStringJourToDate(String date) {
        try {
            SimpleDateFormat formater=new SimpleDateFormat ("dd-MM-yy");
            return formater.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    static public String convertirLongToString(long dateInLong) {
        Date date=convertirLongToDate(dateInLong);
        return convertirDateToString(date);
    }
    
    static public String convertirLongToStringJour(long dateInLong) {
        Date date=convertirLongToDate(dateInLong);
        return convertirDateJourToString(date);
    }
    
    static public String convertirDateJourToString(Date date) {
        SimpleDateFormat formater=new SimpleDateFormat ("dd-MM-yy");
        return formater.format(date);
    }
    
    static public String convertirHeurePAssageToString(Date hp) {
        SimpleDateFormat formater=new SimpleDateFormat ("hh:mm");
        return formater.format(hp);
    }
    
    static public String convertirDateToString(Date date) {
        SimpleDateFormat formater=new SimpleDateFormat ("dd/MM/yyyy ' à ' hh:mm:ss");
        return formater.format(date);
    }
    
    static public java.sql.Date convertirDateUtilToSql(java.util.Date date) {
        String Time =convertirDateJourToString(date);
        Date dateJour=convertirStringJourToDate(Time);
        return new java.sql.Date(dateJour.getTime());
    }
 
}


