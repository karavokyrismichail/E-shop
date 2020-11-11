public class Notebook extends Item
{
    private int senctions;
    
    //constructor
    public Notebook(String iName, double iPrice, String iDescription, int iStock, int iId, int senctions)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.senctions = senctions;
    }
    
    //getters
    public int getSenctions() {return senctions;}
    
    //setters
    public void setSenctions(int s) {this.senctions = s;}
    
    //print the details of a product, overrides the abstract method in Item class
    public String getDetails()
    {
        return("Notebook senctions: " + getSenctions());
    }
    
    //prints the category of product, overrides the abstract method in Item clas
    public String showClass()
    {
        return "Notebook";
    }
}
