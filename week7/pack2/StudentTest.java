package mystring.pack2;

import  mystring.pack1.*;

import java.text.ParseException;
import  java.util.*;

public class StudentTest {
    public static void checkStuId(String input)    throws IllegalInputException {
        IllegalInputException exception;
        String [] test    =  input.split("[0-9]");
        if(test.length  != 0) {
            exception = new IllegalInputException("Student ID Contains None Digit Character(s).");
            throw (exception);
        }
        int id = Integer.valueOf(input);

        if(id > 99999999 || id < 10000000) {
            exception = new IllegalInputException("Student ID More Than 8 bits.");
            throw (exception);
        }

    }
    public static void checkName(String input)     throws IllegalInputException {
        IllegalInputException exception = new IllegalInputException("Name Input Contains None Letter Character(s).");
        String[] test                   = input.split("[^a-zA-Z]");
        StringBuffer buffer             = new StringBuffer();
        int i;

        for(i = 0;i < test.length;i++) {
            buffer.append(test[i]);
        }

        String trim = input.replaceAll(" ", "");
        if(!buffer.toString().equals(trim)) {
            throw (exception);
        }
    }
    public static void checkIdNum(String input)    throws IllegalInputException {
        String[] test       = input.split("\\D");
        StringBuffer buffer = new StringBuffer();
        int i;
        IllegalInputException exception;

        if(input.length() < 18) {
            exception = new IllegalInputException("ID Number less than 18.");
            throw (exception);
        }

        for(i = 0;i < test.length;i++) {
            buffer.append(test[i]);
        }
        if(!buffer.toString().equals(input.trim())) {
            exception = new IllegalInputException("ID Number contains none digit character(s).");

            throw (exception);
        }

    }
    public static void checkPassword(String input) throws IllegalInputException {
        IllegalInputException exception;

        if(input.length() < 8) {
            exception = new IllegalInputException("Password Less Than 8 bits.");
            throw (exception);
        }
        String[] testOthers = input.split("[a-zA-Z0-9]");
        if(testOthers.length != 0) {                    //Check if contains illegal characters.
            exception = new IllegalInputException("Password contains illegal characters.");
            throw (exception);
        }

        String[] testUpper = input.split("[A-Z]");
        if(testUpper.length == 0) {                     //Only contains upper case letters.
            exception = new IllegalInputException("Password only contains upper case letters.");
            throw (exception);
        }
        String[] testLower = input.split("[a-z]");
        if(testLower.length == 0) {                    //Only contains lower case letters.
            exception = new IllegalInputException("Password only contains lower case letters.");
            throw (exception);
        }
        String[] testDigit = input.split("[0-9]");
        if(testDigit.length == 0) {                   //Only contains digits.
            exception = new IllegalInputException("Password only contains digits.");
            throw (exception);
        }

    }
    public static void checkSex(String input)      throws IllegalInputException {
        IllegalInputException exception = new IllegalInputException("Sex input is neither male nor female.");

        if(!(input.equals("male")) && !(input.equals("female"))) {
            throw (exception);
        }

    }


    public static void test() throws ParseException {
        int stu_Id           = 0;
        String stu_id_input;
        stu_id_input         = "";
        String name          = "";
        String idNum         = "";
        String password      = "";
        String sex           = "";
        LinkedList<Student> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        int i = 0;
        boolean flag = true;



        while(flag) {

            for(;i < 5;) {
                switch (i) {
                    case 0: {

                        try {
                            if (list.isEmpty()) {
                                System.out.println("Please Input Student ID That Is 8-bit-long.");
                                stu_id_input = in.next();
                                checkStuId(stu_id_input);
                                stu_Id = Integer.valueOf(stu_id_input);
                            } else {
                                System.out.println("No Need To Input Student ID. Please Go For The Next Section.");
                                stu_Id = list.get(list.size() - 1).getStu_Id() + 1;
                            }

                        } catch (IllegalInputException e) {
                            e.printMessage();
                            i = 0;
                            continue;
                        }

                        i++;
                        break;

                    }
                    case 1: {
                        try {
                            System.out.println("Please Input Name Without None Letter Characters. ");
                            System.out.println("[Exit] Input 00000000 If You Want To Exit And View The Table.");
                            name = in.next();
                            if (name.equals("00000000")) {
                                flag = false;
                                i = 9999; // to break 2 layers of loop
                                break;
                            }
                            checkName(name);

                        } catch (IllegalInputException e) {
                            e.printMessage();
                            i = 1;
                            continue;
                        }
                        i++;
                        break;

                    }

                    case 2: {
                        try {
                            System.out.println("Please Input 18-bit-long ID Numbers Consisting Of All Digits.");
                            idNum = in.next();
                            checkIdNum(idNum);

                        } catch (IllegalInputException e) {
                            e.printMessage();
                            i = 2;
                            continue;
                        }

                        i++;
                        break;
                    }

                    case 3: {
                        try {
                            System.out.println("Please Input Password With Both Upper And Lower Cases Of Letter And More Than 8 bits.");
                            password = in.next();
                            checkPassword(password);
                        } catch (IllegalInputException e) {
                            e.printMessage();
                            i = 3;
                            continue;
                        }
                        i++;
                        break;
                    }

                    case 4: {
                        try {
                            System.out.println("Please Input Sex Either male or female");
                            sex = in.next();
                            checkSex(sex);

                        } catch (IllegalInputException e) {
                            e.printMessage();
                            i = 4;
                            continue;
                        }

                        Student student = new Student(stu_Id, name, idNum, password, sex);
                        list.add(student);
                        i = 0;
                        break;
                    }
                }

            }
        }
        for (Student stu : list
        ) {
            System.out.println(stu);
        }
        in.close();
    }




    public static void main(String[] args) throws ParseException{
        test();
    }



}

