/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Hash{

    // Using Horner's method for degree-M polynomial to calculate Hash
    // Referred from Princeton Algorithms course

    public static final int base = 256;
    public static int hash(String text, int length, int prime_q){
            int h = 0;
            if (length == 0) return 0;
            for (int i = 0; i<length; i++){
                    h = ((h * base) + text.charAt(i)) % prime_q;
            }

            return h;

    }

}
