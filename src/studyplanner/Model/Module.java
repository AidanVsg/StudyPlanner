package studyplanner.Model;
import java.util.HashSet;

public class Module {
    private String name;
    private String code;
    HashSet<Assignment> assignment = new HashSet<>();
    
    // Module constructor
    public Module(){
        this.name = null;
        this.code = null;
        this.assignment = new HashSet<>();
    }
    
    //get methods
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public HashSet getAssignment(){
        return assignment;
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
        this.assignment.add(assignment);
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
