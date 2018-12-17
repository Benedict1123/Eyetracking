package DBConnect;
/**
 * Hello world!
 *
 */
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MongoDBJDBC {

    public static void main(String args[]) {
        try {
            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            System.out.println("Connect to Mongo Server successfully!");
            //@deprecated 查询所有的databases
//            for (String db : mongoClient.getDatabaseNames()) {
//                System.out.println(db);
//            }
            // Now connect to your databases 连接到服务器上的数据库
            MongoDatabase mgdb = mongoClient.getDatabase("eyetracker");
            System.out.println("Connect to database successfully!");
            System.out.println("MongoDatabase inof is : "+mgdb.getName());
            // If MongoDB in secure mode, authentication is required.
            // boolean auth = db.authenticate(myUserName, myPassword);
            // System.out.println("Authentication: "+auth);
//            for (String name : mgdb.listCollectionNames()) {
//                System.out.println(name);
//            }
            MongoCollection<Document> coll = mgdb.getCollection("all_participants");
            System.out.println("Collection created successfully");
            FindIterable<Document> iterable = coll.find();
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> valid_list = new ArrayList<Map<String,Object>>();

            MongoCursor<Document> cursor = iterable.iterator();
            int int_index = 0;
            while (cursor.hasNext()) {
                int_index++;
                Document user = cursor.next();
                String jsonString = user.toJson();
                Gson new_json = new Gson();
                Map<String,Object> json_map = new HashMap<String,Object>();
                json_map = (Map<String,Object>) new_json.fromJson(jsonString, json_map.getClass());
                try {
                    Object key_value_1 = json_map.get("StrictAverageGazePointX (ADCSmm)");
                    Object key_value_2 = json_map.get("StrictAverageGazePointY (ADCSmm)");
                    if (!key_value_1.equals("") && !key_value_2.equals("")) {
                        valid_list.add(json_map);
                    }
                }catch (NullPointerException e){
                    System.out.println(json_map.get("_id").toString());
                    System.out.println(int_index); //4306 条记录
                    e.printStackTrace();
                }
                list.add(json_map); //List里面添加Json对象
            }
//            System.out.println(a.keySet().size());
//            System.out.println(list.get(4306));
            System.out.println("iterated all records in the table");
            System.out.println(list.size());
            System.out.println(valid_list.size());
            //断开数据库连接
//            if(mgdb != null){
//                mgdb = null;
//            }
//            if(mongoClient != null){
//                mongoClient.close();
//            }
//            System.out.println("Close MongoClient successfully!");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }







}