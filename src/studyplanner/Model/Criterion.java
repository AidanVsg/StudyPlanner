package studyplanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import studyplanner.Model.CriterionType;
/**
 * Class to model a Criterion of the Study Planner.
 * @author Kiril
 */
public class Criterion implements Serializable{
    private static final long serialVersionUID = 4L;
    private String name;             //Name of a criteria.
    private CriterionType type;       //Type of a criteria.
    private boolean isMet;           //Whether criteria is met or not.
    private double value;            //Value of a criteria.
    private String unitOfMeasure;    //Unit of measure for the value.

//    /**
//     * Default constructor for an instance of Criterion.
//     */
//    public Criterion(){
//        //TODO put checks in place for unexpected behaviour - make error message shown in GUI and program not terminate
//        this.name = "";
//        this.type = CriterionType.Boolean;
//        this.isMet = false;
//        this.value = 0.0;
//        this.unitOfMeasure= "";
//    }
//    
    /**
     * Overloaded constructor for a criterion with type Value
     * @param name Name of a criteria.
     * @param value Value of a criteria.
     * @param uom Unit of measure for the value.
     */
    public Criterion(String name, double value, String uom){
        this.name = name;
        this.unitOfMeasure = uom;
        this.value = value;                   
        this.type = CriterionType.Value;
        this.isMet = false; //The criterion will not be met when initialised.

    }
    
        /**
     * Overloaded constructor for a criterion with type Boolean.
     * @param name Name of a criteria.
     */
    public Criterion(String name){  
        this.name = name;
        this.type = CriterionType.Boolean;
        this.isMet = false; //The criterion will not be met when initialised.

    }

    /**
     * @param t Task to update.
     */
    public void updateTask(Task t){
        //TODO update the task that a criteria has been completed - note: could potentially move this to Task class
        ArrayList<Criterion> criteria = t.getCriteria();
        
        
        for (Criterion c:
             criteria) {
            if(c.equals(this)){
                if(c.getType().equals(CriterionType.Value)){ //TODO CHANGE LOGIC HERE
                    c.setValue(c.getValue() - this.value);
                    if(c.getValue()<= 0.0)
                        c.setMet(true);
                }
                else{
                    c.setMet(this.isMet);
                }                
            }
            t.setIsDone(c.isMet());
           
        }
        
        if(t.isDone()) t.setName(t.getName() + " ✓");
    }

    /*******************
     * GET/SET METHODS *
     *******************/

    /**
     *@return Criterion name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Name for a criterion.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Criterion type.
     */
    public CriterionType getType() {
        return type;
    }

    /**
     * @param type Type for a criterion.
     */
    public void setType(CriterionType type) {
        if(this.getValue()>0 && type.equals(CriterionType.Boolean)){
            System.out.println("Can't set Criterion with value>0 to Boolean");
        }else if(this.getValue()==0 && type.equals(CriterionType.Value)){       //TODO MAKE NEW EXCEPTION FOR THIS STUFF 
            System.out.println("Cant set Criterion with value=0 to Value");
        }else{
            this.type = type;
        }  
    }

    /**
     * @return Whether the criterion is met or not.
     */
    public boolean isMet() {
        return isMet;
    }

    /**
     * @param met Is the criterion met or not.
     */
    public void setMet(boolean met) {
        isMet = met;
    }

    /**
     * @return Criterion value.
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value Value for a criterion.
     */
    public void setValue(double value) {
        if(value>0){
            this.setType(CriterionType.Value);
        }else{
            this.setType(CriterionType.Boolean); //EXCEPTIONS NEEDED HERE AS WELL
        }
        this.value = value;
    }

    /**
     * @return Criterion unit of measure.
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * @param unitOfMeasure Unit of measure for a criterion.
     */
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
    
        @Override
     public String toString(){
         return this.getName();
    }
}
