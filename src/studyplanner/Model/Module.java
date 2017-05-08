package studyplanner.Model;
import java.util.HashSet;

public class Module {
    private String name;
    private String code;
    HashSet<Assignment> assignments;
    
    // Module constructor
    public Module(){
        this.name = null;
        this.code = null;
        this.assignments = new HashSet<>();
    }
    public Module(String name, String code){
        this.name = null;
        this.code = null;
        this.assignments = new HashSet<>();
    }
    
    //get methods
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public HashSet getAssignments(){
        return assignments;
    }
    
    //Set methods
    public void setName(String name){
        this.name = name;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    //add method to add assignments to assignment hashSet
    public void add(Assignment assignment){
        this.assignments.add(assignment);
    }
            
}
