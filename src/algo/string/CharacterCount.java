package algo.string;

import java.util.*;

public class CharacterCount {

    //Can be Char array by ascii value -- No because given input is scattered so no need to cover all characters
    // Good to be hashmap where key is char and update the count and later on sort by charcount values
    public LinkedHashMap<Character, Integer> characterCount(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedHashMap<Character, Integer> sortedMap= new LinkedHashMap<>();
        // if input is empty string
        if (s.length()==0){
            return sortedMap;
        }

        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        // sort map by character count descending order
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortedMap;
    }

    public static void main(String[] args) {

        CharacterCount count = new CharacterCount();
        String input= "aoNHQATeMNLuWC4vMdGgQpqMge7bit";
        PrintResult(count.characterCount(input), input);

        String input1= "aaaaoNHQATeMNLuWC4vMdGgQpqMge7bit";
        PrintResult(count.characterCount(input1), input1);

        String input2= "aaaao:::bit";
        PrintResult(count.characterCount(input2), input2);

        String input3= "";
        PrintResult(count.characterCount(input3), input3);

        String input4= "AA   bb";
        PrintResult(count.characterCount(input4), input4);
    }
    // Print the results for given different inputs
    private static void PrintResult(HashMap<Character, Integer> charCount, String input) {
        if (charCount.size()==0){
            System.out.println("Input is empty string");
        }
        System.out.println( "input : " + input);
        Iterator<Map.Entry<Character, Integer>> iterator= charCount.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> curr= iterator.next();
            System.out.println(" "+ curr.getKey()+ " : "+  curr.getValue());
        }
    }
}
