public class PCB2 {
    private Integer parent;
    private Integer child;
    private Integer younger_child;
    private Integer older_child;
    private Integer processID;
    
    public PCB2()
    {
        parent = null;
        child = null;
        younger_child = null;
        older_child = null;
    }
    
    public Integer getParent()
    {
        return parent;
    }
    
    public Integer getChild()
    {
        return child;
    }
    
    public Integer getYoungerChild()
    {
        return younger_child;
    }
    
    public Integer getOlderChild()
    {
        return older_child;
    }
    
    public Integer getID()
    {
        return processID;
    }
    
    public void setParent(Integer parent)
    {
        this.parent = parent;
    }
    
    public void setChild(Integer child)
    {
        this.child = child;
    }
    
    public void setYoungerChild(Integer younger_child)
    {
        this.younger_child = younger_child;
    }
    
    public void setOlderChild(Integer older_child)
    {
        this.older_child = older_child;
    }
    
    public void setID(Integer processID)
    {
        this.processID = processID;
    }
}
