/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Adia
 */
public class FXMLDocumentController implements Initializable {
    public FXMLDocumentModel loginModel = new FXMLDocumentModel();
    
    @FXML
    private Label label;
    
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(loginModel.idDbConnected()){
            label.setText("Connected");
        }
        else{
            label.setText("Not Connected");
        }
    }    
    
    public void Login(ActionEvent event){
        try {
            if(loginModel.isLogin(txtUser.getText(), txtPass.getText())){
                //label.setText("User and Pass is correct");
                (((Node)event.getSource()).getScene()).getWindow().hide();
                Parent root;
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(getClass().getResource("Add.fxml").openStream());
                AddController addController = (AddController)loader.getController();
                addController.getUser(txtUser.getText());
                //a
                addController.getReacList();
                addController.getInsuList();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                label.setText("User and Pass is not correct");
            }
        } catch (SQLException ex) {
            label.setText("User and Pass is not correct");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
