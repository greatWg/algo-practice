package algo.string;

public class IsIntPalindrome {

    public boolean isPalindrome(int x) {

        if (x<0){
            return false ;
        }
        else {
            //reverse number
            int original =x;
            int reverse =0;
            while (x >0){
                int temp = x % 10 ;
                reverse = (reverse* 10 )+ temp ;
                x = x/10;
                System.out.println ( " temp :"+ temp + " reverse "+ reverse +" x " + x);
            }
            if (original == reverse){
                return true;
            }
            return false ;
        }
    }

    public static void main(String[] args) {
        IsIntPalindrome pal= new IsIntPalindrome();
        System.out.println (pal.isPalindrome(121) ); //true
        System.out.println (pal.isPalindrome(-121) ); //false
        System.out.println (pal.isPalindrome(10) ); //false
        System.out.println (pal.isPalindrome(-101) ); //false

    }
}
