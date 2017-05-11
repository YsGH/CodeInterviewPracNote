// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", 
// it is the fifth second-level revision of the second first-level revision.

// Here is an example of version numbers ordering:

// 0.1 < 1.1 < 1.2 < 13.37

public class Solution {
    public int compareVersion(String v1, String v2) {
		List<Integer> n1=seperate(v1);
        List<Integer> n2=seperate(v2);
        int i=0;
        while (i<n1.size() && i<n2.size()) {
            if (n1.get(i)==n2.get(i)) {
                i++;
                continue;
            }
            return n1.get(i)<n2.get(i)?-1:1;
        }
        if (i==n1.size() && i==n2.size()) {
            return 0;
        }
        return i==n1.size()?-1:1;
    }
    
    List<Integer> seperate(String s) {
        List<Integer> res=new ArrayList<>();
        int start=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!='.') {
                continue;
            }
            res.add(Integer.valueOf(s.substring(start, i)));
            start=i+1;
        }
        res.add(Integer.valueOf(s.substring(start)));
        int end=res.size()-1;
        while (end>0 && res.get(end)==0) {
            res.remove(end);
            end--;
        }
        return res;
    }
}