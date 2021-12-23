

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

public class EditMenuHandler implements ActionListener {

    JFrame jframe;

    public EditMenuHandler(JFrame jf) {
        jframe = jf;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Search")) {
            String price = JOptionPane.showInputDialog(null, "Enter Candle Price");

            try {
                if(Project3.pr != null){
                float candlePrice = Float.parseFloat(price);
                Project3.pr.showCandles(candlePrice);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please upload the text file first");
                }
                //handles invalid input for price
            } catch (NumberFormatException nfe) { 
                JOptionPane.showMessageDialog(null, "Invalid price");
            }

        }
    } //actionPerformed
}
