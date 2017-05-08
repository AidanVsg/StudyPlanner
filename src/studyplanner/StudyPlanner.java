package studyplanner;

import studyplanner.Model.StudyProfile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class StudyPlanner extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StudyPlanner.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Based StudyPlanner");
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
