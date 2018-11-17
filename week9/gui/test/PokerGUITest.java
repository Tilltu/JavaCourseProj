package gui.test;

import  java.awt.*;
import  java.io.*;

import  gui.utils.GetHandCard;
import  gui.utils.HandCard;
import  gui.utils.Poker;

import  javax.swing.*;


public class PokerGUITest {

    static String[] poker_src;

    public static void main(String[] args) {
        File file = new File("src/gui/utils/PokerSrc");
        poker_src = file.list();

        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Poker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(666, 400);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());


        ImageIcon icon1 = new ImageIcon("src/gui/utils/PokerSrc/background.png");
        icon1.setImage(icon1.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
        JLabel image_lab1 = new JLabel();
        image_lab1.setIcon(icon1);

        ImageIcon icon2 = new ImageIcon("src/gui/utils/PokerSrc/background.png");
        icon2.setImage(icon2.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
        JLabel image_lab2 = new JLabel();
        image_lab2.setIcon(icon2);

        ImageIcon icon3 = new ImageIcon("src/gui/utils/PokerSrc/background.png");
        icon2.setImage(icon2.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
        JLabel image_lab3 = new JLabel();
        image_lab3.setIcon(icon2);

        ImageIcon icon4 = new ImageIcon("src/gui/utils/PokerSrc/background.png");
        icon4.setImage(icon4.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
        JLabel image_lab4 = new JLabel();
        image_lab4.setIcon(icon4);

        ImageIcon icon5 = new ImageIcon("src/gui/utils/PokerSrc/background.png");
        icon5.setImage(icon5.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
        JLabel image_lab5 = new JLabel();
        image_lab5.setIcon(icon5);


        JButton generate_btn = new JButton("Generate");
        generate_btn.addActionListener((listener) -> {
            GetHandCard HC = new GetHandCard();

            HandCard handcard = HC.getHandCard();

            ImageIcon icon1_ = new ImageIcon(findCardURL(handcard.handcard[0]));
            icon1_.setImage(icon1_.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
            image_lab1.setIcon(icon1_);

            ImageIcon icon2_ = new ImageIcon(findCardURL(handcard.handcard[1]));
            icon2_.setImage(icon2_.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
            image_lab2.setIcon(icon2_);


            ImageIcon icon3_ = new ImageIcon(findCardURL(handcard.handcard[2]));
            icon3_.setImage(icon3_.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
            image_lab3.setIcon(icon3_);


            ImageIcon icon4_ = new ImageIcon(findCardURL(handcard.handcard[3]));
            icon4_.setImage(icon4_.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
            image_lab4.setIcon(icon4_);

            ImageIcon icon5_ = new ImageIcon(findCardURL(handcard.handcard[4]));
            icon5_.setImage(icon5_.getImage().getScaledInstance(125, 182, Image.SCALE_DEFAULT));
            image_lab5.setIcon(icon5_);

        });

        /*JTextArea area = new JTextArea(40, 100);
        area.setText("Thank you for playing!");
        area.setFont(new Font(null, Font.BOLD, 30));
        area.setEditable(false);
        area.setForeground(Color.green);*/

        panel.add(image_lab1);
        panel.add(image_lab2);
        panel.add(image_lab3);
        panel.add(image_lab4);
        panel.add(image_lab5);
        panel.add(generate_btn);
        //panel.add(area);

        frame.add(panel);

    }

    public static String findCardURL(Poker poker) {
        int i = 0;
        for(i = 0; i < poker_src.length;i++) {
            if(poker_src[i].contains(poker.toString())) {
                return ("src/gui/utils/PokerSrc/" + poker_src[i]);
            }
        }

        return null;
    }
}
