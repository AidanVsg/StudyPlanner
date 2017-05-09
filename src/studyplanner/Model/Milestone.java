package studyplanner.Model;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class to model a Milestone of the Study Planner.
 * @author Michail
 */
public class Milestone extends Objective{  
    private ArrayList<Task> tasks;          //Tasks that need to be done
                                            //for this Milestone to be done.
    /**
     * Default constructor for this Milestone.
     */
    public Milestone(){
        super();
        this.tasks = new ArrayList();
    }
    /**
     * Overloaded constructor with additional parameters.
     * @param tasks Tasks of the milestone.
     * @param name Name of the milestone.
     * @param description Description of the milestone.
     * @param start Start date of the milestone.
     * @param end End date of the milestone.
     */
    public Milestone(ArrayList<Task> tasks, String name, String description,
                    Date start, Date end){
        super(name, description, start, end);
        this.tasks = new ArrayList();
    }

    /*******************
     * GET/SET METHODS *
     *******************/
    
    /**
     * @return A list of current tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /** 
     * @param tasks A list of tasks
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
    
    /** 
     * @param task The task to be added.
     * @return The added task.
     */
    public boolean addTask(Task task){
        return this.tasks.add(task);
    }
    
    /** 
     * @param task The task to be removed.
     * @return The removed task.
     */
    public boolean removeTask(Task task){
        return this.tasks.remove(task);
    }
    
    /**
     * Checks if all tasks are met in this Milestone.
     * If they are, then isDone is set to true and end date is
     * set as current date.
     * Otherwise, method terminates.
     */
    @Override
    public void update(){
        for(Task task:tasks){
            if(!task.isDone())
                return;
        }
        this.setIsDone(true);
        this.setEnd(new Date());
    }
    //testing Milestone
//    public static void main(String[] args){
//        
//        Milestone ms1 = new Milestone();
//        Task ts1 = new Task();
//        Task ts2 = new Task();
//        
//        ms1.addTask(ts1);
//        ms1.addTask(ts2);
//        
//        System.out.println(ms1.isDone());
//        System.out.println("Now updating with added tasks");
//        ms1.update();
//        System.out.println(ms1.isDone());
//        System.out.println("Now updating ts2 to done");
//        ts2.setIsDone(true);
//        ms1.update();
//        System.out.println(ms1.isDone());
//        System.out.println("Now updating ts1 to done");
//        ts1.setIsDone(true);
//        ms1.update();
//        System.out.println(ms1.isDone());
//    }
}
