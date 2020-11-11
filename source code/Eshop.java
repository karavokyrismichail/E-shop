import java.util.*;
public class Eshop
{
    private String eName;
    private Owner owner;
    private ArrayList<Item> itemList;
    private ArrayList<Buyer> buyerList;
    private ArrayList<String> categoryList;
    private ArrayList<Item> productList;
    private Buyer buyer;
    
    //constructor
    public Eshop (String eName, Owner owner)
    {
        this.eName = eName;
        this.owner = owner;
        itemList = new ArrayList<Item>();
        buyerList = new ArrayList<Buyer>();
        categoryList = new ArrayList<String>();
        productList = new ArrayList<Item>();
    }
    
    //getters
    public String getEname() {return eName;}
    
    //setters
    public void setEname(String en) {this.eName = en;}
    
    //adds an item in itemList
    public void addItem(Item i)
    {
        if (itemList.contains(i)){
            System.out.println("Item exists");
        }
        else{
            itemList.add(i);
        }
    }
    
    //removes an item from itemList
    public void removeItem(Item i)
    {
        itemList.remove(i);
    }
    
    //adds a Buyer in buyerList
    public void addBuyer(Buyer b)
    {
        if (buyerList.contains(b)){
            System.out.println("Buyer exists");
        }
        else{
            buyerList.add(b);
        }
    }
    
    //returns a Buyer from buyerList by giving his email
    public Buyer getBuyerBymail (String e)
    {
        for (Buyer b: buyerList)
        {
            if ((b.getUemail()).equals(e))
            {
               this.buyer = b;
            }
        }
        return this.buyer;
    }
    
    //returns true if buyer exists
    public boolean checkIfbuyerExists (String e)
    {
        for (Buyer b: buyerList)
        {
            if ((b.getUemail()).equals(e)) {
               return true;
            }
        }
        return false;
    }
    
    //removes a Buyer from buyerList
    public void removeBuyer(Buyer b)
    {
        buyerList.remove(b);
        System.out.println("Buyer Removed!");
    } 
    
    //Returns a buyer by it's position in buyerList
    public Buyer FindBuyer(int i)
    {
        return buyerList.get(i);
    }
    
    //Returns the size of buyerList
    public int getBuyerListSize()
    {
        return buyerList.size();
    }
    
    //gets an Item by Id
    public void getItemByID(int id)
    {
        for (Item i: itemList)
        {
            if (i.getiId() == id)
            {
               i.getInfo();
            }
        }
    }
    
    //updates Items Stock in store
    public void updateItemStock(Item i, int s)
    {
        i.setiStock(s);
    }
    
    //adds a brand in category List
    public void addCategory(String s)
    {
        if (categoryList.contains(s)){
            System.out.println("Item exists");
        }
        else{
            categoryList.add(s);
        }
    }
    
    //shows the categories 
    public void  showCategories()
    {
        for (int i = 0; i < categoryList.size(); i++) {
                System.out.println(i + ". " + categoryList.get(i));
            }    
    }
    
    //returns the size if categoryList
    public int getCatListSize()
    {
        return categoryList.size();
    }
    
    //returns a category by it's position in categoryList
    public String FindCategory(int i)
    {
        return categoryList.get(i);
    }
    
    //removes all items from productList
    public void clearProductList()
    {
        productList.clear();
    }
    
    //shows the products in a specific category
    public void showProductsInCategory(String c)
    {
        for (Item i: itemList)
        {
            if ((((Item)i).showClass()).equals(c))
            {
                productList.add(i);
            }
        }
        for (int j = 0; j < productList.size(); j++) {
                System.out.println(j + ". " + (productList.get(j)).getiName() + " | " + (productList.get(j)).getiDescription());
            }
    }
    
    //returns an Item by it's position in productList
    public Item FindProduct(int i)
    {
        return productList.get(i);
    }
    
    //shows all information about a product
    public void showProduct(Item i)
    {
        System.out.print(i);
    }
    
    //returns the size of productList
    public int getProListSize()
    {
        return productList.size();
    }
    
    //returns buyer's status
    public void checkStatus()
    {     
        for (int i = 0; i < buyerList.size(); i++) {
                System.out.println(i + ". " + (buyerList.get(i)).getUname() + ", " + (buyerList.get(i)).getUemail() + ", Bonus: " + (int)Math.round((buyerList.get(i)).getBonus()) + ", Category: " + (buyerList.get(i)).getBuyerCategory());
        } 
    }
}
