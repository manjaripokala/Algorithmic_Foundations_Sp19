/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class LPS {

        public static int[] calculate_lps(String pattern){
        	int[] lps = new int[pattern.length()];
            lps[0] = 0;  // Base case
            for (int i = 1; i < pattern.length(); i++) {
                // Start by assuming we're extending the previous LSP
                int j = lps[i - 1];
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                    j = lps[j - 1];
                if (pattern.charAt(i) == pattern.charAt(j))
                    j++;
                lps[i] = j;
            }
                return lps;
        }
	
}
