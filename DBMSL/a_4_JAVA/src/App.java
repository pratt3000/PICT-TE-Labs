import java.sql.*;


public class App {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from works");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
}
