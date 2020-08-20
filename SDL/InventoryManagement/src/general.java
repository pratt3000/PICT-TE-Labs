import java.util.*; 


public class general {
    static Scanner in = new Scanner(System.in);

    static account_handling acch = new account_handling();
    static HM_count qty = new HM_count();
    static HM_expDate exp = new HM_expDate();
    static ARR_names itmn = new ARR_names();  

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
            System.out.println("Sign-up/ Login : (1/0)");
            int new_acc = Integer.parseInt(in.nextLine());
            if(new_acc == 1){
                acch.new_user_login();
                customer_menu();
                fl=0;
            }
            else{
                int opt = acch.old_user_login();

                if(opt==0){ fl=1; }
                if(opt==1){ fl=0; customer_menu(); }
                if(opt==2){ fl=0; admin_menu(); }
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
        System.out.println("No. of items you want to BUY : ");
        count = Integer.parseInt(in.nextLine());
        for(int ct=0; ct<count; ct++){
            Integer item_id, quan;
            System.out.println("Item_id");
            item_id = Integer.parseInt(in.nextLine());
            System.out.println("Quantity");
            quan = Integer.parseInt(in.nextLine());

            if(qty.buy(item_id, quan) != true){
                System.out.println("not in stock");
                ct--;
            }
        }
        System.out.println("Thanks for supporting us!");
    }


}