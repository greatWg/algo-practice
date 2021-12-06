package algo.string;

import java.util.*;
public class LongestPalindrom {

	/**
	 * @param st string
	 */
	//Recognize only odd length of palindrome
	public int LongestPalindromString(String st){
		int longest=0;
		List<Integer> palindromSizelist= new ArrayList<Integer>();
		int index=0;
		int p =0;
		int size=0;
		int e=0;
	
		while(index<st.length()){
			
			//System.out.println("start while"+"i: "+index +" p: "+p);
			if (index> p && st.charAt(index-p-1)==st.charAt(index)){
				p+=2;
				index++;
				continue;
			}
			palindromSizelist.add(p);
			longest=Math.max(longest, p);
			size=palindromSizelist.size()-2;
			e=size-p;
			//System.out.println("s: "+size +" e: "+e);
			boolean found= false;
			
			//found palindrome
			for(int j=size; j<e;j--){
				int d=j-e-1;
				if(palindromSizelist.indexOf(j)==d){
					p=d;
					found=true;
					break;
				}
			}
			if (!found){
				p=1;
				index++;
			}
		}
		
		palindromSizelist.add(p);
		longest= Math.max(longest, p);
		return longest;
	}
	public static void main(String[] args) {
		LongestPalindrom l= new LongestPalindrom();
		//int n=l.LongestPalindromString("abcdcbbcdcbb");
		int n=l.LongestPalindromString("dbacbcabcdeedcbaba");
		System.out.println("length of string:"+n);
	}


}