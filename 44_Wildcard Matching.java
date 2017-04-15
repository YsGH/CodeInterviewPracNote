// plement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

public class Solution {
    public boolean isMatch(String s, String p) {
        int lastStar=-1;
        int si=0, pi=0, starMatch=0;
        if (p.length()==0) {
            return s.length()==0;
        }
        while (si<s.length()) {
            if (pi<p.length()) {
                if (p.charAt(pi)=='?' || s.charAt(si)==p.charAt(pi)) {
                    si++;
                    pi++;
                    continue;
                }
                if (p.charAt(pi)=='*') {
                    lastStar=pi;
                    starMatch=si;
                    pi++;
                    continue;
                }
            }
            if (lastStar==-1) {
                return false;
            }
            pi=lastStar+1;
            starMatch++;
            si=starMatch;
        }
        while (pi<p.length() && p.charAt(pi)=='*') {
            pi++;
        }
        return pi==p.length();
        
    }
}