import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollPanel extends JPanel{

    private int width;
    private int height;

    public ScrollPanel(){
        try{
            width = Main.frame.getWidth() >> 2; //a present of the full screen
            height = Main.frame.getHeight();
        }catch (Exception e){
            //there was an error with this, so I surrounded it with try and catch
        }


        this.setBackground(new Color(100,100,100));

        System.out.println(width);
        System.out.println(height);
        if(width == 0){
            width = 150;
            height = 400;
        }

        this.setLayout(new GridLayout(1,6));
        JButton homeButton = new JButton("Home");
        this.add(homeButton);















        //Action listeners

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.switchPanels(0);
            }
        });

/**     b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("good");
            }
        });  */
    }
    public void frameResized (int newWidth, int newHeight){
        this.width = (int) (newWidth/4);
        this.height = newHeight;
        if(width > 250){
            width = 250;
        }
        this.setBounds(0,0,width,height);
        this.repaint();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


}
