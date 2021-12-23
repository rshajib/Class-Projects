

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


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//END LIBRARY IMPORTS
public class Project2 {

    List<Candle> unSortedCandle, sortedCandle;

    public Project2(File file) throws FileNotFoundException {

        int height, width;
        float price;

        //Read File
        Scanner fileReader = new Scanner(file);

        //Create LinkedList for unsorted and sorted car informations
        unSortedCandle = new LinkedList<>();
        sortedCandle = new LinkedList<>();

        // tokenize informations
        while (fileReader.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(fileReader.nextLine(), ",");
            if (token.countTokens() != 3) {

                if (token.countTokens() == 1) {
                    System.out.println("Invalid tokens: " + token.nextToken());
                } else {
                    System.out.println("Invalid tokens: " + token.nextToken() + "," + token.nextToken());
                }
            } else {
                height = Integer.parseInt(token.nextToken());
                width = Integer.parseInt(token.nextToken());
                price = Float.parseFloat(token.nextToken());

                //instantiate Candle object and add in LinkList
                Candle candle = new Candle(height, width, price);
                unSortedCandle.add(candle);
                sortedCandle.add(candle);

            }
        }

        // sortCandle will sort candle data according to price
        sortCandle(sortedCandle);
        new CandleGui(unSortedCandle, sortedCandle);
        fileReader.close();
    }

    public void showCandles(float price) {
        sortCandle(sortedCandle);
        List<Candle> unSortedCandleRange, sortedCandleRange;
        unSortedCandleRange = new LinkedList<>();
        sortedCandleRange = new LinkedList<>();

        for (int i = 0; i < sortedCandle.size(); i++) {
            if (sortedCandle.get(i).getPrice() <= price) {
                sortedCandleRange.add(sortedCandle.get(i));
            }
        }
        for (int i = 0; i < unSortedCandle.size(); i++) {
            if (unSortedCandle.get(i).getPrice() <= price) {
                unSortedCandleRange.add(unSortedCandle.get(i));
            }
        }

        new CandleGui(unSortedCandleRange, sortedCandleRange);
    }

    private static void sortCandle(List<Candle> sortedCandle) {
        for (int i = 0; i < sortedCandle.size() - 1; i++) {
//Find minimum element
            int min = i;
            for (int j = i + 1; j < sortedCandle.size(); j++) {
                if (sortedCandle.get(min).getPrice() > sortedCandle.get(j).getPrice()) {
                    min = j;
                }
            }

// Swap the minimum element with the first element
            Candle cd = sortedCandle.get(i);
            sortedCandle.set(i, sortedCandle.get(min));
            sortedCandle.set(min, cd);
        }

    }
}
