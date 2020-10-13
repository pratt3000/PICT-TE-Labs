import java.io.*; 
import java.text.*; 
import java.net.*; 
  
// Server class 
public class Server  
{ 
    public static void main(String[] args) throws IOException  
    { 
        // server is listening on port 5056 
        ServerSocket ss = new ServerSocket(5056); 
          
        // running infinite loop for getting 
        // client request 
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                s = ss.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos); 
  
                // Invoking the start() method 
                t.start(); 
                  
            } 
            catch (Exception e){ 
                ss.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
  
// ClientHandler class 
class ClientHandler extends Thread  
{ 
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss"); 
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    market_database_handling mdh = new market_database_handling();
    account_handling acch = new account_handling();
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()  
    { 
        String received; 
        while (true)  
        { 
            try { 
                
                String user_name, password, status;
                received = dis.readUTF();

                switch (received) { 
                    case "old_user_login" : 
                        user_name = dis.readUTF();
                        password = dis.readUTF();
                        status = acch.old_user_login(user_name, password);
                        dos.writeUTF(status);
                        break; 
                          
                    case "new_user_login" : 
                        user_name = dis.readUTF();
                        password = dis.readUTF();
                        status = acch.new_user_login(user_name, password);
                        dos.writeUTF(status);
                        break; 
                          
                    default: 
                        dos.writeUTF("Breaking"); 
                        break; 
                } 
                if(received.equals("terminate")){
                    break;
                }
                mdh.pass_day();
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
    
} 