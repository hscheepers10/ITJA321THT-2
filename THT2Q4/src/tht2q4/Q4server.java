/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tht2q4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
 * @author User
 */
public class Q4server {

    public static void main(String[] args) {
        try {
            //attributes
            String inS = null;
            String result;
            int randNumTot = 0;
            String[] opers = {"+", "-", "/", "*"};
            Random rand = new Random();
            int randNum1 = rand.nextInt(10) + 1;
            int randNum2 = rand.nextInt(10) + 1;
            int num1 = randNum1;
            int num2 = randNum2;

            //server
            System.out.println("Server is starting....");
            ServerSocket serv = new ServerSocket(8000);
            Socket ser2 = serv.accept();
            DataOutputStream output = new DataOutputStream(ser2.getOutputStream());
            //1st output
            output.writeUTF("Welcome to Edureka Trivia Game");
            DataInputStream input = new DataInputStream(ser2.getInputStream());
            switch (pickOper(opers)) {
                case ("-"):
                    randNumTot = randNumTot + num1 - num2;
                    result = num1 + "-" + num2;
                    //2 output
                    output.writeUTF("What is " + result + " = " + randNumTot + "?");
                    //1st input
                    inS = (String) input.readUTF();
                    //3d output
                    if (inS == Integer.toString(randNumTot)) {
                        output.writeUTF("Welldone, that's correct!");
                    } else {
                        output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                    }
                    break;
                case ("+"):
                    randNumTot = randNumTot + num1 + num2;
                    result = num1 + "+" + num2;
                    //2 output
                    output.writeUTF("What is " + result + " = " + randNumTot + "?");
                    //1st input
                    inS = (String) input.readUTF();
                    //3d output
                    if (inS == Integer.toString(randNumTot)) {
                        output.writeUTF("Welldone, that's correct!");
                    } else {
                        output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                    }
                    break;
                case ("/"):
                    randNumTot = randNumTot + num1 / num2;
                    result = num1 + "/" + num2;
                    //2 output
                    output.writeUTF("What is " + result + " = " + randNumTot + "?");
                    //1st input
                    inS = (String) input.readUTF();
                    //3d output
                    if (inS == Integer.toString(randNumTot)) {
                        output.writeUTF("Welldone, that's correct!");
                    } else {
                        output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                    }
                    break;
                case ("*"):
                    randNumTot = randNumTot + num1 * num2;
                    result = num1 + "*" + num2;
                    //2 output
                    output.writeUTF("What is " + result + " = " + randNumTot + "?");
                    //1st input
                    inS = (String) input.readUTF();
                    //3d output
                    if (inS == Integer.toString(randNumTot)) {
                        output.writeUTF("Welldone, that's correct!");
                    } else {
                        output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                    }
                    break;
            }
            while (inS != "stop") {
                switch (pickOper(opers)) {
                    case ("-"):
                        randNumTot = randNumTot + num1 - num2;
                        result = num1 + "-" + num2;
                        //2 output
                        output.writeUTF("What is " + result + " = " + randNumTot + "?");
                        //1st input
                        inS = (String) input.readUTF();
                        //3d output
                        if (inS == Integer.toString(randNumTot)) {
                            output.writeUTF("Welldone, that's correct!");
                        } else {
                            output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                        }
                        break;
                    case ("+"):
                        randNumTot = randNumTot + num1 + num2;
                        result = num1 + "+" + num2;
                        //2 output
                        output.writeUTF("What is " + result + " = " + randNumTot + "?");
                        //1st input
                        inS = (String) input.readUTF();
                        //3d output
                        if (inS == Integer.toString(randNumTot)) {
                            output.writeUTF("Welldone, that's correct!");
                        } else {
                            output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                        }
                        break;
                    case ("/"):
                        randNumTot = randNumTot + num1 / num2;
                        result = num1 + "/" + num2;
                        //2 output
                        output.writeUTF("What is " + result + " = " + randNumTot + "?");
                        //1st input
                        inS = (String) input.readUTF();
                        //3d output
                        if (inS == Integer.toString(randNumTot)) {
                            output.writeUTF("Welldone, that's correct!");
                        } else {
                            output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                        }
                        break;
                    case ("*"):
                        randNumTot = randNumTot + num1 * num2;
                        result = num1 + "*" + num2;
                        //2 output
                        output.writeUTF("What is " + result + " = " + randNumTot + "?");
                        //1st input
                        inS = (String) input.readUTF();
                        //3d output
                        if (inS == Integer.toString(randNumTot)) {
                            output.writeUTF("Welldone, that's correct!");
                        } else {
                            output.writeUTF("Wrong answer! the correct answer is: " + randNumTot);
                        }
                        break;
                }
            }
            if (inS.equals("stop")) {
                serv.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Methods for randomising the operators
    public static String getOper(String[] arr) {
        Random rand2 = new Random();
        int get = rand2.nextInt(arr.length);
        return arr[get];
    }

    public static String pickOper(String[] opers) {
        String result = getOper(opers);
        return result;
    }
}
