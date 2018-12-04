package mynet.server;


import  java.io.*;
import  java.net.*;
import  java.util.ArrayList;
import  javax.swing.*;

import  mynet.utils.Account;

public class AccountServer implements Runnable{

    static int                port = 6000;
    static DataInputStream    in;
    static DataOutputStream   out;
    static ServerSocket       server;
    static Socket             request;
    static ArrayList<Account> list = new ArrayList<>();
    static String             pack;
    static String             msg;

    public void run () {
        try {
            server = new ServerSocket(port);


            while (true) {
                try {
                    request = server.accept();
                    in = new DataInputStream(request.getInputStream());
                    out = new DataOutputStream(request.getOutputStream());
                    pack = in.readUTF();
                } catch (Exception e) {

                }

                String[] arg = pack.split(",");
                String order = arg[0];

                switch (order) {
                    case "insert": {
                        try {
                            insert(arg);
                            //System.out.println(list.get(0));
                            //out.writeUTF("[ Register Success! ]");
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            //out.writeUTF("[ Register Fail! ]");
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    case "query": {
                        try {
                            query(arg);
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    case "change": {
                        try {
                            change(arg);
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    case "deposit": {
                        try {
                            deposit(arg);
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    case "withdraw": {
                        try {
                            withdraw(arg);
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    case "transfer": {
                        try {
                            transfer(arg);
                            out.writeUTF(msg);
                            request.close();
                        } catch (Exception e) {
                            out.writeUTF("[ Server Error. Operation Failed!]");
                            request.close();
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    static boolean insert(String[] arg) {
        String[] query_arg = new String[]{"query", arg[1]};
        if(query(query_arg)) {
            System.out.println("[ Insert Failure : Account Exist! ]");
            try {
                //out.writeUTF("[ Insert Failure : Account Exist! ]");
                msg = "[ Insert Failure : Account Exist! ]";
            } catch (Exception e) {

            }
            return false;
        } else {
            Account account = new Account(Integer.valueOf(arg[1]), arg[2], arg[3], Double.valueOf(arg[4]), arg[5], arg[6]);
            list.add(account);
            try {
                System.out.println("[ Insert Success ]");
                msg = "[ Insert Success ]";
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    static boolean query(String[] arg) {
        int i;
        int size = list.size();
        int accounts_number = Integer.valueOf(arg[1]);

        for (i = 0;i < size;i++) {
            if (list.get(i).account_num == accounts_number) {
                try {
                    System.out.println("[ Account Found! ]\n [ " + list.get(i).account_num + "   " +
                                       list.get(i).name + " ]");
                    //System.out.println(list.get(i));
                    msg = ("[ Account Found! ]\n [ Account Number: " + list.get(i).account_num + "  Name: " +
                            list.get(i).name + " ]");
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        }
        System.out.println("[ Account Don't Exist! ]");
        msg = "[ Account Don't Exist! ]";
        return false;
    }
    static boolean change(String[] arg) {
        int i;
        int size = list.size();
        int accounts_number = Integer.valueOf(arg[1]);
        String pwd = arg[2];
        String changed_pwd = arg[3];

        for (i = 0; i < size; i++) {
                if (list.get(i).account_num == accounts_number) {
                    try {
                        if (list.get(i).password.equals(pwd)) {
                            list.get(i).password = changed_pwd;
                            //out.writeUTF("[ Password Changed Success ]");
                            System.out.println("[ Password Changed Success ]");
                            msg = "[ Password Changed Success ]";
                            return true;
                        } else {
                            //out.writeUTF("[ Fail ! Wrong Password ]");
                            System.out.println("[ Fail ! Wrong Password ]");
                            msg = "[ Fail ! Wrong Password ]";
                            return false;
                        }
                    } catch (Exception e) {

                    }
                    break;
                }
        }

        System.out.println("[ Account Don't Exist ]");
        msg = "[ Account Don't Exist ]";
        return false;

    }
    static boolean deposit(String[] arg) {
        int i;
        int size = list.size();

        int accounts_number = Integer.valueOf(arg[1]);
        String pwd = arg[2];
        double deposit = Double.valueOf(arg[3]);

        for (i = 0;i < size;i++) {
            if (list.get(i).account_num == accounts_number) {
                try {
                    if (list.get(i).password.equals(pwd)) {
                        list.get(i).balance += deposit;
                        //out.writeUTF("[ Money Deposit Success ]");
                        System.out.println("[ Money Deposit Success ]\n[ Remaining Balance : " + list.get(i).balance + "]");
                        msg = ("[ Money Deposit Success ]\n[ Remaining Balance : " + list.get(i).balance + "]");
                        return true;
                    } else {
                        //out.writeUTF("[ Fail ! Wrong Password ]");
                        System.out.println("[ Fail ! Wrong Password ]");
                        msg = "[ Fail ! Wrong Password ]";
                        return false;
                    }

                } catch (Exception e) {
                    return false;
                }
            }
        }
        System.out.println("[ Fail ! Account Not Found! ]");
        msg = "[ Fail ! Account Not Found! ]";
        return false;
    }
    static boolean withdraw(String[] arg) {
        int i;
        int size = list.size();

        int accounts_number = Integer.valueOf(arg[1]);
        String pwd = arg[2];
        double withdraw = Double.valueOf(arg[3]);

        for (i = 0;i < size;i++) {
            if (list.get(i).account_num == accounts_number) {
                try {
                    if (list.get(i).password.equals(pwd)) {
                        if (list.get(i).balance - withdraw >= 0) {
                            list.get(i).balance -= withdraw;
                            //out.writeUTF("[ Money Deposit Success ]");
                            System.out.println("[ Money Withdraw Success ]\n[ Remaining Balance : " + list.get(i).balance + "]");
                            msg = ("[ Money Withdraw Success ]\n[ Remaining Balance : " + list.get(i).balance + "]");
                            return true;
                        } else {
                            //out.writeUTF("[ Fail ! No Enough Balance! ]");
                            System.out.println("[ Fail ! No Enough Balance! ]");
                            msg = "[ Fail ! No Enough Balance! ]";
                            return false;
                        }
                    } else {
                        //out.writeUTF("[ Fail ! Wrong Password ]");
                        System.out.println("[ Fail ! Wrong Password ]");
                        msg = "[ Fail ! Wrong Password ]";
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }

            }
        }
        System.out.println("[ Fail ! Account Not Found! ]");
        msg = "[ Fail ! Account Not Found! ]";
        return false;
    }
    static boolean transfer(String[] arg) {
        int i;
        int size = list.size();


        int accounts_number = Integer.valueOf(arg[1]);
        String pwd = arg[2];
        int transferTo = Integer.valueOf(arg[3]);
        double transfer = Double.valueOf(arg[4]);



        int     from_index = -1;
        int     to_index = -1;

        Account from = null;
        Account to   = null;




        for (i = 0;i < size;i++) {
            if (list.get(i).account_num == accounts_number) {
                try {
                    if (list.get(i).password.equals(pwd)) {
                        from_index = i;
                        from = list.get(i);
                    } else {
                        //out.writeUTF("[ Fail ! Wrong Password ]");
                        System.out.println("[ Fail ! Wrong Password ]");
                        msg = "[ Fail ! Wrong Password ]";
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
                break;
            }
        }
        if (from == null) {
            try {
                //out.writeUTF("[ Invalid Account! Please Try Again! ]");
                System.out.println("[ Invalid Account! Please Try Again! ]");
                msg = "[ Invalid Account! Please Try Again! ]";
            } catch (Exception e) {

            }
            return false;

        }
        for (i = 0;i < size;i++) {
            if (list.get(i).account_num == transferTo) {
                to_index = i;
                to = list.get(i);
                break;
            }
        }

        if (to == null) {
            try {
                //out.writeUTF("[ Invalid Account To Transfer TO ]");
                System.out.println("[ Invalid Account To Transfer To ]");
                msg = "[ Invalid Account To Transfer TO ]";

            } catch (Exception e) {

            }
            return false;
        }

        if((from.balance - transfer) >= 0) {

                list.get(from_index).balance -= transfer;
                list.get(to_index).balance   -= transfer;
                //out.writeUTF("[ Transfer Success ]");
                System.out.println(from.balance);
            try {
                System.out.println("[ Transfer Success ]");
                System.out.println("[ Current Balance : " + list.get(from_index).balance + " ]" );
                msg = ("[ Transfer Success ]\n[ Current Balance : " + list.get(from_index).balance + " ]");
            } catch (Exception e) {

            }
            return true;
        } else {
            try {
                //out.writeUTF("[ Transfer Failure! Inadequate Balance! ]");
                System.out.println("[ Transfer Failure! Inadequate Balance! ]");
                msg = "[ Transfer Failure! Inadequate Balance! ]";
            } catch (Exception e) {

            }
            return false;
        }
    }
}
