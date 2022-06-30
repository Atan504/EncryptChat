import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Frame extends JFrame {

    private JPanel[] panels = new JPanel[3];
    private int currentPanel;
    private int widthP;
    private int heightP;

    public Frame(int width, int height){

        this.widthP = width;
        this.heightP = height;

        //panels
        HomePanel homepanel = new HomePanel();
        ChatPanel chatpanel = new ChatPanel();
        ScrollPanel scrollpanel = new ScrollPanel();
        panels[0] = homepanel;
        panels[1] = chatpanel;
        panels[2] = scrollpanel;

        this.setLayout(null);
        this.setBounds(0,0,width,height);
        this.setVisible(true);
        this.setResizable(true);
        this.setTitle("EncryptChat 1.2.1");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panels[2]);
        this.add(panels[0]);

        this.repaint();




        //check if the JFrame is resized
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                //set hew Height and Width variables
                widthP = getWidth();
                heightP = getHeight();


                scrollpanel.frameResized(widthP, heightP);
                if(getCurrentPanel() == 0){
                    homepanel.frameResized(widthP,heightP);
                }
                doRepaint();

            }
        });


    }
    public int getCurrentPanel() {return this.currentPanel; }


    private void doRepaint(){this.repaint();}

    public void switchPanels(int panelIndex){
        currentPanel = panelIndex;
        this.getContentPane().removeAll();
        this.add(panels[2]);
        this.add(panels[panelIndex]);
        this.invalidate();
        this.repaint();
        this.validate();
    }

}
