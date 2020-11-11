public abstract class User
{
    private String uName;
    private String uEmail;
    
    //constructor
    public User(String uName, String uEmail)
    {
        this.uName = uName;
        this.uEmail = uEmail;
    }
    
    //getters
    public String getUname() {return uName;}
    public String getUemail() {return uEmail;}
    
    //setters
    public void setUname(String n) {this.uName = n;}
    public void setUemail(String e) {this.uEmail = e;}
}
