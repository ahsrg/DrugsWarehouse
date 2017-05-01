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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
  
  public List<reactivo> listReact() throws SQLException{
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      List<reactivo> listreact = new ArrayList<reactivo>();
      String query = "SELECT * FROM reactivos";
      try {
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
              reactivo rec = new reactivo(resultSet.getString("fecha"), resultSet.getString("nombre"), resultSet.getString("lote"), "algo",resultSet.getString("caducidad"), resultSet.getString("observa"));
              
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
