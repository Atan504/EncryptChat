import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel{

    private int width = 450;
    private int height = 600;

    public HomePanel () {

        //objects


        //general settings
        this.setBackground(new Color(53, 50, 49));
        //grid layout
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new BorderLayout());
        //add objects
        JLabel name = new JLabel("EncryptChat");
        name.setForeground(new Color(84, 255, 0));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        Font serif = new Font("Onyx", Font.PLAIN, 42);
        name.setFont(serif);
        this.add((name), BorderLayout.NORTH);

        

        //Listeners


    }

    public void frameResized (int newWidth, int newHeight){
        int x = (int) (newWidth/4);
        this.width = (int) (newWidth/4) * 3;
        if(x > 250){
            x = 250;
            this.width = newWidth - 250;
        }
        this.height = newHeight;
        this.setBounds(x,0,width,height);
        this.repaint();
    }




}
