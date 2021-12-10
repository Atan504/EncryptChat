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
    public static int count = 0;
    public static String PortSTR;
    public static int PortInt;
	
    //Public objects
    public static JTextField IPTextField = new JTextField("IP here");
    //messages area
    public static JTextArea Textarea = new JTextArea();

    //send objects
    JButton sendBTN = new JButton("Send ->");
    JTextField MSGBox = new JTextField();
    public static String MSG = "";

    public panel() {
        //Objects
        MSGBox.setEditable(true);

        //Textarea conf
        Textarea.setEditable(false); 
        Textarea.setBackground(Color.WHITE);
        Textarea.setForeground(Color.BLACK);
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
        c.gridwidth = 1;
        c.ipady = 400;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 4;
        this.add(scroll, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 4;
        c.ipady = 10;
        c.gridy = 14;
        c.gridx = 0;
        this.add(MSGBox,c);
        c.gridwidth = 4;
        c.gridy = 14;
        c.gridx = 3;
        this.add(sendBTN,c);



        //panel config?

        this.setBackground(Color.gray);



        //Action listeners
        sendBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MyMSGSTR != null || MyMSGSTR != " ") {

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
                        client.sendMessage("1" + MyMSGSTR);
                    } catch (IOException ioException) {
                        System.out.println(ioException.getMessage());
                    }


                }else{
                    System.out.println("msg = null");
                }
            }
        });
        this.repaint();
    }

    //Console text:
    public static void ConText(String names, String MSG) {
        AllText = AllText + "\r\n" + names + ": " +MSG;
        Textarea.setText(AllText);
    }

}
