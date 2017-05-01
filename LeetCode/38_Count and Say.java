// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

// Subscribe to see which companies asked this question.

public class Solution {
    public String countAndSay(int n) {
        String s="1";
        while (n>1) {
            s=helper(s);
            n--;
        }
        return s;
    }
    String helper (String s) {
        StringBuilder res=new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            int count=1;
            while (i+1<s.length() && s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
            }
            res.append(count);
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}