package studyplanner.Model;

import java.util.ArrayList;

public class Task extends Objective{
    protected String type;
    protected Criterion criteria;
    protected Activity activityHistory;
    protected ArrayList <Task> dependentOn;
    
    public Task(String type, Criterion criteria, Activity activityHistory,
                                                    ArrayList <Task> dependentOn){
        
        this.type = type;
        this.criteria = criteria;
        this.activityHistory = activityHistory;
        this.dependentOn = dependentOn;
        
    }
}
