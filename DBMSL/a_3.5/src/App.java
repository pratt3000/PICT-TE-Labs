import java.sql.*;
import java.util.*; 

public class App {
    static Scanner in = new Scanner(System.in);
    static exe ex = new exe(); 
    public static void main(String[] args) {
        int repeat=1, choice;

        System.out.println("1.Create table");
        System.out.println("2.Create Simple view");
        System.out.println("3.Create Simple index");
        System.out.println("4.Create sequence");
        System.out.println("5.Create synonym");
        System.out.println("6.exit");
        System.out.println("7.Create Complex view");
        System.out.println("8.Create Compound index");
        System.out.println("9.Create Unique index");

        ex.reset();
        while(repeat==1){
            System.out.print("Enter option : ");
            choice = Integer.parseInt(in.nextLine());
            switch (choice) { 
                case 1: 
                    ex.create_table();
                    break; 
                case 2: 
                    ex.create_view();
                    break; 
                case 3: 
                    ex.create_index();
                    break; 
                case 4: 
                    ex.create_seq();
                    break; 
                case 5: 
                    ex.create_synonym(); 
                    break;
                case 7:
                    ex.create_complex_view(); 
                    break;
                case 8:
                    ex.create_compound_index();
                    break;
                case 9:
                    ex.create_unique_index();
                    break;
                default: 
                    break; 
                }
            System.out.println("Again? (1/0) : ");
            repeat = Integer.parseInt(in.nextLine());
        }
    }
}
