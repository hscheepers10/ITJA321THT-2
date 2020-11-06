/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tht2q2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @author User
 */

public class Q2server {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        try{
            System.out.println("Server is starting....");
            try (ServerSocket server1 = new ServerSocket(9000)) {
                Socket ser2 = server1.accept();
                DataInputStream input = new DataInputStream(ser2.getInputStream());
                String inS = (String)input.readUTF();
                System.out.println("\tMessage received from client : "+inS);
            }
        }
        catch(IOException ex){
        }
    }
}
