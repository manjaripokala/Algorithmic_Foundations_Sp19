
/**
 * 
 */
package String_Matching;


/**
 * @author manjaripokala
 *
 */
public class KMP {

        public static String KMP_search(String text, String pattern){
                int[] lps = LPS.calculate_lps(pattern);
                int window_j = 0;
                String found_at = "Found at:";
                for (int i = 0; (i < text.length() && window_j < pattern.length());){
                        if (text.charAt(i) == pattern.charAt(window_j)){
                        		//System.out.println("i:" + i + "window_j:" + window_j);
                                if (window_j == pattern.length() - 1){
                                        //found_at[++found_index] = (i - window_j) + 1; // in general, letter count starts at 1
                                		found_at = found_at + " " + ((i - window_j) + 1) + ",";
                                        //reset window_j
                                        window_j = lps[window_j-1];
                                }
                                window_j++;
                                i++;
                        } else {
                        		if (window_j >0) window_j = lps[window_j-1];
                                if(window_j == 0) i++;
                                //System.out.println("i:" + i + "window_j:" + window_j);
                        }
                }
                //if (window_j) == pattern.length()
                return found_at;
        }
}
