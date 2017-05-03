// Given a list of strings, you need to find the longest uncommon subsequence among them. 
// The longest uncommon subsequence is defined as the longest subsequence of one of these strings and 
// this subsequence should not be any subsequence of the other strings.

// A subsequence is a sequence that can be derived from one sequence by deleting some characters 
// without changing the order of the remaining elements. Trivially, 
// any string is a subsequence of itself and an empty string is a subsequence of any string.

// The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. 
// If the longest uncommon subsequence doesn't exist, return -1.

// Example 1:
// Input: "aba", "cdc", "eae"
// Output: 3
// Note:

// All the given strings' lengths will not exceed 10.
// The length of the given list will be in the range of [2, 50].

public class Solution {
    public static Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes) res.add(s.charAt(0) + seq);
        return res;
    }
    public int findLUSlength(String[] strs) {
        Set<String> set = new HashSet<>();
        Arrays.sort(strs, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		if (a.equals(b)) {
        			return 0;
        		}
        		if (a.length() == b.length()) {
					int i = 0;
					while (a.charAt(i) == b.charAt(i)) {
						i++;
					}
					return a.charAt(i) < b.charAt(i) ? -1 : 1;
				}
        		return a.length() > b.length() ? -1 : 1;
        	}
        });
        int n = strs.length;
        for (int i = 0; i < n; i++) {
        	String s = strs[i];
        	if (i+1<n && s.equals(strs[i + 1])) {
        		set.addAll(getSubseqs(s));
        		while (i+1<n && s.equals(strs[i+1])) {
        			i++;
        		}
        		continue;
        	}
        	if (!set.contains(s)) {
        		return s.length();
        	}
        }
        return -1;
    }
}