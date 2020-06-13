/**
 * 
 */
package String_Matching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author manjaripokala
 *
 */
public class CSV_Reader {

		//Delimiters used in the CSV file
		private static final String COMMA_DELIMITER = ",";
		
		public static void main(String args[])
		{
			 
			Scanner scanner = null;
			try {
				//Get the scanner instance
				scanner = new Scanner(new File("Employee.csv"));
				//Use Delimiter as COMMA
				scanner.useDelimiter(COMMA_DELIMITER);
				while(scanner.hasNext())
				{
						System.out.print(scanner.next()+"   ");
				}
			} 
			catch (FileNotFoundException fe) 
			{
				fe.printStackTrace();
			}
			finally
			{
				scanner.close();
			}
		}

}
