/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
*/

import java.util.HashMap;
public class IsPermuPalindrome {
	public boolean isPermuPalindrome(String a) {
		int uniqueChar = 0;
		HashMap<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			Character c = Character.toLowerCase(a.charAt(i));
			if (c == ' ') continue;
			int count = countMap.getOrDefault(c, 0);
			countMap.put(c, ++count);
		}
		for (Character c: countMap.keySet()) {
			if (countMap.get(c) % 2 != 0) uniqueChar++;
		}
		return uniqueChar > 1 ? false : true;
	}

	public static void main(String[] args) {
		String a = "tact Coa";
		IsPermuPalindrome isPP = new IsPermuPalindrome();
		System.out.println(isPP.isPermuPalindrome(a)); 
		System.out.println(isPP.isPermuPalindrome("helllllle")); 
	
	}
}
