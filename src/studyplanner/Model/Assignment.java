package studyplanner.Model;

import java.util.ArrayList;

public class Assignment extends Objective {
    
    protected double weighting;
    protected ArrayList<Task> tasks;
    protected Milestone milestones;
    
    public Assignment(double weighting, ArrayList<Task> tasks, Milestone milestones){
        
        this.weighting = weighting;
        this.tasks = tasks;
        this.milestones = milestones;
    }
    
    public static Task addTask(String type,Criterion criteria, 
                        Activity activityHistory, ArrayList <Task> dependentOn){
        
        return new Task(type, criteria, activityHistory, dependentOn);
    }
    
}
