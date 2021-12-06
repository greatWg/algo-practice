package algo.string;

public class ReverseWordInSentence {

    // Reverse the words of the english sentence
    //I had an Apple. -> Apple an had I.

    public static void main(String[] args) {

        ReverseWordInSentence rvs= new ReverseWordInSentence();

        System.out.println( rvs.reverseWordInSentence( "I had an Apple" )); //Apple an had I
        System.out.println(rvs.reverseWordInSentence( "Hey, I want to eat an apple")); // apple an eat to want I, Hey
        System.out.println( rvs.reverseWordInSentence( "I had an Apple." )); //Apple an had I.
        System.out.println(rvs.reverseWordInSentence( "Hey, I want to eat an apple.")); //apple an eat to want I, Hey.
        System.out.println(rvs.reverseWordInSentence( "Hey! I want to eat an apple.")); // apple an eat to want I! Hey.
        System.out.println(rvs.reverseWordInSentence( "Hey! I'll eat eat an apple.")); // apple an eat eat I'll! Hey.
    }
    public String reverseWordInSentence(String sentence ){
        // constraint  not to worry invalid sentenceS
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split (" "); // i had  an apple  words: { I,  had,  an, apple}

        for (int i= words.length-1; i>=0; i--){
            if (hasSpecialCharacter(words[i])){
                char c= getSpecialChar(words[i]);
                if (c== '.'){
                    sb.append(words[i].replace(c,' ' ).trim());
                }else {
                    sb.append(c + " " + words[i].replace(c, ' ').trim());
                }
            }else
            {
                sb.append(" ");
                sb.append(words[i]);
            }
        }
        if (words[words.length - 1].endsWith(".")) {
            sb.append(".");
        }
        return sb.toString();
    }

    private char getSpecialChar(String word) {
        return word.charAt(word.length()-1);
    }

    private boolean hasSpecialCharacter(String word) {
        return (word.endsWith(",")|| word.endsWith("!") || word.endsWith(".") );
    }
}
