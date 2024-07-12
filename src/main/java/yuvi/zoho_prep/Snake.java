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
    
    Snake(int row,int col)
    {
        snakeboard = new char[row][col];
        for(char[] ch : snakeboard)
        {
            Arrays.fill(ch,'O');
        }

        q.add(new Node(0,0));
        
        this.snakeboard[2][3]='X';
        this.snakeboard[3][1]='X';
        this.snakeboard[4][4]='X';
        this.snakeboard[5][2]='X';
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
            snakeboard[row][col]='.';
            
            while(!q.isEmpty())
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
                
                if(row<0 || row>=snakeboard.length || col<0 || col>=snakeboard[0].length)
                {
                    System.out.println("Invalid Move");
                    continue;
                }
                snakemove(row,col);
            }
        }
        else
        {
            System.out.println("Invalid Move");
            System.exit(0);
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
