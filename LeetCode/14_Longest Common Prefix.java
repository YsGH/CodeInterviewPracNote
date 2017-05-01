// Write a function to find the longest common prefix string amongst an array of strings.

public String longestCommonPrefix(String[] strs) {
    StringBuilder res=new StringBuilder();
    if (strs.length==0) {
        return res.toString();
    }
    for (int i=0;i<strs[0].length(); i++) {
        char c=strs[0].charAt(i);
        for (int j=1;j<strs.length;j++) {
            String s=strs[j];
            if (i>=s.length() || c!=s.charAt(i)) {
                return res.toString();
            }
        }
        res.append(c);
    }
    return res.toString();
}