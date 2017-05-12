package studyplanner.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import studyplanner.Model.StudyProfile;

/**
 *
 * @author Doggo
 */
public class StudyPlannerControl {
    
    private StudyProfile profile; //model data to be used by the controller
    @FXML
    private Label profileTest;
    
    @FXML
    private void dragAction(){
        System.out.println("Works, at least!");
        profileTest.setBackground(Background.EMPTY);
    }
    //JUST SOME TEST METHODS DELETE AFTER TESTING
    @FXML
    private void button1Click(){
        System.out.println("WOrks twice as much!");
        profile.setName("John");
    }
    @FXML
    private void button2Click(){
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
