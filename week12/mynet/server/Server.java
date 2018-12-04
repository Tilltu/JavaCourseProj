package mynet.server;


import  java.awt.*;
import  java.awt.event.KeyAdapter;
import  java.awt.event.KeyEvent;
import  java.io.*;
import  java.net.*;
import  java.util.*;

import  javax.swing.*;

public class Server {

    static int port = 8000;
    static DataInputStream  in;
    static DataOutputStream out;
    static ServerSocket server;
    static Socket socket;


    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("Server");
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
                String servermsg = "Server\t" + date.toString() + "\n" + input.getText() + "\n\n";
                screen.append(servermsg);

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
                out.writeUTF("[ Server Is Done ]\n");
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
            server = new ServerSocket(port);
            socket = server.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {}

        while (true) {
            try{

                Date date = new Date(System.currentTimeMillis());
                String msg = "Client\t" + date.toString() + "\n" + in.readUTF() + "\n\n";
                screen.append(msg);

            } catch (IOException e) {

            }
        }



    }


}
