package com.ontology.emoji.utils;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.ontology.emoji.model.OntologyModel;

public class WriteFile {

	private static Logger log = Logger.getLogger(WriteFile.class.getName());
	private final static String filePath = "EmojiOntology.owl";

	public WriteFile() {}
	
	public void writeOutput() {
		OntologyModel model = OntologyModel.getInstance();
			
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			model.getModel().write(fw, "RDF/XML-ABBREV");
			fw.close();
			System.out.println("Done! \nEmojiOntology.owl was generated.");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			log.error("FileNotFoundException: ", fnfe);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			log.error("IOException", ioe);
		}
	}
}
