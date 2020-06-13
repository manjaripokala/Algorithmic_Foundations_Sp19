/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class BruteForce {
	
	
	public static String search(String text, String pattern) 
    { 
		String found_at = "Found at: ";
  
        /* A loop to slide text one by one */
        for (int i = 0; i <= text.length() - pattern.length(); i++) { 
  
            int j; 
  
            // check for pattern match
            for (j = 0; j < pattern.length(); j++) 
                if (text.charAt(i + j) != pattern.charAt(j)) 
                    break; 
  
            if (j == pattern.length()) 
            	found_at = found_at + (i + 1); 
        }
        return found_at;
    } 

}
