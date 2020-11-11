public class ItemOrdered
{
    private Item item;
    private int quantity;
    
    //constructor
    public ItemOrdered(Item i, int q)
    {
        this.item = i;
        this.quantity = q;
    }
    
    //getters
    public Item getItem() {return item;}
    public int getQuantity() {return quantity;}
    
    //setters
    public void setItem(Item i) {this.item = i;}
    public void setQuantity(int q) {this.quantity = q;}
}
