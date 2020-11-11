public class Pencil extends Item
{
    private double tipSize;
    private String type;
    
    //constructor
    public Pencil(String iName, double iPrice, String iDescription, int iStock, int iId, double s, String t)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.tipSize = s;
        if (t == "H" || t == "B" || t == "HB")
        {
            this.type = t;
        }
    }
    
    //getters
    public double getTipSize() {return tipSize;}
    public String getType() {return type;}
    
    //setters
    public void setTipSize(double t) {this.tipSize = t;}
    public void setType(String t)
    {
        if (t == "H" || t == "B" || t == "HB")
        {
            this.type = t;
        }
    }
    
    //print the details of a product, overrides the abstract method in Item class
    public String getDetails()
    {
        return("Pencil Size: " + getTipSize());
    }
    
    //prints the category of product, overrides the abstract method in Item clas
    public String showClass()
    {
        return "Pencil";
    }
}
