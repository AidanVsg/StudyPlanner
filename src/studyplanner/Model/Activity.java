package studyplanner.Model;

import java.util.ArrayList;

public class Activity {

    private String name;                        //Name of an activity.
    private String description;                 //Description of an activity.
    private Double value;                       //Value of an activity.
    private ArrayList<Criterion> criteria;      //List of all criteria of an activity.
    /**
     * Default constructor for an instance of Activity.
     */
    public Activity() {
        //TODO put checks in place for unexpected behaviour - make error message shown in GUI and program not terminate
        this.name = null;
        this.description = null;
        this.value = 0.0;
        this.criteria = new ArrayList<>();
    }

    /**
     * Update a criteria.
     */
    public void updateCriteria(Criterion c){

        c.setMet(true);
        //TODO check if the method has to do something besides setting boolean isMet
    }

    /*******************
     * GET/SET METHODS *
     *******************/

    /**
     * Get name of an activity.
     * @return Activity name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of an activity.
     * @param name Name for an activity.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of an activity.
     * @return  Activity description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of an activity.
     * @param description Description for an activity.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the value of an activity.
     * @return Activity value.
     */
    public Double getValue() {
        return value;
    }

    /**
     * Set the value of an activity.
     * @param value Value for an activity.
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Get a list of criteria of an activity.
     * @return List of activity criteria.
     */
    public ArrayList<Criterion> getCriteria() {
        return criteria;
    }

    /**
     * Add a criteria to an activity.
     * @param criteria Criterion to add for an activity.
     */
    public void add(Criterion criteria){
        this.criteria.add(criteria);
    }

    /**
     * Add an existing list of criteria to the activity.
     * @param criteria Existing list of criteria to add for an activity.
     */
    public void add(ArrayList<Criterion> criteria) {
        this.criteria = criteria;
    }
}
