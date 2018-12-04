package mynet.test;

import mynet.client.AccountClient;
import mynet.server.AccountServer;
import thread2.utils.withdraw.Account;

import  java.net.*;
import  java.util.ArrayList;
import  javax.swing.*;

public class AccountTest {


    public static void main (String...args) {
        AccountServer server = new AccountServer();
        AccountClient client = new AccountClient();

        Thread s = new Thread(server, "server");
        Thread c = new Thread(client, "client");

        s.start();
        c.start();
    }
}
