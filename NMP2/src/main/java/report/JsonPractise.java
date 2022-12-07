package report;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.jsonpath.JsonPath;

public class JsonPractise {
    
    public static void parseObject(JSONObject json,String key) {
        System.out.println(json.has(key));
        System.out.println(json.get(key));
        
    }

    public static void getKey(JSONObject json,String key) {
       boolean exists=json.has(key);
       Iterator<?> keys;
       String nextKeys;
       
       if(!exists) {
           keys = json.keys();
           while(keys.hasNext()) {
               nextKeys=(String)keys.next();
           try {
               if(json.get(nextKeys) instanceof JSONObject) {
                   if(exists == false) {
                       getKey(json.getJSONObject(nextKeys), key);
                   }
               }else if (json.get(nextKeys) instanceof JSONArray) {
                   JSONArray jsonarray = json.getJSONArray(nextKeys);
                   for(int i=0;i<jsonarray.length();i++) {
                      String jsonArrayString = jsonarray.get(i).toString();
                      JSONObject innerJson = new JSONObject (jsonArrayString);
                      if(exists == false)  {
                          getKey(innerJson, key);
                      }
                   }
               }
            
        } catch (Exception e) {
            // TODO: handle exception
            }
           }
       }
       else {
           parseObject(json,key);
       }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String inputJson= "{\r\n"
                + "    \"id\": \"0001\",\r\n"
                + "    \"type\": \"donut\",\r\n"
                + "    \"name\": \"Cake\",\r\n"
                + "    \"image\":\r\n"
                + "        {\r\n"
                + "            \"url\": \"images/0001.jpg\",\r\n"
                + "            \"width\": 200,\r\n"
                + "            \"height\": 200\r\n"
                + "        },\r\n"
                + "    \"thumbnail\":\r\n"
                + "        {\r\n"
                + "            \"url\": \"images/thumbnails/0001.jpg\",\r\n"
                + "            \"width\": 32,\r\n"
                + "            \"height\": 32\r\n"
                + "        }\r\n"
                + "} ";
        JSONObject inputJsonObject = new JSONObject(inputJson);
        getKey(inputJsonObject,"url");
        String id = JsonPath.read(inputJson, "$.image.url");
        System.out.println(id);
    }

}
