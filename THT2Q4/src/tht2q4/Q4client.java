/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tht2q4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * @author User
 */
public class Q4client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 8000);
            DataInputStream input = new DataInputStream(client.getInputStream());
            //welcome input
            String inS = (String) input.readUTF();
            System.out.println(inS);
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            Scanner inScan = new Scanner(System.in);
            //2nd input
            System.out.println("Question from the server: " + inS);
            String in1 = inScan.nextLine();
            //1st output
            output.writeUTF(in1);
            if (in1 == "stop") {
                System.out.println("“Thank you for playing, Good bye!");
                client.close();
            }
            //3rd input
            System.out.println(inS);

        } catch (IOException ex) {

        }
    }

}
