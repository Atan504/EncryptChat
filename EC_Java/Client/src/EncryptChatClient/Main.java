package EncryptChatClient;

import javax.swing.*;

public class Main {
        public static JPanel panels[] = new JPanel[2];
        public static void panelChangerMethod(int panelNum){
                frame.getContentPane().removeAll();
                frame.add(panels[panelNum]);
                frame.repaint();
        }
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        //TODO:
        // - Settings page
        // - add more encryptions
        // - make TCP between networks
        // - more user friendly UI
        // - Save people IPs and names
        // - I just want a bigger main :)


                //frame
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("EncryptChat 1.2.0");
            frame.setResizable(true);
            frame.setSize(390,600);
            panelChat panelChat = new panelChat();
            panelSet panelSet = new panelSet();
            panels[0] = panelChat;
            panels[1] = panelSet;
            frame.add(panels[0]);
            frame.setLocationRelativeTo(null);
            frame.repaint();



        }
}
