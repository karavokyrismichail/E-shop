public abstract class Item
{
    private String iName;
    private double iPrice;
    private String iDescription;
    private int iStock;
    private int iId;
    
    //constructor
    public Item(String iName, double iPrice, String iDescription,int iStock,int iId)
    {
        this.iName = iName;
        this.iPrice = iPrice;
        this.iDescription = iDescription;
        this.iStock = iStock;
        this.iId = iId;
    }
    
    //getters
    public String getiName() {return iName;}
    public double getiPrice() {return iPrice;}
    public String getiDescription() {return iDescription;}
    public int getiStock() {return iStock;}
    public int getiId() {return iId;}
    
    //setters
    public void setiName(String n) { this.iName = n;}
    public void setiPrice(double p) {this.iPrice = p;}
    public void setiDescription(String d) {this.iDescription = d;}
    public void setiStock(int s) {this.iStock = s;}
    public void setiId(int i) {this.iId = i;}
    
    //prints information for an Item
    public String getInfo()
    {
        return("Product Name: " + getiName() + "\nProduct Price: " + getiPrice() + "\nProduct Description: " + getiDescription() + "\nProduct Stock: " + getiStock() + "\nProduct Id: " + getiId());
    }
    
    //abstract method that returns the details of an Item
    abstract String getDetails();
    
    //abstract method that shows the category of a product
    abstract String showClass();
    
    //prints all informations of an Item
    @Override
    public String toString()
    {
        return("Product Info:\n\n" + getInfo() + "\n\nProduct Details:\n\n" + getDetails());
    }
}
