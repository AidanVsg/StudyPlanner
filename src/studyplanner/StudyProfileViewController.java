package studyplanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import studyplanner.Model.Criterion;
import studyplanner.Model.Milestone;

/**
 * FXML Controller class
 *
 * @author Doggo
 */
public class StudyProfileViewController implements Initializable {

    @FXML private Label profileNameLabel;

    @FXML private ListView<Task> taskListView;
    @FXML private ListView<Assignment> assignmentListView;
    @FXML private ListView<Milestone> milestoneListView;
    
    
    @FXML private ListView<Module> moduleListView;
            
    @FXML private ListView<Criterion> criteriaListView;
    //@FXML
    //ComboBox<Module> moduleComboBox; //module selection box

    private StudyProfile profile;
    
    private Module selectedModule;
    
    private Assignment selectedAssignment;
    
    private Task selectedTask;
    
    private Criterion selectedCriterion;

    @FXML private void addTaskButtonClick() throws IOException {
        showAddTask();
    }
    
    @FXML private void addActivityButtonClick() throws IOException {
        showAddActivity();
    }

    @FXML private void dashboardButtonClick() throws IOException {
        showDashboard();
    }
    
    @FXML private void saveStudyProfile() throws Exception {
        FileOutputStream fos = new FileOutputStream("sp.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(profile);
    }

    public void taskAdded(Task task) {
        Platform.runLater(() -> {
            this.taskListView.getItems().add(task);
        });
    }

    public void criterionAdded(Criterion criterion) {
        Platform.runLater(() -> {
            this.criteriaListView.getItems().add(criterion);
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
        controller.initData(profile,selectedModule,selectedAssignment, this);
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
        controller.initData(profile,selectedModule,selectedAssignment,
                            selectedTask, this);
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
//        ChangeListener listener = (ChangeListener<Assignment>) 
//                (ObservableValue<? extends Assignment> observable, 
//                        Assignment oldValue, Assignment newValue) -> {
//            if(newValue.getTasks().size() != 0)
//                taskListView.getItems().setAll(newValue.getTasks());
//            if(newValue.getMilestones().size() != 0)
//                milestoneListView.getItems().setAll(newValue.getMilestones());
//        };

        profileNameLabel.setText(profile.getName());
        moduleListView.getItems().addAll(profile.getModules());
        for(Module m : moduleListView.getItems())
        {
            System.out.println();
        }

        moduleListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Module>() {
            @Override
            public void changed(ObservableValue ov, Module prev, Module cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                if (assignmentListView.getItems().size() != 0) {
                    assignmentListView.getItems().clear();
                    selectedAssignment=null;
                }
                for (Assignment assign : cur.getAssignments()) {
                    assignmentAdded(assign);
                }
                selectedModule = cur;
            }
        });
        
        assignmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Assignment>() {
            @Override
            public void changed(ObservableValue ov, Assignment prev, Assignment cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                if (taskListView.getItems().size() != 0) {
                    taskListView.getItems().clear();
                    selectedTask=null;
                }
                for (Task t : cur.getTasks()) {
                    taskAdded(t);
                }
                
                selectedAssignment = cur;
                
            }
        });
        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>(){
            @Override
            public void changed(ObservableValue ov, Task prev, Task cur){
                if(criteriaListView.getItems().size() != 0){
                    criteriaListView.getItems().clear();
                    selectedCriterion=null;
                }
                for(Criterion c : cur.getCriteria()){
                    criterionAdded(c);
                }
                selectedTask = cur;
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
