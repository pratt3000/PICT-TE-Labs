import java.sql.*;
import java.util.*;

//import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Result;


public class account_handling {

    Scanner in = new Scanner(System.in);

    boolean username_already_exists(String user_name){
        String query = "select user_name from users where user_name='"+user_name+ "'";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()){
                con.close();
                return false;
                }
            else{
                System.out.println(" **username exists");
                con.close();
                return true;
            }
        }catch(Exception e){System.out.println(e);}

        return true;
    }
    void new_user_login(){
        String pass1, pass2,user_name;
        do{
            System.out.println("Username : ");
            user_name = in.nextLine();
        }while(username_already_exists(user_name));
        username_already_exists(user_name);

        do{
        System.out.println("Password : ");
        pass1 = in.nextLine();
        System.out.println("Re-enter Password : ");
        pass2 = in.nextLine();
        }while(!pass1.equals(pass2));

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            String updt = "insert into users values('"+user_name+ "','"+ pass1 +"')";
            stmt.executeUpdate(updt);
            con.close();
            System.out.println("***account created");
        }catch(Exception e){System.out.println(e);}      
    }

    boolean old_user_login(){
        
        String pass1, user_name;
        String retrieved="";
        do{
            System.out.println("Username : ");
            user_name = in.nextLine();
        }while(!username_already_exists(user_name));

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            String query = "select password from users where user_name='"+user_name+ "'";
            ResultSet rs = stmt.executeQuery(query);

            rs.next();
            retrieved = rs.getString(1);
            //System.out.println("test : ");
            //System.out.println(retrieved);
            con.close();

            
        }catch(Exception e){System.out.println(e);}
        String backup = retrieved;
        do{
            retrieved=backup;
            pass1="";
            System.out.println("Password : ");
            pass1 = in.nextLine();
            //in.nextLine();
            if( !pass1.equals(retrieved)){
                System.out.println("wrong pass");
                System.out.println("Try again? (1/0) : ");
                int opt = Integer.parseInt(in.nextLine());

                if(opt==0){
                    return false;
                }
                System.out.println("pass1 = "+pass1);
                System.out.println("r = "+retrieved);


            }
        }while(!pass1.equals(retrieved));

        System.out.println("**Successful login");
        return true;
    }

}