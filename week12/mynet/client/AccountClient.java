package mynet.client;


import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class AccountClient implements Runnable {

    static int              port = 6000;
    static String           host = "localhost";
    static DataInputStream  in;
    static DataOutputStream out;
    static Socket           socket;


    static int    $1 = -1;
    static String $2 = "";
    static String $3 = "";
    static double $4 = -1d;
    static String $5 = "";
    static String $6 = "";                  //parameters given to register

    //**********************************************************************//

    static int    accound_id = -1;
    static String changedPwd = "";          //parameters given to change password
    static String password = "";

    //**********************************************************************//

    static double withdraw_money = -1d;     //parameters given to withdraw and deposit
    static double deposit_money = -1d;
    //**********************************************************************//

    static int    transfer_to_account = -1; //parameters given to transfer
    static double transfer_money = -1d;

    //**********************************************************************//

    public void run() {

        JFrame frame = new JFrame("Client");
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenuItem register = new JMenuItem("Register");

        register.addActionListener((listener) -> {


            JDialog dialog = new JDialog(frame, "Register");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setTitle("Add an account to table");
            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                $1 = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            JLabel name_lab = new JLabel("Name:");
            JTextField name = new JTextField();
            name.setColumns(2);
            name.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!name.getText().equals("")) {
                        String regex = "[a-zA-Z]";
                        String[] checker = name.getText().split(regex);

                        if (checker.length != 0) {
                            JOptionPane jp = new JOptionPane();
                            jp.showMessageDialog(dialog, "Name must be alphas!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            name.requestFocus();
                            name.setForeground(Color.BLACK);
                        } else {
                            name.setForeground(Color.green);
                            $2 = name.getText();
                        }
                    }
                }
            });

            JLabel id_lab = new JLabel("ID Number:");
            JTextField id = new JTextField();
            id.setColumns(2);
            id.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!id.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        String regex = "[0-9]";
                        String[] checker = id.getText().split(regex);

                        if (checker.length != 0 && id.getText().length() != 18) {
                            jp.showMessageDialog(dialog, "Id bits must be 18 " +
                                            "and Id must be all digits!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);

                            id.requestFocus();

                            id.setForeground(Color.BLACK);

                        } else if (id.getText().length() != 18) {
                            jp.showMessageDialog(dialog, "Id bits must be 18!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);

                            id.requestFocus();

                            id.setForeground(Color.BLACK);

                        } else if (checker.length != 0) {

                            jp.showMessageDialog(dialog, "Id must be all digits!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            id.requestFocus();

                            id.setForeground(Color.BLACK);
                        } else {
                            id.setForeground(Color.green);

                            $3 = id.getText();
                        }
                    }
                }
            });


            JLabel date_lab = new JLabel("Date:");
            JTextField date = new JTextField("No need to input.");
            date.setForeground(Color.gray);
            date.setEditable(false);


            JLabel bal_lab = new JLabel("Balance:");
            JTextField bal = new JTextField();
            bal.setColumns(2);
            bal.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!bal.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        if (bal.getText().split("[0-9\\.\\+\\-]").length != 0) {
                            jp.showMessageDialog(dialog,
                                    "Balance mustn't be digits including dot!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            bal.requestFocus();
                            bal.setForeground(Color.BLACK);
                        } else {
                            double val = Double.valueOf(bal.getText());
                            if (val < 0) {
                                jp.showMessageDialog(dialog,
                                        "Balance mustn't be less than 0!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                bal.requestFocus();
                                bal.setForeground(Color.BLACK);
                            } else {
                                bal.setForeground(Color.green);
                                $4 = Double.valueOf(bal.getText());
                            }
                        }
                    }
                }
            });


            JLabel pwd_lab = new JLabel("Password:");
            JPasswordField pwd = new JPasswordField();
            pwd.setColumns(2);
            pwd.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (pwd.getPassword().length != 0) {
                        JOptionPane jp = new JOptionPane();
                        if (pwd.getPassword().length < 8) {
                            jp.showMessageDialog(dialog,
                                    "Password bits must be at least 8!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            pwd.requestFocus();
                            pwd.setForeground(Color.BLACK);
                        } else {
                            String[] all_digits_checker = String.valueOf(pwd.getPassword()).split("[0-9]");
                            String[] all_alphas_checker = String.valueOf(pwd.getPassword()).split("[a-zA-Z]");


                            if (all_alphas_checker.length == 0 && all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password must contain digits and alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all digits!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_alphas_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else {
                                $5 = String.valueOf(pwd.getPassword());
                            }
                        }
                    }
                }
            });


            JLabel sex_lab = new JLabel("Sex:");
            JRadioButton sex1 = new JRadioButton("male");
            JRadioButton sex2 = new JRadioButton("female");
            ButtonGroup btng = new ButtonGroup();
            btng.add(sex1);
            btng.add(sex2);
            sex1.addActionListener((al) -> {
                sex1.setSelected(true);
                $6 = "male";
            });
            sex2.addActionListener((al) -> {
                sex2.setSelected(true);
                $6 = "female";
            });


            panel1.add(an_lab);
            panel1.add(an);
            panel1.add(name_lab);
            panel1.add(name);
            panel1.add(id_lab);
            panel1.add(id);
            panel1.add(date_lab);
            panel1.add(date);
            panel1.add(bal_lab);
            panel1.add(bal);
            panel1.add(pwd_lab);
            panel1.add(pwd);
            panel1.add(sex_lab);
            panel1.add(sex1);
            panel1.add(sex2);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();
                    name.requestFocus();
                    an.setText("");
                    an.setForeground(Color.BLACK);
                    name.setText("");
                    name.setForeground(Color.BLACK);
                    id.setText("");
                    id.setForeground(Color.BLACK);
                    bal.setText("");
                    bal.setForeground(Color.BLACK);
                    pwd.setText("");
                    pwd.setForeground(Color.BLACK);


                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if(!an.getText().equals("")) {
                    $1 = Integer.valueOf(an.getText());
                }

                if(an.getText().equals("") || name.getText().equals("") || id.getText().equals("") ||
                        bal.getText().equals("") || pwd.getPassword().length == 0 ){
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {



                    try {
                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        String res = ("insert," + $1 + "," + $2 + "," + $3 + "," + $4 + "," + $5 + "," + $6);

                        out.writeUTF(res);
                        out.flush();

                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);


                        socket.close();
                    } catch (IOException e) {

                    }

                    an.setText("");
                    an.setForeground(Color.BLACK);
                    name.setText("");
                    name.setForeground(Color.BLACK);
                    id.setText("");
                    id.setForeground(Color.BLACK);
                    bal.setText("");
                    bal.setForeground(Color.BLACK);
                    pwd.setText("");
                    pwd.setForeground(Color.BLACK);



                    name.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);

        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JMenuItem change = new JMenuItem("Change Password");

        change.addActionListener((listener) -> {


            JDialog dialog = new JDialog(frame, "Change Password");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                accound_id = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            JLabel pwd_lab = new JLabel("Password:");
            JPasswordField pwd = new JPasswordField();
            pwd.setColumns(2);
            pwd.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (pwd.getPassword().length != 0) {
                        JOptionPane jp = new JOptionPane();
                        if (pwd.getPassword().length < 8) {
                            jp.showMessageDialog(dialog,
                                    "Password bits must be at least 8!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            pwd.requestFocus();
                            pwd.setForeground(Color.BLACK);
                        } else {
                            String[] all_digits_checker = String.valueOf(pwd.getPassword()).split("[0-9]");
                            String[] all_alphas_checker = String.valueOf(pwd.getPassword()).split("[a-zA-Z]");


                            if (all_alphas_checker.length == 0 && all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password must contain digits and alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all digits!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_alphas_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else {
                                password = String.valueOf(pwd.getPassword());
                            }
                        }
                    }
                }
            });


            JLabel cpwd_lab = new JLabel("Changed Password:");
            JPasswordField cpwd = new JPasswordField();
            cpwd.setColumns(2);
            cpwd.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (cpwd.getPassword().length != 0) {
                        JOptionPane jp = new JOptionPane();
                        if (cpwd.getPassword().length < 8) {
                            jp.showMessageDialog(dialog,
                                    "Password bits must be at least 8!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            cpwd.requestFocus();
                            cpwd.setForeground(Color.BLACK);
                        } else {
                            String[] all_digits_checker = String.valueOf(cpwd.getPassword()).split("[0-9]");
                            String[] all_alphas_checker = String.valueOf(cpwd.getPassword()).split("[a-zA-Z]");


                            if (all_alphas_checker.length == 0 && all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password must contain digits and alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                cpwd.requestFocus();
                                cpwd.setForeground(Color.BLACK);
                            } else if (all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all digits!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                cpwd.requestFocus();
                                cpwd.setForeground(Color.BLACK);
                            } else if (all_alphas_checker.length == 0) {
                                jp.showMessageDialog(dialog,
                                        "Password mustn't be all alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                cpwd.requestFocus();
                                cpwd.setForeground(Color.BLACK);
                            } else {
                                changedPwd = String.valueOf(cpwd.getPassword());
                            }
                        }
                    }
                }
            });


            panel1.add(an_lab);
            panel1.add(an);

            panel1.add(pwd_lab);
            panel1.add(pwd);

            panel1.add(cpwd_lab);
            panel1.add(cpwd);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();

                    an.setText("");
                    an.setForeground(Color.BLACK);

                    pwd.setText("");
                    pwd.setForeground(Color.BLACK);

                    cpwd.setText("");
                    cpwd.setForeground(Color.BLACK);

                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if (an.getText().equals("") || pwd.getPassword().length == 0 || cpwd.getPassword().length == 0) {
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        String res = ("change," + accound_id + "," + password + "," + changedPwd);

                        out.writeUTF(res);
                        out.flush();


                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);

                        socket.close();

                    } catch (IOException e) {

                    }


                    pwd.setText("");
                    pwd.setForeground(Color.BLACK);

                    cpwd.setText("");
                    cpwd.setForeground(Color.BLACK);



                    an.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);

        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JMenuItem query = new JMenuItem("Query");

        query.addActionListener((listener) -> {
            JDialog dialog = new JDialog(frame, "Query");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                accound_id = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            panel1.add(an_lab);
            panel1.add(an);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();

                    an.setText("");
                    an.setForeground(Color.BLACK);


                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if (an.getText().equals("")) {
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        String res = ("query," + accound_id);

                        out.writeUTF(res);
                        out.flush();

                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);

                        socket.close();

                    } catch (IOException e) {

                    }

                    an.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);

        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JMenuItem withdraw = new JMenuItem("Withdraw");

        withdraw.addActionListener((listener) -> {
            JDialog dialog = new JDialog(frame, "Withdraw");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                accound_id = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            JLabel pwd = new JLabel("Password:");
            JPasswordField pwd_in = new JPasswordField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);

            pwd_in.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    password = String.valueOf(pwd_in.getPassword());
                }
            });


            JLabel withdraw_lab = new JLabel("Withdraw Amount:");
            JTextField withdraw_in = new JTextField();
            withdraw_in.setColumns(2);
            withdraw_in.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!withdraw_in.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        if (withdraw_in.getText().split("[0-9\\.\\+\\-]").length != 0) {
                            jp.showMessageDialog(dialog,
                                    "Withdraw Amount mustn't be digits including dot!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            withdraw_in.requestFocus();
                            withdraw_in.setForeground(Color.BLACK);
                        } else {
                            double val = Double.valueOf(withdraw_in.getText());
                            if (val < 0) {
                                jp.showMessageDialog(dialog,
                                        "Withdraw Amount mustn't be less than 0!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                withdraw_in.requestFocus();
                                withdraw_in.setForeground(Color.BLACK);
                            } else {
                                withdraw_in.setForeground(Color.green);
                                withdraw_money = Double.valueOf(withdraw_in.getText());
                            }
                        }
                    }
                }
            });


            panel1.add(an_lab);
            panel1.add(an);

            panel1.add(pwd);
            panel1.add(pwd_in);

            panel1.add(withdraw_lab);
            panel1.add(withdraw_in);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();

                    an.setText("");
                    an.setForeground(Color.BLACK);

                    pwd_in.setText("");

                    withdraw_in.setText("");


                    /*accound_id = -1;
                    password = "";
                    withdraw_money = -1d;*/


                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if (an.getText().equals("") || pwd_in.getPassword().length == 0 || withdraw_in.getText().equals("")) {
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        if (!String.valueOf(pwd_in.getPassword()).equals("")) {
                            password = String.valueOf(pwd_in.getPassword());
                        }

                        String res = ("withdraw," + accound_id + "," + password + "," + withdraw_money);

                        out.writeUTF(res);
                        out.flush();

                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);

                        socket.close();

                    } catch (IOException e) {

                    }

                    an.setText("");
                    pwd_in.setText("");
                    withdraw_in.setText("");

                    /*accound_id = -1;
                    password = "";
                    withdraw_money = -1d;
                    */


                    an.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);

        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JMenuItem deposit = new JMenuItem("Deposit");

        deposit.addActionListener((listener) -> {
            JDialog dialog = new JDialog(frame, "Deposit");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                accound_id = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            JLabel pwd = new JLabel("Password:");
            JPasswordField pwd_in = new JPasswordField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);

            pwd_in.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    password = String.valueOf(pwd_in.getPassword());
                }
            });


            JLabel deposit_lab = new JLabel("Deposit Amount:");
            JTextField deposit_in = new JTextField();
            deposit_in.setColumns(2);
            deposit_in.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!deposit_in.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        if (deposit_in.getText().split("[0-9\\.\\+\\-]").length != 0) {
                            jp.showMessageDialog(dialog,
                                    "Deposit Amount mustn't be digits including dot!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            deposit_in.requestFocus();
                            deposit_in.setForeground(Color.BLACK);
                        } else {
                            double val = Double.valueOf(deposit_in.getText());
                            if (val < 0) {
                                jp.showMessageDialog(dialog,
                                        "Deposit Amount mustn't be less than 0!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                deposit_in.requestFocus();
                                deposit_in.setForeground(Color.BLACK);
                            } else {
                                deposit_in.setForeground(Color.green);
                                deposit_money = Double.valueOf(deposit_in.getText());
                            }
                        }
                    }
                }
            });


            panel1.add(an_lab);
            panel1.add(an);

            panel1.add(pwd);
            panel1.add(pwd_in);

            panel1.add(deposit_lab);
            panel1.add(deposit_in);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();

                    an.setText("");
                    an.setForeground(Color.BLACK);

                    pwd_in.setText("");

                    deposit_in.setText("");


                    /*accound_id = -1;
                    password = "";
                    deposit_money = -1d;
                    */


                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if (an.getText().equals("") || pwd_in.getPassword().length == 0 || deposit_in.getText().equals("")) {
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        if (!String.valueOf(pwd_in.getPassword()).equals("")) {
                            password = String.valueOf(pwd_in.getPassword());
                        }

                        String res = ("deposit," + accound_id + "," + password + "," + deposit_money);

                        out.writeUTF(res);
                        out.flush();

                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);

                        socket.close();

                    } catch (IOException e) {

                    }

                    an.setText("");
                    pwd_in.setText("");
                    deposit_in.setText("");

                    /*accound_id = -1;
                    password = "";
                    deposit_money = -1d;
                    */


                    an.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);
        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JMenuItem transfer = new JMenuItem("Transfer");

        transfer.addActionListener((listener) -> {
            JDialog dialog = new JDialog(frame, "Transfer");
            JPanel panel1 = new JPanel();
            BoxLayout bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {


                    dialog.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });


            JLabel an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);


            an.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (an.isEditable()) {
                        if (!an.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = an.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                an.setForeground(Color.green);
                                accound_id = Integer.valueOf(an.getText());
                            }
                        }
                    }
                }


            });


            JLabel pwd = new JLabel("Password:");
            JPasswordField pwd_in = new JPasswordField();
            an.setForeground(Color.GRAY);
            an.setColumns(2);

            pwd_in.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    password = String.valueOf(pwd_in.getPassword());
                }
            });


            JLabel transfer_to_lab = new JLabel("Account To Be Transferred To:");
            JTextField transferTo = new JTextField();
            transferTo.setForeground(Color.GRAY);
            transferTo.setColumns(2);


            transferTo.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (transferTo.isEditable()) {
                        if (!transferTo.getText().equals("")) {
                            String regex = "[0-9]";
                            String[] checker = transferTo.getText().split(regex);

                            if (checker.length != 0) {
                                JOptionPane jp = new JOptionPane();
                                jp.showMessageDialog(dialog,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                transferTo.requestFocus();
                                transferTo.setForeground(Color.BLACK);
                            } else {
                                transferTo.setForeground(Color.green);
                                transfer_to_account = Integer.valueOf(transferTo.getText());
                            }
                        }
                    }
                }


            });


            JLabel transfer_lab = new JLabel("Transfer Amount:");
            JTextField transfer_amount = new JTextField();
            transfer_amount.setColumns(2);
            transfer_amount.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (!transfer_amount.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        if (transfer_amount.getText().split("[0-9\\.\\+\\-]").length != 0) {
                            jp.showMessageDialog(dialog,
                                    "Transfer Amount mustn't be digits including dot!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            transfer_amount.requestFocus();
                            transfer_amount.setForeground(Color.BLACK);
                        } else {
                            double val = Double.valueOf(transfer_amount.getText());
                            if (val < 0) {
                                jp.showMessageDialog(dialog,
                                        "Transfer Amount mustn't be less than 0!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                transfer_amount.requestFocus();
                                transfer_amount.setForeground(Color.BLACK);
                            } else {
                                transfer_amount.setForeground(Color.green);
                                transfer_money = Double.valueOf(transfer_amount.getText());
                            }
                        }
                    }
                }
            });


            panel1.add(an_lab);
            panel1.add(an);

            panel1.add(pwd);
            panel1.add(pwd_in);

            panel1.add(transfer_to_lab);
            panel1.add(transferTo);

            panel1.add(transfer_lab);
            panel1.add(transfer_amount);


            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    an.requestFocus();

                    an.setText("");
                    an.setForeground(Color.BLACK);

                    pwd_in.setText("");

                    transferTo.setText("");

                    transfer_amount.setText("");


                    /*accound_id = -1;
                    password = "";
                    transfer_to_account = -1;
                    transfer_money = -1d;
                    */

                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if (an.getText().equals("") || pwd_in.getPassword().length == 0 || transferTo.getText().equals("") || transfer_amount.getText().equals("")) {
                    JOptionPane jp = new JOptionPane();
                    jp.showMessageDialog(dialog, "Input cant't be null!",
                            "InputError", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        socket = new Socket(host, port);

                        in = new DataInputStream(socket.getInputStream());
                        out = new DataOutputStream(socket.getOutputStream());

                        if (!String.valueOf(pwd_in.getPassword()).equals("")) {
                            password = String.valueOf(pwd_in.getPassword());
                        }

                        String res = ("transfer," + accound_id + "," + password + "," + transfer_to_account + "," + transfer_money);
                        //System.out.println(transfer_money);
                        out.writeUTF(res);
                        out.flush();

                        String result = in.readUTF();

                        JOptionPane jp = new JOptionPane();
                        jp.showMessageDialog(dialog,
                                result,
                                "Result", JOptionPane.INFORMATION_MESSAGE);

                        socket.close();

                    } catch (IOException e) {

                    }

                    an.setText("");
                    pwd_in.setText("");
                    transferTo.setText("");
                    transfer_amount.setText("");

                    /*accound_id = -1;
                    password = "";
                    transfer_to_account = -1;
                    transfer_money = -1d;
                    */


                    an.requestFocus();
                }
            });


            panel1.add(confirm_btn);
            panel1.add(cancel_btn);
            panel1.add(exit_btn);
            dialog.add(panel1);


            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setVisible(true);

        });


        //**********************************************************************//
        //**********************************************************************//
        //**********************************************************************//


        JTextArea area = new JTextArea(46, 56);
        area.setEditable(false);
        menuBar.add(register);
        menuBar.add(query);
        menuBar.add(change);
        menuBar.add(withdraw);
        menuBar.add(deposit);
        menuBar.add(transfer);
        panel.add(menuBar);
        panel.add(area);
        frame.add(panel);
        frame.setVisible(true);


    }
}
