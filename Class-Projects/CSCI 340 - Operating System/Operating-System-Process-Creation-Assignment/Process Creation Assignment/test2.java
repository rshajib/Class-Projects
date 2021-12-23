public class test2 {
    private int processes_created = 0;
    private int number_of_processes = 10;
    private PCB2 process_table[] = new PCB2[number_of_processes];
    
    public test2()
    {
        PCB2 initialprocess = new PCB2();
        initialprocess.setID(0);
        
        process_table[processes_created] = initialprocess;
    }
    
    public void Create(Integer p)
    {
        PCB2 parent = process_table[p];
        
        processes_created++;
        PCB2 process = new PCB2();
        process.setParent(parent.getID());
        
        process.setID(processes_created);
        
        if(parent.getChild() == null)
        {
            parent.setChild(process.getID());
        }
        else
        {
            PCB2 tmp = process_table[parent.getChild()];
            while(tmp.getYoungerChild() != null)
            {
                tmp = process_table[tmp.getYoungerChild()];
            }
            process.setOlderChild(tmp.getID());
            tmp.setYoungerChild(process.getID());
        }
        
        process_table[processes_created] = process;
    }
    
    public void Destroy(Integer p)
    {
        if(p == null)
        {
            return;
        }
        PCB2 parent = process_table[p];
        if(parent != null)
        {
            if(parent.getChild() != null)
            {
                PCB2 tmp = process_table[parent.getChild()];
                while(tmp.getYoungerChild() != null)
                {
                    process_table[tmp.getID()] = null;
                    tmp = process_table[tmp.getYoungerChild()];
                    Destroy(tmp.getID());
                }
                process_table[tmp.getID()] = null;
            }
            process_table[p] = null;
            parent.setChild(null);
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
