import java.util.*;
import java.io.*;
public class ShoppingCart
{
    private ArrayList<ItemOrdered> orderList;
    private static int check = 0;
    private static double Net = 0;
    private static double Ccost = 0;
    
    //constructor
    public ShoppingCart()
    {   
        orderList = new ArrayList<ItemOrdered>();
    }
    
    //adds an item in cart
    public void addItemOrdered(Item i, int q)
    {
        if (q <= i.getiStock()) {
            i.setiStock(i.getiStock() - q);
            for (ItemOrdered io : orderList) {
                if (io.getItem() == i) {
                    check = 1;
                    io.setQuantity(io.getQuantity() + q);
                }
            }
            if (check == 0) {
                orderList.add(new ItemOrdered(i, q));
            }
            check = 0;
        } else {
            System.out.println("There are less pieces in Stock!"); 
        }
    }
    
    //returns an item from its position in cart (orderList)
    public ItemOrdered FindItemOrdered(int i)
    {
        return orderList.get(i);
    }
    
    //removes an Item from cart (orderList) and updates the stock
    public void removeItemOrdered(ItemOrdered io)
    {
        (io.getItem()).setiStock((io.getItem()).getiStock() + io.getQuantity());
        orderList.remove(io);
    }
    
    //changes the quantity of an item in cart(orderList)
    public void changeItemOrderedQuantity(ItemOrdered io, int q)
    {
        if (q < io.getQuantity()){
            (io.getItem()).setiStock(io.getQuantity() + (io.getItem()).getiStock() - q);
            io.setQuantity(q);
            System.out.println("Quantity changed!\n");
        } else if (q > io.getQuantity()) {
            if ((q - io.getQuantity()) < (io.getItem()).getiStock()) {
                (io.getItem()).setiStock(io.getQuantity() + (io.getItem()).getiStock() - q);
                io.setQuantity(q);
                System.out.println("Quantity changed!\n");
            } else if ((q - io.getQuantity()) > (io.getItem()).getiStock()) {
                System.out.println("There are less pieces in Stock!");
            }
        }
    }
    
    //calls removeItemOrdered and clears the cart by updating the stock
    public void clearCart()
    {   
        for (int i = orderList.size() -1; i >= 0; i--) {
            removeItemOrdered(orderList.get(i));
        }
        if (orderList.size() == 0) {
            System.out.println("Cart cleared!");
        }
    }
    
    //calculates the cost of net
    public double calculateNet() 
    {
        this.Net = 0;
        for (ItemOrdered io : orderList) {
            this.Net = this.Net + ((io.getItem()).getiPrice() * io.getQuantity());
        }
        return this.Net;
    }
    
    //calculates courier cost based on net
    public double calcluateCourierCost()
    {
        this.Ccost = (calculateNet()*2)/100;
        if (this.Ccost < 3) {
            this.Ccost = 3;
        }
        return Ccost;
    }
    
    //returns the size of the cart
    public int getOrderListSize()
    {
        return orderList.size();
    }
    
    //shows the items in cart 
    public void showCart()
    {
            for (int i = 0; i < orderList.size(); i++) {
                    System.out.println(i + ". " + ((orderList.get(i)).getItem()).getiName() + " " + ((orderList.get(i)).getItem()).getiDescription() + " Price: " + ((orderList.get(i)).getItem()).getiPrice() + " Quantity: " +(orderList.get(i)).getQuantity());
            }
    }
    
    //clears the cart but DOESNT update stock
    public void CheckoutClearCart()
    {
       orderList.clear();
    }
}

