package pack1.person;

public abstract class Person {
    public String name;
    public String address;
    public String phone_num;
    public String email;

    public Person(){}
    public Person(String name, String address,
                  String phone_num, String email){
        this.name      = name;
        this.address   = address;
        this.phone_num = phone_num;
        this.email     = email;
    }
    public String toString() {
        String res = ("Name: " + name + " Address: " + address +
                      " Phone Number: " + phone_num +
                       " Email: " + email);
        return res;
    }
}
