package algo.string;

public class PatternMatching
{
	private String text = "The Best Match pattern!";
	private String pattern= "pattern";
	
	public void matchPattern(String text, String pattern ){
		boolean  foundIt= false;
		for(int i=0; i<text.length()-pattern.length(); i++){
			if( text.regionMatches(i, pattern,0, pattern.length())){
				foundIt= true;
			System.out.println(text.substring(i, i+pattern.length()));
			}
		}
	}
	//find search string index in the text
	public int stringMatching(String text, String search){
		int textLength= text.length();
		int searchLength= search.length();
		int j=0;
		for (int i=0;i<textLength-searchLength; i++){
			 j=0;
			 while (j<searchLength && text.charAt(i+j)==search.charAt(j)){
				 j++;
			 }
			 if (j==searchLength){
				 System.out.println("index: "+i);
				 return(i);
			 }
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "The Best Match pattern!";
		String pattern= "pattern";
		PatternMatching pm= new PatternMatching();
		pm.matchPattern(text, pattern);
		pm.stringMatching(text, pattern);
	
	}

}
