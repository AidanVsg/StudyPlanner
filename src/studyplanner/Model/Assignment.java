package studyplanner.Model;

import java.util.ArrayList;
import java.util.Date;

public class Assignment extends Objective {
    
    private double weighting;
    private ArrayList<Task> tasks;
    private ArrayList<Milestone> milestones;
    
    public Assignment(double weighting,String name, String description,Date start, Date end){
        
        super(name, description, start, end);
        this.weighting = weighting;
    }
    
    public void addTask(String type, ArrayList<Criterion> criteria, 
            ArrayList<Activity> activityHistory, ArrayList <Task> dependentOn,
                            String name, String description,Date start, Date end){
        
        tasks.add(new Task(type, criteria, activityHistory, dependentOn, name, description, start, end));
    }
    
    public void addMilestone(ArrayList<Task> tasks, String name, String description,
                    Date start, Date end){
        milestones.add(new Milestone(tasks,name,description,start,end));
    }
    
    /*******************
     * GET/SET METHODS *
     *******************/
    
    /**
     * @return 
     */
    public double getWeighting() {
        return weighting;
    }

    /**
     * @param weighting 
     */
    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    /**
     * @return 
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * @param tasks 
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return 
     */
    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }

    /**
     * 
     * @param milestones 
     */
    public void setMilestones(ArrayList<Milestone> milestones) {
        this.milestones = milestones;
    }
    
}
