import java.sql.*;
import java.util.*;


public class account_handling {
    static market_database_handling mdh = new market_database_handling();
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
                System.out.println("** username exists **");
                con.close();
                return true;
            }
        }catch(Exception e){System.out.println(e);}

        return true;
    }


    String new_user_login(String user_name, String password){
        if(username_already_exists(user_name)){
            return "err:usernameExists";
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            String updt = "insert into users values('"+user_name+ "','"+ password +"')";
            stmt.executeUpdate(updt);
            con.close();
            System.out.println("*** account created ***");
        }catch(Exception e){System.out.println(e);} 
        return "success";     
    }


    String take_username(){
        String user_name;
        System.out.println("Enter Username : ");
        user_name = in.nextLine();
        return user_name;
    }
    String take_password(){
        String password;
        System.out.println("Enter Password : ");
        password = in.nextLine();
        return password;
    }
    
    String old_user_login(String user_name,String password){
        
        String retrieved="";
        if(!username_already_exists(user_name)){
            return "err:username";
        }
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            String query = "select password from users where user_name='"+user_name+ "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            retrieved = rs.getString(1);
            con.close();

        }catch(Exception e){System.out.println(e);}

        if( !password.equals(retrieved) ){
            return "err:password";
        }
        
        System.out.println("** Successful login ***");
        if(user_name.equals("admin")){
            return "admin";
        }
        return "customer";
    }

}