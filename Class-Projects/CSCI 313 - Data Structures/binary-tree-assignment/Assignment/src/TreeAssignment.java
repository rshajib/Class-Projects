
//Redowan Shajib
  
import java.util.List;
import java.util.ArrayList;
import java.util.Random; 

public class TreeAssignment {
    public static void main(String args[]){
        List<Integer> list = randomList(3);
        System.out.println("Input List: " + list.toString());
        BinTree tree = new BinTree(list);
        System.out.println("Tree: \n" + tree);
       System.out.println("Sum "+ tree.totalSum());
       System.out.println("Height "+ tree.height());
       System.out.println("Range "+ tree.rangeOfTree());
       System.out.println("Smallest Node "+ tree.smallestNode().getData());
       System.out.println("Largest Node "+ tree.largestNode().getData());
       System.out.println("Average "+ tree.averageOfTree());
       System.out.println("Number of nodes "+ tree.numNodes());
       
       
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