package algo.SpellChecker;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import algo.SpellChecker.DataStructure.Node;

public class SpellCheckerCorrecter {

	static RadixTree tree =new RadixTree();
	
	public List<String> readFile()
	{
		List<String> list= new ArrayList<String>();
		String fileName="Files/DOfwords.txt"; //"Files/DictionaryOfWords.txt";
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int wordCount=0;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   
			{
				//list.add(strLine);
				System.out.println(" Input: " +strLine );
				tree.insert(tree.root,strLine);
				tree.PrintTree(tree.root);
				System.out.println();
				wordCount++;
			}
		}
		catch(Exception ex)
		{
			System.err.println("Error: " + ex.getMessage());
		}
		System.out.print(list.size());
		return list;
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpellCheckerCorrecter corrector = new SpellCheckerCorrecter();
		List<String> list= corrector.readFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		while ( input !="exit"){
			try {
				System.out.println(">");
				tree.MatchedWord="";
				input= br.readLine();
				if(tree.lookup(input))
				{
					if (tree.MatchedWord.matches(input))
					{
						System.out.println("Word contains in dictionary, so no need correction.");
					}
					else
					{
						System.out.println("Did you mean ?" + tree.MatchedWord); 
					}
				}
				else
				{
					//System.out.println(tree.SuccessorNode)
					corrector.GetWords(tree.GetSuccessorWords(tree.SuccessorNode, tree.MatchedPrefix, input.length()), input);
				}
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	private void SearchWordAgain(Node successorNode, String matchedprefix, String input)
	{
		String InputSuffix= input.substring(matchedprefix.length());
		
		
		
		
	}
	
	private void GetWords(HashMap<Integer, ArrayList<String>> possibleWords,String input) 
	{
//		if (possibleWords.containsKey(input.length())){
//			ArrayList<String> list= possibleWords.get(input.length());
//			
//			System.out.println();
//		}
		
		Iterator i = possibleWords.entrySet().iterator();
		while(i.hasNext())
		{
			Entry<Integer,ArrayList<String>> value= (Entry<Integer, ArrayList<String>>) i.next();
			System.out.println(value.getKey());
			ArrayList<String> list= value.getValue();
			Iterator itr= list.iterator();
			while(itr.hasNext())
			{
				System.out.print("\t"+itr.next());
				
				
				
			}
		}
		
	}

	// len_s and len_t are the number of characters in string s and t respectively
	int LevenshteinDistance(String s,int len_s, String t,int len_t)
	{
		int cost;
		
	  /* base case: empty strings */
	  if (len_s == 0) return len_t;
	  if (len_t == 0) return len_s;
	 
	  /* test if last characters of the strings match */
	  if (s.charAt(len_s-1) == t.charAt(len_t-1)) cost = 0;
	  else cost = 1;
	 
	  /* return minimum of delete char from s, delete char from t, and delete char from both */
	  return Math.min(Math.min(LevenshteinDistance(s, len_s - 1, t, len_t    ) + 1,
	                 LevenshteinDistance(s, len_s    , t, len_t - 1) + 1),
	                 LevenshteinDistance(s, len_s - 1, t, len_t - 1) + cost);
	}

}
