package studyplanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class StudyProfileViewController implements Initializable {

    @FXML private Label profileNameLabel;
    
    private StudyProfile profile;
    
    public void initData(StudyProfile profile){
        this.profile = profile;
        profileNameLabel.setText(profile.getName());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
