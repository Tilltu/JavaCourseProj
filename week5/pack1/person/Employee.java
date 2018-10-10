package pack1.person;
import  pack1.person.Person;

public class Employee extends Person{
    public String office;
    public String salary;
    public String employed_time;

    public Employee(){}
    public Employee(String name, String address,
                    String phone_num, String email,
                    String office, String salary,
                    String employed_time){
        super(name, address, phone_num, email);
        this.office        = office;
        this.salary        = salary;
        this.employed_time = employed_time;
    }

    @Override
    public String toString() {
        String res;
        res = (super.toString() + " Office: " + office +
               " Salary: " + salary + " Employed Time: " +
                employed_time);
        return res;
    }
}
