import java.util.*;

/**
 *
 * @author Admin
 */
public class PCB {
    private Integer parent;
    private Integer processID;
    private LinkedList<PCB> children;
        
    public PCB()
    {
        parent = null;
        processID = null;
        children = null;
    }
    
    public Integer getParent()
    {
        return parent;
    }
    
    public Integer getID()
    {
        return processID;
    }
    
    public LinkedList<PCB> getChildren()
    {
        return children;
    }
    
    public void setParent(Integer parent)
    {
        this.parent = parent;
    }
    
    public void setChildren(LinkedList<PCB> children)
    {
        this.children = children;
    }
    
    public void setID(Integer processID)
    {
        this.processID = processID;
    }
}
