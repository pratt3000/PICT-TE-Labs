import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import java.util.Arrays;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class App {
    private static final MongoClient mongoClient;
    private static final MongoDatabase db;
    private static final MongoCollection<Document> collection;
    private static final JsonWriterSettings settings;
    private static final Scanner scanner;


    static {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        db = mongoClient.getDatabase("C01");
        collection = db.getCollection("Aadhar");
        settings = JsonWriterSettings.builder().indent(true).build();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        System.out.print("\nOperation: ");
        String choice = scanner.nextLine().toLowerCase();

        while (!choice.equalsIgnoreCase("exit")){

            switch (choice){
                case "insert":
                    insert();
                break;
                case "update":
                    update();
                break;
                case "delete":
                    delete();
                break;
                case "find":
                    find();
                break;
                default:
                    System.out.println("Invalid Action");
            }

            System.out.print("\nOperation: ");
            choice = scanner.nextLine().toLowerCase();

        }
    }

    private static void insert(){
        String n;
        int a,m;
        System.out.print("Aadhar no.: ");
        a = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        n = scanner.nextLine();
        System.out.print("mobno: ");
        m = Integer.parseInt(scanner.nextLine());

        Document article = new Document();
        article.append("Aadharno",a);
        article.append("Name",n);
        article.append("MobileNo",m);
        
        InsertOneResult result = collection.insertOne(article);
        System.out.println("result: "+result);

    }

    private static void update(){
        System.out.print("Aadharno: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String n = scanner.nextLine();

        System.out.print("MobileNo: ");
        int m = Integer.parseInt(scanner.nextLine());

        UpdateResult result = collection.updateOne(
                and(eq("Aadharno",a),eq("Name",n)),
                Updates.set("MobileNo",m)
        );
        System.out.println("result: "+result);

    }

    private static void delete(){
        System.out.print("Aadharno: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String n = scanner.nextLine();

        DeleteResult result = collection.deleteMany(
                and(eq("Aadharno",a),eq("Name",a))
        );
        System.out.println("result: "+result);
    }

    private static void find(){
        for (Document document : collection.find()) {
            System.out.println(document.toJson(settings));
        }
    }
}