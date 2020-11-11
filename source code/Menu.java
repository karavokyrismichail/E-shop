import java.util.*;
import  java.io.*;

public class Menu
{
    public static String readString() {
     byte b[] = new byte[32];
     String str;
    
     try {
         System.in.read(b);
         str = (new String(b)).trim();
         return str;
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
            return "";
        }
    }
    
    public static int readInt() {
     byte b[] = new byte[16];
     String str;
    
     try {
         System.in.read(b); 
         str = (new String(b)).trim();
         return Integer.parseInt(str);
        } catch (IOException e) {
            System.out.println("Exception: " + e.toString());
            return 0;
        } catch (NumberFormatException e) {
            System.out.println("Exception: " + e.toString() + "\nReturned value: -1");
            return -1;
        }
    }
    
    //method for buyer's menu choices
    public static void menuBuyerChoices()
    {
        System.out.println("How do you wish to continue? \n");
        System.out.println("1. Browse Store\n2. View Cart\n3. Checkout\n4. Logout\n5. Exit");
    }
    
    //method for owner's menu choices
    public static void menuOwnerChoices()
    {
        System.out.println("How do you wish to continue? \n");
        System.out.println("1. Browse Store\n2. Check Status\n3. Logout\n4. Exit");
    }
    
    //BUYER & OWNER - Browse Store - 1 - showCategories
    public static void SelectCategory(Eshop e)
    {
        System.out.println("Welcome to " + e.getEname() + "\n"); 
        System.out.println("Select a Category "); 
        e.showCategories();
    }
    
    //BUYER & OWNER - Browse Store - 1a - showProductsInCategory
    public static void SelectProduct(Eshop e, int c)
    {
        System.out.println("Select a Product: ");
        e.clearProductList();
        e.showProductsInCategory(e.FindCategory(c));
    }
                                    
    //BUYER - Browse Store - 1ai - menu method for adding an item in cart
    public static void addItemToCart(Eshop e, Buyer b, int i)
    {
        e.showProduct(e.FindProduct(i));
        System.out.println("\nAdd to cart? y/n :");
        String yn = readString();
        switch (yn){
            case "y":
                System.out.println("Enter the quantity: ");
                int qua = readInt();
                b.placeOrder(e.FindProduct(i), qua);
                break;
                                                    
            case "n":
                break;
        }
    }
    
    //BUYER - View Cart - 2 - menu method for showing buyers cart and choices
    public static void ViewCart(Buyer b)
    {
        b.FinalshowCart();
        System.out.println("=====================================================");
        System.out.println("Pick an Item to Remove it or to Update your Order.");
        System.out.println(b.getShopingCartSize() + ". Clear your Cart"); 
        System.out.println((b.getShopingCartSize() + 1) + ". Checkout"); 
    }
    
    //BUYER - View Cart - 2ai - menu method for removing or updating an item 
    public static void RemoveOrUpdate(int d, int c, Buyer b)
    {
        switch (d){
            case 1:
                b.RemoveItemFromCart(b.FindItemInCart(c));
                System.out.println("Item removed!\n");
                break;
                                                        
            case 2:
                System.out.println("Give the new Quantity: ");
                int Qua = readInt();
                if (Qua == 0){
                    b.RemoveItemFromCart(b.FindItemInCart(c));
                    System.out.println("Item removed!\n");
                } else {
                    b.ChangeQuantity(b.FindItemInCart(c), Qua);
                }
                break; 
        }
    }
    
    //OWNER - Browse Store - 1i - menu method for udating Item's Stock
    public static void OwnerUpdateStock(Eshop e, int p)
    {
        e.showProduct(e.FindProduct(p));
        System.out.println("\nUpdate Stock? y/n :");
        String yn = readString();
        switch (yn){
            case "y":
                System.out.println("Enter new quantity: ");
                int qua = readInt();
                e.updateItemStock(e.FindProduct(p), qua);
                e.showProduct(e.FindProduct(p));
                break;
                                                
            case "n":
                break;
                                                                       
        }
    }
    
    //OWNER - Check Status - 2ai - menu method for removing a buyer from buyerList by owner
    public static void OwnerRemoveBuyer(Eshop e, int s)
    {
        (e.FindBuyer(s)).FinalshowCart();
        System.out.println("Do you wish to remove this buyer? y/n :");
        String yn = readString();
        switch (yn){
            case "y":
               (e.FindBuyer(s)).clearSCart();
                e.removeBuyer(e.FindBuyer(s));
                break;
                                                    
            case "n":
                break;
                                                                           
        }
    }
            
