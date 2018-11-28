/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.gui;



import static java.lang.ProcessBuilder.Redirect.to;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import static jdk.nashorn.internal.objects.NativeJava.to;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import edu.esprit.pidev.impl.SendMail;

/**
 * FXML Controller class
 *
 * @author HOUYEM BENAMOR
 */
public class sendMailController implements Initializable {

    @FXML
    private TextField tfsubject;
    @FXML
    private TextArea tfText;
    @FXML
    private Button btnSignup;
    @FXML
    private TextField tfto;
    private String username = "";
private String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
private String y="";
private String z="";
private String w="";

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
    }    

    @FXML
    private void sendAction(ActionEvent event) throws MessagingException {
        
  /* EnvoyerEmail test=new EnvoyerEmail();
    test.setPassword(pass.getText());
    test.setUsername(tfMail.getText());
    test.setY(tfto.getText());
    test.setZ(tfsubject.getText());
    test.setW(tfText.getText());
test.envoyerm(pass.getText(), tfMail.getText(), tfto.getText(), tfsubject.getText(),tfText.getText());
*/
 
      
           
          
                String to = tfto.getText();
                String subject = tfsubject.getText();
                String message = tfText.getText();
                
                String user = "houyembenamor13@gmail.com";
                String pass = "26016562";

                SendMail.send(to,subject, message, user, pass);
            }           
        

  
    
 
    
    

    
}

    

