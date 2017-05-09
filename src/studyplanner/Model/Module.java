package studyplanner.Model;
import java.util.HashSet;

public class Module {
    private String name;
    private String code;
    HashSet<Assignment> assignments;
    
    /**
     * 
     */
    public Module(){
        this.name = null;
        this.code = null;
        this.assignments = new HashSet<>();
    }
    
    /**
     * 
     * @param name
     * @param code 
     */
    public Module(String name, String code){
        this.name = null;
        this.code = null;
        this.assignments = new HashSet<>();
    }
    
    /*******************
     * GET/SET METHODS *
     *******************/
    
    /**
     * @return 
     */
    public String getName(){
        return name;
    }
    
    /** 
     * @return 
     */
    public String getCode(){
        return code;
    }
    
    /**
     * 
     * @return 
     */
    public HashSet getAssignments(){
        return assignments;
    }
    
    /**
     * @param name 
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * @param code 
     */
    public void setCode(String code){
        this.code = code;
    }
    
    /**
     * @param assignment An assignment to add.
     */
    public void add(Assignment assignment){
        this.assignments.add(assignment);
    }
            
}
