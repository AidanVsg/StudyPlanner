package studyplanner.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.management.JMException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JPanel;
import java.util.Random;


/**
 *
 * @author aidan
 */
public class GanttChartView extends JFrame{

    public GanttChartView(){
        //TITLE
        setTitle("Gantt Chart");
        //MENU
//        JMenuBar menubar = new JMenuBar();
//        //MENU BUTTON
//        JMenu file = new JMenu("File");
//        JMenu help = new JMenu("Help");
//        file.setMnemonic(KeyEvent.VK_F);
//        //BUTTON ITEM
//        JMenuItem fileClose = new JMenuItem("Close");
//        fileClose.setMnemonic(KeyEvent.VK_C);
//        fileClose.setToolTipText("Exit application");
//        fileClose.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                System.exit(0);
//            }
//        });
//        JMenuItem helpAbout = new JMenuItem("About");
//        helpAbout.setToolTipText("About the application");
//        helpAbout.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent event){
//
//           }
//        });
//        //Add the item to button
//        file.add(fileClose);
//        //Add the button to menu
//        menubar.add(file);
//        //Sets up the menu
//        setJMenuBar(menubar);
//        //Frame options

        GChartComponents coms = new GChartComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(coms);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public class GChartComponents extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.blue);
            for (int i=0; i<=1000; i++) {
                Dimension size = getSize();
                Insets insets = getInsets();
                int w = size.width - insets.left - insets.right;
                int h = size.height - insets.top - insets.bottom;
                Random r = new Random();
                int x = Math.abs(r.nextInt()) % w;
                int y = Math.abs(r.nextInt()) % h;
                g2d.drawLine(x, y, x, y);
            }
        }
    }

}
