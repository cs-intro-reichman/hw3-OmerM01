/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("William Shakespeare"));
		System.out.println(preProcess("I am a weakish speller"));

		
		// // Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// // Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if(str1.length() != str2.length()){
			return false;
		}

		for(int i = 0; i < str1.length(); i++){
			int how_Many_in_Str1 = 0;
			int how_Many_in_Str2 = 0;
	
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(j) == str1.charAt(i)) {
					how_Many_in_Str1++;
				}
			}
	
			for (int n = 0; n < str2.length(); n++) {
				if (str2.charAt(n) == str1.charAt(i)) {
					how_Many_in_Str2++;
				}
			}
	
			if (how_Many_in_Str1 != how_Many_in_Str2) {
				return false;
			}
		}

		return true;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newString = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				newString = newString + (char) (str.charAt(i) + 32);
			}
			else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				newString = newString + (char) str.charAt(i);
			}
			else if(str.charAt(i) == ' '){
				newString = newString + (char) str.charAt(i);
			}
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagram = "";
		while(str.length() > 0){
			int rndChar = (int) (Math.random() * str.length());
			anagram = anagram + str.charAt(rndChar);

			//take out the random char from str
			String newStr = "";
        	for (int i = 0; i < str.length(); i++){
          		if (i != rndChar){ 
                	newStr += str.charAt(i);
            	}
        	}
        	str = newStr; // Update the original string to be the new one without the random char
		}

		return anagram;
	}
}
