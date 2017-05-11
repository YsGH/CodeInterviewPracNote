// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

public class Solution {
    public int numDecodings(String s) {
        if (s.length()==0 || s.charAt(0)=='0') {
            return 0;
        }
        int pre=1;
        int cur=1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i)=='0') {
                if (i==0) {
                    return 0;
                }
                if (s.charAt(i-1)=='1' || s.charAt(i-1)=='2') {
                    cur=pre;
                    pre=1;
                    continue;
                } else {
                    return 0;
                }
            }
            if (s.charAt(i-1)!='0' && Integer.valueOf(s.substring(i-1, i+1))<=26) {
                int temp=cur;
                cur+=pre;
                pre=temp;
            } else {
                pre=cur;
            }
        }
        return cur;
    }
}