/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package yuva.chatapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yuvanesh
 */
public class ChatApplication {

    private ArrayList<User> users;
    private ArrayList<Group> groups;
    
    public ChatApplication()
    {
        users = new ArrayList<>();
        groups = new ArrayList<>();
    }
    
    //User Registration
    public void register(String username)
    { 
            users.add(new User(username,false));
    }
  
    //getuser obj
    public User getUserbyName(String username)
    {
        for(User u : users )
        {
            if(u.getUsername().equals(username))
            {
                return u;
            }
        }
        return null;
    }
    
    //get group obj
    public Group getGroupbyName(String groupname)
    {
        for(Group g : groups )
        {
            if(g.getGroupname().equals(groupname))
            {
                return g;
            }
        }
        return null;
    }
    
   //Chat Application
  public void start()
  {
      Scanner sc= new Scanner(System.in);
      boolean loop = true;
      while(loop)
      {
          System.out.println("\n1. New User 2. Create Group 3. Send Message 4. View Message\n5.View Members 6. Add Members 7. Remove Member 8. Registered user\n9. View Groups 10. Exit");
          int n = sc.nextInt();
          sc.nextLine();
          if(n==1)
          {
              System.out.println("Enter username:");
              String username = sc.nextLine();
              
              register(username);
              
              System.out.println(username +"Registered Successfully");
          }
          else if(n==2)
          {
              System.out.println("Enter username:");
              String username = sc.nextLine();
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              
              User u = getUserbyName(username);
              u.setisAdmin(true);
              
              groups.add(new Group(u,groupname));
              
          }
          else if(n==3)
          {
              System.out.println("Enter Username:");
              String Username = sc.nextLine();
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              System.out.println("Enter your Message");
              String message = sc.nextLine();
              User mem = getUserbyName(Username);
              Group grp = getGroupbyName(groupname);
              if(groupname!=null){
                if(grp.members.contains(mem)){
                    grp.addmessage(Username +": "+message);
                }
                else
                {
                   System.out.println("Member not Exist");
                }
              }
              
          }
          else if(n==4)
          {
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              
              Group grp = getGroupbyName(groupname);
              
              if(grp!=null)
              {
                  for(String s : grp.viewmessages())
                  {
                      System.out.println(s);
                  }
              }
              
          }
          else if(n==5)
          {
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              
              Group grp = getGroupbyName(groupname);
              
              System.out.println("Groupname: "+grp.Groupname+" AdminName"+grp.Adminname);
              
              for(User members:grp.viewmembers())
              {
                  System.out.println(members.getUsername());
              }
              
          }
          else if(n==6)
          {
              System.out.println("Enter Adminname:");
              String Adminname = sc.nextLine();
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              System.out.println("Enter membername:");
              String membername = sc.nextLine();
              
//              User admin = getUserbyName(Adminname);
              User mem = getUserbyName(membername);
              Group grp = getGroupbyName(groupname);
              
              if(grp.Adminname.equals(Adminname) && grp!=null && mem!=null)
                   grp.addmembers(mem);
              
          }
          else if(n==7)
          {
              System.out.println("Enter Adminname:");
              String Adminname = sc.nextLine();
              System.out.println("Enter groupname:");
              String groupname = sc.nextLine();
              System.out.println("Enter membername:");
              String membername = sc.nextLine();

//              User admin = getUserbyName(Adminname);
              User mem = getUserbyName(membername);
              Group grp = getGroupbyName(groupname);
              
              if(grp.Adminname.equals(Adminname)  && grp!=null && mem!=null)
                    grp.removemember(mem);
          }
          else if(n==8)
          {
              for(User u : users)
              {
                  System.out.println(u.getUsername());
              } 
          }
           else if(n==9)
          {
              for(Group g : groups)
              {
                  System.out.println(g.Groupname);
              } 
          }
          else if(n==10)
          {
              System.exit(0);
          }
      }         
  }
   
    public static void main(String[] args) {
       ChatApplication app = new ChatApplication();
       app.start();
    }
    
}
