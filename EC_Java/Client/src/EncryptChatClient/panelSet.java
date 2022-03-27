package EncryptChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelSet extends JPanel {
    public static StringBuilder token = new StringBuilder("");
    public static StringBuilder errors = new StringBuilder("");
    public panelSet(){
        //objects
        final JLabel[] label1 = {new JLabel("")};
        JTextField myToken = new JTextField();
        JButton BackToChat = new JButton("<- Back");
        JButton SetToken = new JButton("set token");
        //Colors
        SetToken.setBackground(new Color(31, 31, 31, 255));
        SetToken.setForeground(new Color(34, 255, 0, 255));
        myToken.setBackground(new Color(31, 31, 31, 255));
        myToken.setForeground(new Color(34, 255, 0, 255));
        BackToChat.setBackground(new Color(31, 31, 31, 255));
        BackToChat.setForeground(new Color(34, 255, 0, 255));
        //Boarder color
        myToken.setBorder(BorderFactory.createLineBorder(new Color(101, 97, 89)));
        SetToken.setBorder(BorderFactory.createLineBorder(new Color(101, 97, 89)));
        BackToChat.setBorder(BorderFactory.createLineBorder(new Color(101, 97, 89)));



        this.setBackground(new Color(31, 31, 31, 255));



        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

//      layout MGR settings || GridBagConstraints
        c.gridheight = 10;
        //Add objects
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        this.add(label1[0], c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        this.add(BackToChat, c);
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        JLabel l1 = new JLabel("  Enter your token (8 characters long):");
        l1.setForeground(new Color(34, 255, 0, 255));
        this.add(l1, c);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 7;
        this.add(myToken, c);
        c.gridwidth = 2;
        c.gridx = 2;
        c.gridy = 15;
        this.add(SetToken, c);
        c.gridx =0;
        c.gridy =24;
        JLabel a = new JLabel("Enter your name: ");
        a.setForeground(new Color(34, 255, 0, 255));
        this.add(a , c);

                //Action listeners

        int defaultToken = 00012345;

        SetToken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                token = new StringBuilder(myToken.getText());

                if(token.length() < 8 || token.length() > 8){
                    token = new StringBuilder(defaultToken);

                }

                System.out.println(token);

            }
        });



        BackToChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                token = new StringBuilder(myToken.getText());

                if(token.length() < 8 || token.length() > 8){
                    token = new StringBuilder(defaultToken);
                }

                System.out.println(token);

                Main.panelChangerMethod(1);

            }
        });

        }

        }



