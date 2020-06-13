/**
 * 
 */
package String_Matching;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author manjaripokala
 *
 */
public class Out {
	
	//Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    //private static final String FILE_HEADER = "Text,Pattern,Index";
    
	
	public static void Write(String Text, String Pattern, 
	    		String index) {
		 
		   BufferedWriter bw = null;
		   
		      try {
		    	
		     //file name 
			 File file = new File("/Users/"
	            		+ "manjaripokala/Documents/"
	            		+ "Algorithmic_Foundations/Project/Out.csv");

				
				
			 /* Create file if it is not present at the
			  * specified location*/
			  if (!file.exists()) {
			     file.createNewFile();
			   //Write the CSV file header
			   //bw.write(FILE_HEADER);
			             
			   //Add a new line separator after the header
			   //bw.write(NEW_LINE_SEPARATOR);
			  }
			  

				 FileWriter fw = new FileWriter(file, true);
				 bw = new BufferedWriter(fw);

			
			
			bw.write(Text);
			bw.write(COMMA_DELIMITER);
			bw.write(Pattern);
			bw.write(COMMA_DELIMITER);
			bw.write(index);
  			bw.write(NEW_LINE_SEPARATOR);
		   

		      } catch (IOException ioe) {
			   ioe.printStackTrace();
			}
			finally
			{ 
			   try{
			      if(bw!=null)
				 bw.close();
			   }catch(Exception ex){
			       System.out.println("Error in closing the BufferedWriter"+ex);
			    }
			}
		   }
}
