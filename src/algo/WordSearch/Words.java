package algo.WordSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Words {

	/**
	 * @param args
	 */
	// Storage for Words from WordSearch in correct order and reverse order  
	HashMap<Character, List<String>> wordsMap= new HashMap<Character, List<String>>();
	
	public void insert(List<String> list)
	{
		for(String s: list)
		{
			this.Add(s.replaceAll("\\s", "").toUpperCase(), s.toUpperCase().charAt(0));
			//this.Add(new StringBuffer(s).reverse().toString(), s.toLowerCase().charAt(s.length()-1));
		}
	}
	
	public void Add(String s, char c)
	{
		List<String> wordList=null;
		if (!wordsMap.containsKey(c)){
			 wordList= new ArrayList<String>();
			 wordList.add(s);
			 wordsMap.put((Character)c, wordList);	
		}else
		{
			 wordList= wordsMap.get(c);
			 wordList.add(s);
			 wordsMap.put((Character)c, wordList);
		}
	}
	
	public static void main(String[] args) {
		

	}

}
