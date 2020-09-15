import java.io.*;  
import java.net.*;  
public class Server {  
    public static void main(String[] args){  
        try{  
        ServerSocket ss=new ServerSocket(6666);  
        Socket s=ss.accept();//establishes connection 

        DataInputStream din=new DataInputStream(s.getInputStream()); 
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        String msgin="",msgout="";

        while(true){
            general gen = new general();
            msgin = din.readUTF();
            System.out.println("USER ENTERED: " + msgin);

            if(msgin.equals("1")){
                //contact
                msgout = gen.contact();
            }
            else if(msgin.equals("2")){
                // about
                msgout = gen.about();
            }
            else if(msgin.equals("3")){
                //FAQ
                msgout = gen.FAQ();
            }
            else{
                break;
            }
            
            dout.writeUTF(msgout);
            dout.flush();
        }
        ss.close();
        
        }catch(Exception e){System.out.println(e);}  
    }  
}  

