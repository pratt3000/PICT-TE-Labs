import java.util.*; 

public class Main {
    
    static Scanner in = new Scanner(System.in);
    static general gen = new general();
  
    public static void main(String[] args) throws Exception {

        System.out.println("\n\n**** WELCOME TO BIG-BASKET ****");
        
        int repeat =1;
        while(repeat==1){
            gen.market_status();
            gen._login_();
            gen.pass_day();

            System.out.println("login/leave shop? (1/0) : ");
            repeat = Integer.parseInt(in.nextLine());
        }        
    }
    
    

    

    
}
