

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


import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FileMenuHandler implements ActionListener {

    JFrame jframe;
    
    public FileMenuHandler(JFrame jf) {
        jframe = jf;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            JFileChooser chooser = new JFileChooser("./");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            if (file != null) {
                try {
                 Project3.pr = new Project2(file);
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                }
            }
        } else if (menuName.equals("Quit")) {
            JOptionPane.showMessageDialog(null, "The program will terminate now");
            //exit program
            System.exit(0);
        }
    } //actionPerformed
}
