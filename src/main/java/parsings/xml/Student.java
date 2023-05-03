package parsings.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "student")
public class Student {
    private int rollNo;
    private String firstname;
    private String lastname;
    private String nickname;
    private int marks;
    
    public Student () {
    }
    
    public Student (int rollNo, String firstname, String lastname, String nickname, int marks) {
        this.rollNo = rollNo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.marks = marks;
    }
    
    @XmlAttribute
    public int getRollNo () {
        return rollNo;
    }
    
    public void setRollNoValue (int rollNo) {
        this.rollNo = rollNo;
    }
    @XmlElement
    public String getFirstname () {
        return firstname;
    }
    
    public void setFirstname (String firstname) {
        this.firstname = firstname;
    }
    @XmlElement
    public String getLastname () {
        return lastname;
    }
    
    public void setLastname (String lastname) {
        this.lastname = lastname;
    }
    @XmlElement
    public String getNickname () {
        return nickname;
    }
    
    public void setNickname (String nickname) {
        this.nickname = nickname;
    }
    @XmlElement
    public int getMarks () {
        return marks;
    }
    
    public void setMarks (int marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString () {
        return "Student{" + "rollNo=" + rollNo + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", nickname='" + nickname + '\'' + ", marks=" + marks + '}';
    }
}
