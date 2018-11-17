package gui.test;

import  static java.lang.System.in;
import  static java.lang.System.out;

import  gui.utils.CalculateArea;
import  javax.swing.*;
import  javax.swing.event.DocumentListener;
import  javax.swing.event.UndoableEditListener;
import  javax.swing.text.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.io.InputStream;
import  java.util.Scanner;

public class CalculateAreaGUITest {

    enum Status {
        CORRECT_INPUT(1),
        ILLEGAL_CHRACTER(2),
        NEGATIVE_NUMBER(3);

        int status;
        Status(int type) {
            status = type;
        }

        int toInt() {
            return status;
        }
    }


    public static int checkInput(String in) {
        String regex = "[0-9\\.\\+\\-]";
        String[] ins = in.split(regex);

        if(ins.length != 0) {
            return Status.ILLEGAL_CHRACTER.toInt();
        }

        double value = Double.valueOf(in);
        if(value < 0) {
            return Status.NEGATIVE_NUMBER.toInt();
        }

        return Status.CORRECT_INPUT.toInt();
    }

    public static void exceptionHandle(int status) {
        JOptionPane jp = new JOptionPane();
        if(status == Status.ILLEGAL_CHRACTER.toInt()) {
            jp.showMessageDialog(null, "Input Must Be Digits! Please Retry!",
                                                "Input Error", JOptionPane.ERROR_MESSAGE);
        } else if(status == Status.NEGATIVE_NUMBER.toInt()) {
            jp.showMessageDialog(null, "Input Must Be Positive Number(s)! Please Retry!",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });

    }



    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Area Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu       = new JMenu("Calculate", false);
        menuBar.add(menu);
        JTabbedPane jTabbedPane = new JTabbedPane();
        frame.add(jTabbedPane);

        FlowLayout layout = new FlowLayout();




        JButton btn = new JButton("Calculate");




        JLabel ue_lab = new JLabel("Upper Edge");
        JTextField ue = new JFormattedTextField();
        ue.setColumns(4);
        ue.addFocusListener(new InputFocusListener(ue));

        JLabel le_lab = new JLabel("Lower Edge");
        JTextField le = new JFormattedTextField();
        le.setColumns(4);
        le.addFocusListener(new InputFocusListener(le));
        JLabel h_lab  = new JLabel("Height");
        JTextField h  = new JFormattedTextField();
        h.setColumns(4);
        h.addFocusListener(new InputFocusListener(h));
        JTextArea gut = new JTextArea(20, 20);
        gut.setEditable(false);

        JPanel panel = new JPanel(layout);

        panel.add(ue_lab);
        panel.add(ue);
        panel.add(le_lab);
        panel.add(le);
        panel.add(h_lab);
        panel.add(h);
        panel.add(btn);
        panel.add(gut);


        btn.registerKeyboardAction (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String due = "", dle = "", dh = "";

                    due = ue.getText().trim();

                    dle = le.getText().trim();

                    dh = h.getText().trim();


                    CalculateArea calculateArea = new CalculateArea(due, dle, dh);

                    gut.append("Input Trapezoid's Area Is : " + calculateArea.toString() + "\n");

                    out.println("Success!");

                    ue.requestFocus();
                }
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);



        frame.add(panel);
    }

    static class InputFocusListener extends FocusAdapter {
        JTextField in;

        InputFocusListener(JTextField in) {
            this.in = in;
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(!in.getText().equals("")) {
                int status = checkInput(in.getText().trim());
                if (status != Status.CORRECT_INPUT.toInt()) {
                    exceptionHandle(status);
                    in.requestFocus();
                }
            }
        }

    }
}


