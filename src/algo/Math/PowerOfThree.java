package algo.Math;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        //System.out.print("value "+ n );
        if (n<1){
            return false;
        }
        while(n%3==0){
            n=n/3;
        }
        return n==1;
    }

    public static void main(String[] args) {
        PowerOfThree pt= new PowerOfThree();
        System.out.println("27 expected true : " +pt.isPowerOfThree(27));
        System.out.println("9 expected true : " +pt.isPowerOfThree(9));
        System.out.println("0 expected false : " +pt.isPowerOfThree(0));
        System.out.println("45 expected false : " +pt.isPowerOfThree(45));

        System.out.println("1 expected true : " +pt.isPowerOfThree(1));
        System.out.println("3 expected true : " +pt.isPowerOfThree(3));

        System.out.println(" 19684 expected true : " +pt.isPowerOfThree(19684));
    }
}
