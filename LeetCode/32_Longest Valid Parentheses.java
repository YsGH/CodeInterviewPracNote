// Given a string containing just the characters '(' and ')', 
// find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public int longestValidParentheses(String s) {
    Deque<Character> stack=new ArrayDeque<>();
    Deque<Integer> nums=new ArrayDeque<>();
    int max=0;
    int cur=0;
    for (char c: s.toCharArray()) {
        max=Math.max(max, cur);
        if (c=='(') {
            nums.push(cur);
            stack.push(c);
            cur=0;
            continue;
        }
        if (stack.isEmpty()) {
            if (!nums.isEmpty()) {
                nums.clear();
            }
            cur=0;
            continue;
        }
        stack.pop();
        cur+=2;
        if (stack.size()<nums.size()) {
            cur+=nums.pop();
        }
    }
    return Math.max(cur, max);
}