// Given an array of words and a length L, format the text such that each line 
// has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
// Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. 
// If the number of spaces on a line do not divide evenly between words, 
// the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.

public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ret = new ArrayList<>();
    if (maxWidth == 0) {
        ret.add("");
        return ret;
    }
    Deque<String> line = new ArrayDeque<>();
    int lineWidth=0;
    for (String s:words) {
        int l=s.length();
        if (lineWidth+l>maxWidth && !line.isEmpty()) {
            int totalSpace=maxWidth-lineWidth+1;
            ret.add(lineToString(line, totalSpace));
            lineWidth=0;
        }
        line.offer(s);
        lineWidth+=l+1;
    }
    StringBuilder sb = new StringBuilder();
    while (!line.isEmpty()) {
        sb.append(line.poll());
        if (line.size() != 0) {
            sb.append(" ");
        }
    }
    while (sb.length()!=maxWidth) {
        sb.append(" ");
    }
    ret.add(sb.toString());
    return ret;
}

String lineToString(Deque<String> line, int s) {
    int n=line.size()-1;
    StringBuilder sb=new StringBuilder();
    if (n==0) {
        sb.append(line.poll());
        for (int j=0; j<s; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    int space=s/n+1;
    int residue=s%n;
    for (int i=0; i<residue; i++) {
        sb.append(line.poll());
        for (int j=0; j<=space; j++) {
            sb.append(" ");
        }
    }
    while (!line.isEmpty()) {
    sb.append(line.poll());
    if (line.size()!=0) {
            for (int j=0; j<space; j++) {
                sb.append(" ");
            }
    }
    }
    return sb.toString();
}