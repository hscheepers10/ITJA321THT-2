/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tht2q1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @author User
 */

public class Q1server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        Socket server1 = server.accept();
    }
}
