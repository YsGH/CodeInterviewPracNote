/*
Input: S = "12-4A0r7-4k", K = 4
k>0,S not null
Input only has numbers, letters, and dashes
only Uppercase in output

Output: "1-24A0-R74K"
*/

class Solution {
  static String license (String s, int k) {
    int cur=k;
    StringBuilder sb=new StringBuilder();
    
    for (int i=s.length()-1; i>=0; i--) {
      char c=s.charAt(i);
      if (c=='-') {
        continue;
      }
      if (cur==0) {
        sb.append('-');
        cur=k;
      }
      cur--;
      if (c>='0' && c<='9') {
        sb.append(c);
      } else {
        sb.append(Character.toUpperCase(c));
      }
    }
    return sb.reverse().toString();
  }
  public static void main(String[] args) {
    System.out.println(Solution.license("12-4A0r7-4k",4));
  }
}

// Give a list of word [dog, dove, zebra, duck]
// change it into the shortest prefix that can identfity the word
// [dog, dov, z, du], suppose there is no do in the list

solution 1: sort the array, and compare with the neigbours
solution 2: make trietree
