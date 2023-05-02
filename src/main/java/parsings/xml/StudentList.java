package parsings.xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "class")
public class StudentList {
    private List <XMLStudent> students;
    
    public List<XMLStudent> getStudents() {
        return students;
    }
    
    public void setStudents(List<XMLStudent> students) {
        this.students = students;
    }
    
    public StudentList () {
    }
    
    public StudentList (List <XMLStudent> students) {
        this.students = students;
    }
}
