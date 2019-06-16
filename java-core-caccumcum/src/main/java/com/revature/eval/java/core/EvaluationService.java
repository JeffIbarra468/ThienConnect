package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		//Convert the phrase to upper case to avoid the case sensitive error
		phrase = phrase.toUpperCase();
		
		String acronym="";
		
		
		// extract the first letter from the phrase and add to the acronym string
		acronym = acronym + phrase.charAt(0);
		
		//search ' ' or '-' in the phrase and extract the character before that
		for(int i = 1; i<=phrase.length();i++) {
			if(phrase.charAt(i-1)== ' ' || phrase.charAt(i-1)==('-')){
				//add the extracted characters to the acronym
				acronym += phrase.charAt(i);
			}
		}
		
		return acronym;
		
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		//convert the string to upper case to avoid the case sensitive error
		string = string.toUpperCase();
		
		//Declare the total score 
		int total = 0;

		
		//Create a loop to run "length" times,
		// get each character in the string to compare in each case 
		// if the character from the string equals to the character in each case,
		// then return the number associated with that case 
		// finally, add the number to total and return the total score.
		for(int i=0; i<string.length(); i++) {
			
			switch (string.charAt(i)) {
			
			case 'A': case 'E': case 'I': case 'O': case 'U': case 'L': case 'N': case 'R': case 'S': case 'T':
				total += 1; 
				break;
			case 'D': case 'G': 
				total += 2; 
				break;
			case 'B': case 'C': case 'M': case 'P': 
				total += 3; 
				break;
			case 'F': case 'H': case 'V': case 'W': case 'Y': 
				total += 4; 
				break;
			case 'K': 
				total += 5;
				break;
			case 'J': case 'X': 
				total += 8; 
				break;
			case 'Z': case 'Q': 
				  total += 10;
				break;
			default: 
                break;
			}
			
		}
		return total;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		
		//Create an empty String str, 
		// loop through the given string at each character to check if it is a number, 
		// if it is number then add the character to the empty string.
		String str ="";
		for(int i=0;i<string.length();i++) {
			if(Character.isDigit(string.charAt(i))) {
				str += string.charAt(i);
			}}
		//check illegal format from given string.
		// if the length of the number does not equal to 10 then it is an invalid number
		//-------if(str.length()>10 || str.length()<10) {--------
		if(str.length()!=10) {
			 throw new IllegalArgumentException();
		}return str;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
		//clean up the string to remove \n of the string
		string = string.replaceAll("\n", "");
		
		//split up the string base on "," and " "
		// then add to a String array
		String[] strArray = string.split(",| ");
		
		//create a new HashMap with String and Integer
		Map<String, Integer> map = new HashMap<>();
		
		//Loop through the array 
		Integer count = 1;
		for(int i=0;i<strArray.length;i++) {
			// get the key from the map, if the key equal null, then return the value is 1 
			if (map.get(strArray[i]) == null) {
			    map.put(strArray[i], 1);
			}
			else {
				// if the key is not null then add 1 to the count for each loop then retun the value for the associate key. 
			    map.put(strArray[i], count +=1);
			}	
		}
		return map;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		
		private List<T> sortedList;
		
		public int indexOf(T t) {
			
			// create an Object array base on the given shorted list.
			Object[] array = sortedList.toArray();
			
			//loop through the array and compare the key (t)
			// if the key equal to the element in the array, return the loop count to get the index
			int index =0;
			for(int i=0; i<array.length;i++) {
				if(t.equals(array[i])) {
					index = i;
				}
				// need to search for the left and right when split up the in middle
			}
		
//			System.out.println(index);
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
			
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration

		// Cast the given number to a string
		String num = Integer.toString(input);
		
		
		int temp = 0;
		for(int i=0;i<num.length();i++) {
			// get the first character in the converted string power the length of the string
			temp += Math.pow(Character.getNumericValue(num.charAt(i)),num.length());
			
			} if (temp == input) {
				return true;
			}else {
				return false;
		}
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		
		// create a new ArrayList with type Long
		List<Long> numList = new ArrayList<Long>();
		
		 if(l == 2) {
			numList.add(l);
		
		}else {
			for(long i = 2; i< l; i++) {
		         while(l%i == 0) {
		            numList.add(i);
		            l = l/i;
		         }
		      }
			 if(l >2) {
		    	  numList.add(l);
		      }
		}
		return numList;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		static String plain =  "abcdefghijklmnopqrstuvwxyz";
		static String cipher = "zyxwvutsrqponmlkjihgfedcba";
		
		public static String encode(String string) {
			
			String str = cleanString(string);
			
			String encode = encode1(str);			
			
			String finalEndcode = groupString(encode);
			return finalEndcode;
		}
		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String str = cleanString(string);
			String decode = decode1(str);		
			return decode;
			}


		// This method group with the size in 5 from the given string
		private static String groupString(String str) {
			String groupStr ="";
			int count = 0;
			for (int j = 0; j <str.length();j++) {
				groupStr += str.charAt(j); count++;
				if (count%5 == 0 && count<str.length()) {
					groupStr += " ";
				}
			}return groupStr;
		}

		// this method will encode the string
		private static String encode1 (String str) {
			String encode="";
			for(int i=0; i<str.length();i++) {
				if(Character.isLetter(str.charAt(i))){
					for(int j=0; j<plain.length(); j++) {
						if (str.charAt(i)==plain.charAt(j)) {
							encode+=cipher.charAt(j);
						}
					}
				}else {
					encode+=str.charAt(i);
				}
			}
			return encode;
		}


		// this method to remove all characters in the string except letters and number
		private static String cleanString(String str) {
			str = str.toLowerCase();
			String str1 = "";
			
			for (int i=0; i<str.length();i++) {
				if(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
					str1 += str.charAt(i);
				}
			}	
			return str1;
		}
		
		// this method will decode the string
		private static String decode1(String str) {
			String decode="";
			//loop the the string ;
			for(int i=0; i<str.length();i++) {
				// check if the character is a letter then return the index from cipher string, to 
				if(Character.isLetter(str.charAt(i))){
					for(int j=0; j<plain.length(); j++) {
						if (str.charAt(i)==plain.charAt(j)) {
							decode+=cipher.charAt(j);
						}
					}
				}else {
					decode+=str.charAt(i);
				}
			}
			
			return decode;
		}
	}

	
