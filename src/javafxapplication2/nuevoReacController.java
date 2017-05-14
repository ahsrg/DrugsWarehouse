/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Adia
 */
public class nuevoReacController implements Initializable{
    FXMLDocumentModel model = new FXMLDocumentModel();
    
    @FXML
    TextField textName = new TextField();
    @FXML
    TextField textAmount = new TextField();
    @FXML
    DatePicker dateEnd = new DatePicker();
    @FXML
    TextField textLote = new TextField();
    @FXML
    TextArea textObse = new TextArea();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void cerrar(ActionEvent event){
        try {
           (((Node)event.getSource()).getScene()).getWindow().hide();
//            Parent root;
//            Stage stage = new Stage();
//            FXMLLoader loader = new FXMLLoader();
//            root = loader.load(getClass().getResource("Add.fxml").openStream());
//            
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show(); 
        } catch (Exception e) {
            System.out.println("Error al cerrar reactivo"+e.getMessage()+e);
        } 
    }
    
    public void guardar(ActionEvent event){
        try {
            DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            
           Date currect = new Date();
           String var = textName.getText();
           String var1 = textLote.getText();
           String var2 = textAmount.getText();
           String var3 = textObse.getText();
           String var4 = dateEnd.getValue().toString();
           reactivo reac = new reactivo(dt.format(currect), var, var1, var2, var4, var3);
           if(model.Insert(reac)){
               System.out.println("OK");
           }
        } catch (Exception e) {
            System.out.println("Error al crear reactivo"+e.getMessage()+e);
        } 
    }
}
