package studyplanner.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerControl {
    
    private StudyProfile profile; //model data to be used by the controller
    @FXML
    private ListView<StudyProfile> profileListView;
    
    public void profileAdded(final StudyProfile sp)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                profileListView.getItems().add(sp);
            }
        });
    }
    
    //JUST SOME TEST METHODS DELETE AFTER TESTING
    @FXML
    private void button2Click(){
        StudyProfile sp1 = new StudyProfile();
        sp1.setName("Johny");
        profileAdded(sp1);
    }
    @FXML
    private void button1Click() throws Exception{
        System.out.println("works");
        showCreateStudyProfile();
    }
    
    /**
     * Initialising Model data to be used by the controller
     * @param profile 
     */
    public void initData(StudyProfile profile){
        this.profile = profile;
    }
    //PLEASE FIX ISSUE WITH FILE PLACEMENT. WHY CAN THIS BITCH PATH TO FXML GAAWD
    public void showCreateStudyProfile() throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "CreateStudyProfile.fxml"
                )
        );
        
        
        Stage stage = new Stage();
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        stage.setTitle("Create New Profile");
        
        CreateStudyProfileControl controller = 
                loader.<CreateStudyProfileControl>getController();
        controller.initData(profile);
        stage.show();
    }
}
