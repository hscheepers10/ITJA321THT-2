/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tht2q5;

import java.beans.Statement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author User
 */

public class Q5server {
    public static void main(String[]args) {
        try{
            
            ServerSocket serv = new ServerSocket(8000);
            Socket ser2 = serv.accept();
            System.out.println("Server is starting....");
            DataInputStream input = new DataInputStream(ser2.getInputStream());
            String inS = (String)input.readUTF();
            
            String rsName = inS;
            String rsType = inS;
            String rsPrice = inS;
            DataOutputStream output = new DataOutputStream(ser2.getOutputStream());
            
            String HostName = "localhost";
            String Db = "checkersproducts";
            String UserName = "root";
            String Password = "Captain@1945!";
            String URL = "jdbc:mysql://"+HostName+":3308/"+Db;
            
            try {
                Connection DbCon = DriverManager.getConnection(URL,UserName,Password);
                Statement Dbstmt = (Statement) DbCon.createStatement();
                String Query1 = "INSERT INTO products(prodName,prodType,prodPrice) "
                        + "VALUES('"+rsName+"','"+rsType+"','"+rsPrice+"')";
                int num = Dbstmt.executeUpdate(Query1);
                
                if(num == 1) {
                    output.writeUTF("Product updated!");
                    output.flush();
                }
                DbCon.close();
            } 
            catch (SQLException ex) {
                Logger.getLogger(Q5app.class.getName()).log(Level.SEVERE, null, ex);   
            }
            
            if(inS.equals("stop")) { 
                output.writeUTF("Server stopping....");
                serv.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
