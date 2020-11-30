import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String query;
    private static String name, fname, mname;
    private static int aadhar, age, vote;

    static {
        MysqlHandler.main(new String[0]);
        System.out.println();
    }

    public static void main(String[] args) {
        int rowsAffected;
        int choice = 1;
        while (choice != 0) {
            switch (choice){
                case 1:
                    printHints();
                break;

                case 2:
                    System.out.println("\nCREATING TABLE");
                    query = "create table aadharcards(\n" +
                            "    Aadharno int not null, \n" +
                            "    Name varchar(32) not null, \n" +
                            "    Age int not null, \n" +
                            "    voted int not null, \n" +
                            "    Fathers_name varchar(32) not null, \n" +
                            "    Mothers_name varchar(32) not null \n" +
                            ")";
                    System.out.println(query);
                    MysqlHandler.execute(query);
                break;

                case 3:
                    System.out.println("\nINSERT NEW RECORD");
                    System.out.print("Aadharno: ");
                    aadhar = Integer.parseInt(input.nextLine());
                    System.out.print("Name: ");
                    name = input.nextLine();
                    System.out.print("Age: ");
                    age = Integer.parseInt(input.nextLine());
                    System.out.print("voted: ");
                    vote = Integer.parseInt(input.nextLine());
                    System.out.print("Fathers_name: ");
                    fname = input.nextLine();
                    System.out.print("Mothers_name: ");
                    mname = input.nextLine();

                    query = String.format(
                            "insert into aadharcards (Aadharno,Name,Age,voted,Fathers_name,Mothers_name)\n" +
                            "values ('%s','%s',%s,%s,'%s','%s')",aadhar,name,age,vote,fname,mname
                    );
                    System.out.println(query);
                    MysqlHandler.executeUpdate(query);
                break;

                case 4:
                    System.out.println("\nUPDATE BOOK");
                    System.out.print("aadhar: ");
                    aadhar = Integer.parseInt(input.nextLine());
                    System.out.print("New name: ");
                    name = input.nextLine();
                    System.out.print("New age: ");
                    age = Integer.parseInt(input.nextLine());
                    System.out.print("New vote status: ");
                    vote = Integer.parseInt(input.nextLine());
                    System.out.print("New father's name: ");
                    fname = input.nextLine();
                    System.out.print("New Mothers's name: ");
                    mname = input.nextLine();

                    query = String.format(
                            "update aadharcards set Name='%s',Age=%s,voted=%s,Fathers_name='%s',Mothers_name='%s'\n" +
                            "where Aadharno='%s'",name,age,vote,fname,mname,aadhar
                    );
                    System.out.println(query);
                    rowsAffected = MysqlHandler.executeUpdate(query);
                    if (rowsAffected == 0)
                        System.out.println("Aadhar no: "+aadhar+" Not Found");
                    else
                        System.out.println("record Updated");
                break;

                case 5:
                    System.out.println("\nDELETE record");
                    System.out.print("aadhar: ");
                    aadhar = Integer.parseInt(input.nextLine());

                    query = String.format("delete from aadharcards where Aadharno='%s'",aadhar);
                    System.out.println(query);
                    rowsAffected = MysqlHandler.executeUpdate(query);
                    if (rowsAffected == 0)
                        System.out.println("aadhar no: "+aadhar+" Not Found");
                    else
                        System.out.println("record Deleted");

                break;

                case 6:
                    System.out.println("records TABLE");
                    MysqlHandler.executeQuery("select * from aadharcards");
                break;

                default:
                    System.out.println("Option ("+choice+") not found");
            }

            System.out.println();
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(input.nextLine());
        }

        System.out.println("exit()");
    }
    
    public static void printHints(){
        System.out.println("1. Print Hints");
        System.out.println("2. Create Table");
        System.out.println("3. Insert New record");
        System.out.println("4. Update record");
        System.out.println("5. Delete record");
        System.out.println("6. Show Table");
        System.out.println("0. Exit");
    }

}
