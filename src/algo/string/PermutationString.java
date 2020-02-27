package algo.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

	private ArrayList<String> result= new ArrayList<String>();;
	public ArrayList<String>  Permutation (String s){
		
		if(s.length()==1)
		{
			result.add(s);
			
			
		}else if ( s.length()==2){
			result.add (s);
		
			result.add(swap(s.substring(0,1), s.substring(1,2)));
		}else {
			char [] temp= s.toCharArray();
			for( int i=0; i<s.length();i++){
				result.add(s.substring(i, i+1)+s.substring(i+1, s.length()));
				swap(s.substring(i, i+1), s.substring(i+1, s.length()));
				Permutation(s.substring(i+1,s.length()));
				swap( s.substring(i+1, s.length()), s.substring(i, i+1));
				result.add(s.substring(i+1, s.length())+ s.substring(i, i+1));
				
			}
		}
		 return result ;
		 
		
		 
	}
	private String swap (String x , String y){
		
		StringBuffer temp=  new StringBuffer();
		temp.append(y);
		temp.append(x);
	
		return temp.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationString p = new PermutationString();
		p.Permutation("123");
		
		for (int i=0; i<p.result.size(); i++){
			System.out.println( p.result.get(i));
		}
		
	}

}
