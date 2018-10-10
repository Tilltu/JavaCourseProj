package pack2;
import  pack1.person.*;
import  java.util.*;

public class TestPerson {
    public static void main(String[] args) {
        String[] name      = new String[4];
        String[] address   = new String[4];
        String[] phone_num = new String[4];
        String[] email     = new String[4];
        String   office;
        String   salary;
        String   employed_time;
        String   office_hour;
        String   level;
        String   title;
        int      index;

        int i;
        Scanner src = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<Person>();

        for(i = 0;i < 4;i++) {
            name[i]      = src.next();
            address[i]   = src.next();
            phone_num[i] = src.next();
            email[i]     = src.next();
            switch (i) {
                case 0 : {
                   index = src.nextInt();
                   Student student = new Student(name[i], address[i], phone_num[i],
                                                  email[i], index);
                   people.add(student);
                   System.out.println("Student: \n" + people.get(i).toString());
                   break;
                }
                case 1 : {
                   office        = src.next();
                   salary        = src.next();
                   employed_time = src.next();
                   Employee employee = new Employee(name[i], address[i], phone_num[i],
                                                    email[i], office, salary, employed_time);
                   people.add(employee);
                   System.out.println("Employee: \n" + people.get(i).toString());
                   break;
                }
                case 2 : {
                   office        = src.next();
                   salary        = src.next();
                   employed_time = src.next();
                   office_hour = src.next();
                   level       = src.next();
                   Faculty faculty = new Faculty(name[i], address[i], phone_num[i],
                                                 email[i], office, salary, employed_time,
                                                 office_hour, level);
                   people.add(faculty);
                   System.out.println("Faculty: \n" + people.get(i).toString());
                   break;
                }
                case 3 : {
                   office        = src.next();
                   salary        = src.next();
                   employed_time = src.next();
                   title = src.next();
                   Staff staff = new Staff(name[i], address[i], phone_num[i],
                                           email[i], office, salary, employed_time,
                                           title);
                   people.add(staff);
                   System.out.println("Staff: \n" + people.get(i).toString());
                   break;
                }
                default: {
                   break;
                }
            }
        }
    }
}
