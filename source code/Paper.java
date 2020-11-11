public class Paper extends Item
{
    private int weight;
    private int pages;
    
    //constructor
    public Paper(String iName, double iPrice, String iDescription, int iStock, int iId, int weight, int pages)
    {
        super(iName, iPrice, iDescription, iStock, iId);
        this.weight = weight;
        this.pages = pages;
    }
    
    //getters
    public int getWeight() {return weight;}
    public int getPages() {return pages;}
    
    //setters
    public void setWeight(int w) {this.weight = w;}
    public void setPages(int p) {this.pages = p;}
    
    //print the details of a product, overrides the abstract method in Item class
    public String getDetails()
    {
        return("Paper Weight: " + getWeight() + " grams" + "\nPaper Pages: " + getPages());
    }
    
    //prints the category of product, overrides the abstract method in Item clas
    public String showClass()
    {
        return "Paper";
    }
}