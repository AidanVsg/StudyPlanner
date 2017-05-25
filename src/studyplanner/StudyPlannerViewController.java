package studyplanner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerViewController implements Initializable {
    
    private StudyProfile profile; //profile data to be used by the controller
    
    @FXML private ListView<StudyProfile> profileListView;
    @FXML private AnchorPane content;
    
    @FXML private void loadProfileButtonAction() throws Exception{
        if(profile != null){
            content.getScene().getWindow().hide();
            showStudyProfile();
        }
        
        
        //CODE TO EASE TESTING, PLEASE REMOVE AFTER PROGRAM IS LIVE++++++++++++++++++++++++++++++++++++++++
        StudyProfile testProfile = new StudyProfile();
        testProfile.setName("TEST PROFILE MY MAN");
        File hubFile = new File("HubFile.xml");
        StudyProfile.InitialiseStudyProfile(testProfile, hubFile);
        profile = testProfile;
        showStudyProfile();
        //TESTING CODE ENDED MY BROS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
    
    public void showStudyProfile() throws Exception {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "StudyProfileView.fxml"
                )
        );
        
        Stage stage = new Stage();
        stage.setTitle(profile.getName());
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        
        StudyProfileViewController controller = 
                loader.<StudyProfileViewController>getController();
        controller.initData(profile);
        stage.show();
    }
    
    public void openDashboard(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardView.fxml"));
    
        try {
            Stage stage = new Stage();  
            stage.setScene(new Scene ((HBox) loader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StudyPlannerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ChangeListener listener = (ChangeListener<StudyProfile>) 
                (ObservableValue<? extends StudyProfile> observable, 
                        StudyProfile oldValue, StudyProfile newValue) -> {
            profile = newValue;
            System.out.println("ListView selection changed from oldValue = "
                    + oldValue + " to newValue = " + newValue);
        };
        profileListView.getSelectionModel().selectedItemProperty().addListener(listener);
    }
}