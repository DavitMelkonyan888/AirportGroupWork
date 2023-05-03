package parsings.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    
    public static void main (String[] args) throws JAXBException {
        File         file             = new File("src/main/resources/parsing_data/students.xml");
        JAXBContext  jaxbContext      = JAXBContext.newInstance(StudentList.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StudentList  studentList      = (StudentList) jaxbUnmarshaller.unmarshal(file);
        for (Student i : studentList.getStudents()) {
            System.out.println(i);
        }
    }
}
