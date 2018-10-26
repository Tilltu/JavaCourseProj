package mystring.pack1;

import  java.text.ParseException;
import  java.util.Date;
import  java.text.SimpleDateFormat;

public class Student {
    private int    stu_Id;
    private String name;
    private String idNum;
    private Date   birth_date;
    private String password;
    private String sex;

    public Student(int stu_Id, String name, String idNum, String password, String sex) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        this.stu_Id     = stu_Id;
        this.name       = name;
        this.idNum      = idNum;
        this.birth_date = format.parse(idNum.substring(6, 14));
        this.password   = password;
        this.sex        =  sex;
    }
    public Student(){}

    public Date getBirth_date() {
        return birth_date;
    }

    public int getStu_Id() {
        return stu_Id;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString(){
        return ("Student Info: Name : " + name + ", Stuent ID : " + stu_Id + ", ID Number : " +
                idNum + ", Birth Date : " + birth_date + "\nSex : " + sex + ", Password : " + password);
    }

}
