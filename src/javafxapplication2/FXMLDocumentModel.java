/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Adia
 */
public class FXMLDocumentModel {
      Connection connection;
    
  public FXMLDocumentModel(){
      connection = sqliteConnection.Connector();
      if(connection == null) System.exit(1);
  }
  
  public boolean idDbConnected(){
      try {
          return !connection.isClosed();
      } catch (Exception e) {
          e.printStackTrace();
          return false;
      }
  }
  
  public boolean isLogin(String user, String pass) throws SQLException{
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      String query = "SELECT * FROM Users WHERE user = ? AND pass = ?";
      try {
          preparedStatement = connection.prepareStatement(query);
          preparedStatement.setString(1, user);
          preparedStatement.setString(2, pass);
          
          resultSet = preparedStatement.executeQuery();
          
          if(resultSet.next()){
              return  true;
          }
          else{
              return false;
          }
      } catch (Exception e) {
          return  false;
      } finally{
          preparedStatement.close();
          resultSet.close();
      }
  }
  
  public boolean Insert(reactivo reac) throws SQLException{
       Statement statement = null;
      String query = "INSERT INTO Reacs (nombre, fecha, cantidad, lote, fechaVence, observa) VALUES('"+
              reac.getNombre()+"','"+reac.getFecha()+"','"+reac.getCantidad()
              +"','"+reac.getLote()+"','"+reac.getCaducidad()+"','"+reac.getObserva()+"')";

      try {
          statement = connection.createStatement();
          statement.execute(query);
              return  true;
          
      } catch (Exception e) {
          Logger.getLogger(FXMLDocumentModel.class.getName()).log(Level.SEVERE, null, e);
          return false;
      } finally{
          statement.close();
      }
  }
  
  public List<reactivo> listReact() throws SQLException{
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      List<reactivo> listreact = new ArrayList<reactivo>();
      String query = "SELECT * FROM Reacs";
      try {
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
              reactivo rec = new reactivo(resultSet.getString("fecha"), resultSet.getString("nombre"), resultSet.getString("lote"),  resultSet.getString("cantidad"),resultSet.getString("fechaVence"), resultSet.getString("observa"));
              
              listreact.add(rec);
          }
          
          return listreact;
      } catch (Exception e) {
          System.out.print("Listed reactivos"+e.getMessage());
      } finally{
         
          preparedStatement.close();
          resultSet.close();
      }
       return listreact;
  }
  
   public List<insumo> listInsu() throws SQLException{
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      List<insumo> listInsu = new ArrayList<insumo>();
      String query = "SELECT * FROM Insu";
      try {
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
              insumo rec = new insumo(resultSet.getString("fecha"), resultSet.getString("tipo"), resultSet.getString("cantidad"), resultSet.getString("fechaVence"), resultSet.getString("observa"));
              
              listInsu.add(rec);
          }
          
          return listInsu;
      } catch (Exception e) {
          System.out.print("Listed insumos"+e.getMessage());
      } finally{
         
          preparedStatement.close();
          resultSet.close();
      }
       return listInsu;
  }
}
