// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
// (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public String convert(String s, int row) {
    int n = s.length();
    if (n < 3 || row == 1) {
        return s;
    }
    int col = (n - 1) / (row - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < row; i++) {
        int j = i;
        while (j < n) {
            sb.append(s.charAt(j));
            if (i != 0 && i != row - 1) {
                int k = j + (row - 1-i) * 2;
                if (k < n) {
                    sb.append(s.charAt(k));
                }
            }
            j += (row - 1) * 2;
        }
    }
    return sb.toString();
}