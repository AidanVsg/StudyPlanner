package studyplanner;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import studyplanner.Model.Activity;
import studyplanner.Model.Assignment;
import studyplanner.Model.Criterion;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class CreateTaskViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML ComboBox<Module> moduleComboBox;
    @FXML ComboBox<Assignment> assignmentComboBox;
        
    @FXML DatePicker taskDatePicker;
    
    @FXML TextField nameTextField;
    @FXML TextField typeTextField;
    
    @FXML ListView dependencyListView;
    
    @FXML TextArea descriptionTextArea;
    
    @FXML TableView criteriaTableView;
    
    @FXML Button cancelButton, createTaskButton;
    
    @FXML AnchorPane createTaskWindow;
    
    private Stage stage;
    
    private StudyProfileViewController mainController;
    
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    
    @FXML private void addCriterionButtonClick(){
        
    }
    
    @FXML private void createTaskButtonClick(){
        Assignment assignment = assignmentComboBox.getValue();
        
        String type = typeTextField.getText();
        ArrayList<Criterion> criteria = new ArrayList<>();
        ArrayList<Activity> activityHistory = new ArrayList<>();
        ArrayList<Task> dependencies = new ArrayList<>();
        Date start = new Date();
        Date end = java.sql.Date.valueOf(taskDatePicker.getValue());
        
        Task task = new Task(type,criteria,activityHistory, dependencies,
        nameTextField.getText(),descriptionTextArea.getText(),
        start, end);
        
        assignment.addTask(task);
        mainController.taskAdded(task);
        System.out.println(assignment.getTasks().get(0).getEnd());
        stage.hide();
    }
    
    public void initData(StudyProfile profile){
        stage = (Stage) createTaskWindow.getScene().getWindow();
        this.profile = profile;
        
        moduleComboBox.getItems().addAll(profile.getModules());
        moduleComboBox.valueProperty().addListener(new ChangeListener<Module>() {
            @Override public void changed(ObservableValue ov, Module prev, Module cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                if(assignmentComboBox.getValue() != null){
                    assignmentComboBox.setValue(null);
                }
                ArrayList<Assignment> beforeDeadlineAssign = new ArrayList<>();
                for(Assignment assign : cur.getAssignments()){
                    if(!assign.getEnd().before(new Date())){
                        beforeDeadlineAssign.add(assign);
                    }
                }
                assignmentComboBox.getItems().setAll(beforeDeadlineAssign);
            }    
        });
        assignmentComboBox.valueProperty().addListener(
            new ChangeListener<Assignment>(){
                @Override public void changed(ObservableValue ov, Assignment prev, Assignment cur){
                    if(cur!=null){
                        initializeDatePicker(taskDatePicker, cur);
                    }
                }
            });
    }
    
    @FXML private void addCriterionButtonClick(){
        
    }

    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskDatePicker.setValue(LocalDate.now());        
    }    

    private void initializeDatePicker(DatePicker datePicker, Assignment assign){
        datePicker.setValue(LocalDate.now());
        datePicker.setDisable(false);
        LocalDate assignDeadline = 
                new java.sql.Date(assign.getEnd().getTime()).toLocalDate();
        
        final Callback<DatePicker, DateCell> dayCellFactory = 
            (final DatePicker datePicker1) -> new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (item.isBefore(LocalDate.now()) 
                                            || item.isAfter(assignDeadline)){
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;");   
                    }
                }
            };
        datePicker.setDayCellFactory(dayCellFactory);
    }
    
}
