// Redowan Shajib

import java.util.List;
import java.util.ArrayList;
import java.util.Random; 
import java.util.Collections;

public class PQAssignment {
    public static void main(String args[]){
        List<Integer> list = randomList(20);
        System.out.println("Unsorted Input List: " + list.toString());
        PQ priorityQueue = new PQ(15);
        Collections.sort(list);
        System.out.println("Sorted Input List: " + list.toString());

    }

    private static List<Integer> randomList(int size){
        final Random rng = new Random();
        List<Integer> list = new ArrayList<>(size);
        for(int i = 0; i< size; i++){
            list.add(rng.nextInt()%10);
        }
        return list;
    }
}
