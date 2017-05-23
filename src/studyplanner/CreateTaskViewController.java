package studyplanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class CreateTaskViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML ComboBox moduleComboBox, assignmentComboBox;
    public void initData(StudyProfile profile){
        this.profile = profile;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Module> moduleList;
    }    
    
}
