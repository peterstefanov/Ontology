package com.ontology.emoji.model.ontresources.emojiresources;

import java.util.ArrayList;

public abstract class EmojiResources {

	public abstract void addResource(ArrayList<String> entry);
	
	/**
	 * Returns all annotations per row in ArrayList with first character as
	 * upper case.
	 * 
	 * @param entry
	 * @return annotationNames
	 */
	public ArrayList<String> getAnnotationNames(ArrayList<String> entry) {
		String annotation[];
		annotation = entry.get(4).split(",");

		ArrayList<String> annotationNames = new ArrayList<String>();
		for (int i = 0; i < annotation.length; i++) {
			if (annotation[i].contains(":")) {
				annotationNames.add(annotation[i]);
			} else {
				String tmp = annotation[i].replaceAll("\\W", "");
				annotationNames.add(tmp.substring(0, 1).toUpperCase() + tmp.substring(1, tmp.length()));
			}

		}
		return annotationNames;
	}
	
	
	/**
	 * Description potentially become class name
	 * @param entry
	 * @return String clasName
	 */
	public String getClassName(ArrayList<String> entry) {
		String description[];
		description = entry.get(2).split("\\s+");

		ArrayList<String> descriptionName = new ArrayList<String>();
		for (int i = 0; i < description.length; i++) {
			String tmp = description[i].replaceAll("\\W", "");
			descriptionName.add(tmp.substring(0, 1).toUpperCase() + tmp.substring(1, tmp.length()));
		}

		String className = "";
		for (int i = 0; i < description.length; i++) {
			className += description[i].substring(0, 1).toUpperCase()
					+ description[i].substring(1, description[i].length());
		}
		return className;
	}
	
	public String getUnicode(ArrayList<String> entry) {

		return entry.get(0);
	}
}
