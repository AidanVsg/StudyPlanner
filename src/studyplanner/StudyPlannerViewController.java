package studyplanner;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerViewController {
    
    private StudyProfile profile; //model data to be used by the controller
    
    @FXML private ListView<StudyProfile> profileListView;
    @FXML private AnchorPane content;
    
    
    @FXML private void loadProfileButtonAction(){
        System.out.println("functionality added later, dude");
    }
    @FXML private void newProfileButtonAction() throws Exception{
        showCreateStudyProfile();
    }

    public void profileAdded(final StudyProfile sp) {
        Platform.runLater(() -> {
            profileListView.getItems().add(sp);
        });
    }
    
    public void showCreateStudyProfile() throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "CreateStudyProfileView.fxml"
                )
        );
        
        Stage stage = new Stage();
        //hides stage if main window is closed
        content.getScene().getWindow().setOnHidden(e -> stage.hide());
        stage.setTitle("Create New Profile");
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        
        CreateStudyProfileViewController controller = 
                loader.<CreateStudyProfileViewController>getController();
        controller.initData(this);
        stage.show();
    }
}