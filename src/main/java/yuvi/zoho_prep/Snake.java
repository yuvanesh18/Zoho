/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuvi.zoho_prep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Snake {
    private char[][] snakeboard = null;
    
    Queue <Node> q = new LinkedList<Node>();
    Queue <Node> food = new LinkedList<Node>();
    
    Snake(int row,int col)
    {
        snakeboard = new char[row][col];
        for(char[] ch : snakeboard)
        {
            Arrays.fill(ch,'O');
        }
        q.add(new Node(0,0));
        
        snakeboard[0][0]='.';
        
//        this.snakeboard[2][3]='X';
//        this.snakeboard[3][1]='X';
//        this.snakeboard[4][4]='X';
//        this.snakeboard[5][2]='X';
        food.add(new Node(2,3));
        food.add(new Node(3,1));
        food.add(new Node(4,4));
        food.add(new Node(5,2));
        
        displayfood();
    }
    
    public void startgame()
    {
        int row = 0,col=0;
        while(true)
        {
            Printsnakeboard();
            System.out.print("Enter You move: ");
            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
            switch (ch) {
                    case 'R':
                        ++col;
                        break;
                    case 'L':
                        --col;
                        break;
                    case 'U':
                        --row;
                        break;
                    case 'D':
                        ++row;
                        break;
                    default:
                        break;
                }
            if(!check(row,col))
            {
                if(ch=='R') --col;
                else if(ch=='L') ++col;
                else if(ch=='U') ++row;
                else if(ch=='D') --row;
                continue;
            }
            snakemove(row,col);
        }
    }
    
    public boolean check(int row, int col)
    {
        if(row<0 || row>=snakeboard.length || col<0 || col>=snakeboard[0].length)
                {
                    System.out.println("Invalid Move");
                    return false;
                }
        return true;
    }
    
    public void snakemove(int row,int col)
    {
        if(row>=0 && row<snakeboard.length && col>=0 && col<snakeboard[0].length)
        {
            if(snakeboard[row][col]=='.')
            {
                System.out.println("Game over");
                System.exit(0);
            }
            
            q.add(new Node(row,col));
            
            if(snakeboard[row][col]!='X') 
            {
                Node node = q.poll();
                int r = node.getrow();
                int c = node.getcol();
                snakeboard[r][c]='O';
            }
            else{
                snakeboard[row][col]='.';
                displayfood();
                
            }
             snakeboard[row][col]='.';  
        }
        else
        {
            System.out.println("Invalid Move");
            System.exit(0);
        }
    }
    public void displayfood()
    {
        
        if(!food.isEmpty())
        {
            Node node = food.poll();
            snakeboard[node.getrow()][node.getcol()]='X';
            Printsnakeboard();
            System.out.println(" ");
        }
    }
    public void Printsnakeboard()
    {
       for (char[] chars : snakeboard) {
            for (int j = 0; j < snakeboard[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}
