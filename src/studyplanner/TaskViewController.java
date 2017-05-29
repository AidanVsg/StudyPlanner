package studyplanner;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import studyplanner.Model.Assignment;
import studyplanner.Model.Criterion;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;

/**
 * Controller for an editable view of a task
 * @author Michail Krugliakov 100136484
 */
public class TaskViewController implements Initializable {
    private StudyProfile profile;
    private Task task;
    
    @FXML TextField startDateTextField; //task start date
    @FXML DatePicker taskDatePicker; //task deadline date picker
    
    @FXML TextField moduleTextField;
    @FXML TextField assignmentTextField;
    
    @FXML TextField nameTextField; //task name input field
    @FXML TextField typeTextField; //task type input field
    
    @FXML ListView dependencyListView; //list of tasks this tasks depends on
    
    @FXML TextArea descriptionTextArea; //description of the task
    
    @FXML TableView<Criterion> criteriaTableView; //list of criteria to meet this task
        @FXML TableColumn criterionName;
        @FXML TableColumn criterionValue;
        @FXML TableColumn criterionUOM;
    
    @FXML Button cancelButton, updatesTaskButton, addCriterionButton; 
            //closes window    //updates a task     //adds an empty criterion
    
    @FXML AnchorPane createTaskWindow; //shortcut fields to ease acess
    private Stage stage;               //to this controller's view's stage
    

    
    private int i=0;
    
    /**
     * Closes task window
     */
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    /**
     * adds an editable criterion to criteriaTableView
     */
    @FXML private void addCriterionButtonClick(){
        i++;
        Criterion criterion = new Criterion("criterion"+i);
        if(i%2==0){
            criterion.setValue(i/2);
            criterion.setUnitOfMeasure("units done");
        }else{
            criterion.setUnitOfMeasure("done dis");
        }
        criteriaTableView.getItems().add(criterion);
    }
    /**
     * checks for correctness of inputs and creates a new task in
     * selected assignment
     */
    @FXML private void updateTaskButtonClick(){
        //NOTE: OPTIONAL FIELDS ARE: Description, dependencies.
        //selects assignment to add the task to
        Assignment assignment;
        //>>>>ADD CHECKS AND PROPER READING OF INPUT FIELDS.
        
        task.setName(nameTextField.getText());
        task.setType(typeTextField.getText());
        task.setDescription(descriptionTextArea.getText());

        task.setEnd(java.sql.Date.valueOf(taskDatePicker.getValue()));
        task.setCriteria((ArrayList<Criterion>) criteriaTableView.getItems());
        stage.hide();
    }
    public void initData(StudyProfile profile, Task task){
        this.profile = profile;
        stage = (Stage) createTaskWindow.getScene().getWindow();
        
        this.task = task;
        profile.getModules().forEach((Module module) -> {
            module.getAssignments().forEach((Assignment assign) -> {
                for(Task t : assign.getTasks()){
                    if(t.equals(task)){
                        moduleTextField.setText(module.getName());
                        assignmentTextField.setText(assign.getName());
                    }
                }
            });
        });
        
        nameTextField.setText(task.getName());
        typeTextField.setText(task.getType());
        descriptionTextArea.setText(task.getDescription());
        startDateTextField.setText(task.getStart().toString());
        taskDatePicker.setValue(
                    new java.sql.Date(task.getEnd().getTime()).toLocalDate());
        criteriaTableView.getItems().setAll(task.getCriteria());
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
