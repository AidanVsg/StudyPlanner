package studyplanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller with basic functionality for creation windows.
 * @author Michail Krugliakov 100136484
 */
abstract class CreateViewController implements Initializable{
    @FXML protected ComboBox moduleComboBox;
    @FXML protected ComboBox assignmentComboBox;
    @FXML protected TextArea descriptionTextArea;
    @FXML protected Button cancelButton, createButton;
    
    protected Stage stage;    
    
    
    /**
     * Hides this controller's view window if stage is initialized
     */
    @FXML protected void cancelButtonClick(){
        if(stage != null) stage.hide();  
    }
    
    protected abstract void initStage(Stage stage);

    @Override
    public abstract void initialize(URL location, ResourceBundle resources);
}
