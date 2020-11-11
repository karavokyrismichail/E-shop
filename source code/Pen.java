public class Pen extends Item
{
    private String color;
    private double tipSize;
    
    //constructor
    public Pen(String iName, double iPrice, String iDescription,int iStock,int iId, String color, double tipSize)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.color = color;
        this.tipSize = tipSize;
    }
    
    //getters
    public String getColor() {return color;}
    public double getTipSize() {return tipSize;}
    
    //setters
    public void setColor(String c) {this.color = c;}
    public void setTipSize(double t) {this.tipSize = t;}
    
    //print the details of a product, overrides the abstract method in Item class
    public String getDetails()
    {
        return("Pen Color: " + getColor() + "\nPen Size: " + getTipSize());
    }
    
    //prints the category of product, overrides the abstract method in Item clas
    public String showClass()
    {
        return "Pen";
    }
}
