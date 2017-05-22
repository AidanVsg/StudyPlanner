/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyplanner;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class CreateStudyProfileViewController implements Initializable {
    private StudyPlannerViewController mainController;
    
    @FXML private AnchorPane createProfileWindow;
    private Stage stage;
    
    @FXML private Button createProfileButton;
    @FXML private Button cancelProfileButton;
    @FXML private Button browseButton;
    
    @FXML private TextField profileNameField;
    @FXML private TextField dataFilePathField;
    
    @FXML private Label errNameLabel, errDataLabel;
    
    @FXML
    private void browseButtonClick(){
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            dataFilePathField.setText(file.getPath());
        }
    }
    
    @FXML
    private void cancelButtonClick(){
        stage.hide();
    }
    
    @FXML
    private void createProfileButtonClick(){
        if(profileNameField.getText().trim().equals("")){
            errNameLabel.setText("name field is empty");
        }else{
            StudyProfile profile = new StudyProfile();
            profile.setName(profileNameField.getText());
            mainController.profileAdded(profile);
            stage.hide();
        }
        
    }
    
    /**
     * Gives this controller a reference to the main StudyPlanner controller
     * and initialises a shortcut variable for CreateStudyProfileView's stage
     * @param controller - main controller
     */
    public void initData(StudyPlannerViewController controller){
        stage = (Stage) createProfileWindow.getScene().getWindow();
        this.mainController = controller;
    }
    
    private void configureFileChooser(final FileChooser fileChooser){
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("XML", "*.xml"),
                new FileChooser.ExtensionFilter("HUB", "*.hub")
            );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}   
