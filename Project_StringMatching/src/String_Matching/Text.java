/**
 * 
 */
package String_Matching;

/**
 * @author manjaripokala
 *
 */
public class Text {

	    private String text;  
	    
	    public Text(String text) {
	        super();
	        this.text = text;
	    }
	    
	    public String gettext() {
	        return text;
	    }
	    public void settext(String text) {
	        this.text = text;
	    }
	    
	    @Override
	    public String toString() {
	        return "text=" + text ;
	    }
}
