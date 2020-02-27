package algo.WordSearch;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrossWords {

	private static final String WordListFile ="Files/WordList.txt";
	private static final String WordSearchFile = "Files/WordSearch.txt";
	
	public static void main(String[] args) {
		CrossWords crossWords = new CrossWords();
		Words words = new Words();
		Moves moves= new Moves();
		
		WordSearchSpace search= new WordSearchSpace();
		words.insert(crossWords.readFile(WordListFile));
		search.createSearchSpace(crossWords.readFile(WordSearchFile));
		
		moves.m=search.row;
		moves.n=search.column;
		SearchWords(words.wordsMap, search.wordSearch ,moves );
	}
	
	private static void SearchWords(HashMap<Character, List<String>> wordsMap, char[][] wordSearch,Moves moves) 
	{	
		String prefix;int currentRowIndex=0, currentColumnIndex=0; int wordCount=0;
		
		int count=0;
		for (int i=0; i<moves.m; i++){
			for(int j=0; j<moves.n; j++)
			{
				char c = wordSearch[i][j];
				List<String> possibleWords= wordsMap.get(c);
				if (possibleWords!=null)
				{
					currentRowIndex=i; currentColumnIndex=j;
					for(String direction : moves.Directions)
					{
						for(String word:possibleWords)
						{
							i=currentRowIndex; j=currentColumnIndex;
							prefix= String.valueOf(c);
							count=0;
							while ((word.startsWith(prefix)) && (prefix.length()<word.length()))
							{	
								moves.nextMove(i, j, direction);
								i = moves.nextRowIndex;
								j =	moves.nextColumnIndex;	
								prefix= prefix + String.valueOf(wordSearch[i][j]);
								//System.out.print("\t"+direction+":" + wordSearch[i][j] );
								//System.out.println("Matched word "+ prefix + "\t Length:"+count++);
								if (prefix.matches(word))
								{
									//System.out.println("---------------------------");
									System.out.println(String.format( wordCount++ +" %s found in direction %s at row %d and column %d",word, direction, currentRowIndex, currentColumnIndex));
									//System.out.println("---------------------------");
									//remove from List
									//possibleWords.remove(word);
								}
							}
							
						}
						//update Wordsmap
						wordsMap.put(c, possibleWords);
						//System.out.println (String.format(" at row %d and column %d", i, j ));
					}
					i=currentRowIndex; j=currentColumnIndex;
					//System.out.println("\ni and J"+ i +"\t"+j);
				}
			}
		}
	}
	
	public List<String> readFile(String fileName)
	{	
		List<String> lines = new ArrayList<String>();
		String line;
		try 
		{
			FileInputStream fis= new FileInputStream(fileName);
			DataInputStream st= new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(st));
			while((line = br.readLine()) != null)
			{
				lines.add(line) ;
			}
		} 
		catch (FileNotFoundException e)
		{	
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return lines;
	}
}
