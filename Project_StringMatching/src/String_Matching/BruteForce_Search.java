/**
 * 
 */
package String_Matching;


import java.util.List;

/**
 * @author manjaripokala
 *
 */
public class BruteForce_Search {
		
	
		//Memory 
		private static final long MEGABYTE = 1024L * 1024L;

		public static long bytesToMegabytes(long bytes) {
			return bytes / MEGABYTE;
		}
	
		
	    public  static void main(String[] args) {
	    	
	    	//Read Text file
	    	List<Text> textList = Read_Text.read("/Users/"
	            		+ "manjaripokala/Documents/"
	            		+ "Algorithmic_Foundations/Project/Housing_Inventories_2005_to_2018.csv");
	        
	        
	        // Read pattern file
	        List<Pattern> patternList = Read_Pattern.read("/Users/"
            		+ "manjaripokala/Documents/"
            		+ "Algorithmic_Foundations/Project/pattern.csv");
	        
	       
			//multiply data to replicate
			textList = Read_Text.data_multiply(textList, 10000, 500);
			
			//Start time
			long startTime = System.currentTimeMillis();
			
			
	        for(Text e : textList) {
	        	for(Pattern p : patternList) {
	        		
	        		BruteForce.search(e.gettext(), p.getpattern());
	        		Out.Write(e.gettext(), p.getpattern(), BruteForce.search(e.gettext(), p.getpattern()));
	            	}
	            }
	            
	        long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("Elapsed Time in MilliSeconds " + elapsedTime);
            
	         // Get the Java runtime
                Runtime runtime = Runtime.getRuntime();
                // Run the garbage collector
                runtime.gc();
                // Calculate the used memory
                long memory = runtime.totalMemory() - runtime.freeMemory();
                System.out.println("Used memory is bytes: " + memory);
                System.out.println("Used memory is megabytes: "
                        + bytesToMegabytes(memory));
                
                
	            
	        }	    
}
