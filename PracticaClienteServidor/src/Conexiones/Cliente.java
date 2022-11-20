/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author axelm
 */
public class Cliente {
    public static void main(String[] args)throws IOException{
        Socket s = new Socket("localhost",4999);
        
        Scanner teclado=new Scanner(System.in);
        String msg=null;
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        try{                    
             do{                
                 msg=teclado.nextLine();
                 pr.println(msg);   
                 pr.flush();
                 
                 InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
        
                String str = bf.readLine();
                System.out.println("Servidor: "+ str);
               }while(msg.compareTo("exit")!=0);                       

            s.close();//Fin de la conexión
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
