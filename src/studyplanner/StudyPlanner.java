package studyplanner;

import studyplanner.Model.StudyProfile;
import studyplanner.View.GanttChartView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class StudyPlanner {

    public static void main(String[] args) {
        StudyProfile sp = new StudyProfile();


        GanttChartView chart = new GanttChartView();
        try{
            writeObject(sp);
        }
        catch (IOException ex){

        }

    }
    public static void writeObject(Object obj) throws IOException{
        FileOutputStream fos = new FileOutputStream("spfile.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
    }



}
