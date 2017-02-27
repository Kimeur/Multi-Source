/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Arslen REMACI
 */
public class FindXML {
    
    public FindXML(){
        
    }
    
    public boolean containsIgnoreCase( String haystack, String needle ) {
        if(needle.equals(""))
            return true;
        if(haystack == null || needle == null || haystack .equals(""))
            return false; 

        Pattern p = Pattern.compile(needle,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
        Matcher m = p.matcher(haystack);
        return m.find();
}
    
    
    public ArrayList<String> Search_n_find(ArrayList<String> param) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException{
        ArrayList<String> list = new ArrayList();
        
        try{
            File inputFile = new File("movies.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            
            String value = param.get(0);
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (containsIgnoreCase(eElement.getElementsByTagName("title").item(0).getTextContent(), value)){
                        String answer = eElement.getElementsByTagName("title").item(0).getTextContent() + 
                                        ". Genres : " +
                                        eElement.getElementsByTagName("genres").item(0).getTextContent();
                        
                        list.add(answer);
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }        
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ParserConfigurationException e){
            e.printStackTrace();
        }
        catch(SAXException e){
            e.printStackTrace();
        }
        return list;
        
    }
}
