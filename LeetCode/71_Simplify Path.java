// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack=new ArrayDeque<>();
        String[] p=path.split("/");
        for (String s: p) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollFirst();
                }
                continue;
            }
            stack.offerFirst(s);
        }
        StringBuilder sb=new StringBuilder();
        sb.append('/');
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
            sb.append('/');
        }
        if (sb.length()!=1) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}