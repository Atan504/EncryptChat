package EncryptChatClient;

import javax.swing.*;

public class frame extends JFrame {
    public frame(){
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.setTitle("EncryptChat 1.2.0");
            this.setResizable(true);
            this.setSize(300,600);
            panel panel = new panel();
            this.add(panel);
            panel.setVisible(true);
            this.setLocationRelativeTo(null);
            this.repaint();



    }
}
