import java.util.*;

public class accounts {
    

    Scanner in = new Scanner(System.in);
    Set<String> hash_Set = new HashSet<String>();
    private HashMap<String,String> mp=new HashMap<String,String>(); 

    boolean username_already_exists(String user_name){

        if (! hash_Set.contains(user_name)){
            hash_Set.add(user_name);
            return false;
            }
        else{
            System.out.println(" **username exists");
            return true;
        }

    }

    void new_user_login(){
        String pass1, pass2,user_name;
        do{
            System.out.print("\nUsername : ");
            user_name = in.nextLine();
        }while(username_already_exists(user_name));
        //username_already_exists(user_name);

        do{
            System.out.print("Password          : ");
            pass1 = in.nextLine();
            System.out.print("Re-enter Password : ");
            pass2 = in.nextLine();
        }while(!pass1.equals(pass2));

        hash_Set.add(user_name);
        mp.put(user_name, pass1);

        System.out.println("*** account created ***");

    }

    int old_user_login(){
        String pass1, user_name;
        String retrieved="";
        do{
            System.out.print("\nUsername : ");
            user_name = in.nextLine();
        }while(!username_already_exists(user_name));

        retrieved = mp.get(user_name);

        String backup = retrieved;
        do{
            retrieved=backup;
            pass1="";
            System.out.print("\nPassword : ");
            pass1 = in.nextLine();

            if( !pass1.equals(retrieved)){
                System.out.println("wrong pass");
                System.out.println("Try again? (1/0) : ");
                int opt = Integer.parseInt(in.nextLine());

                if(opt==0){
                    return 0;
                }
            }
        }while(!pass1.equals(retrieved));

        System.out.println("** Successful login ***");
        if(user_name.equals("admin")){
            return 2;
        }
        return 1;
        
    }

}