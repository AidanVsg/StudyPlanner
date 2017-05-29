package studyplanner;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Doggo
 */
public abstract class CreateObjectiveViewController extends CreateViewController{
    @FXML protected DatePicker dueDatePicker; //deadline date picker
    @FXML protected TextField nameTextField; //name input field
}
