// James Dizikes
// Jessie Gomez
// CS 1323/1324, Fall 2019
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;

public class Project11 {
// creating ArrayLists
	public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> common = readFile("common-dictionary.txt");
        ArrayList<String> personal = new ArrayList<>();
        
     // Try to read the personal dictionary file if it exists
        File personalFile = new File("personal-dictionary.txt");
        if (personalFile.exists()) {
            personal = readFile("personal-dictionary.txt");
        }

        // Sort the dictionaries to prepare them for binary search
        Collections.sort(common);
        Collections.sort(personal);

        // Example user interaction code for adding a new word to personal dictionary
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word or 'quit' to stop:");
        String word = scanner.nextLine().trim();

        while (!word.equals("quit")) {
            if (checkSpelling(word, common, personal)) {
                System.out.println("The word is spelled correctly.");
            } else {
                System.out.println("The word was not found in the dictionary.");
                System.out.println("Would you like to add it to your personal dictionary (yes/no)?");
                String response = scanner.nextLine().trim();

                if (response.equalsIgnoreCase("yes")) {
                    personal.add(word);
                    Collections.sort(personal); // Re-sort after adding new word
                }
            }

            System.out.println("Enter a word or 'quit' to stop:");
            word = scanner.nextLine().trim();
        }

        scanner.close();
        writeFile("personal-dictionary.txt", personal);
        System.out.println("Goodbye!");
    }

	// Read each line of a file and store them in a ArrayList
	public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
	    ArrayList<String> words = new ArrayList<>();
	    Scanner scanner = new Scanner(new File(fileName));
	    while (scanner.hasNextLine()) {
	        words.add(scanner.nextLine().trim());
	    }
	    scanner.close();
	    return words;
	}

	// Return true if word is in either array; otherwise, return false. 
	// The arrays are sorted, so binary search can be used again.
	public static boolean checkSpelling(String word, ArrayList<String> common, ArrayList<String> personal) {
	    return Collections.binarySearch(common, word) >= 0 || Collections.binarySearch(personal, word) >= 0;
	}
	
	// Write the nonempty elements of an ArrayList to a given file.
	public static void writeFile(String fileName, ArrayList<String> list) throws FileNotFoundException {
	    PrintWriter writer = new PrintWriter(fileName);
	    for (String word : list) {
	        writer.println(word);
	    }
	    writer.close();
	}
}