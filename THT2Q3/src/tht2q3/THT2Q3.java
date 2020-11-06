/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tht2q3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * @author User
 */

public class THT2Q3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[]args) {
        try {
            Socket client = new Socket("localhost",9000);
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF("Hi, I study ITJA321 at PIHE!");
            output.close();  
            client.close(); 
        }
        catch(IOException ex) {
        }
    }
}
