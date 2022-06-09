import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static JFrame frame = new JFrame(); //Frame
    public static JPanel[] panels = new JPanel[2]; //an array of all panels to switch between them easier
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        Message m = new Message("Me",formatter.format(date),"hello","abc");
        System.out.println(m.toString());
        m.fromString("someone|2022-06-09 at 16:05:04 EET|inaminasinamina|456");
        System.out.println(m.toString());


        /*TODO
        *  - GUI
        *  - TCP - Get packets, Send Packets
        *  - Encryption & DeEncryption methods   */


        //UI
        //panels
        HomePanel homepanel = new HomePanel();
        ChatPanel chatpanel = new ChatPanel();
        panels[0] = homepanel;
        panels[1] = chatpanel;

        //frame set
        frame.add(panels[0]);
        frame.setBounds(600,400,600,400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("EncryptChat 1.2.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.repaint();

        while(sc.nextInt() != 2){
            if(sc.nextInt() == 1){
                switchPanels(1);
            } else if (sc.nextInt() == 0) {
                switchPanels(0);
            }
        }


    }

    public static void switchPanels(int panelIndex){
        //switch the current panel with another by entering his index in the array.
        frame.getContentPane().removeAll();
        frame.add(panels[panelIndex]);
        frame.invalidate();
        frame.repaint();
        frame.validate();
    }
}
