package parsings.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    
    public static void main (String[] args) throws JAXBException {
        File         file             = new File("C:\\Users\\Davit\\IdeaProjects\\xmljson\\src\\main\\resources\\students.xml");
        JAXBContext  jaxbContext      = JAXBContext.newInstance(StudentList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StudentList  studentList      = (StudentList) jaxbUnmarshaller.unmarshal(file);
        for(XMLStudent i: studentList.getStudents()){
            System.out.println(i.toString());
        }
    }
    
}
