package algo.string;

public class FindEncryptedMethod {

    String getMidChar(String str){
        StringBuilder sb = new StringBuilder();
        int start=0;
        int end = str.length();
        if (str.length()>1){
            int mid= (start + end-1)/2 ;
            sb.append(str.charAt(mid));
            sb.append(getMidChar(str.substring(start, mid)));
            sb.append(getMidChar(str.substring(mid+1, end)));
            return sb.toString();
        }
        return str;
    }

    String findEncryptedWord(String s) {
        // Write your code here
        String R = getMidChar(s);

        return R;
    }

    public static void main(String[] args) {
        FindEncryptedMethod fem = new FindEncryptedMethod();
        System.out.println(fem.findEncryptedWord("abc"));

        System.out.println (fem.findEncryptedWord("abcd"));
    }

}
