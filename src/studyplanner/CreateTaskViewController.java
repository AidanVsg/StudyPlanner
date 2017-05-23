package studyplanner;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class CreateTaskViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML DatePicker taskDatePicker;
    
    
    @FXML ComboBox moduleComboBox, assignmentComboBox;
    public void initData(StudyProfile profile){
        this.profile = profile;
        moduleComboBox.getItems().addAll(profile.getModules());
        moduleComboBox.valueProperty().addListener(new ChangeListener<Module>() {
            @Override public void changed(ObservableValue ov, Module prev, Module cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                if(!assignmentComboBox.getValue().equals(null)){
                    assignmentComboBox.setValue(null);
                }
                assignmentComboBox.getItems().setAll(cur.getAssignments());
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
        initializeDatePicker(taskDatePicker, profile);
        
    }    
    
    //TODO ALSO DISABLE BEING ABLE TO PICK A DATE AFTER DEADLINE
    private void initializeDatePicker(DatePicker datePicker, StudyProfile profile){
        final Callback<DatePicker, DateCell> dayCellFactory = 
            (final DatePicker datePicker1) -> new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (item.isBefore(
                            LocalDate.now())
                            ){
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;");   
                    }
                }
            };
        datePicker.setDayCellFactory(dayCellFactory);
    }
    
}
