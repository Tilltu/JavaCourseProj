package gui.utils;

import java.util.LinkedList;

public class Query {

    public Account findAccount(LinkedList<Account> list, String in, String type) {
        int i = 0;
        if(type.equals("name")) {
            for(i = 0;i < list.size();i++) {
                if(list.get(i).name.equals(in)) {
                    return list.get(i);
                }
            }
        } else if(type.equals("account")) {
            for(i = 0;i < list.size();i++) {
                if(list.get(i).account_num == Integer.valueOf(in)) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}
