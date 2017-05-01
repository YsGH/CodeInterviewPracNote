// iven a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// String[] keyboard=new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public List<String> letterCombinations(String digits) {
        if (digits.length()==0) {
            return new ArrayList<String>();
        }
        List<StringBuilder> sbs=new ArrayList<StringBuilder>();
        sbs.add(new StringBuilder(""));
        String[] keyboard=new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char n:digits.toCharArray()) {
            List<StringBuilder> newlist=new ArrayList<StringBuilder>();
            for (StringBuilder sb: sbs) {
                for (char c:keyboard[n-'0'].toCharArray()) {
                	StringBuilder temp=new StringBuilder(sb);
                    newlist.add(temp.append(c));
                }
            }
            sbs=newlist;
        }
        List<String> res=new ArrayList<>();
        for (StringBuilder sb: sbs) {
            res.add(sb.toString());
        }
        return res;
    }