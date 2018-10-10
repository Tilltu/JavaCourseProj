package pack1.person;
import  pack1.person.Employee;

public class Staff extends Employee{
    String title;

    public Staff(){}
    public Staff(String name, String address,
                 String phone_num, String email,
                 String office, String salary,
                 String employed_time, String title) {
        super(name, address, phone_num, email, office, salary,
              employed_time);
        this.title = title;
    }

    @Override
    public String toString() {
        String res;
        res = (super.toString() + " Title: " + title);
        return res;
    }
}
