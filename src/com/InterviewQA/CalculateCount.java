package com.InterviewQA;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class CalculateCount {

	private static  Map<Character, Integer> hashMap = new HashMap<Character,Integer>();
	
	public static void main(String[] args) 
	{
		int count=1;
		CalculateCount calculateCount = new CalculateCount();
		String fileName= "Files/autogram.txt" ;
		char[] chars = calculateCount.Process( fileName);
		
		for(int i =0; i< chars.length; i++)
		{
			System.out.print(i+ " : "+chars[i]);
			if (!hashMap.containsKey(chars[i]))
			{	
				hashMap.put(chars[i], count);
			}
			else
			{
				System.out.print( "   incremented from  : "+hashMap.get(chars[i]));
				hashMap.put(chars[i], hashMap.get(chars[i])+1);
				System.out.println( " to : "+hashMap.get(chars[i]));
				
				//hashtable.replace(chars[i],  (Integer)hashTable.get(chars[i])+1);
			}
		}
		
		 for( char i : hashMap.keySet())
		 {
			 System.out.println( "Key :"+i+" Value: "+hashMap.get(i));
		 }
	}

	private char[] Process(String fileName) 
	{
		File file = new File (fileName);
		char[] chars=null;
		try 
		{
			FileReader reader= new FileReader(file);
			chars = new char[(int)file.length()];
			reader.read(chars);
		
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return chars;
	}
}
