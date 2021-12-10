import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;

import static java.awt.Color.*;




public class Main {
    static int PortINT;
    public static boolean on;
    public static String consoleTXT = "";
    public static JTextArea console = new JTextArea();
    static String MSG;
    public String HB;
    public static void sendMSG(String MSG){
        consoleTXT = consoleTXT+"\r\n"+MSG;
        console.setText(consoleTXT);

    }

    public static void main(String[] args) throws IOException {



        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //IP Address text field
        JTextField IPtextfield = new JTextField("26.185.195.9");
        String IPaddress = IPtextfield.getText();
        //Port number text field
        JTextField Porttextfield = new JTextField("6666");

        String PortNUM = Porttextfield.getText();
        //IP and Port action listener + button
        JButton IP_Port_Taker = new JButton("Take IP and Port");
        //MESSAGE
        JTextField MSGtxt = new JTextField("Message here");
        JButton sendMSG = new JButton("Sand message");
        JButton exit = new JButton("EXIT");
        console.setEditable(false);
        console.setBackground(LIGHT_GRAY);
        console.setForeground(BLACK);
        console.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane (console,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton setupconnectionBTN = new JButton("Start setup connection");
        JLabel setupLabel = new JLabel("Setup Connection: ");

        setupLabel.setBackground(lightGray);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(IPtextfield, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridwidth = 2;
        c.gridy = 0;
        panel.add(Porttextfield, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 0;
        panel.add(IP_Port_Taker, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 3;
        c.gridwidth = 5;
        c.ipady = 150;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(scroll, c);
        c.ipady = 10;
        c.gridwidth = 4;
        c.gridy = 4;
        c.gridx = 1;
        panel.add(MSGtxt, c);
        c.ipady = 10;
        c.gridwidth = 1;
        c.gridy = 4;
        c.gridx = 5;
        panel.add(sendMSG, c);
        c.ipady = 10;
        c.gridwidth = 4;
        c.gridy = 5;
        c.gridx = 1;
        panel.add(setupLabel, c);
        c.ipady = 10;
        c.gridwidth = 3;
        c.gridy = 5;
        c.gridx = 5;
        panel.add(setupconnectionBTN, c);








        setupconnectionBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Thread() {
                    public void run() {
                        String systemipaddress = "";
                        String IPaddress = IPtextfield.getText();
                        String PortNUM = Porttextfield.getText();
                        PortINT=Integer.parseInt(PortNUM);
                        try
                        {
                            URL url_name = new URL("http://bot.whatismyipaddress.com/");

                            BufferedReader sc =
                                    new BufferedReader(new InputStreamReader(url_name.openStream()));

                            // reads system IPAddress
                            systemipaddress = sc.readLine().trim();
                        }
                        catch (Exception notworky)
                        {
                            systemipaddress = "Cannot Execute Properly";
                        }
                        try {
                            GreetClient client = new GreetClient();
                            client.startConnection(IPaddress,PortINT);
                            String response = client.sendMessage("2" + systemipaddress);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        System.out.println("your public IP Address: " + systemipaddress +"\n");

                    }
                }.start();

            }
        });









        IP_Port_Taker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IPaddress = IPtextfield.getText();
                String PortNUM = Porttextfield.getText();
                PortINT=Integer.parseInt(PortNUM);
                System.out.println(IPaddress +":" + PortNUM);

            }
        });


        sendMSG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IPaddress = IPtextfield.getText();
                String PortNUM = Porttextfield.getText();
                MSG = MSGtxt.getText();
                PortINT=Integer.parseInt(PortNUM);
                System.out.println("the message is: " + MSG);
                System.out.println("the IP address is: " + IPaddress +":" + PortINT);
                try {
                    SendMSG(IPaddress,PortINT,"1"+ MSG);
                } catch (IOException ioException) {
//                    System.out.println(ioException.getMessage());
                }


            }
        });


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });










        JFrame frame = new JFrame();
//        JLabel bgp = new JLabel();
//        bgp.setIcon(new ImageIcon());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 600);
        frame.setTitle("EncryptChat");
        frame.setResizable(true);
        frame.add(panel);
        panel.setVisible(true);
        frame.repaint();










    }

    public static void HB(String HB,String IP, int port) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection(IP,port);
        try{
            String response = client.sendMessage("9" + MSG);

        }catch(IOException ioException){

        }
    }
    public static void SendMSG(String IP,int port, String MSG) throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("localhost",18140);

        try{
            String response = client.sendMessage("1" + MSG);
            System.out.println(response);
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }



    }

}
