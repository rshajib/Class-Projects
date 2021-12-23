

    /**
                  * <b>Title:</b> Project_4:<br>
                  * <b>Filename:</b> project4.java<br>
                  * <b>Date Written:</b>  December 12, 2019<br>
                  * <b>Due Date:</b> December 12, 2019<br>
                  * <p>
                  * <b>Description:</b><br>
                  * Sorting an Array of Candles/ Displaying in a GUI/ searching candles 
                  * within given price
                  * </p>
                  * <p>
                  * The program will read necessary candle informations from a text file 
                  * </p>
                  
                 
                                 
                  *@author REDOWAN K SHAJIB
                  *@CUNY_ID 23622613
                  * CSCI 212 (Lab section 11F)
                  */


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Project3 extends JFrame{
  
	private static final long serialVersionUID = 1L;
public static Project3 myGUI; 
   public static Project2 pr;
   public static Project3 initiateGUI() {

      myGUI = new Project3();
      myGUI.setSize(600, 600);
      myGUI.setLocation(100, 100);
      myGUI.setLayout(new GridLayout(1, 2));
      myGUI.setTitle("Candle");
      myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
      JMenuBar menuBar = new JMenuBar();
      
      myGUI.createFileMenuBar(menuBar);
       
      myGUI.setVisible(true);
      return myGUI;
   }
   
   public void createFileMenuBar(JMenuBar menuBar) {
      // creates a file menuBar
      JMenuItem item1;
      JMenuItem item3;
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");

      FileMenuHandler fmh = new FileMenuHandler(this);
      item1 = new JMenuItem("Open");
      item1.addActionListener(fmh);
      fileMenu.add(item1);
      fileMenu.addSeparator();
      JMenuItem item2 = new JMenuItem("Quit");
      item2.addActionListener(fmh);
      fileMenu.add(item2);
      
        EditMenuHandler emh = new EditMenuHandler(this);
      item3 = new JMenuItem("Search");
      item3.addActionListener(emh);
      editMenu.add(item3);
      
      
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
   }
  
   public static void main(String[] args) {
      Project3.initiateGUI();
   } // close main
}