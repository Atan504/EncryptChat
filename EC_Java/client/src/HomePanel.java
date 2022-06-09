import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel{
    //public panel objects
    public static JButton settingBTN = new JButton("Setting");
    public HomePanel () {
        //general settings
        this.setBackground(new Color(53, 50, 49));
        //grid layout
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        //add objects to panel


        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(settingBTN, c);

        JButton b = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        this.add(b, c);

        JButton a = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        this.add(a, c);

        JButton g = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        this.add(g, c);

    }
}
