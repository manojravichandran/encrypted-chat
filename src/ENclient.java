
package client0;

import java.net.*;
import java.io.*;
public class Client0 {

    
    public static void main(String[] args) throws Exception {
         String sentence,nwsentence;
         char crypt[] = null;
         int i=0;
        DataInputStream infromuser = new DataInputStream(System.in);
       System.out.println("encrypted chat");
        Socket cs = new Socket("10.1.4.30",6789);
        DataInputStream infromserver = new DataInputStream(cs.getInputStream());
        DataOutputStream outtoserver = new DataOutputStream(cs.getOutputStream());
       int key=1;
       char c;
       int z=0;
       int cry =0;
       char[] carray=new char[10];
        while(true)
        {
      
           System.out.println("client message:");
        sentence = infromuser.readLine();
       
       for(i=0;i<sentence.length();i++)
       {
         c=sentence.charAt(i);
          z=c;
  
           z=z+key;
            
           carray[i]=(char) z;
            
        
           
            
        }
        
   
       
       sentence=(new String(carray));
        outtoserver.writeBytes(sentence+"\n");
        
       
        nwsentence = infromserver.readLine();
        
          for(i=0;i<nwsentence.length();i++)
       {
         c=nwsentence.charAt(i);
          z=c;
  
           z=z-key;
            
           carray[i]=(char) z;
            
        
           
            
        }
    
        nwsentence=new String(carray);
          
        
    
        System.out.println("From Server:"+nwsentence);
        
       
        }
        
        
       
    
    }
    
}
