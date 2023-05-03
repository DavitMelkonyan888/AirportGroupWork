package parsings.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "class")
public class StudentList {
    private List <Student> students;
    
    @XmlElement (name = "student")
    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public StudentList () {
    }
    
    public StudentList (List <Student> students) {
        this.students = students;
    }
}
