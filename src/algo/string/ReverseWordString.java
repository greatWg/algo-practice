package algo.string;

public class ReverseWordString {
	
	public String reverseString(String input){
		String revInput;
		int i, j;
		
		char [] revArray= new char[input.length()];
		for (i=0, j=input.length()-1;i<input.length();i++, j--){
			 revArray[j]= input.charAt(i);
		}
		revInput= String.copyValueOf(revArray); 
		return revInput;
	}
	 
	public String ReverseWordOfString(String in){
		String word=this.reverseString(in);
		StringBuffer sb= new StringBuffer();
		for ( int i=0; i< in.length();i++){
			if ( word.indexOf(" ")==-1 && word != null){
				String s= this.reverseString(word);
				sb.append(s);
				i+=word.length();
			}
			else if (word.indexOf(" ")<=word.lastIndexOf(" ") ){
				String s= this.reverseString(word.substring(i, word.indexOf(" ")));
				sb.append(s);
				i=(word.indexOf(" ")+1);
				word= word.substring(i, word.length());
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordString RW= new ReverseWordString();
		String word=RW.reverseString("Hello World");
		System.out.println(" Reverse Word: "+word);  // dlroW olleH
		String revWord=RW.ReverseWordOfString("Hello World");
		System.out.println(" Reverse Word: "+revWord);  //World Hello

		String revWord1=RW.ReverseWordOfString("Hello World great");
		System.out.println(" Reverse Word: "+revWord1);  //World Hello
	}
}
