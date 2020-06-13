/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Boyer_Moore_Slide {

	// to accommodate other language characters, let's take base as 1000 instead of 256
	// example text: cafǹ trieste (609 vallejo) - algorithm errors out
	public static final int base = 256;

    public static int[] slide_array(String pattern){
            int[] slide = new int[base];
            for(int i = 0; i<base; i++){
                    slide[i] = -1;
            }

            for(int j = 0; j<pattern.length(); j++){
                    slide[pattern.charAt(j)] = j;
            }
            return slide;
    }
}
