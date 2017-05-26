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
 * Controller for study profile creation window.
 *
 * @author Michail Krugliakov 100136484
 */
public class CreateStudyProfileViewController implements Initializable {
    //reference to a study planner controller so that a newly created profile
    //may be passed on to it and added to a Study Planner list view
    private StudyPlannerViewController mainController;      
    
    //shortcut fields to make accessing this controller's view's stage easier
    @FXML private AnchorPane createProfileWindow;
    private Stage stage;
    
    @FXML private Button createProfileButton; //button to create a profile
    @FXML private Button cancelProfileButton; //button to close profile creation
    @FXML private Button browseButton;        //button to browse to a data file  
    
    @FXML private TextField profileNameField; //field to input profile's name   
    @FXML private TextField dataFilePathField;//field to input path to hub file
    
    @FXML private Label errNameLabel, errDataLabel; //labels to handle
                                                    //user input errors
    
    
    //TODO IF FILE IS BAD FOR HEALTH, MAKE SURE IT DOESNT GET LOADED
    @FXML private void createProfileButtonClick(){
        //reset fields so that they dynamically change with each button click
        errNameLabel.setText("");
        errDataLabel.setText("");
        
        Boolean nameFieldIsEmpty = profileNameField.getText().trim().equals("");
        Boolean dataFieldIsEmpty = dataFilePathField.getText().trim().equals("");
        
        if(nameFieldIsEmpty){
            errNameLabel.setText("name field is empty");
        }
        if(dataFieldIsEmpty){
            errDataLabel.setText("data field is empty");
        }
        if(!nameFieldIsEmpty && !dataFieldIsEmpty){
            StudyProfile profile = new StudyProfile();
            
            File hubFile = new File(dataFilePathField.getText());
            profile.setName(profileNameField.getText());
            
            StudyProfile.InitialiseStudyProfile(profile, hubFile);
            
            mainController.profileAdded(profile);
            stage.hide();
        }    
    }
    
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    
    @FXML private void browseButtonClick(){
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            dataFilePathField.setText(file.getPath());
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
    
    /**
     * Defines name and allowed extensions for fileChooser
     * @param fileChooser - fileChooser to be configured
     */
    private void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setTitle("Select Hub file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XML", "*.xml"),
                new FileChooser.ExtensionFilter("HUB", "*.hub"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
            );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}   
