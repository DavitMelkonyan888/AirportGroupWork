package parsings.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "student")
public class XMLStudent {
    @XmlAttribute (name = "rollno")
    private int rollNo;
    
    private String firstname;
    private String lastname;
    private String nickname;
    private int marks;
    
    public XMLStudent () {
    }
    
    public XMLStudent (int rollNo, String firstname, String lastname, String nickname, int marks) {
        this.rollNo = rollNo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.marks = marks;
    }
    
    public int getRollNoValue () {
        return rollNo;
    }
    
    public void setRollNoValue (int rollNo) {
        this.rollNo = rollNo;
    }
    
    public String getFirstname () {
        return firstname;
    }
    
    public void setFirstname (String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname () {
        return lastname;
    }
    
    public void setLastname (String lastname) {
        this.lastname = lastname;
    }
    
    public String getNickname () {
        return nickname;
    }
    
    public void setNickname (String nickname) {
        this.nickname = nickname;
    }
    
    public int getMarks () {
        return marks;
    }
    
    public void setMarks (int marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString () {
        return "XMLStudent{" + "rollNo=" + rollNo + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", nickname='" + nickname + '\'' + ", marks=" + marks + '}';
    }
}
