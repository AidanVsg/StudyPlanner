package studyplanner;

import studyplanner.Model.StudyProfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import studyplanner.Controller.CreateStudyProfileControl;
import studyplanner.Controller.StudyPlannerControl;



public class StudyPlanner extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        StudyProfile profile = new StudyProfile();
        
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "StudyPlanner.fxml"
                )
        );
        
        stage.setScene(
            new Scene(
                (Pane) loader.load()
            )
        );
        stage.setTitle("WILL IT BLEND");
        
        StudyPlannerControl controller = 
                loader.<StudyPlannerControl>getController();
        controller.initData(profile);
        
        stage.show();
    }

    public static void main(String[] args) {
//        StudyProfile sp = new StudyProfile();
//
//
//        //GanttChartView chart = new GanttChartView();
//        try{
//            writeObject(sp);
//        }
//        catch (IOException ex){
//
//        }
          launch(args);
      
    }
    public static void writeObject(Object obj) throws IOException{
        FileOutputStream fos = new FileOutputStream("spfile.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
    }



}
