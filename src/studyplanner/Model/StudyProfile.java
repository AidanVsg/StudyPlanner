package studyplanner.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

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



public class StudyProfile implements Serializable{
    private String name;                                // name of the study prrofile
    static private ArrayList<Module> modules;                  //List of all modules
    //todo remove static
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
			
			String mname = eElement.getElementsByTagName("mname").item(0).getTextContent();//module name
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
				
				String name2 = e1Element.getElementsByTagName("aname").item(0).getTextContent();
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

