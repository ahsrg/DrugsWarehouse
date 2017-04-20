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
import java.util.List;

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
  
  public List<Object> listReact() throws SQLException{
      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      List<Object> listreact = new ArrayList<Object>();
      String query = "SELECT * FROM reactivo";
      try {
          preparedStatement = connection.prepareStatement(query);
          resultSet = preparedStatement.executeQuery();
          
          while(resultSet.next()){
              listreact.add(resultSet.getRow());
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
}
