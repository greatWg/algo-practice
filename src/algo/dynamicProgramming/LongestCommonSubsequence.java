package algo.dynamicProgramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();
        // empty string
        if (m==0 || n==0){
            return 0;
        }
        else{
            int [][] dp = new int[m+1][n+1];
            // first character no dp updated
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // check prev char and update current dp[r][c]
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // previous diagonal +1
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // max from (same row prev col, same col, prev row)
                    }
                }
            }
            printDP(dp);
            return dp[m][n];
        }
    }

    private void printDP(int[][] dp) {
        int m= dp.length;
        int n= dp[0].length;

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" "+ dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence seq = new LongestCommonSubsequence();
        System.out.println("expected 3 and result is " + seq.longestCommonSubsequence("abcde", "ace")); //true
        System.out.println("expected 3 and result is " + seq.longestCommonSubsequence("abc", "abc")); //true
        System.out.println("expected 0 and result is " + seq.longestCommonSubsequence("abc", "def")); //true
        System.out.println("expected 3 and result is " + seq.longestCommonSubsequence("ABCDGH", "AEDFHR")); // A D H
        System.out.println("expected 4 and result is " + seq.longestCommonSubsequence("AGGTAB", "GXTXAYB")); // GTAB
    }
}
