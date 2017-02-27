/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.rmi.server.ObjID.read;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mamadou
 */
public class Chercher {
    public Chercher(){ 
     
    }
    
 public ArrayList<String> strategie(ArrayList<String> maLis) throws FileNotFoundException, IOException{
                                                ArrayList<String> maListe = new ArrayList();
        
            try{
                File file = new File ("/home/mamadou/workspace/Multi-Source-master/src/javafxapplication2/imdb.txt");
                FileReader fr = new FileReader (file);
                BufferedReader br = new BufferedReader (fr);
                                
                String cetteValeur = maLis.get(0);
                    try{
                        String ligne="";                   
                        while(ligne!=null){                     
                            ligne = br.readLine();
                            if (ligne.contains(cetteValeur)){                       
                                        System.out.println("le mot est trouvé: ");
                                                System.out.println (ligne); 
                                                maListe.add(ligne);
                                                
                            }                                                                                    
                        }                                    
                                        
                    } 
                        catch (IOException exception){
                                           System.out.println ("Erreur lors de la lecture : ");
                    }  
                
            }
                catch (FileNotFoundException e){
            System.out.println("le fichier n'a pas été trouvé.");             
        }
                                
return maListe;
    }
    
    
    
}
