
package server1;
import java.io.*;
import java.net.*;

public class Server1 {

    
    public static void main(String[] args) throws Exception {
      String sentence,newsentence;
      int n;
      char c;
      char[] carray=new char[100];
      int key=1;
      ServerSocket ss = new ServerSocket(6789);
      while(true)
      {
       Socket s=ss.accept();
       System.out.println("ENCRYPTED CHAT");
       System.out.println("from the user "+s);
       DataInputStream mesclient=new DataInputStream(System.in);
       DataInputStream inFromclient=new DataInputStream(s.getInputStream());
       DataOutputStream outToclient=new DataOutputStream(s.getOutputStream());
       while(true)
       {
       sentence=inFromclient.readLine();   
    
     for(int i=0;i<sentence.length();i++)
     {
         c=sentence.charAt(i);
         n=c;
         n=n-key;
         carray[i]=(char)n;
         
     }
     sentence=new String(carray);
      System.out.println(sentence);
      
      
      System.out.println("your chat:\n");
      sentence=mesclient.readLine();
      
     for(int i=0;i<sentence.length();i++)
     {
         c=sentence.charAt(i);
         n=c;
         n=n+key;
         carray[i]=(char)n;
         
     }
     sentence=new String(carray);
       outToclient.writeBytes(sentence+'\n');
      
       
    }
    }
    }
}
    