// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        StringBuilder cur=new StringBuilder();
        helper(res, cur, s, 4);
        return res;
    }
    
    void helper(List<String> res, StringBuilder cur, String s, int left) {
        if (left==1) {
            if (s.charAt(0)=='0' && s.length()!=1) {
                return;
            }
            if (Integer.valueOf(s)<=255) {
                StringBuilder ip=new StringBuilder(cur);
                ip.append(s);
                res.add(ip.toString());
            }
            return;
        }
        int n=s.length();
        if (n<left || n>left*3) {
            return;
        }
        for (int i=0; i<3 && i<s.length()-1; i++) {
            if (s.charAt(0)=='0') {
                helper(res, cur.append("0."), s.substring(1,n), left-1);
                cur.delete(cur.length()-2, cur.length());
                break;
            }
            String d=s.substring(0,i+1);
            if (Integer.valueOf(d)<=255) {
                helper(res, cur.append(d+"."), s.substring(i+1,n), left-1);
                if (cur.charAt(cur.length()-1)=='.') {
                	cur.deleteCharAt(cur.length()-1);
                }
                cur.delete(cur.length()-i-1, cur.length());
            }
        }
    }
}