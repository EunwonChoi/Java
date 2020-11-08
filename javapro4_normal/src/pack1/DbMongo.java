package pack1;

import org.bson.*;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DbMongo {

	public DbMongo() {
		try {
			MongoClient client = new MongoClient("localhost", 27017);
			MongoDatabase db = client.getDatabase("test");
			MongoCollection<Document> collection = db.getCollection("user");

			//자료추가
			Document ins_doc = new Document("name", "나이스").append("age", "33").append("job", "음악가");
			collection.insertOne(ins_doc);

			System.out.println("건수: "  + collection.countDocuments());
			
			Document doc = collection.find().first();   //첫번째 자료만 출력
			System.out.println("첫번째 자료: " + doc.toJson());  
			
			System.out.println();
			MongoCursor<Document> cursor = collection.find().iterator();   //모두 출력
			//MongoCursor<Document> cursor = collection.find().limit(2).iterator();   //2개만 출력
			
			
			
			/*
			while(cursor.hasNext()) { 
				//Document doument = cursor.next();
				//String jsonResult  = document.toJason();
				String jsonResult = cursor.next().toJson();
				System.out.println(jsonResult);
			}
			*/
			
			cursor = collection.find().iterator();
			while(cursor.hasNext()) {
				Document document2 = cursor.next();
				System.out.println("이름: " + document2.get("name") + ", 나이" + document2.get("age") + ", 직업: " + document2.get("job"));
			}
			
		} catch (Exception e) {
			System.out.println("err: " + e );
		}
	}
	
	public static void main(String[] args) {
		new DbMongo();

	}

}
