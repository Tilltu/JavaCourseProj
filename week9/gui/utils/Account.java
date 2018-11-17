package gui.utils;

import  java.io.Serializable;
import  java.text.ParseException;
import  java.text.SimpleDateFormat;
import  java.util.Date;

public class Account implements Comparable<Account>, Serializable {
    public int    account_num;
    public String name;
    public String id_num;
    public Date   birthday;
    public double balance;
    public String password;
    public String sex;

    @Override
    public int compareTo(Account a) {
        if(this.balance > a.balance) {
            return -1;
        } else if (this.balance == a.balance) {
            return 0;
        }
        return 1;
    }

    public Account(int account_number, String name, String id_number,
                   double balance, String password, String sex){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        this.account_num = account_number;
        this.name        = name;
        this.id_num      = id_number;
        try {
            this.birthday    = format.parse(id_num.substring(6, 14));
        }catch (ParseException pe) {

        }
        this.balance     = balance;
        this.password    = password;
        this.sex         = sex;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        return ("Account Number : " + account_num + "\n" +
                "Name                   : " + name + "\n" +
                //"Id Number        : " + id_num + "\n" +
                //"Birthday           : " + format.format(birthday) + "\n" +
                "Balance                : " + balance + " RMB\n");
                //"Password          : " + password + "\n" +
                //"Sex                 : " + sex + "\n"); //TODO
    }


}
