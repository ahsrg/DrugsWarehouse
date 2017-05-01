/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Adia
 */
public class nuevoReacController implements Initializable{

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
    
}
