package studyplanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import studyplanner.Model.Criterion;
import studyplanner.Model.CriterionType;
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
    @FXML private TableView approachingTable;
    @FXML private TableView passedTable;
    @FXML private TableColumn approachingAssignment;
    @FXML private TableColumn approachingDeadline;
    @FXML private TableColumn passedAssignment;
    @FXML private TableColumn passedDeadline;
    @FXML private AnchorPane dashboardAnchor;
    @FXML private ProgressBar taskBar;
    @FXML private ProgressBar assignmentBar;
    @FXML private Label criterionProgress;
    @FXML private Label selectedTaskName;
    @FXML private Label selectedCriterionName;
    @FXML private Label selectedAssignmentName;
    @FXML private StudyProfile profile;   
    
    @FXML private Module selectedModule;   
    @FXML private Assignment selectedAssignment;   
    @FXML private Task selectedTask;    
    @FXML private Milestone selectedMilestone;
    @FXML private Criterion selectedCriterion;
    @FXML private Label moduleStudyTime;
    
    @FXML private void generateGanttChart() throws Exception{

        Stage stage = new Stage();
        stage.setTitle("Gantt Chart");
        //stage.setOnHidden(e -> updateTaskListView());
       
        
        GanttChartController gch = new GanttChartController();
        
        
        gch.firstInit(selectedAssignment, stage);
        gch.setPrevious(selectedAssignment, stage);
        gch.setNext(selectedAssignment, stage);
        Scene scene = gch.getScene();
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML private void addTaskButtonClick() throws IOException {
        showAddTask();
    }
    @FXML private void addMilestoneButtonClick() throws IOException {
        showAddMilestone();
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
    public void milestoneAdded(Milestone milestone){
        Platform.runLater(() -> {
            this.milestoneListView.getItems().add(milestone);
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
    
        private void updateStage(Stage stage) {
        stage.setOnHidden(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                updateTaskList(selectedAssignment);
                updateCriteriaList(selectedTask);
                updateDeadlines(profile);
                showCriteriaProgress(selectedCriterion);                   
            }
        });
    }
        
            private void showCriteriaProgress(Criterion selectedCriterion) {
                String text = "";
                if(selectedCriterion == null){
                    selectedCriterionName.setText("Criterion Progress");
                    criterionProgress.setText("");
                }
                else{
                    if(selectedCriterion.getType().equals(CriterionType.Boolean))
                    {
                        if(selectedCriterion.isMet()) text = " is done";
                        else text = " is not done";
                    }
                    else{
                        double progress = selectedCriterion.getValue();                    
                        text = Double.toString(progress) + " left";
                    }

                        selectedCriterionName.setText(selectedCriterion.getName());
                    criterionProgress.setText(text);
                }
                
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
        updateStage(stage);

        CreateTaskViewController controller
                = loader.<CreateTaskViewController>getController();
        controller.initData(profile,selectedModule,selectedAssignment, this);
        stage.show();
    }
    
    private void updateDeadlines(StudyProfile profile) {
        boolean allDone = true;
        
        approachingTable.getItems().clear();
        passedTable.getItems().clear();
        for(Module m : profile.getModules()){
            for(Assignment a : m.getAssignments()){
                
                Date current = new Date();
                
                for(Task t : a.getTasks()){
                    if(!t.isDone()) allDone = false;
                }
                
                
                    
                if(!allDone && current.getTime() < a.getEnd().getTime())
                    approachingTable.getItems().add(a);
                else
                   passedTable.getItems().add(a); 
                
            }
        }
    }
    
    private void showTask() throws Exception{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "TaskView.fxml"
                )
        );
    
        Stage stage = new Stage();
        stage.setTitle(selectedTask.getName());
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        updateStage(stage);
        
        TaskViewController controller = 
                loader.<TaskViewController>getController();
        controller.initData(profile, selectedTask);
        stage.show();    
    }
    
    private void showAddMilestone() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "CreateMilestoneView.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setTitle("New Milestone");

        stage.setScene(
                new Scene(
                        (Pane) loader.load()
                )
        );

        CreateMilestoneViewController controller
                = loader.<CreateMilestoneViewController>getController();
        controller.initData(profile,selectedModule,selectedAssignment, this);
        stage.show();
    }
    
    private void showMilestone() throws Exception{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "MilestoneView.fxml"
                )
        );
    
        Stage stage = new Stage();
        stage.setTitle(selectedMilestone.getName());
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        updateStage(stage);
        
        MilestoneViewController controller = 
                loader.<MilestoneViewController>getController();
        controller.initData(profile, selectedMilestone);
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
        updateStage(stage);
        
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
    
    private void updateTaskList(Assignment cur){
        if(cur == null){
                    selectedAssignmentName.setText("Assignment Progress");
                    assignmentBar.setProgress(0.0);
        }
        else{
             int required = cur.getTasks().size();
        int finished = 0;
        if ( !taskListView.getItems().isEmpty()) {
                    taskListView.getItems().clear();
                    criteriaListView.getItems().clear();
                    selectedTask=null;
                    selectedCriterion = null;
                }
                for (Task t : cur.getTasks()) {
                    taskAdded(t);
                    if(t.isDone()) finished++;
                }
                
                        double progress = (double)finished/required;
        
                        selectedAssignmentName.setText(cur.getName());
                        assignmentBar.setProgress(progress);
        }
       
     
    }
    private void updateCriteriaList(Task cur){
        if(cur == null){
                    selectedTaskName.setText("Task Progress");
                    taskBar.setProgress(0.0);
        }
        else{
            int required = cur.getCriteria().size();
            int finished = 0;
            if(!criteriaListView.getItems().isEmpty()){
                        criteriaListView.getItems().clear();
                        selectedCriterion=null;
                    }
                    for(Criterion c : cur.getCriteria()){
                        criterionAdded(c);
                        if(c.isMet()) finished++;
                    }

                            double progress = (double)finished/required;
            selectedTaskName.setText(cur.getName());
            taskBar.setProgress(progress);
        }
    }
    
    public void initData(StudyProfile profile) {
        this.profile = profile;
        milestoneListView = new ListView<>();
//        ChangeListener listener = (ChangeListener<Assignment>) 
//                (ObservableValue<? extends Assignment> observable, 
//                        Assignment oldValue, Assignment newValue) -> {
//            if(newValue.getTasks().size() != 0)
//                taskListView.getItems().setAll(newValue.getTasks());
//            if(newValue.getMilestones().size() != 0)
//                milestoneListView.getItems().setAll(newValue.getMilestones());
//        };

        PropertyValueFactory<Assignment,String> aName = new PropertyValueFactory<>("name");
        PropertyValueFactory<Assignment,Date> aDate = new PropertyValueFactory<>("end");
        
        approachingAssignment.setCellValueFactory(aName);
        approachingDeadline.setCellValueFactory(aDate);
        
        passedAssignment.setCellValueFactory(aName);
        passedDeadline.setCellValueFactory(aDate);
        
        

        updateDeadlines(profile);
        

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
                if (!assignmentListView.getItems().isEmpty()) {
                    assignmentListView.getItems().clear();
                    criteriaListView.getItems().clear();
                    taskListView.getItems().clear();
                    selectedAssignment=null;
                    selectedCriterion=null;
                }
                for (Assignment assign : cur.getAssignments()) {
                    assignmentAdded(assign);
                }
                selectedModule = cur;
                moduleStudyTime.setText("Time spent studying " + cur.getName() + ": "+ Double.toString(cur.getTimeSpentStudying()));
            }
        });
        
        assignmentListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Assignment>() {
            @Override
            public void changed(ObservableValue ov, Assignment prev, Assignment cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                updateTaskList(cur);
                
                selectedAssignment = cur;
                
            }
        });
        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>(){
            @Override
            public void changed(ObservableValue ov, Task prev, Task cur){
                updateCriteriaList(cur);
                selectedTask = cur;
            }
        });
        criteriaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Criterion>(){
            @Override
            public void changed(ObservableValue ov, Criterion prev, Criterion cur){
                showCriteriaProgress(cur);
                selectedCriterion = cur;
            }
        });

        milestoneListView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent click) {
                if (click.getClickCount() == 2) {
                   //Use ListView's getSelected Item
                   selectedMilestone = milestoneListView.getSelectionModel()
                                                            .getSelectedItem();
                    try {
                        showMilestone();
                    } catch (Exception ex) {
                        Logger.getLogger(StudyProfileViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }});
        taskListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click){

                if (click.getClickCount() == 2) {
                   //Use ListView's getSelected Item
                   selectedTask = taskListView.getSelectionModel()
                                                            .getSelectedItem();
                    try {
                        showTask();
                    } catch (Exception ex) {
                        Logger.getLogger(StudyProfileViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }});
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

