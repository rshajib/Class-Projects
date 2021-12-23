
public class Assignment1 {    
        
    public static void main(String[] args) {
        
        long start1 = System.nanoTime();
        for(int i=0; i<1000; i++)
        {
            new test().testprocedure();
        }
        long end1 = System.nanoTime();
        System.out.println("Running Time of method1: " + (end1 - start1) + " nanoseconds");
        
        long start2 = System.nanoTime();
        for(int i=0; i<1000; i++)
        { 
            new test2().testprocedure();
        }
        long end2 = System.nanoTime();
        System.out.println("Running Time of method2: " + (end2 - start2) + " nanoseconds");
        
    }
}