    //menu method for registration
    public static void Registration(Eshop e)
    {
        System.out.println("Your email doesn't exist, Do you wish to register? | y/n");
        String register = readString();
                        
        switch(register) {
            case "y": 
               System.out.print("\nEnter your name: ");
               String newName = readString();
               System.out.print("\nEnter your email: ");
               String newEmail = readString();
               while (e.checkIfbuyerExists(newEmail)){
                    System.out.println("This e-mail is taken, give an other e-mail:");
                    newEmail = readString();
                }
               Buyer b = new Buyer("", "");
               b.setUname(newName);
               b.setUemail(newEmail);
               e.addBuyer(b);
               Buyer buyer = e.getBuyerBymail(newEmail);
               System.out.println("\nRegistration Succeded! " + buyer.getUname() + ", Bonus: " + buyer.getBonus() + ", Category: " + buyer.getBuyerCategory());
               break;
               
           case"n":
               break;    
        }
    }
    
    //main
    static void main(String[] args) {
        
        Scanner Scan = new Scanner(System.in);
        int buyer_choice = 0;
        int owner_choice = 0;
        int cat = 0;
        int pro = 0;
        int cart = 0;
        int status = 0;
        String email;
        String yn;
        
        //creation of Owner
        Owner owner1 = new Owner("Mixalis", "Mixalis@ceid.upatras.gr");
        
        //creation of Items
        Pencil pencil1 = new Pencil("Faber-Castell", 0.70, "Green", 30, 9000, 0.2, "H");
        Pencil pencil2 = new Pencil("Faber-Castell", 0.90, "Sparkle, Gray", 40, 118202, 0.7, "B");
        Pencil pencil3 = new Pencil("Faber-Castell", 0.65, "Grip, pink", 50, 2001, 0.5, "HB");
        
        Pen pen1 = new Pen("Pilot", 1.17, "Super Grip Ballpoint", 20, 2028003, "blue", 0.5);
        Pen pen2 = new Pen("Parker", 18.96, "Jotter Ballpoint Architecture Special Edition", 10, 2025828, "red", 0.7);
        Pen pen3 = new Pen("Bic", 0.16, "Cristal Ballpoint", 60, 847897, "black", 1.0);
        
        Notebook notebook1 = new Notebook("Salko Paper", 1.70, "Colorline", 25, 7858, 3);
        Notebook notebook2 = new Notebook("Skag University", 3.05, "Laminated ", 20, 231909, 4);
        Notebook notebook3 = new Notebook("Typotrust", 4.2, "Academy  ", 15, 4535, 5);
        
        Paper paper1 = new Paper("Arches",22.5 ,"Oil, Fine Grain, White, 23cm x 31cm", 4, 162328, 300, 12);   
        Paper paper2 = new Paper("Strathmore", 27.90,"Series 500 Writing Journals", 13, 9200954, 500, 160);
        Paper paper3 = new Paper("Winsor & Newton",88.11 ,"Professional Water Colour Block - Cold Press", 5, 6663262, 300, 20); 
        
        //creation of Buyers
        Buyer buyer1 = new Buyer("Agis", "Agis@ceid.upatras.gr");
        Buyer buyer2 = new Buyer("Makis", "Makis@ceid.upatras.gr");
        
        //creation of E-Shop
        Eshop eshop1 = new Eshop("RoyalBJ", owner1); 
        
        //add Items in the shop 
        eshop1.addItem(pencil1);
        eshop1.addItem(pencil2);
        eshop1.addItem(pencil3);
        eshop1.addItem(pen1);
        eshop1.addItem(pen2);
        eshop1.addItem(pen3);
        eshop1.addItem(notebook1);
        eshop1.addItem(notebook2);
        eshop1.addItem(notebook3);
        eshop1.addItem(paper1);
        eshop1.addItem(paper2);
        eshop1.addItem(paper3);
            
        //add buyers in the shop
        eshop1.addBuyer(buyer1);
        eshop1.addBuyer(buyer2);
        
        //add brands in brandsList
        eshop1.addCategory("Pencil");
        eshop1.addCategory("Pen");
        eshop1.addCategory("Notebook");
        eshop1.addCategory("Paper");
       
        //filling buyer's carts
        buyer1.placeOrder(paper2, 3);
        buyer1.placeOrder(notebook3, 4);
        buyer1.placeOrder(pen3, 5);
        
        buyer2.placeOrder(notebook2, 7);
        buyer2.placeOrder(pen3, 2);
        buyer2.placeOrder(pen1, 1);
        buyer2.placeOrder(pencil3, 20);
        
        //setting category and bonus to buyers
        buyer1.setBonus(199);
        buyer1.setBuyerCategory(buyer1.getBonus());
        
        buyer2.setBonus(98);
        buyer2.setBuyerCategory(buyer2.getBonus());
        
        
        //Menu
        System.out.println("Give your e-mail:");
        email = readString();
        System.out.println("---------------------------------------------------------------");
        while (buyer_choice != 5 && owner_choice != 4){
            /////////////////////////////////////BUYER/////////////////////////////////////////
            if (eshop1.checkIfbuyerExists(email) && buyer_choice != 5) {
                Buyer buyer = eshop1.getBuyerBymail(email);
                System.out.println("\nHello Buyer: " + buyer.getUname() + ", Bonus: " + (int)Math.round(buyer.getBonus()) + ", Category: " + buyer.getBuyerCategory());
                menuBuyerChoices();
                buyer_choice = readInt();
                while (buyer_choice != 4 && buyer_choice != 5){
                    switch (buyer_choice)
                    {
                        case 1:
                            while (cat != eshop1.getCatListSize()){
                                System.out.println("---------------------------------------------------------------");
                                pro = 0;
                                SelectCategory(eshop1);
                                System.out.println(eshop1.getCatListSize() + ". Go Back"); 
                                cat = readInt();
                                if (cat < eshop1.getCatListSize()){
                                    System.out.println("---------------------------------------------------------------");
                                    SelectProduct(eshop1, cat);
                                    System.out.println(eshop1.getProListSize() + ". Go Back"); 
                                    pro = readInt();
                                    if (pro < eshop1.getProListSize()){
                                        System.out.println("---------------------------------------------------------------");
                                        addItemToCart(eshop1, buyer, pro);
                                    } 
                                }
                            }
                            break;
                                
                        case 2:
                            while (cart != (buyer.getShopingCartSize() + 2)){
                                if (buyer.getShopingCartSize() > 0){
                                    ViewCart(buyer);
                                    System.out.println((buyer.getShopingCartSize() + 2) + ". Go Back"); 
                                    cart = readInt();
                                    if (cart < buyer.getShopingCartSize()){
                                        System.out.println("---------------------------------------------------------------");
                                        System.out.println("1. Remove this Item");
                                        System.out.println("2. Update your Order");
                                        System.out.println("3. Go Back");
                                        int decision = readInt();
                                        System.out.println("---------------------------------------------------------------");
                                        if (decision !=3){
                                            RemoveOrUpdate(decision, cart, buyer);
                                        }
                                    } else if (cart == buyer.getShopingCartSize()) {
                                        System.out.println("---------------------------------------------------------------");
                                        buyer.clearSCart();
                                    } else if (cart == (buyer.getShopingCartSize() + 1)){
                                        System.out.println("---------------------------------------------------------------");
                                        buyer.checkout();
                                    }
                                } else { 
                                    System.out.println("Your Cart is Empty, Browse Store to Fill it!");
                                    cart = 4;
                                    break;
                                }
                            }
                            break;
                                
                        case 3:
                            buyer.checkout(); 
                            break;    
                    }
                    cat = 0;
                    cart = 0;
                    System.out.println("---------------------------------------------------------------");
                    menuBuyerChoices();
                    buyer_choice = readInt();
                } 
            }
            ////////////////////////////////////OWNER////////////////////////////////////////////////
            else if ((owner1.getUemail()).equals(email) && owner_choice != 4) {
                System.out.println("Hello " + owner1.getUname() + ", ADMIN: " + owner1.getAdmin());
                menuOwnerChoices();
                owner_choice = readInt();
                while (owner_choice != 3 && owner_choice != 4){
                    switch (owner_choice)
                    {
                        case 1:
                            while (cat != eshop1.getCatListSize()){
                                System.out.println("---------------------------------------------------------------");
                                pro = 0;
                                SelectCategory(eshop1);
                                System.out.println(eshop1.getCatListSize() + ". Go Back"); 
                                cat = readInt();
                                if (cat < eshop1.getCatListSize()){
                                    System.out.println("---------------------------------------------------------------");
                                    SelectProduct(eshop1, cat);
                                    System.out.println(eshop1.getProListSize() + ". Go Back"); 
                                    pro = readInt();
                                    if (pro < eshop1.getProListSize()){
                                        System.out.println("---------------------------------------------------------------");
                                        OwnerUpdateStock(eshop1, pro);
                                    }
                                }
                            }
                            break;
                                
                        case 2:
                            while (status != eshop1.getBuyerListSize()){
                                System.out.println("---------------------------------------------------------------");
                                eshop1.checkStatus();
                                System.out.println("\nSelect a Buyer to see his Cart");
                                System.out.println("Press " +  eshop1.getBuyerListSize() + " to Go Back");
                                status = readInt(); 
                                if (status < eshop1.getBuyerListSize()){
                                    System.out.println("---------------------------------------------------------------");
                                    OwnerRemoveBuyer(eshop1, status);
                                }
                            }
                            break;    
                    }
                    System.out.println("---------------------------------------------------------------");
                    cat = 0;
                    status = 0;
                    menuOwnerChoices();
                    owner_choice = readInt();
                } 
            }
            ////////////////////////////////////UNKNOWN//////////////////////////////////////////////////
            else if (buyer_choice != 5 && owner_choice != 4){
                Registration(eshop1);
            }
        
            if(buyer_choice != 5 && owner_choice != 4) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Do you wish to login? y/n");
                yn = readString();
                switch(yn){
                    case "y":
                        System.out.println("Give e-mail:");
                        email = readString();
                        break;
                      
                    case "n":
                        buyer_choice = 5;
                        break;
                }
            }
        }
    }
}
