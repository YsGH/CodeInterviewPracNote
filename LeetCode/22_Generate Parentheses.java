// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

public class Solution {
    int p;
    public List<String> generateParenthesis(int n) {
        p=n;
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        dfs(res, sb, 0, 0);
        return res;
    }
    
    void dfs(List<String> res, StringBuilder sb, int left, int right) {
        if (left+right==p*2) {
            res.add(sb.toString());
            return;
        }
        if (left!=p) {
            sb.append('(');
            dfs(res, sb, left+1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<left) {
            sb.append(')');
            dfs(res, sb, left, right+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}