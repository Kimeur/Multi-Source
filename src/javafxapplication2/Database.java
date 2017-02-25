/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


/**
 *
 * @author GAZOUZI
 */
public abstract class Database {
    // conncetion avec la base de données
    public static Connection createconnection()  {
        
        // declarer le chemin de la base
        String driver="com.microsoft.sqlserver.jdbc";
        //System.out.println("driver");  
	String userName = "sa";
        //System.out.println("user !");  
        String password = "root";
        //System.out.println("pass !");  
        String url = "jdbc:sqlserver://DESKTOP-8MPH5JP\\WINCCFLEXEXPRESS;databaseName=Movies";
        //System.out.println("lien !");  
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //System.out.println("ffffe !");  
             Connection cx = DriverManager.getConnection(url, userName, password);
             //System.out.println("Connexion effective !");  
             return cx;
        }     
       catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
     public Database(){
    	    }
     //public  abstract ObservableList<Object> getAllObject(String search) throws IOException;
}
    

			

