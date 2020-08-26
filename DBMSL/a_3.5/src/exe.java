import java.sql.*;

public class exe {
    
    void create_table(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("drop table if exists sample");
            stmt.executeUpdate("create table sample (id int not null,value varchar(20))");
            
            ResultSet r = stmt.executeQuery("select * from sample");
            while(r.next()) {
                System.out.println(r.getInt(1) + "\t" + r.getString(2));
            }

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
            ResultSet r = stmt.executeQuery("select * from comp");
            while(r.next()) {
                System.out.println(r.getString(1) + "\t" + r.getString(2));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_index(){
        try{
            String stmnt = "CREATE INDEX ind_1 ON professor(fname)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            ResultSet r = stmt.executeQuery("show index from professor");
            while(r.next()){
                System.out.println(r.getString(3) + "\t" + r.getString(5));
            }
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

    // write in writeups[ only avaliable in oracle not mysql ]
    void create_synonym(){
        try{
            String stmnt = "CREATE TABLE employees (emp_no INT AUTO_INCREMENT PRIMARY KEY,f_name VARCHAR(50),l_name VARCHAR(50));";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("drop table if exists employees");
            stmt.executeUpdate(stmnt);
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_complex_view(){
        try{
            String stmnt = "create or replace view comp as select p.fname, p.lname from professor p, department d where p.dept_id=d.dept_id";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            ResultSet r = stmt.executeQuery("select * from comp");
            while(r.next()) {
                System.out.println(r.getString(1) + "\t\t\t" + r.getString(2));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_compound_index(){
        try{
            String stmnt = "CREATE INDEX ind_2 ON professor(fname, lname)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            ResultSet r = stmt.executeQuery("show index from professor");
            while(r.next()){
                System.out.println(r.getString(3) + "\t" + r.getString(5));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void create_unique_index(){
        try{
            String stmnt = "CREATE unique INDEX ind_3 ON department(dept_id)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(stmnt);
            ResultSet r = stmt.executeQuery("show index from department");
            while(r.next()){
                System.out.println(r.getString(3) + "\t" + r.getString(5));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    void reset(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A1_professor_schema","root","Hello@123");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("drop table if exists employees");
            stmt.executeUpdate("drop index ind_1 on professor");
            stmt.executeUpdate("drop index ind_2 on professor");
            stmt.executeUpdate("drop index ind_3 on department");
            stmt.executeUpdate("DROP VIEW IF EXISTS comp");
            stmt.executeUpdate("drop table if exists sample");

            con.close();
        }catch(Exception e){System.out.println(e);}
    }

    //display tables remaining
    //show index from tables name
    //simple compound unique index make
    // views tyoes

}