/*
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)

"Mr John Smith    "
"Mr%20John%20Smith"
*/
import java.util.Arrays;
public class URLify {
	public String urlify(String str) {
		char[] arr = str.toCharArray();
		int i = arr.length - 1, j = arr.length - 1;
		while(arr[j] == ' ') j--;
System.out.println(Arrays.toString(arr));
		for (; j >= 0; j--) {
			if (arr[j] != ' ') {
				swap(arr, i, j);
				i--;
			} else {
				arr[i] = '0';
				arr[i - 1] = '2';
				arr[i - 2] = '%';
				i -= 3;
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr.toString();
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	} 

	public static void main(String[] args) {
		URLify ify = new URLify();
		String url = "Mr John Smith    ";
		ify.urlify(url);
	}
}

