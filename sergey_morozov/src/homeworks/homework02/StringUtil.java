package homeworks.homework02;

public class StringUtil {

	static int searchSubstring(char[] str, char[] substr) {
		
		for (int i = 0; i < str.length-1; i++) {
			if (str[i] == substr[0]) {
			for (int j = 1; j < substr.length; j++) { 
				if (str[i+1] == substr[j]) {
					continue;
				}
				return i;
			}
		}
		}
		return -1;
	}
	

	
	public static void main(String[] args) {
		
		char[] str = "I am a robot. My name is Charlie".toCharArray();
		char[] substr = "rob".toCharArray();
		System.out.println(searchSubstring(str,substr));

	}

}
