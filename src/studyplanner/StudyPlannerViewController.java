package studyplanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class StudyPlannerViewController implements Initializable {
    
    private StudyProfile profile; //profile data to be used by the controller
    
    @FXML private ListView<StudyProfile> profileListView;
    @FXML private AnchorPane content;
    
    
    @FXML private void loadProfileButtonAction() throws Exception{
        if(profile != null){
            content.getScene().getWindow().hide();
            showStudyProfile();
        }
        
        else
        {
        //CODE TO EASE TESTING, PLEASE REMOVE AFTER PROGRAM IS LIVE++++++++++++++++++++++++++++++++++++++++
        StudyProfile testProfile = new StudyProfile();
        testProfile.setName("TEST PROFILE MY MAN");
        File hubFile = new File("HubFile.xml");
        StudyProfile.InitialiseStudyProfile(testProfile, hubFile);
        profile = testProfile;
        showStudyProfile();
        }
        //TESTING CODE ENDED MY BROS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
    @FXML private void newProfileButtonAction() throws Exception{
        showCreateStudyProfile();
    }
    
    @FXML private void saveStudyProfile() throws Exception{
                FileOutputStream fos = new FileOutputStream("sp.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(profile);
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ChangeListener listener = (ChangeListener<StudyProfile>) 
                (ObservableValue<? extends StudyProfile> observable, 
                        StudyProfile oldValue, StudyProfile newValue) -> {
            profile = newValue;
        };
        
        FileInputStream fin = null;
	ObjectInputStream ois = null;
        
        try{                   
            fin = new FileInputStream("sp.ser");
            ois = new ObjectInputStream(fin);
                       
            profileAdded((StudyProfile) ois.readObject());
        }
        catch(Exception e){
            System.out.println("file does not exist");
        }
                        
        
        
        profileListView.getSelectionModel().selectedItemProperty().addListener(listener);
        
        
    }
}