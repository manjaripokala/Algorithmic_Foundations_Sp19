/**
 * 
 */
package String_Matching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author manjaripokala
 *
 */
public class Read_Text {
		
		//Delimiters used in the CSV file
	    // private static final String COMMA_DELIMITER = ",";
	    
	    
	    public static List<Text> read(String filename)
	    {
	    	//Create List for holding Data objects
	    	List<Text> textList = new ArrayList<Text>();
	    	
	        BufferedReader text_file = null;
	        
	        try
	        {
	        	// Read text to be searched
	            text_file = new BufferedReader(new FileReader(filename));
	            
	            String line = "";
	            //Read to skip the header
	            //text_file.readLine();
	            //Reading from the second line
	            while ((line = text_file.readLine()) != null) 
	            {
	            	//System.out.println(line); don't split by comma
	                String[] textdata = line.split("&^%");
	                if(textdata.length > 0 )
	                		//&&  textdata[0].length() > 0)
	                {
	                    //Save the data details in data object
	                	Text data = new Text(textdata[0].toLowerCase());
	                    textList.add(data);
	                }
	            }
	            
	            //Print length of data
	            System.out.println(textList.size());
	        
	        }
	        catch(Exception ee)
	        {
	            ee.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	            	text_file.close();
	            }
	            catch(IOException ie)
	            {
	                System.out.println("Error occured while closing the BufferedReader");
	                ie.printStackTrace();
	            }
	        }
	        
	        return textList; 
	    }
	    
	    
	    public static List<Text> data_multiply(List<Text> text_List, int multiply, int limit) {
	    	List<Text> textList = new ArrayList<Text>();
	    	
	    	for (int i = 0; i<multiply; i++) {
	    		for(Text e : text_List) {
	    			if (textList.size() >= limit) break;
	    			textList.add(e);
	    		}
	    	}
	    	System.out.println(textList.size());
	    	return textList;
	    }
}
