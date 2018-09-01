/*
One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
*/
import java.util.HashMap;
import java.lang.Math;
public class OneAway {

	public boolean oneAway(String a, String b) {
		int diff = 0;
		HashMap<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < a.length(); i ++) {
			int count = charCount.getOrDefault(a.charAt(i), 0);
			charCount.put(a.charAt(i), ++count);
		}
		for (int i = 0; i < b.length(); i++) {
			int count = charCount.getOrDefault(b.charAt(i), 0);
			charCount.put(b.charAt(i), --count);
		}
		for (Character c: charCount.keySet()) {
			diff += Math.abs(charCount.get(c));
		}
		return (diff) <= 2 ? true : false;
	}
	public static void main(String[] args) {
		String a = "jacing";
		String b = "facing";
		OneAway oa = new OneAway();
		System.out.println(oa.oneAway(a,b));
	}
}
