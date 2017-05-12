package studyplanner.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerControl {
    
    private StudyProfile profile; //model data to be used by the controller
    @FXML
    private ListView<StudyProfile> profileListView;
    private ObservableList<StudyProfile> studyProfileList = 
                                            FXCollections.observableArrayList();
    
    
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
        studyProfileList.add(sp1);
        profileAdded(sp1);
        System.out.println("WOrks twice as much!");
        profile.setName("John");
    }
    @FXML
    private void button1Click(){
        
        if(profile.getName() != null){
            System.out.println(profile.getName());
        }else{
            System.out.println("Profile not named yet.");
        }
    }
    
    /**
     * Initialising Model data to be used by the controller
     * @param profile 
     */
    public void initData(StudyProfile profile){
        this.profile = profile;
    }
}
