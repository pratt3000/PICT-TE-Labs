import java.util.*; 

public class Main extends Thread {

    static Scanner in = new Scanner(System.in);
    static market_database_handling mdh = new market_database_handling();
    public static void main(String[] args) throws Exception {
        Main thread = new Main();
        thread.start();
    }

    public void run() {
        int repeat =1;
        while(repeat==1){

            mdh.get_market_status();
            mdh._login_();
            mdh.pass_day();

            System.out.println("login/leave shop? (1/0) : ");
            repeat = Integer.parseInt(in.nextLine());
        }        
      }
}
