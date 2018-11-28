/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.technique;

import edu.esprit.pidev.interfaces.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author HOUYEM BENAMOR
 */
public class MyConnection {
          
    public String url="jdbc:mysql://localhost:3306/eshop";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnection instance;
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion bien établié");
        } catch (SQLException ex) {
           System.err.println(ex.getMessage());
        }
    }
    public static MyConnection getInstance(){//pour eliminer l'erreur de private et
        //permettra de renvoyer une unique instance de la classe. 
        if(instance==null)
        {
            instance=new MyConnection();
        }
        return instance;
}
    
    public Connection getConection(){
      return cnx;  
    }

  
}
