package studyplanner;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import studyplanner.Model.Activity;
import studyplanner.Model.Assignment;
import studyplanner.Model.Criterion;
import studyplanner.Model.CriterionType;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;

/**
 * Controller for task creation window
 * @author Michail Krugliakov 100136484
 */
public class CreateActivityViewController implements Initializable {
    private StudyProfile profile;
    private Task selectedTask;
    private CriterionType criterionType;
    
    @FXML ComboBox<Module> moduleComboBox; //module selection box
    @FXML ComboBox<Assignment> assignmentComboBox; //assignment selection box
    @FXML ComboBox<Task> taskComboBox; //assignment selection box   
    @FXML ComboBox<Criterion> criterionComboBox;
      
    @FXML TextField criterionValue;
    @FXML Label criterionUOM;
    @FXML TextField nameTextField; //task name input field
    
    @FXML TextArea descriptionTextArea; //description of the task
    
    
    @FXML Button cancelButton, createActivityButton, addCriterionButton; 
            //closes window    //creates a new task     //adds an empty criterion
    
    @FXML AnchorPane createActivityWindow; //shortcut fields to ease acess
    private Stage stage;               //to this controller's view's stage
    
    //private StudyProfileViewController mainController;
                                       //controller to pass task data to
    
    /**
     * Closes task creation window
     */
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    /**
     * checks for correctness of inputs and creates a new task in
     * selected assignment
     */
    @FXML private void createActivityButtonClick(){
        Activity activity = new Activity();
           
        
        activity.setDescription(descriptionTextArea.getText());
        activity.setValue(Double.parseDouble(criterionValue.getText()));
        activity.updateCriterion(criterionComboBox.getValue());
        activity.setName(nameTextField.getText()); //
        criterionComboBox.getValue().updateTask(selectedTask);
        stage.hide();
    }
    
    public void initData(StudyProfile profile, Module module,
                Assignment assign, Task task,
                StudyProfileViewController mainController){
        
        if(module!=null) moduleComboBox.setValue(module);
        if(assign!=null) assignmentComboBox.setValue(assign);
        if(task!=null) taskComboBox.setValue(task);
        //this.mainController = mainController;
        stage = (Stage) createActivityWindow.getScene().getWindow();
        
        this.profile = profile;
        
        moduleComboBox.getItems().addAll(profile.getModules());
        
       
    }

    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
         
        moduleComboBox.valueProperty().addListener(new ChangeListener<Module>() {
            @Override 
            public void changed(ObservableValue ov, Module prev, Module cur) {
                //resets value to zero so that user can't create task
                //with incompatible modules and assignments
                if(assignmentComboBox.getValue() != null){
                    assignmentComboBox.setValue(null);
                }
                ArrayList<Assignment> beforeDeadlineAssign = new ArrayList<>();
                for(Assignment assign : cur.getAssignments()){
                    if(!assign.getEnd().before(new Date())){
                        beforeDeadlineAssign.add(assign);
                    }
                }
                assignmentComboBox.getItems().setAll(beforeDeadlineAssign);
            }    
        });
        assignmentComboBox.valueProperty().addListener(
            new ChangeListener<Assignment>(){
                @Override
                public void changed(ObservableValue ov, Assignment prev, Assignment cur){
                    if(taskComboBox.getValue() != null){
                        taskComboBox.setValue(null);
                    }
                    for (Task t : cur.getTasks()){
                        if(!t.isDone())
                            taskComboBox.getItems().add(t);
                    }
                }
            });
        taskComboBox.valueProperty().addListener(
                new ChangeListener<Task>(){
                    @Override
                    public void changed(ObservableValue ov, Task prev, Task cur){
                        selectedTask = cur;
                        if(criterionComboBox.getValue() != null){
                            criterionComboBox.setValue(null);
                        }
                        for (Criterion c : cur.getCriteria()){
                            if(!c.isMet())
                                criterionComboBox.getItems().add(c);
                        }
                    }
                });
        criterionComboBox.valueProperty().addListener(
                new ChangeListener<Criterion>(){
                    @Override
                    public void changed(ObservableValue ov, Criterion prev, Criterion cur){
                       
                        if(cur.getType().equals(CriterionType.Boolean)){
                            criterionUOM.setText("");
                            criterionValue.setDisable(true);
                        }
                        else{
                            criterionUOM.setText(cur.getUnitOfMeasure());
                            criterionValue.setDisable(false);
                        }
                        //criterionType = cur.getType();
                    }
                });
        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");
        TextFormatter<Double> textFormatter = new TextFormatter<Double>(new DoubleStringConverter(), 0.0, change
        -> {
            String newText = change.getControlNewText();
            if (validDoubleText.matcher(newText).matches()) return change;
            else return null;
            
        });
        criterionValue.setTextFormatter(textFormatter);
        textFormatter.valueProperty().addListener((obs, oldValue, newValue) ->
        {
            criterionValue.setText(newValue.toString());
        });
//        criterionValue.textProperty().addListener(new ChangeListener<String>() {
//        @Override
//        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//            if (!newValue.matches("^[0-9][.][0-9]")) {
//                criterionValue.setText(newValue.replaceAll("[^\\d]", ""));
//            }
//        }
//    });
    }   
}
