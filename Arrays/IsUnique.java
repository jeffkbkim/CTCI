/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/
// assume ASCII (128)
public class IsUnique {
	boolean isUnique(String str) {
		boolean[] duplicate = new boolean[128];	
		for (int i = 0; i < str.length(); i++) {
			if (duplicate[str.charAt(i)]) return false;
			duplicate[str.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		IsUnique iu = new IsUnique();
		System.out.println(iu.isUnique("hello"));
		System.out.println(iu.isUnique("world"));
		
	}

}
