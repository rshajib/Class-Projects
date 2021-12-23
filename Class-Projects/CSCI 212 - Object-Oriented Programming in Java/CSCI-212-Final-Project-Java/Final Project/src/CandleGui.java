
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


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

//END LIBRARY IMPORTS
public class CandleGui extends JFrame {

    private static final long serialVersionUID = 1L;

    public CandleGui(List<Candle> sortedCandle, List<Candle> unSortedCandle) {
        // TODO Auto-generated constructor stub
        GUI(sortedCandle, unSortedCandle);

    }

    private void GUI(List<Candle> sortedCandle, List<Candle> unSortedCandle) {
       // TODO Auto-generated method stub

        //Text field to display
        this.setSize(800, 800);
        this.setBackground(Color.RED);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea lblUnSorted = new JTextArea();
        lblUnSorted.setBackground(Color.LIGHT_GRAY);
        JTextArea lblSorted = new JTextArea();
        lblSorted.setBackground(Color.LIGHT_GRAY);

        StringBuffer sbUnSortedCandle = new StringBuffer();
        StringBuffer sbSortedCandle = new StringBuffer();

        //Add candles to text field
        for (int i = 0; i < sortedCandle.size(); i++) {
            sbUnSortedCandle.append(unSortedCandle.get(i).toString() + "\n");
            sbSortedCandle.append(sortedCandle.get(i).toString() + "\n");

        }
        lblUnSorted.setText(sbUnSortedCandle.toString());
        lblSorted.setText(sbSortedCandle.toString());

        //Define layout
        GridLayout layout = new GridLayout(1, 2);

        layout.setHgap(10);
        layout.setVgap(10);
        this.setLayout(layout);
        this.add(lblUnSorted);
        this.add(lblSorted);
        this.setVisible(true);

        // Create borders
        Border empty = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        CompoundBorder line = new CompoundBorder(empty, blackLine);
        Border grid1Border = BorderFactory.createTitledBorder(line, "Sorted Data");
        ((TitledBorder) grid1Border).setTitleFont(new Font("Arial", Font.ITALIC, 20));
        Border grid2Border = BorderFactory.createTitledBorder(line, "Unsorted Data");
        ((TitledBorder) grid2Border).setTitleFont(new Font("Arial", Font.ITALIC, 20));
        lblSorted.setBorder(grid2Border);
        lblUnSorted.setBorder(grid1Border);

        this.setTitle("Project2: Candle Information List");
        this.getContentPane().add(lblSorted);
        this.getContentPane().add(lblUnSorted);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
