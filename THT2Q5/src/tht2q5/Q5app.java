/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tht2q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Q5app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String nameR, typeR, priceR;

            Scanner in1 = new Scanner(System.in);
            System.out.println("Welcome to Checkers Stock Talking App");
            Socket client = new Socket("localhost", 8000);
            System.out.println("Enter Product Nsme: ");
            nameR = in1.nextLine();
            System.out.println("Enter Product Type: ");
            typeR = in1.nextLine();
            System.out.println("Enter Product Price: ");
            priceR = in1.nextLine();

            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(nameR);
            output.flush();
            output.writeUTF(typeR);
            output.flush();
            output.writeUTF(priceR);
            output.flush();
            DataInputStream input = new DataInputStream(client.getInputStream());
            String inS = (String) input.readUTF();
            System.out.println("Server says: " + inS);

            while (nameR.equals("stop")) {

                System.out.println("Enter Product Nsme: ");
                nameR = in1.nextLine();
                System.out.println("Enter Product Type: ");
                typeR = in1.nextLine();
                System.out.println("Enter Product Price: ");
                priceR = in1.nextLine();

                output.writeUTF(nameR);
                output.flush();
                output.writeUTF(typeR);
                output.flush();
                output.writeUTF(priceR);
                output.flush();

                inS = (String) input.readUTF();
                System.out.println("Server says: " + inS);
            }
            if (nameR.equals("stop")) {
                System.out.println("“Exiting Checkers Stock Taking App, Good bye!");
            }
        } catch (IOException ex) {

        }
    }

}
