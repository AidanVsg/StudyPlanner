package studyplanner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class CreateStudyProfileControl {
    
    private StudyProfile profile;
    
    @FXML
    private AnchorPane createProfileWindow;
    
    @FXML
    private Button createProfileButton;
    @FXML
    private Button cancelProfileButton;
    @FXML
    private Button browseButton;
    @FXML
    private TextField profileNameField;
    @FXML
    private TextField dataFilePathField;
    
    @FXML
    private void cancelButtonClick(){
        profileNameField.setText("Yes!");
    }
    
    @FXML
    private void createProfileButtonClick(){
        System.out.println("works?");
    }
    
    public void initData(StudyProfile profile){
        this.profile = profile;
    }
    
}
