package com.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class inputFileTest {

	/**
	 * 	 * 
	 * @param args
	 */
	
	private FileInputStream fis=null;
	private ArrayList<Integer> a = new ArrayList<Integer>();
	public int[] readFile(){
		 
		//String fileName="Files/IntegerArray.txt";
		String fileName="Files/QuickSort.txt";
		try{
			File t = new File(fileName);
//			System.out.println(t.getAbsolutePath());
//			System.out.println(t.getPath());
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(fileName);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  int i=0;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				//  System.out.println (strLine);
				  a.add(Integer.parseInt(strLine));	 
			  }
			  //Close the input stream
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
		int []b =new int[a.size()];;
		for(int i=0; i<a.size();i++){
			b[i]=a.get(i);
		}
		return b;
	}
			  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		inputFileTest in= new inputFileTest();
//		in.readFile("Files/IntegerArray.txt");

	}

}
