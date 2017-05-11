// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// Note:
// The vowels does not include the letter "y".

public class Solution {
    public String reverseVowels(String s) {
		if (s.length() <= 1) {
			return s;
		}
		char[] array=s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (!isVowel(Character.toLowerCase(array[left])) && left<right) {
				left++;
			}
			while (!isVowel(Character.toLowerCase(array[right])) && left<right) {
				right--;
			}
			if (left==right) {
				break;
			}
			char temp=array[left];
			array[left++]=array[right];
			array[right--]=temp;
		}
		return new String(array);
	}

	boolean isVowel(char c) {
		switch (c) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		}
		return false;
	}
}