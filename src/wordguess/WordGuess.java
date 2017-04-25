/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordguess;
import java.util.Scanner;

 
 /**
  * Plays a word guessing game with one player.
  */
 public class WordGuess {

	public static void main(String[] args) {
                
                // Modified
		final String SECRET_WORD = "HORACE";
		final String FLAG = "!";
		String wordSoFar = "", updatedWord = "";
		String letterGuess, wordGuess = "";
		int numGuesses = 0;
                
                // Added
                int score;
                int maxPoint;
                int wordlength = 0;
                int diff;
                int choseFlag = 0;
                int flagWin = 0;
                
		Scanner input = new Scanner(System.in);
		
                // Added
                System.out.println("Choose difficulty (number of guesses): \n");
                System.out.println("Easy(1): 20, Normal(2): 15, Hard(3): 10, Dark Souls(4): 6   _");
                diff = input.nextInt();
                if (diff == 1) {
                    score = 200;
                    maxPoint = 200;
                    System.out.println("Kinda wimpy but okay");
                } else if (diff == 2) {
                    score = 150;
                    maxPoint = 150;
                    System.out.println("Fair enough");
                } else if (diff == 3) {
                    score = 100;
                    maxPoint = 100;
                    System.out.println("Kickin' it up a knotch, I like that");
                } else if (diff == 4) {
                    score = 60;
                    maxPoint = 60;
                    System.out.println("Let's see how this goes");
                } else {
                    score = 150;
                    maxPoint = 150;
                    System.out.println("Normal by default, learn to type next time");
                }
                
                
                
		/* begin game */
		System.out.println("WordGuess game.\n");
		for (int i = 0; i < SECRET_WORD.length() + 1; i++) {
			wordSoFar += "-";								//word as dashes
                        wordlength++;
		}
		System.out.println(wordSoFar + "\n");				//display dashes
	
		/* allow player to make guesses*/
		do {
			System.out.print("Enter a letter (" + FLAG + " to guess entire word): ");
			letterGuess = input.nextLine();
			letterGuess = letterGuess.toUpperCase();			
		
			/* increment number of guesses */
                        if (letterGuess.equals(FLAG)) {
                            
                        } else {
                           numGuesses += 1; 
                        }
			
			
			/* player correctly guessed a letter--extract string in wordSoFar up to the letter 
			 * guessed and then append guessed letter to that string. Next, extract rest of 
			 * wordSoFar and append after the guessed letter
			 */
			if (SECRET_WORD.indexOf(letterGuess) >= 0) {
				updatedWord = wordSoFar.substring(0, SECRET_WORD.indexOf(letterGuess)); 
				updatedWord += letterGuess;												
				updatedWord += wordSoFar.substring(SECRET_WORD.indexOf(letterGuess)+1, wordSoFar.length());
				wordSoFar = updatedWord;
			}
				
			/* display guessed letter instead of dash */
			System.out.println(wordSoFar + "\n");                       // Added
		} while (!letterGuess.equals(FLAG) && !wordSoFar.equals(SECRET_WORD) && (numGuesses * 10) <= score);
		
		/* finish game and display message and number of guesses */
		if (letterGuess.equals(FLAG)) {
			System.out.println("What is your guess? ");
			wordGuess = input.nextLine();
			wordGuess = wordGuess.toUpperCase();
                        
                        // Added
                        choseFlag = 1;
		}
		if (wordGuess.equals(SECRET_WORD) || wordSoFar.equals(SECRET_WORD)) {
                    if (choseFlag == 1) {
                        System.out.println("You won!");
                        flagWin = 1;
                    } else {
                        System.out.println("You won!");	
                    }
				
		} else {
			System.out.println("Sorry. You lose.");
		}
                
                
		System.out.println("The secret word is " + SECRET_WORD);
		System.out.println("You made " + (numGuesses - 1) + " guesses.");
                
                // Added
                int maxScore = (maxPoint - (wordlength * 10)) + 10;
                int finalScore = score - (numGuesses * 10);               
                System.out.println("Your score is: " + (finalScore + 10));
                
                if (flagWin == 1) {
                    int bonus = finalScore - (maxScore);
                    System.out.println("Guess bonus of " + (bonus + 10));
                }
                
                
                System.out.println("The maximum score for this word is " + maxScore);
	}
}