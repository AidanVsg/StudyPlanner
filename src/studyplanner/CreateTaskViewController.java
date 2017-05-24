package studyplanner;

import java.net.URL;
import java.time.LocalDate;
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
import studyplanner.Model.Assignment;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class CreateTaskViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML ComboBox moduleComboBox, assignmentComboBox;
    
    @FXML DatePicker taskDatePicker;
    
    @FXML TextField nameTextField;
    
    @FXML ListView dependencyListView;
    
    @FXML TextArea descriptionTextArea;
    
    @FXML TableView criteriaTableView;
    
    @FXML Button cancelButton, createTaskButton;
    
    @FXML AnchorPane createTaskWindow;
    
    private Stage stage;
    
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    
    @FXML private void createTaskButtonClick(){
        
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!MAKE SURE YOU CANT CREATE TASKS IF TODAY IS AFTER THE DEADLINE OF AN ASSIGNMENT
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
                assignmentComboBox.getItems().setAll(cur.getAssignments());
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
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        taskDatePicker.setValue(LocalDate.now());        
    }    

    //YOU CAN STILL CHEAT THE BLOCK IF YOU SELECT THE DATE BEFORE YOU SELECT AN ASSIGNMENT
    private void initializeDatePicker(DatePicker datePicker, Assignment assign){
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
