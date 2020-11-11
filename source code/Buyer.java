import java.util.*;
 
public class Buyer extends User
{
    private double bonus;
    private String buyerCategory;
    private ShoppingCart sc;
    private static double FinalCcost = 0;
    private Scanner checkout = new Scanner (System.in);
    private String checkout_decision;
    
    //constructor
    public Buyer(String uName, String uEmail)
    { 
        super(uName, uEmail);
        bonus = 0;
        buyerCategory = "BRONZE";
        sc = new ShoppingCart();
    }
    
    //getters
    public double getBonus() {return bonus;}
    public String getBuyerCategory() {return buyerCategory;}
    //setters
    public ShoppingCart getShoppingCart() {return  sc;}
    public void setBonus(double b) {this.bonus = b;}
    
    //set Category
    public void setBuyerCategory(double b)
    {
        if (b < 100){
            this.buyerCategory = "BRONZE";
        }
        else if (b >= 100 && bonus < 200){
            this.buyerCategory = "SILVER";
        }
        else {
            this.buyerCategory = "GOLD";
        }
    }
    
    //Add to cart
    public void placeOrder(Item i, int q) 
    {
       sc.addItemOrdered(i, q);
    }
    
    //Courier Cost based on Buyer's Category
    public double FinalCourierCost(){
        if (getBuyerCategory() == "SILVER"){
            this.FinalCcost = (sc.calcluateCourierCost()/2);
        } else if (getBuyerCategory() == "GOLD") {
            this.FinalCcost = 0;
        } else{
            this.FinalCcost = sc.calcluateCourierCost();
        }
        return this.FinalCcost;
    }
    
    //print all items in cart, it's cost and courier cost
    public void FinalshowCart()
    {
        if (getShopingCartSize() > 0){
            sc.showCart();
            System.out.println("Net's Cost: " + sc.calculateNet() + " Courier Cost: " + FinalCourierCost());
        } else {
            System.out.println("Cart Is Empty");
        }
    }
    
    //get the size of shoping cart list
    public int getShopingCartSize()
    {
        return sc.getOrderListSize();
    }
    
    //checkout cart
    public void checkout()
    {
        FinalshowCart();
        if (getShopingCartSize() > 0){
            System.out.println("Do you wish to finish your checkout? :  y/n");
            checkout_decision = checkout.nextLine();
            switch(checkout_decision) {
                case "y":
                    setBonus(getBonus() + ((sc.calculateNet() * 10) / 100));
                    sc.CheckoutClearCart();
                    setBuyerCategory(getBonus());
                    System.out.println("Checkout Succesed!");
                    break;
                case"n":
                    break;
            }
        }
    }
    
    //get an item of orderList by its position
    public ItemOrdered FindItemInCart(int i)
    {
        return sc.FindItemOrdered(i);
    }
    
    //removes an item from cart
    public void RemoveItemFromCart(ItemOrdered io)
    {
        sc.removeItemOrdered(io);
    }
    
    //changes the quantity of an item in the cart
    public void ChangeQuantity(ItemOrdered i, int q)
    {
        sc.changeItemOrderedQuantity(i, q);
    }
    
    //remove all items from shopping cart
    public void clearSCart()
    {
        sc.clearCart();
    }
}
