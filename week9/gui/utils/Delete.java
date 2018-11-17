package gui.utils;

import java.util.LinkedList;

public class Delete {
    public void delete(LinkedList<Account> list, Account account) {
        list.remove(account);
    }
}
