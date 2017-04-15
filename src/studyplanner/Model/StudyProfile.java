package studyplanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;



public class StudyProfile implements Serializable{
    private String name;                                // name of the study prrofile
    private ArrayList<Module> modules;                  //List of all modules
    HashSet<StudyProfile> profiles;                     //HashSet to prevent
                                                        //inserting duplicate StudyProfile Objects
    private static final long serialVersionUID = 1L;
    /**
     * StudyProfile Constructor
     */
    public StudyProfile(){
        this.name = null;
        this.modules = new ArrayList<>();
        this.profiles = new HashSet<>();
    }
    
    /*******************
     * GET METHODS *
     *******************/

    /**
     * Get name of an StudyProfile method.
     * @return StudProfile name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get modules method.
     * @return ArrayList of modules.
     */
    public ArrayList getModules() {
        return modules;
    }
    
    /**
     * Get profiles.
     * @return set of profiles.
     */
    public HashSet<StudyProfile> getProfiles(){
        return profiles;
    }
    
    /**
     * Set the name of the study profile.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * add method to add study profile to profiles set
     * @param profiles
     */
    public void add(StudyProfile profiles) {
        this.profiles.add(profiles);
    }

}

