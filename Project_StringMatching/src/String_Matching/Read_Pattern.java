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
public class Read_Pattern {
		
		//Delimiters used in the CSV file
	    private static final String COMMA_DELIMITER = ",";
	  //Create List for holding Data objects
        static List<Pattern> patternList = new ArrayList<Pattern>();
	    
	    public static List<Pattern> read(String filename)
	    {
	        BufferedReader pattern_file = null;
	        
	        try
	        {
	        	// Read pattern
	            pattern_file = new BufferedReader(new FileReader(filename));
	            
	            String line = "";
	            //Read to skip the header
	            //pattern_file.readLine();
	            //Reading from the second line
	            while ((line = pattern_file.readLine()) != null) 
	            {
	                String[] patterndata = line.split(COMMA_DELIMITER);
	                if(patterndata.length > 0 )
	                {
	                    //Save the data details in data object
	                	Pattern data = new Pattern(patterndata[0].toLowerCase());
	                    patternList.add(data);
	                }
	            }
	            
	            //Print length of data
	            System.out.println(patternList.size());
	        
	        }
	        catch(Exception ee)
	        {
	            ee.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	            	pattern_file.close();
	            }
	            catch(IOException ie)
	            {
	                System.out.println("Error occured while closing the BufferedReader");
	                ie.printStackTrace();
	            }
	        }
	        
	        return patternList; 
	    }
}
