import java.util.HashMap;
public class IsPermutation {
	public boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) return false;
		HashMap<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			Integer count = charCount.getOrDefault(a.charAt(i), 0);
			charCount.put(a.charAt(i), ++count);
		}
		for (int i = 0; i < b.length(); i++) {
			Integer count = charCount.getOrDefault(b.charAt(i), 0);
			charCount.put(b.charAt(i), --count);
		}
		for (Character c: charCount.keySet()) {
			if (charCount.get(c) != 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "hello";
		String b = "elloh";
		IsPermutation ip = new IsPermutation();
		System.out.println(ip.isPermutation(a, b));
		String c = "leetcodeallday";
		String d = "yeetcoddalldal";
		System.out.println(ip.isPermutation(c, d));
	}
}

