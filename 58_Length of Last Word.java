// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example, 
// Given s = "Hello World",
// return 5.

public class Solution {
    public int lengthOfLastWord(String s) {
        int res=0;
        s=s.trim();
        for (char c: s.toCharArray()) {
            if (c==' ') {
                res=0;
            } else {
                res++;
            }
        }
        return res;
    }
}

// better one, from the end

public int lengthOfLastWord(String s) {
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
}