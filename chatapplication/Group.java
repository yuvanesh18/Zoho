/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuva.chatapplication;

import java.util.ArrayList;

/**
 *
 * @author Yuvanesh
 */
public class Group {
    ArrayList<User> members = new ArrayList<>();
    String Groupname ;
    String Adminname;
    ArrayList<String> Messages = new ArrayList<>();
    
    public Group(User u,String groupname)
    {
        this.members.add(u);
        this.Adminname=u.getUsername();
        this.Groupname=groupname;
    }
    
    
    public void addmembers(User u)
    {
        members.add(u);
    }
    public void removemember(User u)
    {
        members.remove(u);
    }
    public ArrayList<User> viewmembers()
    {
        return members;
    }
    
    public void addmessage(String message)
    {
        Messages.add(message);
    }
    public ArrayList<String> viewmessages()
    {
        return Messages;
    }
    
    public String getGroupname()
    {
        return Groupname;
    }

}
