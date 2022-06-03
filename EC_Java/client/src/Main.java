import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame(); //Frame
    public static JPanel[] panels = new JPanel[1]; //an array of all panels to switch between them easier
    public static void main(String[] args) {
        /*TODO
        *  - GUI
        *  - TCP - Get packets, Send Packets
        *  - Encryption & DeEncryption methods   */


        //UI
        //panels
        HomePanel homepanel = new HomePanel();
        panels[0] = homepanel;

        //frame set
        frame.add(panels[0]);
        frame.setBounds(100,100,100,100);
        frame.setVisible(true);
        frame.setTitle("EncryptChat 1.2.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.repaint();
        
    }

    public static void switchPanels(int panelIndex){
        //switch the current panel with another by entering his index in the array.
        frame.getContentPane().removeAll();
        frame.add(panels[panelIndex]);
        frame.invalidate();
        frame.repaint();
    }
}
