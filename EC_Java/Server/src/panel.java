import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class panel extends JPanel {
    public static boolean on;
    public static String consoleTXT = "";
    public static JTextArea console = new JTextArea();
    public static JTextField port = new JTextField("6666");
    public static void sendCON(String MSG){
        consoleTXT = consoleTXT+"\r\n"+MSG;
        console.setText(consoleTXT);

    }

    public panel(){
        this.setBackground(Color.gray);
        JButton start = new JButton("start");
        JButton close = new JButton("close");
        JButton restart = new JButton("restart");
        start.setBackground(Color.gray);
        close.setBackground(Color.gray);
        restart.setBackground(Color.gray);
        console.setEditable(false);
        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane (console,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setAutoscrolls(true);
        console.setLineWrap(true);
        console.setWrapStyleWord(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipady = 30;
        c.gridx = 0;
        c.gridy = 0;
        this.add(start, c);
        c.gridx = 1;
        this.add(close, c);
        c.gridx = 2;
        this.add(restart, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 150;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(scroll, c);


        port.setBackground(Color.black);
        port.setForeground(Color.white);
        c.ipady = 10;       //reset to default
        c.gridwidth = 1;   //1 columns wide
        c.gridy = 2;       //third row
        this.add(port, c);
        c.gridx = 1;       //aligned with button 2
        this.add(new JLabel("port"), c);
        c.gridx = 2;       //aligned with button 2
        JButton send = new JButton("send");
        this.add(send, c);

        repaint();


        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Server started");
                sendCON("Started");

                        new Thread() {
                            public void run() {
                                try {
                                    GreetServer.start(Integer.parseInt(port.getText()));
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                        }.start();



            }
        });

        //(Atan) ignore errors its working... kinda
       close.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Thread() {
                    public void run() {
                System.out.println("Server closed");
                sendCON("Closed");
                on = false;
                try {
                    GreetServer.stop();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                    }
                }.start();
            }
        });

       //(Atan) ignore errors its working... kinda
        restart.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Thread() {
                    public void run() {
                consoleTXT = " ";
                console.setText("");
                System.out.println("Server restart");
                sendCON("Restarted");

                try {
                    GreetServer.stop();
                    GreetServer.start(6666);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                    }
                }.start();

            }
            });

        send.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        }
}


