package mynet.server;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.*;
import javax.swing.*;

import static java.lang.System.out;

public class Middleware {

    public static volatile JTextArea area1 = new JTextArea(28, 28);;
    public static volatile JTextArea area2 = new JTextArea(28, 28);;

    // area1 is server's screen
    // area2 is client's screen

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = null;    // Middleware's socket
        DatagramPacket packet = null;    // Middleware's packet

        JTextArea cinput = new JTextArea(28, 28); // input area for client
        JTextArea sinput = new JTextArea(28, 28); // input area for server
        JButton     cbtn = new JButton("Send");
        JButton     sbtn = new JButton("Send");


        sbtn.addActionListener((listener) -> {
            try {
                String msg;
                DatagramSocket ssocket = null; // Server's socket
                DatagramPacket spacket = null; // Server's packet

                ssocket = new DatagramSocket(2345);

                msg = sinput.getText();

                Date date = new Date(System.currentTimeMillis());
                msg = "Server\t" + date.toString() + "\n" + msg + "\n";


                spacket = new DatagramPacket(msg.getBytes(), msg.length(),
                        InetAddress.getByName("127.0.0.1"), 8000);
                ssocket.send(spacket);

                sinput.setText("");

                ssocket.close();
            } catch (Exception e) {
                sinput.setText("ERROR!");
            }
        });

        cbtn.addActionListener((listener) -> {
            try {
                String msg;
                DatagramSocket csocket = null; // Client's socket
                DatagramPacket cpacket = null; // Client's packet

                csocket = new DatagramSocket(2345);

                msg = cinput.getText();

                Date date = new Date(System.currentTimeMillis());
                msg = "Client\t" + date.toString() + "\n" + msg + "\n";


                cpacket = new DatagramPacket(msg.getBytes(), msg.length(),
                        InetAddress.getByName("127.0.0.1"), 8000);
                csocket.send(cpacket);

                cinput.setText("");


                csocket.close();
            } catch (Exception e) {
                cinput.setText("ERROR!");
            }
        });

        JFrame frame = new JFrame("Server");
        JFrame frame2 = new JFrame("Client");


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JScrollPane(area1));
        panel.add(new JScrollPane(sinput));
        panel.add(sbtn);

        JButton sexit = new JButton("EXIT");
        sexit.addActionListener((listener) -> {
            if (frame2.isDisplayable()) {
                frame.dispose();
            } else {
                System.exit(0);
            }            area1.append(("Server\t" + new Date(System.currentTimeMillis()).toString() +
                    "\n" + "exited the chat").trim() + "\n");
            area2.append(("Server\t" + new Date(System.currentTimeMillis()).toString() +
                    "\n" + "exited the chat").trim() + "\n");
        });

        panel.add(sexit);
        frame.add(panel);
        frame.setVisible(true);


        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setBounds(
                frame.getX() + 700,
                frame.getY(),
                frame.getWidth(),
                frame.getHeight()
        );
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(new JScrollPane(area2));
        panel2.add(new JScrollPane(cinput));
        panel2.add(cbtn);

        JButton cexit = new JButton("EXIT");
        cexit.addActionListener((listener) -> {
            if (frame.isDisplayable()) {
                frame2.dispose();
            } else {
                System.exit(0);
            }
            area1.append(("Client\t" + new Date(System.currentTimeMillis()).toString() +
                    "\n" + "exited the chat").trim() + "\n");
            area2.append(("Client\t" + new Date(System.currentTimeMillis()).toString() +
                    "\n" + "exited the chat").trim() + "\n");
        });

        panel2.add(cexit);

        frame2.add(panel2);
        frame2.setVisible(true);



        for(;;) {

            byte[] data = new byte[128];

            for (int i = 0;i < 128;i++) {
                data[i] = ' ';
            }

            socket = new DatagramSocket(8000);
            packet = new DatagramPacket(data, data.length);

            socket.receive(packet);
            String str = new String(data);

            area1.append(str.trim() + "\n");
            area2.append(str.trim() + "\n");

            socket.close();
        }

    }
}
