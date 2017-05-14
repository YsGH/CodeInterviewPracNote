// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

public class Solution {
    boolean[][] matrix;
    public boolean isInterleave(String s1, String s2, String s3) {
        matrix = new boolean[s1.length()+1][s2.length()+1];
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if (n3!=n1+n2) {
            return false;
        }
        return helper(s1, s2, s3);
    }
    
    boolean helper(String s1, String s2, String s3){
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if (n1==0) {
            return s3.equals(s2);
        }
        if (n2==0) {
            return s3.equals(s1);
        }
        matrix[n1][n2]=true;
        boolean f1=false;
        boolean f2=false;
        if (s3.charAt(0)==s2.charAt(0) && !matrix[n1][n2-1]) {
            f1=helper(s1,s2.substring(1, n2),s3.substring(1,n3));
        }
        if (f1) return f1;
        if (s3.charAt(0)==s1.charAt(0) && !matrix[n1-1][n2]) {
            f2=helper(s1.substring(1, n1),s2,s3.substring(1,n3));
        }
        return f2;
    }
}