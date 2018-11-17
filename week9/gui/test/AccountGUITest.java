package gui.test;


import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
import  gui.utils.Account;

import  gui.utils.*;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;
import  java.util.LinkedList;


public class AccountGUITest {

    static boolean focusLostFlag = true;

    static LinkedList<Account> accounts;

    static int    $1 = -1;
    static String $2 = "";
    static String $3 = "";
    static double $4 = -1d;
    static String $5 = "";
    static String $6 = "";  //parameters given to insert


    public static void main(String[] args) {
        accounts = new LinkedList<>();

        javax.swing.SwingUtilities.invokeLater(() -> {
            showAccountGUI();
        });
    }

    static void showAccountGUI() {
        JFrame frame = new JFrame("Account Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);

        JTabbedPane tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        JPanel panel = new JPanel(new FlowLayout());

        JTextArea area = new JTextArea(20, 26);
        area.setVisible(true);
        area.setEditable(false);


        //******************************************************//


        JButton insert_btn  = new JButton("Insert");
        insert_btn.addActionListener((actionEvent)->{
            focusLostFlag = true;

            JPanel          panel1 = new JPanel();
            JDialog        dialog1 = new JDialog();
            BoxLayout      bl1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(bl1);

            dialog1.setTitle("Add an account to table");
            dialog1.setBounds((new Rectangle(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            )));
            dialog1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    //exit_btn.requestFocus();
                    focusLostFlag = false;

                    dialog1.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });





            JLabel    an_lab = new JLabel("Account Number:");
            JTextField an = new JTextField("Just need to input once");
            an.setForeground(Color.GRAY);
            an.setColumns(2);
            if(!accounts.isEmpty()) {
                an.setEditable(false);
            }


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
                                jp.showMessageDialog(dialog1,
                                        "Account Number must be digits!",
                                        "InputError",
                                        JOptionPane.ERROR_MESSAGE);
                                an.requestFocus();
                                an.setForeground(Color.BLACK);
                            } else {
                                if (accounts.size() == 0) {
                                    an.setForeground(Color.green);
                                    $1 = Integer.valueOf(an.getText());
                                } else {
                                    $1 = accounts.get(accounts.size()).account_num + 1;
                                }
                            }
                        }
                    }
                }


            });




            JLabel    name_lab = new JLabel("Name:");
            JTextField name = new JTextField();
            name.setColumns(2);
            name.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(!name.getText().equals("")) {
                        String regex = "[a-zA-Z]";
                        String[] checker = name.getText().split(regex);

                        if (checker.length != 0) {
                            JOptionPane jp = new JOptionPane();
                            jp.showMessageDialog(dialog1, "Name must be alphas!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            name.requestFocus();
                            name.setForeground(Color.BLACK);
                        }else {
                            name.setForeground(Color.green);
                            $2 = name.getText();
                        }
                    }
                }
            });

            JLabel    id_lab = new JLabel("ID Number:");
            JTextField id  = new JTextField();
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

                        if(checker.length != 0 && id.getText().length() != 18) {
                            jp.showMessageDialog(dialog1, "Id bits must be 18 " +
                                                  "and Id must be all digits!",
                                                 "InputError", JOptionPane.ERROR_MESSAGE);

                            id.requestFocus();

                            id.setForeground(Color.BLACK);

                        }
                        else if (id.getText().length() != 18) {
                            jp.showMessageDialog(dialog1, "Id bits must be 18!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);

                            id.requestFocus();

                            id.setForeground(Color.BLACK);

                        }else if (checker.length != 0) {

                            jp.showMessageDialog(dialog1, "Id must be all digits!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            id.requestFocus();

                            id.setForeground(Color.BLACK);
                        }else {
                            id.setForeground(Color.green);

                            $3 = id.getText();
                        }
                    }
                }
            });





            JLabel   date_lab = new JLabel("Date:");
            JTextField   date = new JTextField("No need to input.");
            date.setForeground(Color.gray);
            date.setEditable(false);


            JLabel    bal_lab = new JLabel("Balance:");
            JTextField bal = new JTextField();
            bal.setColumns(2);
            bal.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(!bal.getText().equals("")) {
                        JOptionPane jp = new JOptionPane();
                        if (bal.getText().split("[0-9\\.\\+\\-]").length != 0) {
                            jp.showMessageDialog(dialog1,
                                    "Balance mustn't be digits including dot!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            bal.requestFocus();
                            bal.setForeground(Color.BLACK);
                        } else {
                            double val = Double.valueOf(bal.getText());
                            if (val < 0) {
                                jp.showMessageDialog(dialog1,
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



            JLabel    pwd_lab = new JLabel("Password:");
            JPasswordField pwd = new JPasswordField();
            pwd.setColumns(2);
            pwd.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(pwd.getPassword().length != 0) {
                        JOptionPane jp = new JOptionPane();
                        if(pwd.getPassword().length < 8) {
                            jp.showMessageDialog(dialog1,
                                    "Password bits must be at least 8!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            pwd.requestFocus();
                            pwd.setForeground(Color.BLACK);
                        } else {
                            String[] all_digits_checker = String.valueOf(pwd.getPassword()).split("[0-9]");
                            String[] all_alphas_checker = String.valueOf(pwd.getPassword()).split("[a-zA-Z]");


                            if (all_alphas_checker.length == 0 && all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog1,
                                        "Password must contain digits and alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_digits_checker.length == 0) {
                                jp.showMessageDialog(dialog1,
                                        "Password mustn't be all digits!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            } else if (all_alphas_checker.length == 0) {
                                jp.showMessageDialog(dialog1,
                                        "Password mustn't be all alphas!",
                                        "InputError", JOptionPane.ERROR_MESSAGE);
                                pwd.requestFocus();
                                pwd.setForeground(Color.BLACK);
                            }else {
                                $5 = String.valueOf(pwd.getPassword());
                            }
                        }
                    }
                }
            });


            JLabel    sex_lab = new JLabel("Sex:");
            JRadioButton sex1 = new JRadioButton("male");
            JRadioButton sex2 = new JRadioButton("female");
            ButtonGroup  btng = new ButtonGroup();
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

            //Doing Insertion

            JButton cancel_btn = new JButton("Cancel");

            cancel_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if(accounts.isEmpty()) {
                        an.requestFocus();
                    } else {
                        name.requestFocus();
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
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            JButton confirm_btn = new JButton("Confirm");
            confirm_btn.addActionListener((actionEvent1) -> {

                if ($1 == -1 || $2.equals("") || $3.equals("") || $4 == -1 ||
                        $5.equals("") || $6.equals("")) {
                    JOptionPane jp  = new JOptionPane();
                    jp.showMessageDialog(dialog1, "Input cant't be null!",
                                         "InputError", JOptionPane.ERROR_MESSAGE);

                } else {
                    if (accounts.size() == 0) {
                        $1 = Integer.valueOf(an.getText());
                        an.setEditable(false);
                    } else {
                        $1 = accounts.get(accounts.size() - 1).account_num + 1;
                    }

                    Account account = new Account($1, $2, $3, $4, $5, $6);


                    //System.out.println(account);

                    Insert insert = new Insert();
                    insert.insert(accounts, account);


                    //an.setText("");
                    //an.setForeground(Color.BLACK);
                    an.setText("Just need to input once");
                    an.setForeground(Color.GRAY);
                    //an.setColumns(2);
                    if(!accounts.isEmpty()) {
                        an.setEditable(false);
                    }
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
            dialog1.add(panel1);
            dialog1.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog1.setVisible(true);
        });





        //******************************************************//





        JButton query_btn   = new JButton("Query");
        query_btn.addActionListener((actionEvent) -> {

            JPanel panel2 = new JPanel();
            BoxLayout bl2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
            panel2.setLayout(bl2);
            JDialog dialog2 = new JDialog();
            dialog2.setBounds(
                frame.getX() + 50,
                frame.getY() + 50,
                   frame.getWidth(),
                   frame.getHeight() + 20
            );
            dialog2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog2.setTitle("Query an account");

            JTextField      an_text  = new JTextField();
            an_text.setEditable(false);
            JButton       qan_btn    = new JButton("Account Number:");
            JTextField    name_text  = new JTextField();
            JButton       qname_btn  = new JButton("Name:");
            name_text.setEditable(false);

            qan_btn.addActionListener((listener) -> {
                qan_btn.setSelected(true);
                an_text.setEditable(true);
                qname_btn.setSelected(false);
                name_text.setText("");
                name_text.setEditable(false);
            });

            qname_btn.addActionListener((listener) -> {
                qname_btn.setSelected(true);
                name_text.setEditable(true);
                qan_btn.setSelected(false);
                an_text.setText("");
                an_text.setEditable(false);
            });

            ButtonGroup group = new ButtonGroup();
            group.add(qan_btn);
            group.add(qname_btn);

            JTextArea  board  = new JTextArea(20, 20);
            board.setVisible(true);
            board.setEditable(false);

            //todo board.
            JButton    q_btn  = new JButton("Query");

            q_btn.addActionListener((listener) -> {
                JOptionPane jp = new JOptionPane();

                if(qan_btn.isSelected()) {
                    if (an_text.getText().equals("")) {
                        jp.showMessageDialog(dialog2,
                                "Account Number can't be null!",
                                "InputError",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        String regex = "[0-9]";
                        String[] checker = an_text.getText().split(regex);

                        if (checker.length != 0) {

                            jp.showMessageDialog(dialog2,
                                    "Account Number must be digits!",
                                    "InputError",
                                    JOptionPane.ERROR_MESSAGE);
                            an_text.requestFocus();
                            an_text.setForeground(Color.BLACK);
                        } else {
                            String in = an_text.getText();
                            Query query = new Query();

                            if(query.findAccount(accounts, in, "account") != null) {
                                board.setText("");
                                board.append(query.findAccount(accounts, in, "account").toString());
                                board.append("**************************************************" + "\n");
                            }else {
                                jp.showMessageDialog(dialog2,
                                        "Sorry! Account doesn't exist!",
                                        "NotFound",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            an_text.requestFocus();
                        }
                    }
                }else if(qname_btn.isSelected()) {
                    if(name_text.getText().equals("")) {
                        jp.showMessageDialog(dialog2,
                                "Name can't be null!",
                                "InputError",
                                JOptionPane.ERROR_MESSAGE);
                    } {
                        String regex = "[a-zA-Z]";
                        String[] checker = name_text.getText().split(regex);

                        if (checker.length != 0) {
                            jp.showMessageDialog(dialog2, "Name must be alphas!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            name_text.requestFocus();
                            name_text.setForeground(Color.BLACK);
                        }else {
                            String in   = name_text.getText();
                            Query query = new Query();

                            if(query.findAccount(accounts, in, "name") != null) {
                                board.setText("");
                                board.append(query.findAccount(accounts, in, "name").toString());
                                board.append("**************************************************" + "\n");
                            }else {
                                jp.showMessageDialog(dialog2,
                                        "Sorry! Account doesn't exist!",
                                        "NotFound",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            name_text.requestFocus();
                        }
                    }
                }
                else {
                    jp.showMessageDialog(dialog2,
                            "Input can't be null!",
                            "InputError",
                            JOptionPane.ERROR_MESSAGE);
                }


            });

            JButton clear_button = new JButton("Clear");
            clear_button.addActionListener((listener) -> {
                board.setText("");
            });

            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                    dialog2.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            panel2.add(qan_btn);
            panel2.add(an_text);
            panel2.add(qname_btn);
            panel2.add(name_text);
            panel2.add(board);
            panel2.add(new JScrollPane(board));
            panel2.add(q_btn);
            panel2.add(clear_button);
            panel2.add(exit_btn);

            dialog2.add(panel2);
            //dialog2.add(qan_btn);

            dialog2.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog2.setVisible(true);




        });




        //******************************************************//
        JButton delete_btn   = new JButton("Delete");
        delete_btn.addActionListener((actionEvent) -> {
            JPanel panel3 = new JPanel();
            BoxLayout bl3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
            panel3.setLayout(bl3);
            JDialog dialog3 = new JDialog();
            dialog3.setBounds(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            );
            dialog3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog3.setTitle("Delete an account");

            JTextField      an_text  = new JTextField();
            an_text.setEditable(false);
            JButton       qan_btn    = new JButton("Account Number:");
            JTextField    name_text  = new JTextField();
            JButton       qname_btn  = new JButton("Name:");
            name_text.setEditable(false);

            qan_btn.addActionListener((listener) -> {
                qan_btn.setSelected(true);
                an_text.setEditable(true);
                qname_btn.setSelected(false);
                name_text.setText("");
                name_text.setEditable(false);
            });

            qname_btn.addActionListener((listener) -> {
                qname_btn.setSelected(true);
                name_text.setEditable(true);
                qan_btn.setSelected(false);
                an_text.setText("");
                an_text.setEditable(false);
            });

            ButtonGroup group = new ButtonGroup();
            group.add(qan_btn);
            group.add(qname_btn);

            JTextArea  board  = new JTextArea(20, 20);
            board.setEditable(false);


            JButton    d_btn  = new JButton("Delete");
            d_btn.addActionListener((listener) -> {
                JOptionPane jp = new JOptionPane();

                if(qan_btn.isSelected()) {
                    if (an_text.getText().equals("")) {
                        jp.showMessageDialog(dialog3,
                                "Account Number can't be null!",
                                "InputError",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        String regex = "[0-9]";
                        String[] checker = an_text.getText().split(regex);

                        if (checker.length != 0) {

                            jp.showMessageDialog(dialog3,
                                    "Account Number must be digits!",
                                    "InputError",
                                    JOptionPane.ERROR_MESSAGE);
                            an_text.requestFocus();
                            an_text.setForeground(Color.BLACK);
                        } else {
                            String in = an_text.getText();
                            Query query = new Query();

                            Account res = query.findAccount(accounts, in, "account");

                            if(res != null) {
                                int val = jp.showConfirmDialog(dialog3, "Are you sure to delete it?");
                                if(val == JOptionPane.YES_OPTION) {
                                    Delete delete = new Delete();
                                    delete.delete(accounts, res);
                                    board.append("Deleted:\n" + res.toString() + "********************************");
                                }

                            }else {
                                jp.showMessageDialog(dialog3,
                                        "Sorry! Account doesn't exist!",
                                        "NotFound",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            an_text.requestFocus();
                        }
                    }
                }else if(qname_btn.isSelected()) {
                    if(name_text.getText().equals("")) {
                        jp.showMessageDialog(dialog3,
                                "Name can't be null!",
                                "InputError",
                                JOptionPane.ERROR_MESSAGE);
                    } {
                        String regex = "[a-zA-Z]";
                        String[] checker = name_text.getText().split(regex);

                        if (checker.length != 0) {
                            jp.showMessageDialog(dialog3, "Name must be alphas!",
                                    "InputError", JOptionPane.ERROR_MESSAGE);
                            name_text.requestFocus();
                            name_text.setForeground(Color.BLACK);
                        }else {
                            String in   = name_text.getText();
                            Query query = new Query();

                            Account res = query.findAccount(accounts, in, "name");

                            if(res != null) {
                                int val = jp.showConfirmDialog(dialog3, "Are you sure to delete it?");
                                if(val == JOptionPane.YES_OPTION) {
                                    Delete delete = new Delete();
                                    delete.delete(accounts, res);
                                    board.append("Deleted:\n" + res.toString() + "********************************");
                                }

                            }else {
                                jp.showMessageDialog(dialog3,
                                        "Sorry! Account doesn't exist!",
                                        "NotFound",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            name_text.requestFocus();
                        }
                    }
                }
                else {
                    jp.showMessageDialog(dialog3,
                            "Input can't be null!",
                            "InputError",
                            JOptionPane.ERROR_MESSAGE);
                }


            });


            JButton exit_btn = new JButton("Exit");
            exit_btn.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                    dialog3.dispose();
                }

                @Override
                public void focusLost(FocusEvent e) {

                }
            });

            panel3.add(qan_btn);
            panel3.add(an_text);
            panel3.add(qname_btn);
            panel3.add(name_text);
            panel3.add(board);
            panel3.add(new JScrollPane(board));
            panel3.add(d_btn);
            panel3.add(exit_btn);
            dialog3.add(panel3);


            dialog3.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            dialog3.setVisible(true);
        });

        //******************************************************//





        //******************************************************//


        JButton display_btn   = new JButton("Display");
        display_btn.addActionListener((actionEvent) -> {
            JDialog dialog4 = new JDialog();
            JPanel  panel4  = new JPanel();

            BoxLayout bl = new BoxLayout(panel4, BoxLayout.Y_AXIS);
            panel4.setLayout(bl);

            dialog4.setBounds(
                    frame.getX() + 50,
                    frame.getY() + 50,
                    frame.getWidth(),
                    frame.getHeight() + 20
            );
            dialog4.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog4.setTitle("Display all accounts");
            dialog4.setVisible(true);



            Display display = new Display();
            JTable  table = display.display(accounts);

            JScrollPane sp = new JScrollPane(table);

            JButton exit_btn = new JButton("Exit");
            exit_btn.addActionListener((listener) -> {
                dialog4.dispose();
            });

            panel4.add(sp);
            panel4.add(exit_btn);

            dialog4.add(panel4);


        });

        JButton exit_btn   = new JButton("Exit");
        exit_btn.setForeground(Color.RED);
        exit_btn.addActionListener((actionEvent) -> {

            System.exit(0);
        });

        //******************************************************//






        panel.add(insert_btn);
        panel.add(query_btn);
        panel.add(delete_btn);
        panel.add(display_btn);
        panel.add(exit_btn);


        //area.append("asfsfas");
        //panel.add(new JScrollPane(area));


        frame.add(panel);


    }


}
