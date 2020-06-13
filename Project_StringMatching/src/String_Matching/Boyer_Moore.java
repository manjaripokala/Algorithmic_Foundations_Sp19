/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Boyer_Moore {
	
	public static String search(String text, String pattern){
        int[] slide_arr = Boyer_Moore_Slide.slide_array(pattern);
        String found_at = "Found at: ";
        int j = 0; // pattern index     

        for (int i = 0; i<(text.length() - pattern.length() + 1);){
        	
                for(j = pattern.length() -1; j>=0; j--){

                        if(text.charAt(i+j) != pattern.charAt(j)){
                                i = i + Math.max(1, j - slide_arr[text.charAt(i+j)]);
                                break;
                        }
                }
                if (j < 0) {
                        found_at = found_at + " " + (i + 1) + ",";
                        i = i + pattern.length();
                }
                //i ++;
        }
        return found_at;
}


}
