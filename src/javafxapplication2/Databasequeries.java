/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *
 * @author GAZOUZI
 */
public class Databasequeries extends Database{

    public Databasequeries () {
		super();
	}
	
    
  public static ObservableList<Object> getAllObject(String search ) throws IOException{
	       Connection dbConnection = Database.createconnection();
           System.out.println("Connexion effective !"); 
           boolean f = false;
           int ss=0;
           try {
            ss=parseInt(search);
           } catch(Exception kimeur) {
                f= true;
           }
           System.out.println(ss);
           String selectSql= null;
           
           if(!f)
           
           	{String d="duration";
           	 String b= "budget";
                 System.out.println("Yes");
           	  selectSql = "SELECT * FROM [Movies].[dbo].[movie_metadata] WHERE "+d+" = "+search+"  OR "+b+"="+search+"";}
           else
           {
           	String dir="director_name";
           	String act="actor_1_name";
                System.out.println("No");
           	selectSql = "SELECT * FROM [Movies].[dbo].[movie_metadata] WHERE "+dir+" LIKE '"+search+"%'  OR "+act+" LIKE '"+search+"%'";

           }
           
	      
               
                
    
                ObservableList<Object> items= FXCollections.observableArrayList();
                System.out.println("yo");
	       
	       try{
              Statement statement = dbConnection.createStatement();
		      System.out.println(selectSql);
		      ResultSet resultSet = statement.executeQuery(selectSql);
                      System.out.println("Htm");
		       while (resultSet.next())   
                    {  
                        System.out.println(resultSet.getString(2) + " " + resultSet.getString(4));
                        items.add("directeur :"+ resultSet.getString(2) + " et  la duration du film : "+resultSet.getString(4));
                        
	           
                    

	         
                            }
              resultSet.close();
	          statement.close();
	          dbConnection.close();
	           return items;
	      
              
        
  }     catch (SQLException ex) {
            Logger.getLogger(Databasequeries.class.getName()).log(Level.SEVERE, null, ex);
        }
               return null;
  }
}  
    
            
            
            

                    
