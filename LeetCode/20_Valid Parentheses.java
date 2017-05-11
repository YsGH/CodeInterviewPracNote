// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    public boolean isValid(String s) {
		Deque<Character> stack=new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c=='(' || c=='[' || c=='{' ) {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char pre=stack.pop();
			if ((pre=='(' && c==')') || (pre=='[' && c==']') || (pre=='{' && c=='}')) {
				continue;
			}
			return false;
		}
		return stack.isEmpty();
	}