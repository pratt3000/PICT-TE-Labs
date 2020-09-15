import java.io.*;  
import java.net.*;  

public class Client {  
    void call_client() {  
    try{      
        Socket s=new Socket("localhost",6666); 
        DataInputStream din=new DataInputStream(s.getInputStream()); 
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String msgin="",msgout="";
        
        while(!msgin.equals("stop")){
            System.out.println("---- HELP ----");
            System.out.println("1. Contact Info");
            System.out.println("2. About");
            System.out.println("3. FAQs");
            System.out.println("4. go back to Main menu");
            msgout = br.readLine();
            dout.writeUTF(msgout);
            msgin = din.readUTF();
            System.out.println(msgin);
        }

        dout.flush();  
        dout.close();  
        s.close();  
        }catch(Exception e){System.out.println("--quitting server");}  
    }  
}  