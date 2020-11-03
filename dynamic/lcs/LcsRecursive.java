public class LcsRecursive {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()<text2.length()) {
            return lcs(text1, text2, 0,0);
        } else 
            return lcs(text2, text1, 0,0);
    }
    private int lcs(String s1, String s2, int i, int j) {
        if(i==s1.length() || j==s2.length())
            return 0;
        else {
            if(s1.charAt(i) == s2.charAt(j)) {
                return 1 + lcs(s1, s2, i+1, j+1);
            } else {
                return Math.max(lcs(s1, s2, i, j+1), lcs(s1,s2,i+1,j));
            }
        }
    }
}
