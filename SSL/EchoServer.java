/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shreyash
 */
import javax.net.ssl.*;
import java.io.*;
public class EchoServer 
{
    public static void main(String[] arstring) 
    {
        try 
        {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            InputStream is = sslSocket.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isReader);
            String string = null;
            while ((string = br.readLine()) != null) 
            {
                System.out.println(string);
                System.out.flush();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

/* Note 

before compiling the server class we need to perform certain steps on the command prompt
1.)->keytool -genkey -KeyStore mykey -keyalg RSA
fill in the details which are required 
now compile the server classs
after compiling the Server class follwing steps are to be performed 

java -Djavax.net.ssl.keyStore=mykey -Djavax.net.ssl.keyStorePassword=123456 followed by the class name i.e EchoServer
password must be same which you entered during the details asked. 

*/