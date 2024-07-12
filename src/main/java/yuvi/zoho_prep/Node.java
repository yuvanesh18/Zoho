
package yuvi.zoho_prep;

public class Node {
    
    private int row;
    private int col;
    Node(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
    
    public int getrow()
    {
        return row;
    }
    
    public int getcol()
    {
        return col;
    }
}
