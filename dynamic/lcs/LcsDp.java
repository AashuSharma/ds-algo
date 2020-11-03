import java.util.Arrays;
class LcsDp {
    public int longestCommonSubsequence(String text1, String text2) {
        int memo[][] = new int[text1.length()][text2.length()];
        for(int[] arr: memo) {
            Arrays.fill(arr,-1);
        }
        return lcs(text1, text2, 0,0, memo);
    }
    private int lcs(String s1, String s2, int i, int j, int[][] memo) {
        System.out.println("s1: "+s1+" s2: "+s2+" i: "+i+" j: "+j);
        if(s1.charAt(i) == s2.charAt(j)) {
            if(i+1<s1.length() && j+1<s2.length()) {
                if(memo[i+1][j+1] == -1) {
                    memo[i+1][j+1] = lcs(s1, s2, i+1, j+1, memo);
                }
                return 1+ memo[i+1][j+1];
            } else 
                return 1;
        } else {
            int out1 =0;int out2=0;
            if(j+1<s2.length()) {
                if(memo[i][j+1] == -1) {
                    memo[i][j+1] = lcs(s1, s2, i, j+1, memo);
                    out1=memo[i][j+1];
                }
            }
            if(i+1<s1.length()) {
                if(memo[i+1][j] == -1) {
                    memo[i+1][j] = lcs(s1,s2,i+1,j, memo);
                    out2=memo[i+1][j];
                }
            }
            return Math.max(out1, out2);
        }
    }
}
