package studyplanner.Model;

import java.util.ArrayList;

public class Task extends Objective{
    private String type;
    private ArrayList<Criterion> criteria;
    private ArrayList<Activity> activityHistory;
    private ArrayList<Task> dependentOn;
    
   
    public Task(String type, ArrayList<Criterion> criteria, 
            ArrayList<Activity> activityHistory, ArrayList <Task> dependentOn){
        
        this.type = type;
        this.criteria = criteria;
        this.activityHistory = activityHistory;
        this.dependentOn = dependentOn;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }

    public ArrayList<Activity> getActivityHistory() {
        return activityHistory;
    }

    public void setActivityHistory(ArrayList<Activity> activityHistory) {
        this.activityHistory = activityHistory;
    }

    public ArrayList<Task> getDependentOn() {
        return dependentOn;
    }
}
