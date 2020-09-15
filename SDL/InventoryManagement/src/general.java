import java.util.*; 


public class general {
    static Scanner in = new Scanner(System.in);

    static accounts acch = new accounts();      //change to account_handling for Database support
    static HM_count qty = new HM_count();
    static HM_expDate exp = new HM_expDate();
    static ARR_names itmn = new ARR_names();  
    static Client cli = new Client();

    static int item_count=13;

    general(){
        System.out.println("\n\n**** WELCOME TO BIG-BASKET ****"); 
    }
    void market_status(){
        System.out.println("Market Status : ");
        System.out.printf( "\n| %2s.| %-15s| %5s   | %-10s |\n ","ID", "Item Name", "QTY", "Expires in" );
        System.out.println("---------------------------------------------");

        for(int ct=0; ct<item_count; ct++){
            System.out.printf( "| %2d.| %-15s| %5d   |%5d days  |\n",
                                ct + 1,
                                itmn.get_item_name(ct),
                                qty.get_count(ct+1),
                                exp.get_expDate(ct+1)
                            );
        }
    }

    void pass_day(){
        Boolean _status_ = exp.pass_day();
        System.out.println("A DAY HAS PASSED");
        if(_status_)
            System.out.println("*** please ask admin to restock\n");
        System.out.println("---------------------------------------------");
           
        
        for(Integer ct=0; ct<item_count; ct++){
            if(exp.get_expDate(ct+1)==0)
                qty.set_0(ct+1);
        }
    }

    void _login_(){
        int fl=1;
        while(fl==1){
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Help");


            System.out.print("\nChoice : ");
            int new_acc = Integer.parseInt(in.nextLine());
            if(new_acc == 2){
                acch.new_user_login();
                customer_menu();
                fl=0;
            }
            else if(new_acc == 1){
                int opt = acch.old_user_login();

                if(opt==0){ fl=1; }
                if(opt==1){ fl=0; customer_menu(); }
                if(opt==2){ fl=0; admin_menu(); }
            }  
            else if(new_acc == 3){
                // add client server here
                cli.call_client();
            }          
        }
    }

    void admin_menu(){
        System.out.println("***Admin Mode");
        System.out.println("Re-stock per category :");
        Integer quan;
        quan = Integer.parseInt(in.nextLine());
        
        System.out.println("Restocking...");
        for(Integer ct=0; ct<item_count; ct++){
            qty._set_(ct+1, quan);
        }
        exp.set_exp_date();
    }

    void customer_menu(){
        Integer count;
        System.out.print("\nNo. of items you want to BUY : ");
        count = Integer.parseInt(in.nextLine());
        for(int ct=0; ct<count; ct++){
            Integer item_id, quan;
            System.out.print("\nItem_id  : ");
            item_id = Integer.parseInt(in.nextLine());
            System.out.print("Quantity : ");
            quan = Integer.parseInt(in.nextLine());

            if(qty.buy(item_id, quan) != true){
                System.out.println("** not in stock **");
                ct--;
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("\nThanks for supporting us!");
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

    int check_inventory(int itmn){
        return  (qty.get_count(itmn+1));
    }

}