import java.util.*; 

public class Main extends Thread {

    static Scanner in = new Scanner(System.in);
    static market_database_handling mdh = new market_database_handling();
    static account_handling acch = new account_handling();

    public static void main(String[] args) throws Exception {
        Main thread = new Main();
        thread.start();
    }

    public void run() {
        int repeat =1;
        while(repeat==1){

            int fl=1;
            while(fl==1){
                int new_acc = mdh.choose_login_options();

                if(new_acc == 1){
                    int opt = acch.old_user_login();
                    fl = mdh.display_respective_menu(opt);                
                }
                else if(new_acc == 2){
                    fl = acch.new_user_login();
                }          
            }

            mdh.pass_day();

            repeat = mdh.continue_shopping();
        }        
      }
}
