package studyplanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;
import studyplanner.Model.Module;
import studyplanner.Model.Assignment;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class StudyProfileViewController implements Initializable {

    @FXML private Label profileNameLabel;
    @FXML private ListView<Task> taskListView;
    
    private StudyProfile profile;
    
    @FXML private void addTaskButtonClick() throws IOException{
        showAddTask();
    }
    
      @FXML private void saveStudyProfile() throws Exception{
        FileOutputStream fos = new FileOutputStream("sp.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(profile);
    }
      
    public void taskAdded(Task task){
        Platform.runLater(() -> {
            this.taskListView.getItems().add(task);
        });
    }
    
    private void showAddTask() throws IOException{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "CreateTaskView.fxml"
                )
        );
        
        Stage stage = new Stage();
        stage.setTitle("New Task");
        stage.setOnHidden(e -> updateTaskListView());
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        
        CreateTaskViewController controller = 
                loader.<CreateTaskViewController>getController();
        controller.initData(profile, this);
        stage.show();
    }
        
    public void initData(StudyProfile profile){
        this.profile = profile;
        updateTaskListView();
        profileNameLabel.setText(profile.getName());
    }
    private void updateTaskListView(){
        for(Module m : profile.getModules()){
            for(Assignment a : m.getAssignments()){
                for(Task t : a.getTasks()){
                    taskAdded(t);
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
