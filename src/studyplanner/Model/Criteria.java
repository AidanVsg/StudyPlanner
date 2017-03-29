package studyplanner.Model;

public class Criteria {

    private String name;             //Name of a criteria.
    private CriteriaType type;       //Type of a criteria.
    private boolean isMet;           //Whether criteria is met or not.
    private double value;            //Value of a criteria.
    private String unitOfMeasure;    //Unit of measure for the criteria.

    /**
     * Default constructor for an instance of Criteria.
     */
    public Criteria(){
        //TODO put checks in place for unexpected behaviour - make error message shown in GUI and program not terminate
        this.name = null;
        this.type = null;
        this.isMet = false;
        this.value = 0.0;
        this.unitOfMeasure= null;
    }

    /**
     * Update a task.
     */
    public void updateTask(){
        //TODO update the task that a criteria has been completed - note: could potentially move this to Task class
    }

    /*******************
     * GET/SET METHODS *
     *******************/

    /**
     * Get name of a criteria.
     * @return Criteria name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of a criteria.
     * @param name Name for a criteria.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get type of a criteria.
     * @return Criteria type.
     */
    public CriteriaType getType() {
        return type;
    }

    /**
     * Set type of a criteria.
     * @param type Type for a criteria.
     */
    public void setType(CriteriaType type) {
        this.type = type;
    }

    /**
     * Check if the criteria is met.
     * @return Whether the criteria is met or not.
     */
    public boolean isMet() {
        return isMet;
    }

    /**
     * Set the criteria to be met or unmet.
     * @param met Is the criteria met or not.
     */
    public void setMet(boolean met) {
        isMet = met;
    }

    /**
     * Get value of a criteria.
     * @return Criteria value.
     */
    public double getValue() {
        return value;
    }

    /**
     * Set value of a criteria.
     * @param value Value for a criteria.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Get unit of measure of a criteria.
     * @return Criteria unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Set unit of measure of a criteria.
     * @param unitOfMeasure Unit of measure for a criteria.
     */
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
