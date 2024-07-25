/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuva.chatapplication;


public class User {
 
    private String UserName;
    private boolean isAdmin;
   
    public User(String username,boolean isAdmin) {
        this.UserName = username;
        this.isAdmin = isAdmin;        
    }
    
    public String getUsername()
    {
        return UserName;
    }
    
    public void setisAdmin(boolean isAdmin)
    {
        this.isAdmin=isAdmin;
    }
    public boolean getisAdmin()
    {
        return isAdmin;
    }
   
}
