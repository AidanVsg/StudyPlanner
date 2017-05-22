package studyplanner.Model;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class to model an Objective of the Study Planner.
 * @author Michail
 */
public class Assignment extends Objective { 
    private double weighting;                   //Percentage of the assignment's worth.
    private ArrayList<Task> tasks;              //List of tasks.
    private ArrayList<Milestone> milestones;    //List of milestones.
    
    /**
     * Constructor with additional parameters.
     * @param weighting How much % does the assignment weight.
     * @param name Name of the task.
     * @param description Description of the task.
     * @param start Beginning date of the task.
     * @param end Deadline of the task.
     */
    public Assignment(double weighting,String name, String description,
                        Date start, Date end){
        
        super(name, description, start, end);
        this.weighting = weighting;
        this.tasks = new ArrayList<>();
        this.milestones = new ArrayList<>();
    }
    
    /**
     * Add a task to an assignment.
     */
    public void addTask(Task task){
        tasks.add(task);
    }
    
    /**
     * Add a milestone to an assignment.
     * @param tasks Certain tasks need to be done for the milestone.
     * @param name Name of the milestone.
     * @param description Description of the milestone.
     * @param start Beginning date of the milestone.
     * @param end Deadline of the milestone.
     */
    public void addMilestone(ArrayList<Task> tasks, String name, String description,
                    Date start, Date end){
        milestones.add(new Milestone(tasks,name,description,start,end));
    }
    
    /*******************
     * GET/SET METHODS *
     *******************/
    
    /**
     * @return Weighting of the assignment.
     */
    public double getWeighting() {
        return weighting;
    }

    /**
     * @param weighting  How much % does the assignment weight.
     */
    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    /**
     * @return List of assignment's tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * @param tasks List of tasks for an assignment.
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return List of assignment's milestones.
     */
    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }

    /**
     * @param milestones List of milestones for an assignment.
     */
    public void setMilestones(ArrayList<Milestone> milestones) {
        this.milestones = milestones;
    }
    
}
