package pack1.person;
import  pack1.person.Person;

public class Student extends Person{
    private final String[] grade = {"Freshman", "Sophomore",
                            "Junior", "Senior"};
    String status;


    public Student(){}
    public Student(String name, String address,
                   String phone_num, String email, int index) {
        super(name, address, phone_num, email);
        status = grade[index];
    }
    public String toString() {
        String res;
        res = (super.toString() + " Status: " + this.status);
        return res;
    }

}
