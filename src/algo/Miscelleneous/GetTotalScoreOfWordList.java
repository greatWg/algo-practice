package algo.Miscelleneous;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
  by its alphabetical position in the list to obtain a name score.  For example, when the list is sorted into
  alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
  So, COLIN would obtain a score of 938 × 53 = 49714.  What is the total of all the name scores in the file?
 */
public class GetTotalScoreOfWordList {

    public List<String> readFile (String filePath)  {
        String seperator = ",";
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(seperator);
                System.out.println( "parsed line " + values[0]+ values[1]);
                records= Arrays.asList(values);
                System.out.println( "List"+  records.get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
    public void printList(List<String> list){
        for( int i =0;  i<list.size();i++){
           // System.out.println(list.get(i));
        }
    }
    public int getScore(List<String> list){
        int score = 0;
        // sort the list using Array.sort method
        Collections.sort(list);
        // calculate the ascii value of name
        for (int i =0; i<list.size(); i++){
            String word = list.get(i).toString();
            //System.out.println( "word "+ word);
            int currentElementScore =  getScoreByAlphabet(word) * (i+1);
            score += currentElementScore;
        }
        return score;

    }
     private int getScoreByAlphabet(String word) {

        int wordScore=0;
        for (int i=1; i<word.length()-1;i++){
               int c = word.charAt(i);
               wordScore +=  (c == 34) ? 0 : c - 64;
               //System.out.println("char"+ word.charAt(i));
               System.out.println("word : " + word + " score : " + wordScore + "char : " + word.charAt(i) + "ascii value " + c);

       }
        System.out.println("word : "+  word + " score : "  + wordScore);
        return wordScore;
     }
}
