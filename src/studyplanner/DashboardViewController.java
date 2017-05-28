package studyplanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;
import studyplanner.StudyPlanner;

/**
 *
 * @author Doggo
 */
public class DashboardViewController {
    
//    @FXML
//    private SplitPane parentPane;
    @FXML
    private Pane parentBox;
    
//    public static void writeObject(Object obj) throws IOException{
//        FileOutputStream fos = new FileOutputStream("spfile.ser");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(obj);
//    }
    
    public void initialize() {
        
        
        
        ProgressBar pb = new ProgressBar(0.6);
        ProgressIndicator pi = new ProgressIndicator(0.6);
        
        
        parentBox.getChildren().add(pb);
        
    
    }
    
    
}
    
    