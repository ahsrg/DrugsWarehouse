/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 *
 * @author Adia
 */
public class nuevoInsuController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void cerrar(ActionEvent event){
        try{
        ((Node)event.getSource()).getScene().getWindow().hide();
        }catch(Exception e){
           System.out.println("Error al cerrar insumo"+e.getMessage()+e);
        }
    }
    
}
