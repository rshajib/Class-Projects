
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

	
	
public class SortedCandleList extends CandleList{
	public SortedCandleList(){
		super();
	}

	public void add(Candle c){

		if(first == null){
			first = new CandleNode(c);
			last = new CandleNode(c);
			length++;
			return;
		}
			CandleNode newFirst = new CandleNode(c);
			CandleNode oldFirst = first;
			first = newFirst;
			first.next = oldFirst;
			length++;
			return;
	}

}




