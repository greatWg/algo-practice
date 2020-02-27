package algo.WordSearch;

import java.util.ArrayList;
import java.util.List;

public class Moves {
	
	List<String> Directions;
	
	int m;
	int n;
	
	int nextRowIndex=0;
	int nextColumnIndex=0;
	
	public Moves(){
		Directions= new ArrayList<String>() ;
		Directions.add("LR");
		Directions.add("RL");
		Directions.add("U");
		Directions.add("D");
		Directions.add("DUL");
		Directions.add("DUR");
		Directions.add("DDL");
		Directions.add("DDR");
	}	
	
	public void nextMove(int i, int j, String direction)
	{
		if (direction == Directions.get(0) &&  j>=0 && j<n-1 ) 
		{ 
			j++;//LR
		}
		if (direction == Directions.get(1) && j>0 && j<=n  )
		{
			j--;//RL
		}
		if (direction == Directions.get(2) && i<=m && i>0)
		{
			i--;//UP
		}
		if (direction == Directions.get(3) && i>=0 && i< m-1)
		{
			i++;//down
		}
		if (direction == Directions.get(4) && i>0 && j>0)
		{
			i--;j--;//DUL
		}
		if (direction == Directions.get(5) && i>0 && j<n-1)
		{
			i--;j++;//DUR
		}
		if ( direction == Directions.get(6) && i<m-1 && j>0)
		{
			i++;j--;//DDL
		}
		if(direction == Directions.get(7) && i<m-1 && j<n-1)
		{
			i++;j++;//DDR
		}
		nextRowIndex= i;
		nextColumnIndex=j;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
