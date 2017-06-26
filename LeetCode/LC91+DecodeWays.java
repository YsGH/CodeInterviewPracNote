/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

key words: Dynamic Programming, DP

key point: a(n) = a(n-1) + a(n-2) if c(n-1)c(n) <= 26 otherwise a(n) = a(n-1)
            注意 0 的处理： 如果i是0，必须保证c(n-1)c(n) <= 26 且不为 0
            否则 不能decode
*/
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prepre = s.charAt(0) == '0' ? 0:1;
        int pre = s.charAt(0) == '0' ? 0:1;
        for (int i = 1; i < s.length(); i++) {
            int value = Integer.valueOf(s.substring(i-1, i+1));
            System.out.println(value);
            int temp = pre;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '0' || value > 26) {
                    return 0;
                }
                pre = prepre;
            } else if (value <= 26 && value >= 10) {
                pre = prepre + pre;
            }
            prepre = temp;
        }
        
        return pre;
    }
}


/*
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
