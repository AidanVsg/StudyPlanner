package studyplanner;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import studyplanner.Model.Activity;
import studyplanner.Model.Assignment;
import studyplanner.Model.Criterion;
import studyplanner.Model.Module;
import studyplanner.Model.StudyProfile;
import studyplanner.Model.Task;

/**
 * Controller for task creation window
 * @author Michail Krugliakov 100136484
 */
public class CreateActivityViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML ComboBox<Module> moduleComboBox; //module selection box
    @FXML ComboBox<Assignment> assignmentComboBox; //assignment selection box
    @FXML ComboBox<Task> taskComboBox; //assignment selection box   
    @FXML ComboBox<Criterion> criterionComboBox;
       
    @FXML DatePicker taskDatePicker; //task deadline date picker
    
    @FXML TextField nameTextField; //task name input field
    @FXML TextField typeTextField; //task type input field
    
    @FXML ListView dependencyListView; //list of tasks this tasks depends on
    
    @FXML TextArea descriptionTextArea; //description of the task
    
    @FXML TableView criteriaTableView; //list of criteria to meet this task
        @FXML TableColumn criterionName;
        @FXML TableColumn criterionValue;
        @FXML TableColumn criterionUOM;
    
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
           
        activity.setName(nameTextField.getText()); //
        activity.setDescription(descriptionTextArea.getText());
        activity.setValue(0.0);
        activity.updateCriterion(criterionComboBox.getValue());
        stage.hide();
    }
    
    public void initData(StudyProfile profile, 
                StudyProfileViewController mainController){
        
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
                        taskComboBox.getItems().add(t);
                    }
                }
            });
        taskComboBox.valueProperty().addListener(
                new ChangeListener<Task>(){
                    @Override
                    public void changed(ObservableValue ov, Task prev, Task cur){
                        if(criterionComboBox.getValue() != null){
                            criterionComboBox.setValue(null);
                        }
                        for (Criterion c : cur.getCriteria()){
                            criterionComboBox.getItems().add(c);
                        }
                    }
                });

    }   
    
    class EditingCell extends TableCell<Criterion, String> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(null);
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 
        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0, 
                    Boolean arg1, Boolean arg2) {
                        if (!arg2) {
                            commitEdit(textField.getText());
                        }
                }
            });
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

    private void updateDatePicker(DatePicker datePicker, Assignment assign){
        datePicker.setValue(LocalDate.now());
        datePicker.setDisable(false);
        LocalDate assignDeadline = 
                new java.sql.Date(assign.getEnd().getTime()).toLocalDate();
        
        final Callback<DatePicker, DateCell> dayCellFactory = 
            (final DatePicker datePicker1) -> new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    
                    if (item.isBefore(LocalDate.now()) 
                                            || item.isAfter(assignDeadline)){
                        setDisable(true);
                        setStyle("-fx-background-color: #ffc0cb;");   
                    }
                }
            };
        datePicker.setDayCellFactory(dayCellFactory);
    }
    
}
