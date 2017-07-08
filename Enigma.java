package Enigma;

/**
 * @author Nina
 *CSC 142
 *January 22, 2017
 */
public class Enigma {
	private String outer = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
	public String middle = "#EJOTYCHMRWAFKPUZDINSXBGLQV";
	public String inner = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
	
	/**
	 * Empty constructor
	 */
	public Enigma(){
		
	}
	
	/**
	 * @param inner
	 * @param middle
	 */
	public Enigma (String inner, String middle){
		this.inner = inner;
		this.middle = middle;
	}
	
	/**
	 * Make sure that the rotor is valid
	 * 27 characters long and include every letter in the alphabet
	 * @param rotStr is the string
	 * @return true if the rotor is valid
	 */
	public Boolean isRotorValid (String rotStr){
		rotStr = rotStr.toUpperCase();
		if (rotStr.length() != 27){//False if string is less than 27 characters
			return false;
		} 
		if (!(rotStr.startsWith("#"))){//False if string doesn't begin with #
			return false;
		}

		for (int i = 1; i < rotStr.length(); i++){
			char current = rotStr.charAt(i);//Takes one character at a time starting with index 1 and run it through a loop
			for (int j = i + 1; j <= rotStr.length()-1; j++){//Compare individual letters through the rest of alphabet
				if (current == rotStr.charAt(j)){//if individual letter match a letter from string, return false
					return false;
				}	
			}
		}
		return true;//return true if passes the 3 tests above
	}
	
	/**
	 * Takes a string (make it uppercase) and encrypt it
	 * Remove commas, period, and aposthrophe
	 * @param phrase
	 * @return the encrypted message
	 */
	public String encrypt (String phrase){
		phrase = phrase.toUpperCase();
		phrase = phrase.replaceAll(" ", "#");//replace spaces with "#"
		phrase = phrase.replaceAll("[.,']", "");//remove period, comma, aposthrophe
		String secretMessage = "";
		for (int i = 0; i < phrase.length(); i++){
			secretMessage += encode(phrase.charAt(i));
			rotate();
			secretMessage = secretMessage.replaceAll("#"," ");//prevent "#" from printing
		}
		return secretMessage;
	}
	
	/**
	 * Takes a string (make it uppercase) and decrypt it
	 * Remove commas, period, and aposthrope
	 * @param phrase
	 * @return the decrypted message
	 */
	public String decrypt (String phrase){
		phrase = phrase.toUpperCase();
		phrase = phrase.replaceAll(" ", "#");
		phrase = phrase.replaceAll("[.,']", "");
		String secretMessage = "";
		for (int i = 0; i < phrase.length(); i++){
			secretMessage += decode(phrase.charAt(i));
			rotate();
			secretMessage = secretMessage.replaceAll("#", " ");
		}
		return secretMessage;
	}
	
	/**
	 * Takes a character and encrypt it
	 * @param ch
	 * @return the encrypted letter
	 */
	private char encode (char ch){
		ch = Character.toUpperCase(ch);//This allow ch to return the actual index instead of -1
		int innerIndex = this.inner.indexOf(ch);//Index of char in inner rotor
		char outerAtIndex = this.outer.charAt(innerIndex);//Char on outer rotor at inner rotor
		int middleIndex = this.middle.indexOf(outerAtIndex);//Index of char from outer rotor in middle rotor 
		return this.outer.charAt(middleIndex);//outer char at middle index
	}
	
	/**
	 * Takes a character and decrypt it
	 * @param ch
	 * @return the decrypted character
	 */
	private char decode (char ch){
		ch = Character.toUpperCase(ch);
		int outterIndex = this.outer.indexOf(ch);
		char middleIndex = this.middle.charAt(outterIndex);
		int outerAtIndex = this.outer.indexOf(middleIndex);
		return this.inner.charAt(outerAtIndex);
	}
	
	/**
	 * This method just rotate the string clockwise when called
	 */
	private void rotate(){//rotate inner roter once clockwise
		String lastChar = inner.substring(inner.length()-1, inner.length());
		inner = lastChar + inner.substring(0, inner.length()-1);
	
	}
	//I combined the 3 method into one because they were just calling each other 
	//So to avoid passing parameters, it was easier to put them into one
	/*public int innerRoter (char character){
		int innerIndex = inner.indexOf(character);
		return innerIndex;
	}
	
	public char outerRoter(int innerRoter){
		char outerAtIndex = outer.charAt(innerRoter);
		return outerAtIndex;
		
	}
	
	public char middleRoter(char outerRoter){
		int middleIndex = middle.indexOf(outerRoter);
		return outer.charAt(middleIndex);
	}*/
	
	/**
	 * @return
	 */
	public String getOuter() {
		return outer;
	}

	/**
	 * @param outer
	 */
	public void setOuter(String outer) {
		this.outer = outer;
	}

	/**
	 * @return
	 */
	public String getMiddle() {
		return middle;
	}

	/**
	 * @param middle
	 */
	public void setMiddle(String middle) {
		this.middle = middle;
	}

	/**
	 * @return
	 */
	public String getInner() {
		return inner;
	}

	/**
	 * @param inner
	 */
	public void setInner(String inner) {
		this.inner = inner;
	}	
}