/*----------------------------------------------------------------			
			To encode: This code is broke in methods
			 
			 remove all characters that are not letter or number
			String cleanString = "";
			for (int i=0; i<string.length();i++) {
				if(Character.isLetter(string.charAt(i)) || Character.isDigit(string.charAt(i))) {
					cleanString += string.charAt(i);
				}
			}	
			
			encode the string
			String encode="";
			for(int i=0; i<cleanString.length();i++) {
				if(Character.isLetter(cleanString.charAt(i))){
					for(int j=0; j<plain.length(); j++) {
						if (cleanString.charAt(i)==plain.charAt(j)) {
							encode+=cipher.charAt(j);
						}
					}
				}else {
					encode+=cleanString.charAt(i);
				}
			}
		
			split the string in group of 5
			String groupEncode ="";
			int count = 0;
			for (int j = 0; j <encode.length();j++) {
				groupEncode += encode.charAt(j); count++;
				if (count%5 == 0 && count<encode.length()) {
					groupEncode += " ";
				}
			}
			
-----------------------------------------------------------------*/			
					
/*-------------------------------------------------------------------------		
			To decode: This code is broke in methods
			
			String plain =  "abcdefghijklmnopqrstuvwxyz";
			String cipher = "zyxwvutsrqponmlkjihgfedcba";
			
			
			String cleanString = "";
			for (int i=0; i<string.length();i++) {
				if(Character.isLetter(string.charAt(i)) || Character.isDigit(string.charAt(i))) {
					cleanString += string.charAt(i);
				}
			}	
			
			String decode="";
			for(int i=0; i<cleanString.length();i++) {
				if(Character.isLetter(cleanString.charAt(i))){
					for(int j=0; j<plain.length(); j++) {
						if (cleanString.charAt(i)==plain.charAt(j)) {
							decode+=cipher.charAt(j);
						}
					}
				}else {
					decode+=cleanString.charAt(i);
				}
			}
------------------------------------------------------------------------------*/		
		

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13? 
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

 		//	declare  result = 0
		int result = 0;
		// remove the ? from the string
		string = string.replace("?", "");
		
		//split the string using " " to and put in the array
		String[] array = string.split(" ");	
		
		//Switch use the third index to return the result
		 switch (array[3]) {
		 case "plus": result = Integer.parseInt(array[2])+ Integer.parseInt(array[4]); break;
		 case "minus": result = Integer.parseInt(array[2])- Integer.parseInt(array[4]); break;
		 case "multiplied": result = Integer.parseInt(array[2])* Integer.parseInt(array[5]); break;
		 case "divided": result = Integer.parseInt(array[2])/ Integer.parseInt(array[5]); break;
		 default: break;
		 }
		return result;
	}

}
