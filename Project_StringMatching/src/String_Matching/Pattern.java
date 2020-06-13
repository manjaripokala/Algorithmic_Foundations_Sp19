/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Pattern {

	    private String pattern;  
	    
	    public Pattern(String pattern) {
	        super();
	        this.pattern = pattern;
	    }
	    
	    public String getpattern() {
	        return pattern;
	    }
	    public void setpattern(String pattern) {
	        this.pattern = pattern;
	    }
	    
	    @Override
	    public String toString() {
	        return "pattern=" + pattern ;
	    }
}
