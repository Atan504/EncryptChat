import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static JFrame frame = new JFrame(); //Frame
    public static JPanel[] panels = new JPanel[2]; //an array of all panels to switch between them easier
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        /*TODO
        *  - GUI
        *  - TCP - Get packets, Send Packets
        *  - Encryption & DeEncryption methods   */

        String a = "sus";
        String b = Encryption.encrypt(a,"melah","12345");

        System.out.println(a);
        System.out.println(b);
        System.out.println(Encryption.decrypt(b,"melah","Ea"));





//        //UI
//        //panels
//        HomePanel homepanel = new HomePanel();
//        ChatPanel chatpanel = new ChatPanel();
//        panels[0] = homepanel;
//        panels[1] = chatpanel;
//
//        //frame set
//        frame.add(panels[0]);
//        frame.setBounds(600,400,600,400);
//        frame.setVisible(true);
//        frame.setResizable(false);
//        frame.setTitle("EncryptChat 1.2.1");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.repaint();
//


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
