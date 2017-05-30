package studyplanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import studyplanner.Model.Objective;

/**
 *
 * @author Doggo
 */
public abstract class ObjectiveViewController extends ViewController{
    
    @FXML protected Button cancelButton, updateButton;
    @FXML protected TextArea descriptionTextArea;
    @FXML protected TextField startDateTextField;
    @FXML protected DatePicker endDatePicker;
    
    public void initializeViewFromObjective(Objective objective){
        nameTextField.setText(objective.getName());
        descriptionTextArea.setText(objective.getDescription());
        startDateTextField.setText(objective.getStart().toString());
        endDatePicker.setValue(
                new java.sql.Date(objective.getEnd().getTime()).toLocalDate());
         
    }
    /**
     * Hides this controller's view window if stage is initialized
     */
    @FXML protected void cancelButtonClick(){
        if(stage != null) stage.hide();  
    }
    
    @FXML abstract void updateButtonClick();
}
