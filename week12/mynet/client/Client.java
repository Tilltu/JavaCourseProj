package mynet.client;

import mynet.server.Server;

import  java.awt.*;
import  java.io.*;
import  java.net.*;
import  java.util.*;

import  javax.swing.*;

public class Client {

    static int port = 8000;
    static String host = "localhost";
    static DataInputStream in;
    static DataOutputStream out;
    static Socket socket;

    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Client");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout());
        JTextArea screen = new JTextArea(20, 20);
        screen.setEditable(false);
        JTextArea input = new JTextArea(20, 20);


        JButton exit = new JButton("Exit");
        JButton send = new JButton("Send");


       /**
        *  Button " send " to append input msg to the screen and write input msg
        *  to OutputDataStream
        */
        send.addActionListener((listener) -> {
            try {
                Date date = new Date(System.currentTimeMillis());
                String clientmsg = "Client\t" + date.toString() + "\n" + input.getText() + "\n\n";
                screen.append(clientmsg);

                out.writeUTF(input.getText());

                input.setText("");

            }catch (IOException e) {

            }
        });

        /**
         * Free in and out
         */
        exit.addActionListener((listener) -> {
            try {
                out.writeUTF("[ Client Is Away ]\n");
                in.close();
                out.close();
                System.exit(0);
            }catch (IOException e) {

            }
        });



        panel.add(new JScrollPane(screen));
        panel.add(new JScrollPane(input));
        panel.add(send);
        panel.add(exit);
        frame.add(panel);
        frame.setVisible(true);


        /**
         *  Initialize a socket
         */
        try {
                socket = new Socket(host, port);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {}


        while (true) {
            try{

                Date date = new Date(System.currentTimeMillis());
                String msg = "Server\t" + date.toString() + "\n" + in.readUTF() + "\n\n";
                screen.append(msg);

            } catch (IOException e) {

            }
        }
    }
}
