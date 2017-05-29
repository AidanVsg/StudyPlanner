package studyplanner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import studyplanner.Model.Assignment;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;
import studyplanner.StudyPlanner;

/**
 *
 * @author Doggo
 */
public class DashboardViewController implements Initializable{
    
//    @FXML
//    private SplitPane parentPane;
    @FXML
    private Pane parentBox;
        @FXML AnchorPane dashboardWindow; //shortcut fields to ease acess
    private Stage stage;               //to this controller's view's stage
    private StudyProfile profile;
    
//    public static void writeObject(Object obj) throws IOException{
//        FileOutputStream fos = new FileOutputStream("spfile.ser");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(obj);
//    }
    public void initData(StudyProfile profile, 
                StudyProfileViewController mainController){
        
        //this.mainController = mainController;
        stage = (Stage) dashboardWindow.getScene().getWindow();
        
        this.profile = profile;
               
        
        Module m = profile.getModules().get(0);
        int taskNum = m.getAssignments().size();
        int finished = 0;
            for(Assignment a : m.getAssignments()){
                for(Task t : a.getTasks()){
                    if(t.isDone()) finished++;
                }
            }
            
        double progress = (double)finished/taskNum;
        
        ProgressBar pb = new ProgressBar(progress);
        //ProgressIndicator pi = new ProgressIndicator(0.6);
        
        
        parentBox.getChildren().add(pb);

    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    }
    
    
}
    
    