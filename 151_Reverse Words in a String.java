// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.

public class Solution {
    public String reverseWords(String s) {
        if (s==null && s.length()==0) {
            return s;
        }
        s=s.trim();
        String[] array=s.split(" ");
        if (array.length==0) {
        	return s;
        }
        StringBuilder sb=new StringBuilder();
        int n=array.length;
        for (int i=n-1; i>0; i--) {
            if (array[i].length()!=0) {
	            sb.append(array[i]);
	            sb.append(" ");
        	}
        }
        sb.append(array[0]);
        return sb.toString();
    }
}