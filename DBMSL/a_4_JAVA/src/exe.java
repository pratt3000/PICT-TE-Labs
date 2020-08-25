import java.sql.*;

public class exe {
    
    void create_table(String name){
        try{
            String stmnt = "create table "+name+" (id int not null,value varchar(20))";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_view(){
        try{
            String stmnt = "create or replace view comp as select fname, lname from professor where dept_id=1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_index(){
        try{
            String stmnt = "CREATE INDEX ind_1 ON professor(salary)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_seq(){
        try{
            String stmnt = "CREATE TABLE employees (emp_no INT AUTO_INCREMENT PRIMARY KEY,f_name VARCHAR(50),l_name VARCHAR(50));";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_synonym(){
        try{
            String stmnt = "CREATE TABLE employees (emp_no INT AUTO_INCREMENT PRIMARY KEY,f_name VARCHAR(50),l_name VARCHAR(50));";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void reset(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("drop table if exists employees;");
            stmt.executeUpdate("drop index ind_1 on professor");
            stmt.executeUpdate("DROP VIEW IF EXISTS comp;");
            stmt.executeUpdate("drop table if exists sample;");

            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    //display tables remaining
    //show index from tables name
    //simple compound unique index make
    // views tyoes

}