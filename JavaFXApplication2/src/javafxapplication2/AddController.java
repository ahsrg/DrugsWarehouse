/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adia
 */
public class AddController implements Initializable {
    
    FXMLDocumentModel model = new FXMLDocumentModel();

    @FXML
    private Label userCon;
    private TableView reacList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getUser(String user) {
        userCon.setText(user);
    }    
    
    public void getReacList(){
        try {
            List<Object> list = model.listReact();
            for (int i = 0; i < list.size(); i++) {
                reacList.
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loginPane(ActionEvent event){
        try {
           (((Node)event.getSource()).getScene()).getWindow().hide();
            Parent root;
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("FXMLDocument.fxml").openStream());
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        } catch (Exception e) {
        }
        
    }
}
