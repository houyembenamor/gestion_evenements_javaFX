/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.gui;


import edu.esprit.pidev.entites.DateService;
import edu.esprit.pidev.entites.Evenement;
import edu.esprit.pidev.impl.CrudClass;
import edu.esprit.pidev.interfaces.IEvenementServices;
import edu.esprit.pidev.technique.MyConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.naming.Context;
import javax.swing.JOptionPane;
 

/**
 *
 * @author HOUYEM BENAMOR
 */
public class FXMLAjouterController implements Initializable {
    
    @FXML
   private Label nom_event_label;
    @FXML
   private Label date_d_label;
    @FXML
   private Label date_f_label;
    @FXML
   private Label descrip_event_label;
    
   
    private TextField id_event_box;
    @FXML 
    private TextField nom_event_box;
    @FXML
    
    private DatePicker  date_d_box;
    @FXML
    private DatePicker  date_f_box;
    @FXML
    private TextArea descrip_event_box;
    @FXML
    private Button btn_ajouterevenement;
    @FXML
    private TableView < Evenement>evenement_tableview;
    @FXML
    private TableColumn<Evenement, Integer> id_event_column;
    @FXML
    private TableColumn<Evenement, String> nom_event_column;
    @FXML
    private TableColumn<Evenement, Date> date_d_column;
    @FXML
    private TableColumn<Evenement,Date> date_f_column;
    @FXML
    private TableColumn<Evenement, String> descrip_event_column;
    @FXML
    private Button btn_afficherevenement;
      private ObservableList<Evenement> data;
    @FXML
    private Button btn_supprimerevenement;
    private DatePicker datePicker;
   private LocalDate d;
    @FXML
    private Button btn_actualiserevenement;
    @FXML
    private Button updatebtn;
   
 

      
 


    
    

 



    
    
 
    @FXML
    private void handleButtonAction(ActionEvent event) throws ParseException {
        
   Evenement e=new Evenement();
           if( validateFields())
           {
      

         
            e.setNom_event(nom_event_box.getText());
               e.setDate_d(Date.valueOf(date_d_box.getValue()));
                   
         e.setDate_f(Date.valueOf(date_f_box.getValue()));
                    
                 e.setDescrip_event(descrip_event_box.getText());
            

            CrudClass crudclass = new CrudClass();
          
            
               
                crudclass.ajouterEvenement(e);
            refreshTable();
            clearFields();
            }
		
    }
    
    
    
    
    
    
    public void buildData() {
     
         Connection conn = MyConnection.getInstance().getConection();  
         

        data = FXCollections.observableArrayList();

        try {
            String req = "select * from evenements";
            PreparedStatement ps = conn.prepareStatement(req);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                Evenement s = new Evenement();

                
                s.setId_event(r.getInt("id_event"));
                
                s.setNom_event(r.getString("nom_event"));
                
                s.setDate_d(r.getDate("date_d"));
                s.setDate_f(r.getDate("date_f"));
                 s.setDescrip_event(r.getString("descrip_event"));       
                
                
              
                
                
                data.add(s);
               
            }
          
           evenement_tableview .setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(CrudClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
        id_event_column.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        nom_event_column.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        date_d_column.setCellValueFactory(new PropertyValueFactory<>("date_d"));
        date_f_column.setCellValueFactory(new PropertyValueFactory<>("date_f"));
         descrip_event_column.setCellValueFactory(new PropertyValueFactory<>("descrip_event"));
        buildData();
        

    }

  
           
           
           
           
              
    
    
    
    
    @FXML
    private void afficherButtonAction(ActionEvent event)  {
      
        
       buildData() ;
       
        id_event_column.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        nom_event_column.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        date_d_column.setCellValueFactory(new PropertyValueFactory<>("date_d"));
        date_f_column.setCellValueFactory(new PropertyValueFactory<>("date_f"));
         descrip_event_column.setCellValueFactory(new PropertyValueFactory<>("descrip_event"));
         
        evenement_tableview.setItems(null);
        evenement_tableview.setItems(data);
        
        System.out.println("liste affiché");
        
        
    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) {

        
     CrudClass u = new CrudClass();
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setTitle("Suppression ");
       alert.setContentText("Vouslez-vous vraiment supprimer ce produit ?");
      Optional<ButtonType> result = alert.showAndWait();
       if (result.get() == ButtonType.OK)
        {
       u.supprimerEvenement(evenement_tableview.getSelectionModel().getSelectedItem().getId_event());
          initialize(null, null);
           buildData();
       }
      else
           buildData();
           initialize(null, null);
    }



       public void refreshTable(){
             Connection conn = MyConnection.getInstance().getConection();  
         

        data = FXCollections.observableArrayList();
        data.clear();
         try{                
                String query = "select * from evenements";
               PreparedStatement pst = conn.prepareStatement(query);
               ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    data.add(new Evenement(
                            rs.getInt("id_event"),
                            rs.getString("nom_event"),
                            rs.getDate("date_d"),
                            rs.getDate("date_f"),
                            rs.getString("descrip_event") ));
                    evenement_tableview.setItems(data);                    
                }
                pst.close();
                rs.close();
            }catch(Exception e2){
                System.err.println(e2);
            }
    }






