/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author axelm
 */
public class Servidor {
    public static void main(String[] args)throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();
        
        System.out.println("Cliente conectado");
        
        
        
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        Scanner teclado=new Scanner(System.in);
        String msg=null;
        try{                    
             do{            
                 InputStreamReader in = new InputStreamReader(s.getInputStream());
                 BufferedReader bf = new BufferedReader(in);
        
                String str = bf.readLine();
                System.out.println("Cliente: "+ str);
                 
                 msg=teclado.nextLine();
                 pr.println(msg);   
                 pr.flush();
               }while(msg.compareTo("exit")!=0);                       

            s.close();//Fin de la conexión
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
