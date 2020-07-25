import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		boolean response = true;
		System.out.println("Welcome to the Pig Latin translator.");
		System.out.println();
		while (response == true) {
			Scanner scnr = new Scanner(System.in);
			System.out.println("Enter a sentence to be translated: ");
			System.out.println();
			String line = scnr.nextLine();
			if (line.isEmpty()) {
				System.out.println("Please enter a sentence.");
				System.out.println();
				continue;
			}
			line=line.toLowerCase();
			String[] words;
			words = line.split(" ");
			String finalLine = "";
			String punc = "";

			for (int i = 0; i < words.length; i++) {

				// Checking punctuations here
				String punct[] = { "!", "?", ".", ";", ",", "-", ":" };
				for (int j = 0; j < punct.length; j++) {
					if (words[i].contains(punct[j])) {
						int index = words[i].indexOf(punct[j]);
						words[i] = (words[i].substring(0, index)).toString()
								+ (words[i].substring(index + 1)).toString();

						punc = punct[j];
					}
				}
				
// Checking words starts with vowels
				if ((words[i].charAt(0) == 'a') || (words[i].charAt(0) == 'e') || (words[i].charAt(0) == 'i')
						|| (words[i].charAt(0) == 'o') || (words[i].charAt(0) == 'u')) {

					words[i] = words[i] + "way";
				} else
		//Checking words with consonants
				{
					words[i] = words[i].substring(1) + words[i].charAt(0) + "ay";
				}

				finalLine = finalLine + words[i].toString() + punc + " ";
				punc = "";
			}
			
			System.out.println(finalLine + "\n");
			System.out.println("Translate another sentence ?(y/n)");
			response = scnr.next().equalsIgnoreCase("y");

		}
		System.out.println("Thanks for playing Pig Latin game");
	}
}
