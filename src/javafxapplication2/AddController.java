/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.collections.FXCollections;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author Adia
 */
public class AddController implements Initializable {
    
    FXMLDocumentModel model = new FXMLDocumentModel();

    @FXML
    private Label userCon;
    @FXML
    private TableView<reactivo> reacList;
    @FXML
    private TableColumn<reactivo,String> fechaR = new TableColumn<>("Fecha");
    @FXML
    private TableColumn<reactivo,String> nombreR = new TableColumn<>("Nombre");
    @FXML
    private TableColumn<reactivo,String> loteR = new TableColumn<>("Lote");
    @FXML
    private TableColumn<reactivo,String> cantidadR = new TableColumn<>("Cantidad");
    @FXML
    private TableColumn<reactivo,String> caduR = new TableColumn<>("Fecha de Caducidad");
    @FXML
    private TableColumn<reactivo,String> obserR = new TableColumn<>("Observaciones");
    
    @FXML
    private TableView<insumo> insuList;
    @FXML
    private TableColumn<insumo,String> fechaI = new TableColumn<>("Fecha");
    @FXML
    private TableColumn<insumo,String> tipoI = new TableColumn<>("Tipo de insumo");
    @FXML
    private TableColumn<insumo,String> cantidadI = new TableColumn<>("Cantidad");
    @FXML
    private TableColumn<insumo,String> caduI = new TableColumn<>("Fecha de Caducidad");
    @FXML
    private TableColumn<insumo,String> obserI = new TableColumn<>("Observaciones");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void getUser(String user) {
        userCon.setText(user);
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
    
    public void getReacList(){
        try {
            ObservableList<reactivo> list = FXCollections.observableArrayList(model.listReact());
            //reacList.setEditable(true);
            
                fechaR.setCellValueFactory( new PropertyValueFactory<reactivo, String>("Fecha"));
                nombreR.setCellValueFactory( new PropertyValueFactory<reactivo, String>("Nombre"));
                loteR.setCellValueFactory( new PropertyValueFactory<reactivo, String>("Lote"));
                caduR.setCellValueFactory( new PropertyValueFactory<reactivo, String>("Caducidad"));
                obserR.setCellValueFactory( new PropertyValueFactory<reactivo, String>("Observa"));
               
          reacList.setItems(list);
            
        } catch (SQLException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.out.println("GET REACTIVE: "+e.getMessage()+e);
        } 
    }
    
    public void getInsuList(){
        try {
            ObservableList<insumo> list = FXCollections.observableArrayList(model.listInsu());
            //reacList.setEditable(true);
            
                fechaI.setCellValueFactory( new PropertyValueFactory<insumo, String>("Fecha"));
                tipoI.setCellValueFactory( new PropertyValueFactory<insumo, String>("Tipo"));
                cantidadI.setCellValueFactory( new PropertyValueFactory<insumo, String>("Cantidad"));
                caduI.setCellValueFactory( new PropertyValueFactory<insumo, String>("Caducidad"));
                obserI.setCellValueFactory( new PropertyValueFactory<insumo, String>("Observa"));
               
          insuList.setItems(list);
            
        } catch (SQLException ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            System.out.println("GET INSUMO: "+e.getMessage()+e);
        } 
    }

    public void nuevoReac(ActionEvent event){
        try {
            
                //label.setText("User and Pass is correct");
                //(((Node)event.getSource()).getScene()).getWindow().hide();
                Parent root;
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(getClass().getResource("nuevoReac.fxml").openStream());
                nuevoReacController nuevoReac = (nuevoReacController)loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
           
        }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nuevoInsu(ActionEvent event){
        try {
            
                //label.setText("User and Pass is correct");
                //(((Node)event.getSource()).getScene()).getWindow().hide();
                Parent root;
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(getClass().getResource("nuevoInsu.fxml").openStream());
                nuevoInsuController nuevoInsu = (nuevoInsuController)loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
           
        }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
