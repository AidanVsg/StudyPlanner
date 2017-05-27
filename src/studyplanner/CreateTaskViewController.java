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
public class CreateTaskViewController implements Initializable {
    private StudyProfile profile;
    
    @FXML ComboBox<Module> moduleComboBox; //module selection box
    @FXML ComboBox<Assignment> assignmentComboBox; //assignment selection box
        
    @FXML DatePicker taskDatePicker; //task deadline date picker
    
    @FXML TextField nameTextField; //task name input field
    @FXML TextField typeTextField; //task type input field
    
    @FXML ListView dependencyListView; //list of tasks this tasks depends on
    
    @FXML TextArea descriptionTextArea; //description of the task
    
    @FXML TableView criteriaTableView; //list of criteria to meet this task
        @FXML TableColumn criterionName;
        @FXML TableColumn criterionValue;
        @FXML TableColumn criterionUOM;
    
    @FXML Button cancelButton, createTaskButton, addCriterionButton; 
            //closes window    //creates a new task     //adds an empty criterion
    
    @FXML AnchorPane createTaskWindow; //shortcut fields to ease acess
    private Stage stage;               //to this controller's view's stage
    
    private StudyProfileViewController mainController;
                                       //controller to pass task data to
    
    /**
     * Closes task creation window
     */
    @FXML private void cancelButtonClick(){
        stage.hide();
    }
    /**
     * adds an editable criterion to criteria
     */
    @FXML private void addCriterionButtonClick(){
        criteriaTableView.getItems().add(new Criterion());
    }
    /**
     * checks for correctness of inputs and creates a new task in
     * selected assignment
     */
    @FXML private void createTaskButtonClick(){
        //NOTE: OPTIONAL FIELDS ARE: Description, dependencies.
        //selects assignment to add the task to
        Assignment assignment = assignmentComboBox.getValue();
        //>>>>ADD CHECKS AND PROPER READING OF INPUT FIELDS.
        Task task = new Task();
        task.setName(nameTextField.getText());
        task.setType(typeTextField.getText());
        task.setDescription(descriptionTextArea.getText());
        task.setStart(new Date());
        task.setEnd(java.sql.Date.valueOf(taskDatePicker.getValue()));
           
        assignment.addTask(task); //

        stage.hide();
    }
    
    public void initData(StudyProfile profile, 
                StudyProfileViewController mainController){
        
        this.mainController = mainController;
        stage = (Stage) createTaskWindow.getScene().getWindow();
        
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
        taskDatePicker.setValue(LocalDate.now());    
         
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
                    if(cur!=null){
                        updateDatePicker(taskDatePicker, cur);
                    }
                }
            });
        
        Callback<TableColumn, TableCell> cellFactory =
             (TableColumn p) -> new EditingCell(); 
        
         criterionName.setEditable(true);
         criterionName.setCellFactory(cellFactory);
        criterionName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        criterionName.setCellFactory(TextFieldTableCell.forTableColumn());
        criterionValue.setEditable(true);
        criterionValue.setCellValueFactory(
                new PropertyValueFactory<Criterion, String>("value"));
        criterionUOM.setCellValueFactory(
                new PropertyValueFactory<Criterion, String>("unitOfMeasure"));
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
