package pack2;

import  pack1.Student;
import  java.util.*;

public class Grade {
    public static void printStudentNames(Student student[], int sum){
        for(int i = 0;i < sum;i++){
            System.out.println(student[i].getName());
        }
    }
    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       String  name;
       Student student[] = new Student[3];
       for(int i = 0;i < 3;i++){
           student[i] = new Student();
       }

       student[0].setName("张三");
       student[1].setName("李四");
       student[2].setName("王五");

       printStudentNames(student,3);
   }
}

