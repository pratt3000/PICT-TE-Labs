import java.sql.*;
import java.util.*;
import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;



public class market_database_handling {
    Scanner in = new Scanner(System.in);
    
    static account_handling acch = new account_handling();
    static Client cli = new Client();

    void get_market_status(){
        String query = "SELECT * FROM Market";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\n\n**** WELCOME TO BIG-BASKET ****");
            System.out.printf( "\n| %-15s| %10s   |%10s       | %10s |\n","Item Name", "QTY", "Expires in", "Cost" );
            System.out.println("________________________________________________________________");
            if(rs.next()){ 
				do{
                System.out.printf("| %-15s| %10s   |%10s days  | %10s |\n",
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)
                            );
				}while(rs.next());
			}
			else{
				System.out.println("Record Not Found...");
            }
            System.out.println("________________________________________________________________");
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
    
    int get_quantity(String item_name){
        String query = "select quantity from Market where name='"+item_name+"';";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int quan = rs.getInt(1);
            con.close();
            return quan;
        }catch(Exception e){System.out.println(e);return -1;}
    }

    int get_expiry(String item_name){
        String query = "select expiry from Market where name='"+item_name+"';";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int exp = rs.getInt(1);
            con.close();
            return exp;
        }catch(Exception e){System.out.println(e);return -1;}
    }

    int get_cost(String item_name){
        String query = "select cost from Market where name='"+item_name+"';";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int cost = rs.getInt(1);
            con.close();
            return cost;
        }catch(Exception e){System.out.println(e);return -1;}
    }

    void pass_day(){
        String updt_expiry = "update Market set expiry = IF(expiry<=1, 0, expiry-1);";
        String updt_quantity = "update Market set quantity = IF(expiry<1, 0, quantity)";
        String updt_cost = "update Market set cost = IF(expiry<1, 0, cost)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(updt_expiry);
            stmt.executeUpdate(updt_quantity);
            stmt.executeUpdate(updt_cost);
            System.out.println("A DAY HAS PASSED !!!");
            con.close();
        }catch(Exception e){System.out.println(e);}
    }
    
    int continue_shopping(){
        System.out.println("login/leave shop? (1/0) : ");
        int repeat = Integer.parseInt(in.nextLine());
        return repeat;
    }

    int choose_login_options(){    
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.print("\nChoice : ");
        int new_acc = Integer.parseInt(in.nextLine());
        return new_acc;
    }

    void display_respective_menu(String status){
        if(status.equals("customer")){ customer_menu(); }
        if(status.equals("admin")){ admin_menu(); }
    }

    void admin_menu(){
        int choice;
        System.out.println("*** Admin Mode ***");
        System.out.println("Order default/ Order Specific ? (1/0)");
        choice = Integer.parseInt(in.nextLine());
        if(choice == 1){
            run_default_market();
        }
        else{
            System.out.println("Re-stock per category :");

            int repeat = 1;
            while(repeat != 0){

                Integer q, exp, c;        //quantity expiry cost
                String item_name;

                System.out.println("Item Name        : ");
                item_name = in.nextLine();
                System.out.println("Restock Quantity : ");
                q = Integer.parseInt(in.nextLine());
                System.out.println("New Expiry       : ");
                exp = Integer.parseInt(in.nextLine());
                System.out.println("New Cost         : ");
                c = Integer.parseInt(in.nextLine());
                
                System.out.println("\nRestocking...");
                
                String updt = "update Market set quantity ='"+q+"', expiry = '"+exp+"', cost = '"+c+"' where name = '"+item_name+"';";
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(updt);
                    System.out.println("Restocked !");
                    con.close();
                }catch(Exception e){System.out.println(e);}

                System.out.println("Restock another item ?(1/0) ");
                repeat = Integer.parseInt(in.nextLine());
            }
        }
        
    }

    void customer_menu(){

        Integer count;
        System.out.print("\nNo. of items you want to BUY : ");
        count = Integer.parseInt(in.nextLine());
        int total_cost = 0;
        String[] items = new String[20];
        int[] quantities = new int[20];

        for(int ct=0; ct<count; ct++){

            String item_name;
            Integer quan;
            System.out.println("Item Name        : ");
            item_name = in.nextLine();
            System.out.println("Quantity         : ");
            quan = Integer.parseInt(in.nextLine());

            items[ct] = item_name;
            quantities[ct]=quan;
            total_cost = total_cost + buy_item(item_name, quan);
        }

        System.out.println("---------------------------------------------");
        System.out.println("YOUR BASKET : \n");
        for(int ct=0; ct<count; ct++){
            System.out.println(items[ct] + " : " + quantities[ct] );
        }
        System.out.println("cost : " + total_cost);
        System.out.println("\n\nThanks for supporting us!");
        System.out.println("---------------------------------------------");
    }

    int buy_item(String name, Integer quan){
        String updt_quantity = "update Market set quantity = IF(quantity-'"+quan+"'<1, 0, quantity-'"+quan+"') where name='"+name+"';";
        String updt_cost = "update Market set cost = IF(quantity<1, 0, cost) where name='"+name+"';";
        String updt_exp = "update Market set expiry = IF(quantity<1, 0, expiry) where name='"+name+"';";
        String query_cost = "select cost from Market where name='"+name+"';";
        int cost=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            Statement stmt = con.createStatement();

            stmt.executeUpdate(updt_quantity);
            stmt.executeUpdate(updt_cost);
            stmt.executeUpdate(updt_exp);

            ResultSet rs = stmt.executeQuery(query_cost);
            rs.next();
            cost = rs.getInt(1);

            
            con.close();
        }catch(Exception e){System.out.println(e);}

        return (cost*quan);
    }

    void run_default_market(){
        //Getting the connection
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bb_accounts","root","Hello@123");
            System.out.println("Connection established......");
            //Initialize the script runner
            ScriptRunner sr = new ScriptRunner(con);
            //Creating a reader object
            Reader reader = new BufferedReader(new FileReader("/home/pratt3000/Documents/College/PICT_TE-Labs/SDL/InventoryManagement/Database/create_table.sql"));
            //Running the script
            sr.runScript(reader);
        }catch(Exception e){System.out.println(e);}
    }
    String contact(){
        // System.out.println("---------CONTACT DETAILS--------");
        // System.out.println("\nHelp Desk : 9899998230");
        // System.out.println("Complaints : 9899998231");
        // System.out.println("Email : bgbskt@gmail.bgbskt.com");
        // System.out.println("Donate : <DONATION LINK>");

        return("---------CONTACT DETAILS--------\nHelp Desk : 9899998230\nComplaints : 9899998231\nComplaints : 9899998231\nEmail : bgbskt@gmail.bgbskt.com\nDonate : <DONATION LINK>");
    }

    String about(){
        // System.out.println("--------- ABOUT --------");
        // System.out.println("\nBigbasket company was founded by V S Sudhakar, Hari Menon, Vipul Parekh, Abhinay Choudhari and V S Ramesh in 2011. Initially, in 1999, they started India's first e-commerce site FabMart and then went on to establish Fabmall-Trinethra chain of more than 200 grocery supermarket stores in southern India, the business was later sold to Aditya Birla Group. It is popularly known as 'More' retail chain.[6] In 2011 they launched bigbasket online grocery delivery service. On August 9, 2019, bigbasket partnered with a non-profit organisation Goonj and through their Rahat flood programme provided relief materials to people who were affected during the Kerala Flood");
        return("--------- ABOUT --------\nBigbasket company was founded by V S Sudhakar, Hari Menon, Vipul Parekh, Abhinay Choudhari and V S Ramesh in 2011. Initially, in 1999, they started India's first e-commerce site FabMart and then went on to establish Fabmall-Trinethra chain of more than 200 grocery supermarket stores in southern India, the business was later sold to Aditya Birla Group. It is popularly known as 'More' retail chain.[6] In 2011 they launched bigbasket online grocery delivery service. On August 9, 2019, bigbasket partnered with a non-profit organisation Goonj and through their Rahat flood programme provided relief materials to people who were affected during the Kerala Flood");
    }

    String FAQ(){
        // System.out.println("--------- FAQs --------");
        // System.out.println("1. when was bigbasket founded?");
        // System.out.println("2007");
        // System.out.println("1. who founded big basket?");
        // System.out.println("someone did");

        return ("--------- FAQs --------\n1. when was bigbasket founded?\n2007\n2. who founded big basket?\nsomeone did");
    }

}
