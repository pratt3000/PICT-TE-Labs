import java.util.*; 

public class Main {
    static Scanner in = new Scanner(System.in);

    static account_handling acch = new account_handling();
    static HM_count qty = new HM_count();
    static HM_expDate exp = new HM_expDate();
    static ARR_names itmn = new ARR_names();
    static Admin_AUTH AUTH = new Admin_AUTH();
    

    
    static int item_count=13;
    public static void main(String[] args) throws Exception {

        System.out.println("\n\n**** WELCOME TO BIG-BASKET ****");
        
        int repeat =1;
        while(repeat==1){
            market_status();
            _login_();
            pass_day();

            System.out.println("login/leave shop? (1/0) : ");
            repeat = in.nextInt();
        }        
    }
    
    static void market_status(){
        System.out.println("Market Status : ");
        System.out.printf( "\n| %2s.| %-15s| %5s   | %-10s |\n ","ID", "Item Name", "QTY", "Expires in" );
        System.out.println("---------------------------------------------");

        for(int ct=0; ct<item_count; ct++){
            //System.out.println( + "      " + );
            System.out.printf( "| %2d.| %-15s| %5d   |%5d days  |\n",
                                ct + 1,
                                itmn.get_item_name(ct),
                                qty.get_count(ct+1),
                                exp.get_expDate(ct+1)
                            );
        }
    }

    static void pass_day(){
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

    static void _login_(){
        int ip;
        int fl=1;
        while(fl==1){
            System.out.println("\nLogin as Admin/ Customer : (1 / 0)");
            ip = in.nextInt();
            if(ip==1){
                System.out.print("ENTER PASS-KEY : ");
                int pass = in.nextInt();
                boolean status=AUTH.authenticate(pass);

                if(status == true){
                    admin_menu();
                    fl=0;
                }
                else{
                    System.out.println("\n***WRONG pass-key**");
                }
            }
            else if(ip==0){
                System.out.println("new account/ old account?(1/0)");
                int new_acc = in.nextInt();
                if(new_acc == 1){
                    System.out.println("test");

                    acch.new_user_login();
                    customer_menu();
                    fl=0;
                }
                else{
                    if(acch.old_user_login()){
                        customer_menu();
                        fl=0;
                    }
                    else{
                        fl=1;
                    }
                }            
            }
        }
    }

    static void admin_menu(){
        System.out.println("***Admin Mode");
        System.out.println("Re-stock per category :");
        Integer quan;
        quan = in.nextInt();
        
        System.out.println("Restocking...");
        for(Integer ct=0; ct<item_count; ct++){
            qty._set_(ct+1, quan);
        }
        exp.set_exp_date();
    }

    static void customer_menu(){
        Integer count;
        System.out.println("No. of items you want to BUY : ");
        count = in.nextInt();
        for(int ct=0; ct<count; ct++){
            Integer item_id, quan;
            System.out.println("Item_id");
            item_id = in.nextInt();
            System.out.println("Quantity");
            quan = in.nextInt();

            if(qty.buy(item_id, quan) != true){
                System.out.println("not in stock");
                ct--;
            }
        }
        System.out.println("Thanks for supporting us!");
    }
}
