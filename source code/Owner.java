public class Owner extends User
{
    private boolean isAdmin;
    
    //constructor
    public Owner(String uName, String uEmail)
    {
        super(uName, uEmail);
        isAdmin = true;
    }
    
    //getters
    public boolean getAdmin() { return isAdmin;}
}