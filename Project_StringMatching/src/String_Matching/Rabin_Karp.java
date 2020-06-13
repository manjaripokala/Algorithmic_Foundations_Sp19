/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Rabin_Karp{

	// With extended ASCII codes, there are a total 256 characters
	public static final int base = 256;

	public static final int modulo_prime = 977;


	public static String search(String text, String pattern){ 
		
		// assign pattern & text lengths to variables at first to save execution time
		int p = pattern.length();
		int t = text.length();
	
		if (t < p) // sometimes pattern can be larger than text
			return "null";
		
		
		String found_at = "Found at: ";
		int character_check_index = 0;
		int text_hash = 0;

		//pattern hash
		int pattern_hash = Hash.hash(pattern, p, modulo_prime);
		//System.out.println(pattern_hash);

		// text hash - first pattern length characters
			text_hash = Hash.hash(text, p, modulo_prime);

		//calculation of Radix
		// Be sure to calculate power = length - 1 since 4 digit has highest power of 3
		int RD = 1;
		for(int r=0; r<p-1; r++){
			RD = ( RD * base ) % modulo_prime; // apply modulo for value to be lesser
		}
	
		for(int i = 0; i<(t-p+1); i++){
			//System.out.println("text:" + text_hash);
			//System.out.println("patt:" + pattern_hash);
			if (text_hash == pattern_hash){
				//check if each character equal
				for(character_check_index = 0; character_check_index<p; character_check_index++){
					if(text.charAt(i + character_check_index) != pattern.charAt(character_check_index)) 
					break;
				}
				if (character_check_index  == p)
				found_at = found_at + " " + (i+1);
			}
			
			//else 
			// Add Q to old hash value before subtracting with 1st character, ensures hash to be positive value
                        // For value to be lesser, we can always use modulo on every operation
			if (i < (t - p)){
	
				text_hash = ((text_hash + modulo_prime - ((text.charAt(i) * RD) % modulo_prime)) * base) % modulo_prime;
				text_hash = (text_hash + text.charAt(i+p)) % modulo_prime;

			}
		}
		
		return found_at;

		}

}

