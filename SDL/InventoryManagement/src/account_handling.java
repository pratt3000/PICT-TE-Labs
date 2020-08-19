import java.sql.*;
import java.util.*;


public class account_handling {

    Scanner in = new Scanner(System.in);

    void new_user_login(){
        String pass1, pass2;
        System.out.println("test");

        System.out.println("Username : ");
        String user_name = in.nextLine();

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
            stmt.executeUpdate("insert into users" + "values("+user_name+ ","+ pass1 +")");//error
            con.close();
            System.out.print("***account created");
        }catch(Exception e){System.out.println(e);}      //add if username already exists
    }

    boolean old_user_login(){
        System.out.println("Username : ");
        String user_name = in.nextLine();
        System.out.println("Password : ");
        String pass1 = in.nextLine();
        String retrieved="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select passwords from users where username='"+user_name+"'");
            retrieved = rs.getString(1);
            con.close();
        }catch(Exception e){System.out.println(e);}

        if( pass1.equals(retrieved)){
            System.out.println("**successful login");
            return true;
        }
        else{
            System.out.println("wrong pass");
            return false;
        }
    }

}