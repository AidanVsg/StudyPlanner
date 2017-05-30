package studyplanner;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import studyplanner.Model.Assignment;
import studyplanner.Model.Milestone;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;


/**
 * Controller for an editable view of a milestone
 *
 * @author Doggo
 */
public class MilestoneViewController 
        extends ObjectiveViewController
        implements Initializable {
    private Milestone milestone;
    
    @FXML ListView addedTaskListView;
    
    @FXML TextField moduleTextField, assignmentTextField;

    @Override
    void updateButtonClick() {
        milestone.setName(nameTextField.getText());
        milestone.setDescription(descriptionTextArea.getText());
        milestone.setTasks((ArrayList<Task>) addedTaskListView.getItems());
        milestone.setEnd(java.sql.Date.valueOf(endDatePicker.getValue()));
        
        stage.hide();
    }
    
    public void initData(StudyProfile profile, Milestone milestone){
        stage = this.fetchStage();
        this.milestone = milestone;
        
        profile.getModules().forEach((Module module) -> {
            module.getAssignments().forEach((Assignment assign) -> {
                for(Milestone mileS : assign.getMilestones()){
                    if(mileS.equals(milestone)){
                        moduleTextField.setText(module.getName());
                        assignmentTextField.setText(assign.getName());
                    }
                }
            });
        });
        this.initializeViewFromObjective(milestone);
        addedTaskListView.getItems().setAll(milestone.getTasks());
        
    }
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
