/*
题目： plement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

＃recursion #dp #greedy #regex #wildcard #two pointers
*/
Solution 1: recursion
Solution 2: dp

Solution 3: greedy
纪录上一个＊号位置，然后先match 0个char，如果不能match下去，再match多一个
public boolean isMatch(String s, String p) {
	int i = 0;
	int j = 0;
	int starIndex = -1;
	int iIndex = -1;
 
	while (i < s.length()) {
		if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
			++i;
			++j;
		} else if (j < p.length() && p.charAt(j) == '*') {
			starIndex = j;		
			iIndex = i;
			j++;
		} else if (starIndex != -1) {
			j = starIndex + 1;
			i = iIndex+1;
			iIndex++;
		} else {
			return false;
		}
	}
 
	while (j < p.length() && p.charAt(j) == '*') {
		++j;
	}
 
	return j == p.length();
}

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
