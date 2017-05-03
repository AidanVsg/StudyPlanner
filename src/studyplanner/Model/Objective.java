package studyplanner.Model;

import java.util.Date;

public class Objective {
    
    private String name;                //name of this Objective
    private String description;         //description of this objective
    private Date start;                 //start date of this Objective
    private Date end;                   //end date of this Objective
    private boolean isDone;             //flag to check if this Objective
                                        //is met
    
    /**
     * Default constructor for Objective
     */
    public Objective(){
        this.name = null;
        this.description = null;
        this.start = new Date(); //sets the start date at time of object 
                                 //creation
        this.end = null;
        this.isDone = false;    //Objective is not met by default
    }
    /**
     * Get name of this Objective
     * @return - name of this Objective
     */
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get description of this Objective
     * @return - description of this Objective
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Get start date of this Objective
     * @return - start date of this Objective
     */
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
    /**
     * Get end date of this Objective
     * @return - end date of this Objective
     */
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
    /**
     * Check if this Objective is done
     * @return - true if Objective is done, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    /**
     * Checks if all criteria is met for Objective. Since Objective
     * has no criteria, isDone can only be set to true manually.
     * If this Objective is done, then end date is set at the moment
     * this method was called.
     */
    public void update(){
        if(this.isDone()){
            this.end = new Date();
        }
    }
    
}
