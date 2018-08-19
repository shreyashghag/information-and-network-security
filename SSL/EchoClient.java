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
public class EchoClient 
{
    public static void main(String[] arstring) 
    {
        try 
        {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 9999);
            InputStream is = System.in;
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isReader);
            OutputStream os = sslSocket.getOutputStream();
            OutputStreamWriter osWriter = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osWriter);
            String string = null;
            while ((string = br.readLine()) != null) 
            {
                bw.write(string + '\n');
                bw.flush();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}

/* Note 
after compiling the Client class follwing steps are to be performed 

java -Djavax.net.ssl.trustStore=mykey -Djavax.net.ssl.trustStorePassword=123456 followed by the class name i.e EchoClient 

*/


