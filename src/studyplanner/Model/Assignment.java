package studyplanner.Model;

import java.util.ArrayList;

public class Assignment extends Objective {
    
    private double weighting;
    private ArrayList<Task> tasks;
    private ArrayList<Milestone> milestones;
    
    public Assignment(double weighting, ArrayList<Task> tasks, ArrayList<Milestone> milestones){
        
        this.weighting = weighting;
        this.tasks = tasks;
        this.milestones = milestones;
    }
    
    public static Task addTask(String type,ArrayList<Criterion> criteria,
                        ArrayList<Activity> activityHistory, ArrayList <Task> dependentOn){
        
        return new Task(type, criteria, activityHistory, dependentOn);
    }
    
}