  public void clearFields(){
        
        nom_event_box.clear();
        date_d_box.setValue(null);
        date_d_box.getEditor().setText(null);
        date_f_box.setValue(null);
        date_f_box.getEditor().setText(null);
        descrip_event_box.clear();
       
    }
      
 
private boolean validateFields(){
        if( ( nom_event_box.getText().isEmpty())|( descrip_event_box.getText().isEmpty())){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Into The Fields");
                alert.showAndWait();
                
                return false;
        }
        if((date_d_box.getEditor().getText().isEmpty())|(date_f_box.getEditor().getText().isEmpty())){
            
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Fields");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter The Date");
                alert.showAndWait();
                
                return false;
        }
       
          return true;
    }
 
  
   /*private boolean validateNomEvent(){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nom_event_box.getText());
        if(m.find() && m.group().equals(nom_event_box.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Name  event");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Name Event");
                alert.showAndWait();
            
            return false;            
        }
    }/*
   
  /*  private boolean validateDescripvent(){
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(descrip_event_box.getText());
        if(m.find() && m.group().equals(descrip_event_box.getText())){
            return true;
        }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validate Description  event");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Description Event");
                alert.showAndWait();
            
            return false;            
        }
    }
*/
  
  

    @FXML
    private void actualiserButtonAction(ActionEvent event)throws ParseException  {
        clearFields();
    }

    @FXML
    private void upaction(ActionEvent event) throws IOException {
        
         CrudClass e= new CrudClass();
      Evenement ev=new Evenement();
   data = FXCollections.observableArrayList();
         Connection cnx = MyConnection.getInstance().getConection();  
        

          evenement_tableview.setEditable(true);
    
nom_event_column.setCellFactory(TextFieldTableCell.forTableColumn()); 

   
   id_event_column.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() { 
 
    
    public String toString(Integer object) { 
        return String.valueOf(object); 
    } 
  
    public Integer fromString(String string) { 
        return Integer.parseInt(string); 
    }    
}));
   
   
 
     
   descrip_event_column.setCellFactory(TextFieldTableCell.forTableColumn()); 
        
   evenement_tableview.getSelectionModel().getSelectionMode();
    
       e.modifierEvenement(evenement_tableview.getSelectionModel().getSelectedItem());
    try {
            String requete="UPDATE evenements SET id_event=?,nom_event=? , date_d=?,  date_f=?,  descrip_event=?  WHERE id_event=?" ;
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            pst.setString(1,id_event_column.getText());
             pst.setString(2,nom_event_column.getText());
             pst.setString(3,date_d_column.getText());
             pst.setString(4,date_f_column.getText());
              pst.setString(5,descrip_event_column.getText());
            
              pst.executeUpdate();
   e.ajouterEvenement(ev);
        }catch (SQLException ex){
            Logger.getLogger(CrudClass.class.getName()).log(Level.SEVERE,null,ex);
        }
   System.out.println(" modifié");
   
    }

   

  

  
  


    
}
    
    
    
    
   


