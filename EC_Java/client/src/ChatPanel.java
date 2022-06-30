import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {


    private int width = 450;
    private int height = 600;
    public ChatPanel () {
        this.setBackground(new Color(100));
    }

    public void frameResized (int newWidth, int newHeight){
        int x = (int) (newWidth/4);
        this.width = (int) (newWidth/4) * 3;
        this.height = newHeight;
        this.setBounds(newWidth/4,0,width,height);
        this.repaint();
    }

}
