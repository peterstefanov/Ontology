package com.ontology.emoji;

import com.ontology.emoji.utils.ReadFile;

/**
 * Hello world!
 *
 */
public class Main {
	
	private final static String filePath = "file/EmojiUnicodes.xlsx";

	
	public static void main(String[] args) {

		if (args == null || args.length == 0) {
			System.out.println(
					"\nEmojiUnicodes.xlsx file provided in  ../resources/file/ will be used!"
				 +  "\nTraversing over each row of EmojiUnicodes.xlsx file ............................"
				 +  "\nBuilding the Ontology...........................................................");
			ReadFile rf = new ReadFile(filePath);
			rf.readInput();
		} else {
			System.out.println("Try again without passing arguments!");
		}		
	}
}
