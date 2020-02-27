package com.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {
	private FileInputStream fis=null;
	private ArrayList<Integer> a = new ArrayList<Integer>();
	private ArrayList<Integer> b = new ArrayList<Integer>();
	public void readFile(){
		 
		//String fileName="Files/IntegerArray.txt";
		String fileName="Files/Jobs.txt";
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
			  int jobCount=0;
			  String s[]= new String[2];
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
				  // Print the content on the console
				//  System.out.println (strLine);
				  if (jobCount==0 ){
					  jobCount=Integer.parseInt(strLine);
				  }
				  else {
					  s= strLine.split(" ");
					  a.add(Integer.parseInt(s[0]));	
					  b.add(Integer.parseInt(s[1]));
				  }	
			  }
			  //Close the input stream
			  in.close();
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		Input i= new Input();
		i.readFile();
		for(int c=0;c<i.a.size(); c++){
			System.out.print(i.a.get(c));	System.out.println("   "+i.b.get(c));	
		}
	}
}
