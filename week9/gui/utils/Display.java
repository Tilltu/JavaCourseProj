package gui.utils;

import javax.swing.*;
import  java.util.LinkedList;
import  java.lang.Comparable;

public class Display {


    public JTable display(LinkedList<Account> list) {
        list.sort(Account::compareTo);

        String res = "";
        int size = list.size();

        String[] row_name = {"Account Number", "Name", "Balance"};
        String[][] row_data = new String[size][3];

        for(int i = 0;i < size;i++) {
            row_data[i][0] = String.valueOf(list.get(i).account_num);
            row_data[i][1] = list.get(i).name;
            row_data[i][2] = String.valueOf(list.get(i).balance) + " (RMB)";
        }

        JTable table = new JTable(row_data, row_name);
        table.setVisible(true);

        return table;
    }
}
