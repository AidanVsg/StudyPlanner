package studyplanner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class StudyProfileViewController implements Initializable {

    @FXML private Label profileNameLabel;
    
    private StudyProfile profile;
    
    @FXML private void addTaskButtonClick() throws IOException{
        showAddTask();
    }
    
    private void showAddTask() throws IOException{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "CreateTaskView.fxml"
                )
        );
        
        Stage stage = new Stage();
        stage.setTitle("New Task");
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        
        CreateTaskViewController controller = 
                loader.<CreateTaskViewController>getController();
        controller.initData(profile);
        stage.show();
    }
        
    public void initData(StudyProfile profile){
        this.profile = profile;
        profileNameLabel.setText(profile.getName());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
