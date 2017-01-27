/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author GAZOUZI
 */
public class FXMLDocumentController implements Initializable {

    private String field;
    
   
    @FXML
    private void handleCloseAction(ActionEvent event) {     
      System.exit(0);
    }
    
    @FXML
    private void handleOpenAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        fileChooser.setInitialDirectory(new File("C:\\Users\\GAZOUZI\\Documents"));
        fileChooser.getExtensionFilters().addAll( new ExtensionFilter("PDF Files", "*.pdf"));
        fileChooser.getExtensionFilters().addAll( new ExtensionFilter("TXT Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
    }
    
    @FXML
    private void handleCopyAction(ActionEvent event){
        Clipboard systemClipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        
        content.putString(field);
        systemClipboard.setContent(content);
    }
    
    @FXML
    private void handleDeleteAction(ActionEvent event) {     
        
    }
    
    @FXML
    private Label label;
    
    @FXML
    private TextField cont;
    
    @FXML
    private ListView<Object> listcont;
    
    ObservableList<Object> items= FXCollections.observableArrayList();  
    
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String s=cont.getText();
        if (s.equals("Joy"))
        {items.add("Joy is the story of the title character, who rose to become founder and matriarch of a powerful family business dynasty.");
        
        final Hyperlink hyperlink = new Hyperlink("http://www.imdb.com/title/tt2446980/videoplayer/vi4091916825?ref_=tt_ov_vi");
        items.add(hyperlink);
        }listcont.setItems(items);  
    }
    
    @FXML
    private void handleAboutAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setOpacity(1);
           stage.setTitle("About the system");
           stage.setScene(new Scene(root));
           stage.showAndWait();
           stage.setResizable(false);
    }
    @FXML 
    
    private javafx.scene.control.Button closeButton;

    @FXML
       private void closeButtonAction(){
   
    Stage stage = (Stage) closeButton.getScene().getWindow();
    
    stage.close();
}
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
