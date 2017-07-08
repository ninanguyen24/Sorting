
package Enigma;
import java.util.*;

/**
 * @author Nina
 *CSC143
 *January 22, 2017
 *Encryption
 */
public class EnigmaClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Enigma test = new Enigma();
		
		intro();
		userSelection(test);
		encryptDecrypt(test);
	}
	
	/**
	 * This is just the introduction
	 */
	public static void intro (){
		System.out.println("Welcome to the Enigma Machine!");
		System.out.println("This machine can Encrypt or Decrypt your messages. " +
				"\nIt takes a letter from the inner ring, find the letter with matching" +
				"\nindex from the outer ring, then match the letter from the outter ring" +
				"\nwith the middle ring. Finally, it finds the matching index from the middle" +
				"\nletter with the inner ring to produce the Encrypt letter.");
		System.out.println("Decrypting does the same thing but in reverse.");
	}
	
	/**
	 * This ask the user what rotor settings do they want to do
	 * @param test
	 */
	public static void userSelection(Enigma test){
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1. Use default rotor settings");
		System.out.println("2. Input custom rotor settings");
		System.out.print("Selection: ");
		Scanner console = new Scanner(System.in);
		int userInput = console.nextInt();
		
		if (userInput == 1){
			System.out.println("Inner ring: " + test.getInner());
			System.out.println("Middle ring: " + test.getMiddle());
			System.out.println("Outer Ring: " + test.getOuter());

		} else if (userInput == 2) {
			System.out.println("Please create your INNER rotor (Starts with #"
					+ " and include every letter from the alphabet): ");
			String line = console.next();
			if (test.isRotorValid(line) == false){//test validity of user input for inner rotor
				System.out.println("The rotors are invalid. The default rotors will be used.");
				System.out.println(test.getInner());
			} else {
				test.setInner(line);
				System.out.println(test.inner);
			}
			System.out.println("Please create your MIDDLE rotor (Starts with #"
					+ " and include every letter from the alphabet): ");
			String line2 = console.next();
			if (test.isRotorValid(line2) == false){//test validity of user input for middle rotor
				System.out.println("The rotors are invalid. The default rotors will be used.");
				System.out.println(test.getMiddle());
			} else {
				test.setMiddle(line2);
				System.out.println(test.middle);
			}
		} else {
			System.out.println("Your input is invalid. Please rerun the program.");	
		}
		
	}
	
	/**
	 * This ask the user if they want to encrypt, decrypt or just see an example.
	 * It make sure the rotor the user entered is valid
	 * @param test
	 * Prints out the messages
	 */
	public static void encryptDecrypt (Enigma test){
		String example = "Enigma the first assignment";
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to: ");
		System.out.println("1. Encrypt");
		System.out.println("2. Decrypt");
		System.out.println("3. Run Default Example");
		int userInput = input.nextInt();
		
		if(userInput == 1){
			System.out.println("Please input a line to encrypt: ");
			input.nextLine();//the new line was prevent java from letting user input data, this solves it
			String line = input.nextLine();
			System.out.println(test.encrypt(line));
		} else if (userInput == 2){
			System.out.println("Please input a line to decrypt: ");
			input.nextLine();//the new line was prevent java from letting user input data, this solves it
			String line = input.nextLine();
			System.out.println(test.decrypt(line));
		} else if (userInput == 3){
			System.out.println(test.encrypt(example));
		} else {
			System.out.println("Your input is invalid. Here is the default example.");
			System.out.println(test.encrypt(example));
		}
	}
		
	
}
