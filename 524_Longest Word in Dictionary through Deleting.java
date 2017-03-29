// Given a string and a string dictionary, find the longest string in the dictionary that can 
// be formed by deleting some characters of the given string. 
// If there are more than one possible results, return the longest word with the smallest lexicographical order. 
// If there is no possible result, return the empty string.

// Example 1:
// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]

// Output: 
// "apple"
// Example 2:
// Input:
// s = "abpcplea", d = ["a","b","c"]

// Output: 
// "a"

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        int len=0;
        String ret="";
        int n=s.length();
        for (String word: d) {
            int m=word.length();
            if (n<m || m<len) {
                continue;
            }
            if (m==len && ret.compareTo(word)<0) {
                continue;
            }
            int dpos=0;
            for (int i=0; i<n; i++) {
                if (n-i<m-dpos) {
                    break;
                }
                if (s.charAt(i)==word.charAt(dpos)) {
                    dpos++;
                    if (dpos==m) {
                        ret=word;
                        len=m;
                        break;
                    }
                }
            }
        }
        return ret;
    }
}