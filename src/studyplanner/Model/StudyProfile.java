package studyplanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
//XML imports below
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Class to model the Study Profile of the Planner.
 * @author Moaz
 */
public class StudyProfile implements Serializable{
    private static final long serialVersionUID = 1L;    //Serialisation ID
    private String name;                                //Name of the study prrofile
    //TODO remove static
    private ArrayList<Module> modules;          //List of all modules 
    //TODO discuss moving set of profiles to another class
    HashSet<StudyProfile> profiles;                     //HashSet to prevent
                                                        //inserting duplicate 
                                                        //StudyProfile Objects
    /**
     * Default constructor for an instance of Study Profile.
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
     * @return Name of the Study Profile.
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return List of all modules.
     */
    public ArrayList<Module> getModules() {
        return modules;
    }
    
    /**
     * @return A set of profiles.
     */
    public HashSet<StudyProfile> getProfiles(){
        return profiles;
    }
    
    /**
     * @param name Name for a Study Profile.
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

    @Override
    public String toString(){
        return this.name;
    }

    /**
     * method to initialise a study profile by reading a HUB file
     * @param profile   the profile to be initialised
     * @param file      the hub file to get the profile information from
     */
    public static void InitialiseStudyProfile(StudyProfile profile, File file){
        try{
            File xmlFile = file;
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Module");//returns list of modules
            
            // for each module it reads the name, code and the assignment details associated to the module
            for (int i = 0; i < nList.getLength(); i++) {
                Module module = new Module();
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String mname = eElement.getAttribute("mname");//gets module name
                    String code = eElement.getAttribute("code");//gets module code

                    module.setName(mname);
                    module.setCode(code);

                    profile.getModules().add(module);//adding the new module to the semester profile modules list
                }

                NodeList assignmentList = nNode.getChildNodes();//gets the assignments associated to the module
                
                /*
                for each assignment associated to the module it gets the name,
                weighting,start and end date and the description
                */
                for (int j = 0; j < assignmentList.getLength(); j++) {
                    Node n1Node = assignmentList.item(j);
                    if (n1Node.getNodeType() == Node.ELEMENT_NODE) {

                        Element e1Element = (Element) n1Node;

                        String name2 = e1Element.getElementsByTagName("name").item(0).getTextContent();//gets assignment name
                        double weighting = Double.parseDouble(e1Element.getElementsByTagName("weighting").item(0).getTextContent());//gets assignment wighting
                        Date start = new Date();
                        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            start = df.parse(e1Element.getElementsByTagName("start").item(0).getTextContent());//gets start date
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date end  = new Date();
                        try {
                            end = df.parse(e1Element.getElementsByTagName("end").item(0).getTextContent());//gets end date
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String description = e1Element.getElementsByTagName("Description").item(0).getTextContent();//gets assignment description

                        Assignment assignment = new Assignment(weighting,name2,description,start,end);
                        module.getAssignments().add(assignment);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String argv[]) {
        StudyProfile profile = new StudyProfile();
        File hubFile = new File("HubFile.xml");
        
        InitialiseStudyProfile(profile, hubFile);
        for(Module module : profile.getModules()){
            System.out.println(module);
            for(Assignment assignment : module.getAssignments()){
                System.out.println("\t"+assignment);
            }
        }
        
    }
    
}
