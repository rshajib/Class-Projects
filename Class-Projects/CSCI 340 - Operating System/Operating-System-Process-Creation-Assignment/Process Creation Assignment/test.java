import java.util.LinkedList;


/**
 *
 * @author Admin
 */
public class test {
    
    private int processes_created = 0;
    private int number_of_processes = 10;
    private PCB process_table[] = new PCB[number_of_processes]; 
    
    public test()
    {
        PCB initialprocess = new PCB();
        initialprocess.setID(0);
        
        process_table[processes_created] = initialprocess;
    }
    
    public void Create(Integer p)
    {
        PCB parent = process_table[p];
        
        processes_created++;
        PCB process = new PCB();
        process.setParent(parent.getID());
        
        process.setID(processes_created);
        
        LinkedList<PCB> children = parent.getChildren();
        if(children == null)
        {
            children = new LinkedList<PCB>();
        }
        children.addLast(process);
        parent.setChildren(children);
        
        process_table[processes_created] = process;
    }
    
    public void Destroy(Integer p)
    {
        if(p == null)
        {
            return;
        }
        PCB parent = process_table[p];
        if(parent.getChildren() != null)
        {
            int size = parent.getChildren().size();
            for(int i=0; i<size; i++)
            {
                Destroy(parent.getChildren().getFirst().getID());
                parent.getChildren().removeFirst();
            }
            process_table[p] = null;
        }
        else
        {
            process_table[p] = null;
        }
    }
    
    public void testprocedure()
    {
        Create(0);
        Create(0);
        Create(2);
        Create(0);
        Create(2);
        
        Destroy(0);
    }
}
