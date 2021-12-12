package EncryptChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class panel extends JPanel {

    //public variables
    public static String AllText;
    public static String MyMSGSTR = "";
    public static String names;
    public static String IP_PortSTR = "";
    public static String IPSTR = "";

    public static String PortSTR;
    public static int PortInt;
    //local variables
    Font font1 = new Font("",Font.PLAIN,20);
    Font fontIP = new Font("",Font.PLAIN,16);
	
    //Public objects
    public static JTextField IPTextField = new JTextField("IP here");
    //messages area
    public static JTextArea Textarea = new JTextArea();

    //send objects
    JButton sendBTN = new JButton("Send ->");
    JTextField MSGBox = new JTextField();
    public static String MSG = "";
    public panel() {
        //Object
        //colors for objects
        //fonts
        IPTextField.setFont(fontIP);
        MSGBox.setFont(font1);
        //Color Pallet https://coolors.co/558b59-426145-85ad87-1f1f1f-603c06-563910-eddfbf-ffedc2
            //background colors
            MSGBox.setEditable(true);
            MSGBox.setBackground(new Color(31, 31, 31, 255));
            sendBTN.setBackground(new Color(31, 31, 31, 255));
            IPTextField.setBackground(new Color(31, 31, 31, 255));
            MSGBox.setForeground(new Color(34, 255, 0, 255));
            sendBTN.setForeground(new Color(34, 255, 0, 255));
            IPTextField.setForeground(new Color(34, 255, 0, 255));
            this.setBackground(new Color(31, 31, 31, 255));
            //border color
                IPTextField.setBorder(BorderFactory.createLineBorder(new Color(101, 97, 89)));
                MSGBox.setBorder(BorderFactory.createLineBorder(new Color(101, 97, 89)));

        //Textarea conf
        Textarea.setEditable(false); 
        Textarea.setBackground(new Color(31, 31, 31, 255));
        Textarea.setForeground(new Color(34, 255, 0, 255));
        Textarea.setFont(new Font("Arial", Font.PLAIN, 14)); //font
        JScrollPane scroll = new JScrollPane (Textarea, //scroll Main.panel
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setAutoscrolls(true);
        Textarea.setLineWrap(true);
        Textarea.setWrapStyleWord(true);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Layout Manager
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        
        //Layout MGR settings || GridBagConstraints
        c.gridheight = 10;
        //Add objects
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 2;
        this.add(IPTextField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 0;
        c.ipady = 450;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 4;
        this.add(scroll, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;
        c.ipady = 20;
        c.gridy = 14;
        c.gridx = 0;
        this.add(MSGBox,c);
        c.gridwidth = 4;
        c.gridy = 15;
        c.gridx = 5;
        this.add(sendBTN,c);




        //Action listeners
        sendBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IP_PortSTR = IPTextField.getText();
                System.out.println(IP_PortSTR);
                MyMSGSTR = MSGBox.getText();
                ConText(names = "you", MyMSGSTR);

                MSGBox.setText("");
                IPTextField.setText(IPTextField.getText());

                //IP + PORT separate

                String[] arr = IP_PortSTR.split(":");
                IPSTR = arr[0];
                PortSTR = arr[1];
                PortInt = Integer.parseInt(arr[1]);
                System.out.println(IPSTR);
                System.out.println(PortInt);
                    //send func
                GreetClient client = new GreetClient();
                try {
                    client.startConnection(IPSTR, PortInt);
                    client.sendMessage("2" + MasterEncryption.MasterEncryption(1,2,3,4,5,MyMSGSTR));
                    System.out.println("Sent this String"+MasterEncryption.MasterEncryption(1,2,3,4,5,MyMSGSTR));
                } catch (IOException ioException) {
                    System.out.println(ioException.getMessage());
                }
            }
        });
        this.repaint();
    }

    //Console text:
    public static void ConText(String names, String MSG) {
        //adds the text to the panel.
        System.out.println("A new Message got into the textBoard");
        AllText = AllText + "\r\n" + names + ": " +MSG;
        Textarea.setText(AllText);
    }




}
