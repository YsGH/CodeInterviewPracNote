// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Solution {
    public int strStr(String s, String t) {
        int n=s.length();
        int m=t.length();
        if (n<m) {
            return -1;
        }
        for (int i=0; i<n-m+1; i++) {
            int j=0;
            while (j<m && s.charAt(i+j)==t.charAt(j)) {
                j++;
            }
            if (j==m) {
                return i;
            }
        }
        return -1;
    }
}