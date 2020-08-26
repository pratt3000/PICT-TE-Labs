import java.sql.*;
import java.util.Scanner;

public class Main {
	
    public static void main(String args[]) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsl?autoReconnect=true&useSSL=false","root","Qwerty@12");
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            int choice=0;
            while(true){
                System.out.println("Select\n1.View\n2.Index\n3.Sequence/auto-increment\n0.Exit\nChoice");
                choice = sc.nextInt();
                if(choice == 0) {
                    break;
                }
                switch (choice) {
                    case 1: {
                        int ch;
                        System.out.println("1.Simple View\n2.Complex View\n3.Drop view\nChoice");
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1:{
                                try {
                                    stmt.executeUpdate("create or replace view myview as select cust_fname, cust_lname from customer");
                                    System.out.println("Query executed sucessfully!!!");
                                    ResultSet r = stmt.executeQuery("select * from myview");
                                    while(r.next()) {
                                        System.out.println(r.getString(1) + "\t" + r.getString(2));
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 2: {
                                try {
                                    stmt.executeUpdate("create or replace view myview1 as select author_name,title from author, book where author.author_no=book.author_no");
                                    System.out.println("Query executed sucessfully!!!");
                                    ResultSet r = stmt.executeQuery("select * from myview1");
                                    while(r.next()) {
                                        System.out.println(r.getString(1) + "\t\t\t" + r.getString(2));
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 3: {
                                try {
                                    stmt.executeUpdate("drop view myview");
                                    stmt.executeUpdate("drop view myview1");
                                    System.out.println("Query executed sucessfully!!!");
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        int ch;
                        System.out.println("1.Simple Index\n2.Compound Index\n3.Unique Index\n4.Drop index\nChoice");
                        ch = sc.nextInt();
                        switch (ch){
                            case 1:{
                                try {
                                    stmt.executeUpdate("create index pub_id on publisher(publisher_name)");
                                    System.out.println("Query executed sucessfully!!!");
                                    ResultSet r = stmt.executeQuery("show index from publisher");
                                    while(r.next()){
                                        System.out.println(r.getString(3) + "\t" + r.getString(5));
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 2: {
                                try{
                                    stmt.executeUpdate("create index cust_ind on customer(cust_fname,cust_lname)");
                                    System.out.println("Query executed sucessfully!!!");
                                    ResultSet r = stmt.executeQuery("show index from customer");
                                    while(r.next()){
                                        System.out.println(r.getString(3) + "\t" + r.getString(5));
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 3: {
                                try{
                                    stmt.executeUpdate("create unique index author_id on author(author_no)");
                                    System.out.println("Query executed sucessfully!!!");
                                    ResultSet r = stmt.executeQuery("show index from author");
                                    while(r.next()){
                                        System.out.println(r.getInt(2) + "\t" +r.getString(3) + "\t" + r.getString(5));
                                    }
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                            case 4: {
                                try{
                                    stmt.executeUpdate("alter table customer drop index cust_ind");
                                    stmt.executeUpdate("alter table publisher drop index pub_id");
                                    System.out.println("Query executed sucessfully!!!");
                                } catch (SQLException e) {
                                    System.out.println(e);
                                }
                                break;
                            }
                        }
                        break;
                    }
                    case 3: {
                        stmt.executeUpdate("create table task(id int unsigned not null auto_increment, primary key(id), task_name varchar(20))");
                        
                        String sql = "INSERT INTO task " +
                                "VALUES (null, 'Issue')";
                        stmt.executeUpdate(sql);
                        sql = "INSERT INTO task " +
                                "VALUES (null, 'Submit')";
                        stmt.executeUpdate(sql);
                        ResultSet r = stmt.executeQuery("select * from task");
                        while(r.next()) {
                            System.out.println(r.getInt(1) + "\t" + r.getString(2));
                        }
                        System.out.println("Query executed sucessfully!!!");
                        stmt.executeUpdate("drop table task");
                        break;
                    }
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}