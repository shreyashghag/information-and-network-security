import java.lang.Math;

public class vernam {
	public static void main(String args[]) {
		// This would be the text we encrypt (in this case "hello")
		// We convert it to a character array
		String text = new String("hello");
		char[] arText = text.toCharArray();

		// This would be our vernam cipher (should be same length as our text)
		// Here we use the same letters, but theoretically should be random
		// characters generated on the fly. USE RANDOM LETTERS!
		String cipher = new String("XYZHG");
		char[] arCipher = cipher.toCharArray();

		// Array to hold our encryption (again same length)
		char[] encoded = new char[5];

		// Encrypt the text by using XOR (exclusive OR) each character
		// of our text against cipher.
		System.out.println("Encoded " + text + " to be... ");
		for (int i = 0; i < arText.length; i++) {
			encoded[i] =  (char) (arText[i] ^ arCipher[i]);
			System.out.print(encoded[i]);
		}

		 System.out.println("\nDecoded to be... ");

		// Run through the encrypted text and against the cipher again
		// This decrypts the text.
		for (int i = 0; i < encoded.length; i++) {
			char temp = (char) (encoded[i] ^ arCipher[i]);
			System.out.print(temp);
		}
	  
	}
}
