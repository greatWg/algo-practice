package algo.string;

import java.util.HashMap;

public class MaxNumberOfWordOccurance {
    public int maxNumberOfBalloons(String text) {

        String word = "balloon";

        HashMap<Character, Integer> balloonMap = new HashMap<Character, Integer>();
        setBalloonMap(balloonMap);
        for (Character c : text.toCharArray()) {
            if (balloonMap.containsKey(c)) {
                balloonMap.put(c, balloonMap.get(c) + 1);
            }
        }
        // string Balloon count

        int minCount = balloonMap.get(word.charAt(0)) ;
        int tempCharCount= 0;
        for (int i=0;i< word.length();i++){
            char currentChar= word.charAt(i);
            if( currentChar== 'l'  || currentChar== 'o') {
                 tempCharCount = (balloonMap.get(currentChar)/2);

            } else {
                tempCharCount = balloonMap.get(currentChar);
            }

            minCount= Math.min(tempCharCount, minCount);

        }
//        if (balloonMap.containsKey(c)){
//                if (balloonMap.get(c)-1==0){
//                    balloonMap.remove(c);
//                }
//                else {
//                    balloonMap.put(c, balloonMap.get(c) - 1);
//                }
//                //balloonMap.get(c)-1
//            }
//        if (text.isEmpty()){
//            return count;
//        }
//        HashMap<Character, Integer> balloonMap = new HashMap<Character, Integer>();
//        setBalloonMap(balloonMap);
//
//        // initialize balloon
//        for (Character c: text.toCharArray()){
//            if(balloonMap.isEmpty()){
//                // count++;
//                setBalloonMap(balloonMap);
//                ballonCount= ballonCount+1;
//            }
//            if (balloonMap.containsKey(c)){
//                if (balloonMap.get(c)-1==0){
//                    balloonMap.remove(c);
//                }
//                else {
//                    balloonMap.put(c, balloonMap.get(c) - 1);
//                }
//                //balloonMap.get(c)-1
//            }
//        }
//
//        if(balloonMap.isEmpty()){
//           ballonCount= ballonCount+1;
//        }

        return minCount;

    }

    private void setBalloonMap(HashMap<Character, Integer> balloonMap){
        int count =0;
        String searchBalloon= "balloon";
        // HashMap<Character, Integer> balloonMap = new HashMap<Character, Integer>();
        for (Character c: searchBalloon.toCharArray()){
            if (balloonMap.containsKey(c)){
                //balloonMap.put(c);
            }else{
                balloonMap.put(c,count);
            }
        }
    }

    public static void main(String[] args) {
        MaxNumberOfWordOccurance maxWordCount= new MaxNumberOfWordOccurance();

//        String word0= "nlaebolko";
//        System.out.println( word0 + " : " + maxWordCount.maxNumberOfBalloons(word0));
//
//        String word1= "loonbalxballpoon";
//        System.out.println( word1 + " : " + maxWordCount.maxNumberOfBalloons(word1));
//
//        String word2= "leetcode";
//        System.out.println( word2 + " : " + maxWordCount.maxNumberOfBalloons(word2));
//
//        String word3= "";
//        System.out.println( word3 + " : " + maxWordCount.maxNumberOfBalloons(word3));
//
//        String word4= "baoollnnololgbax";
//        System.out.println( word4 + " : " + maxWordCount.maxNumberOfBalloons(word4));

        String word5= "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println( "long string" + " : " + maxWordCount.maxNumberOfBalloons(word5));

    }
}
