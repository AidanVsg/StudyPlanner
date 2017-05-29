package studyplanner;
import studyplanner.DashboardViewController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;
import studyplanner.Model.Module;
import studyplanner.Model.Assignment;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import studyplanner.Model.Milestone;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class StudyProfileViewController implements Initializable {

    @FXML
    private Label profileNameLabel;
    @FXML
    private ListView<Task> taskListView;
    @FXML
    private ListView<Assignment> assignmentListView;
    @FXML
    private ListView<Milestone> milestoneListView;
    @FXML
    ComboBox<Module> moduleComboBox; //module selection box

    private StudyProfile profile;

    @FXML
    private void addTaskButtonClick() throws IOException {
        showAddTask();
    }
    
    @FXML
    private void addActivityButtonClick() throws IOException {
        showAddActivity();
    }

        @FXML
    private void dashboardButtonClick() throws IOException {
        showDashboard();
    }
    
    @FXML
    private void saveStudyProfile() throws Exception {
        FileOutputStream fos = new FileOutputStream("sp.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(profile);
    }

    public void taskAdded(Task task) {
        Platform.runLater(() -> {
            this.taskListView.getItems().add(task);
        });
    }

    public void assignmentAdded(Assignment as) {
        Platform.runLater(() -> {
            this.assignmentListView.getItems().add(as);
        });
    }

    private void showAddTask() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "CreateTaskView.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setTitle("New Task");
        //stage.setOnHidden(e -> updateTaskListView());

        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        CreateTaskViewController controller
                = loader.<CreateTaskViewController>getController();
        controller.initData(profile, this);
        stage.show();
    }
    
    private void showAddActivity() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "CreateActivityView.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setTitle("New Activity");
        //stage.setOnHidden(e -> updateTaskListView());

        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        CreateActivityViewController controller
                = loader.<CreateActivityViewController>getController();
        controller.initData(profile, this);
        stage.show();
    }
    
    private void showDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "DashboardView.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setTitle("Dashboard");
        //stage.setOnHidden(e -> updateTaskListView());

        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        DashboardViewController controller
                = loader.<DashboardViewController>getController();
        controller.initData(profile, this);
        stage.show();
    }
    
    public void initData(StudyProfile profile) {
        this.profile = profile;
                taskListView.getItems().clear();
//        ChangeListener listener = (ChangeListener<Assignment>) 
//                (ObservableValue<? extends Assignment> observable, 
//                        Assignment oldValue, Assignment newValue) -> {
//            if(newValue.getTasks().size() != 0)
//                taskListView.getItems().setAll(newValue.getTasks());
//            if(newValue.getMilestones().size() != 0)
//                milestoneListView.getItems().setAll(newValue.getMilestones());
//        };

        profileNameLabel.setText(profile.getName());
        moduleComboBox.getItems().addAll(profile.getModules());

        moduleComboBox.valueProperty().addListener(new ChangeListener<Module>() {
            @Override
            public void changed(ObservableValue ov, Module prev, Module cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                //assignmentListView = new ListView<>();
                if (assignmentListView.getItems().size() != 0) {
                    assignmentListView.getItems().clear();
                }
                for (Assignment assign : cur.getAssignments()) {
                    assignmentAdded(assign);
                }
            }
        });
        
        assignmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Assignment>() {
            @Override
            public void changed(ObservableValue ov, Assignment prev, Assignment cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                //assignmentListView = new ListView<>();
                if (taskListView.getItems().size() != 0) {
                    taskListView.getItems().clear();
                }
                for (Task t : cur.getTasks()) {
                    taskAdded(t);
                }
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
