import com.mongodb.client.*;
import com.mysql.cj.xdevapi.JsonValue;
import java.util.Iterator;
import java.util.Scanner;
import com.mongodb.*;
import org.bson.Document;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class App
{
public static void main(String[] args) {
try {
MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
MongoDatabase db = mongo.getDatabase("b7");
MongoCollection<Document> collection = db.getCollection("game");
Scanner sc = new Scanner(System.in);
JSONObject obj = new JSONObject();
JSONArray jarr = new JSONArray();
String uname, badge;
int u_number;
System.out.print("Enter Name :");
uname = sc.nextLine();
System.out.print("Enter User Number : ");
u_number = sc.nextInt();
sc.nextLine();
while (true) {
System.out.print("Enter badge:");
badge = sc.nextLine();
jarr.add(badge);
System.out.print("Enter 'Y' to add more");
badge = sc.nextLine();
if (!badge.equals("Y"))
break;
}
//encoding json
obj.put("name", uname);
obj.put("user_number", u_number);
obj.put("badges", jarr);
Document document;
document = Document.parse(obj.toString());
collection.insertOne(document);
//System.out.print(obj);
for (Document doc : collection.find()) {
// System.out.print(doc.toJson().toString());
Object o1 = JSONValue.parse(doc.toJson());
JSONObject jsonObject = (JSONObject) o1;
//decoding json object
System.out.printf("%15s %15s %30s", jsonObject.get("name").toString(),
jsonObject.get("user_number"), jsonObject.get("badges"));
System.out.print('\n');
}
} catch (Exception e) {
System.out.println(e);
}
}
}