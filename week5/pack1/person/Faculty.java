package pack1.person;
import  pack1.person.Employee;

public class Faculty extends Employee{
    String office_hour;
    String level;

    public Faculty(){}
    public Faculty(String name, String address,
            String phone_num, String email,
            String office, String salary,
            String employed_time, String office_hour,
            String level){
        super(name, address, phone_num, email, office,
              salary, employed_time);
        this.office_hour = office_hour;
        this.level       = level;
    }

    @Override
    public String toString() {
        String res;
        res = (super.toString() + "Office Hour: " + office_hour +
               " Level: " + level);
        return res;
    }
}
