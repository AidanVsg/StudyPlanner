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
    
    @FXML private void browseButtonClick(){
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            dataFilePathField.setText(file.getPath());
        }
    }
    
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    
    @FXML private void createProfileButtonClick(){
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
