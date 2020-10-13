import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
// Client class 
public class Client  
{ 
    static market_database_handling mdh = new market_database_handling();
    static account_handling acch = new account_handling();
    public static void main(String[] args) throws IOException  
    { 
        try
        { 
            Scanner scn = new Scanner(System.in); 
              
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 
      
            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056); 
      
            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

            int repeat =1;
            while(repeat==1){

                String user_name, password, password_chk;
                
                mdh.get_market_status();
                int new_acc = mdh.choose_login_options();
                String status = "";
                if(new_acc == 1){
                    while(status.equals("err:password") || status.equals("err:username") || status.equals("")){
                        System.out.println(status);
                        dos.writeUTF("old_user_login");
                        user_name = acch.take_username();
                        dos.writeUTF(user_name);
                        password = acch.take_password();
                        dos.writeUTF(password);
                        status = dis.readUTF();
                    }
                    mdh.display_respective_menu(status);                
                }
                else if(new_acc == 2){
                    while(status.equals("err:usernameExists") || status.equals("")){
                        dos.writeUTF("new_user_login");
                        user_name = acch.take_username();
                        dos.writeUTF(user_name);
                        
                        do{
                            password = acch.take_password();
                            System.out.print("REENTER ");
                            password_chk = acch.take_password();
                        }while(!password.equals(password_chk));
                        
                        System.out.println("Successfully created account");
                        dos.writeUTF(password);
                        status = dis.readUTF();
                    }
                    mdh.display_respective_menu("customer");
                }          
                repeat = mdh.continue_shopping();
            }   
            dos.writeUTF("terminate");     
              
            // closing resources 
            scn.close(); 
            dis.close(); 
            dos.close(); 
            s.close();
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        
    } 
}