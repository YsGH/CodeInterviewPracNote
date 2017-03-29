// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length()<=1) {
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while (left<right) {
            while (!valid(s.charAt(left)) && left<right) {
                left++;
            }
            while (!valid(s.charAt(right)) && left<right) {
                right--;
            }
            if (left==right) {
                return true;
            }
            if (!same(s.charAt(left++), s.charAt(right--))) {
                return false;
            }
        }
        return true;
        
    }
    
    boolean same(char c, char d) {
        if (c>='0' && c<='9') {
            return c==d;
        }
        int dif=c-d;
        return dif==0 || Math.abs(dif)==32;
    }
    
    boolean valid (char c) {
        if (c>='A' && c<='Z') {
            return true;
        }
        if (c>='a' && c<='z') {
            return true;
        }
        if (c>='0' && c<='9') {
            return true;
        }
        return false;
    }
}

// better ones

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}