//package week3;
import java.util.*;
import java.math.*;

public class Student {
  private String name, gender, id;

  Student(){
      name   = "NULL";
      gender = "NULL";
      id     = "NULL";
  }

  void setName  (String name){
      this.name   = name;
  }
  void setGender(String gender){
      this.gender = gender;
  }
  void setId    (String id){
      this.id     = id;
  }
  String getName(){
      return this.name;
  }
  String getGender(){
      return this.gender;
  }
  String getId(){
      return this.id;
  }
  private void print(){
      System.out.println("Name: "   + this.getName() + "\n" +
                         "Gender: " + this.gender + "\n" +
                         "Id: "     + this.id);
  }
  public static void main(String [] args){
      Scanner in = new Scanner(System.in);
      Student[] student = new Student[3];
      String name, gender, id;

      {
          for(int i = 0;i < 3;i++) {
              student[i] = new Student();
              name       = in.next();
              gender     = in.next();
              id         = in.next();
              student[i].setName  (name);
              student[i].setGender(gender);
              student[i].setId    (id);
              student[i].print();
          }
      }

  }


}

