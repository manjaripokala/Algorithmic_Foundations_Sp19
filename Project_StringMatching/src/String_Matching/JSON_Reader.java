/**
 * 
 */
package String_Matching;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * @author manjaripokala
 *
 */
public class JSON_Reader {
	
	    public static void main(String args[]) {
	        JSONParser parser = new JSONParser();
	        try
	        {
	            Object object = parser
	                    .parse(new FileReader("/Users/manjaripokala/Documents/Algorithmic_Foundations/Project/sample.json"));
	            
	          //convert Object to JSONObject
	            JSONObject jsonObject = (JSONObject)object;
	            
	            //Reading the String
	            String name = (String) jsonObject.get("Name");
	            Long age = (Long) jsonObject.get("Age");
	            
	            //Reading the array
	            JSONArray countries = (JSONArray)jsonObject.get("Countries");
	            
	            //Printing all the values
	            System.out.println("Name: " + name);
	            System.out.println("Age: " + age);
	            System.out.println("Countries:");
	            for(Object country : countries)
	            {
	                System.out.println("\t"+country.toString());
	            }
	        }
	        catch(FileNotFoundException fe)
	        {
	            fe.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	
}
