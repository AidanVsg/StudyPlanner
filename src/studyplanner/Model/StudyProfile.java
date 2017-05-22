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
    static private ArrayList<Module> modules = new ArrayList<>();           //List of all modules 
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

    public static void main(String argv[]) {

    try {

	File fXmlFile = new File("HubFile.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("Module");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {
                Module module = new Module();
		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			String mname = eElement.getElementsByTagName("name").item(0).getTextContent();//module name
			String code = eElement.getElementsByTagName("code").item(0).getTextContent();
                        
                        module.setName(mname);
                        module.setCode(code);

                        modules.add(module);
		}
		NodeList assignmentList = doc.getElementsByTagName("Assignment");
		
		for (int temp1 = 0; temp1 < assignmentList.getLength(); temp1++) {

			Node n1Node = assignmentList.item(temp1);

			System.out.println("\nCurrent Element :" + n1Node.getNodeName());

			if (n1Node.getNodeType() == Node.ELEMENT_NODE) {

				Element e1Element = (Element) n1Node;
				
				String name2 = e1Element.getElementsByTagName("name").item(0).getTextContent();
                                double weighting = Double.parseDouble(e1Element.getElementsByTagName("weighting").item(0).getTextContent());
                                Date start = new Date();
                                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                try {
                                    start = df.parse(e1Element.getElementsByTagName("start").item(0).getTextContent());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                Date end  = new Date();
                                try {
                                    end = df.parse(e1Element.getElementsByTagName("end").item(0).getTextContent());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
				String description = e1Element.getElementsByTagName("Description").item(0).getTextContent();
                                
                                Assignment assignment = new Assignment(weighting,name2,description,start,end);
                                module.getAssignments().add(assignment);
			}
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
}

