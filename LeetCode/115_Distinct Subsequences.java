// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by 
// deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
// (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.

public class Solution {
    public int numDistinct(String s, String t){
        int m=s.length();
        int n=t.length();
        if (m<n) {
            return 0;
        }
        if (n==0) {
            return m;
        }
        int[] res=new int[m];
        int first=-1;
        int pre=0;
        for (int i=0; i<n; i++) {
        	int start=first+1;
        	first=-1;
            for (int j=start; j<m; j++) {
                if (t.charAt(i)==s.charAt(j)) {
                	if (first==-1) {
                		first=j;
                	}
                    if (j==start) {
                        pre=res[j];
                        if (j==0) {
                            res[j]=1;
                        } else {
                            res[j]=res[j-1];
                        }
                    } else if (i==0) {
                        res[j]=res[j-1]+1;
                    } else {
                        int temp=res[j];
                        res[j]=res[j-1]+pre;
                        pre=temp;
                    }
                } else {
                    pre=res[j];
                    if (first!=-1 && j!=0) {
                        res[j]=res[j-1];
                    } else {
                        res[j]=0;
                    }
                }
            }
            if (first==-1) {
            	return 0;
            }
        }
        return res[m-1];
    }
}