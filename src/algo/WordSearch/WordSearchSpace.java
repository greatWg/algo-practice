package algo.WordSearch;

import java.util.List;

public class WordSearchSpace {
	
	char[][] wordSearch;
	int row ;
	int column;
	
	public void createSearchSpace(List<String> lines)
	{
		row = lines.get(0).length();
		column = lines.size();
		wordSearch= new char[row][column];
		int i=0;
		for(String s:lines ){
			wordSearch[i]= s.toCharArray();
			i++;
		}
	}
	
}
