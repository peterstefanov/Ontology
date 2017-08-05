package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class PlaceClass extends EmojiClass{


	public PlaceClass(){

	}
	
	public void addEmojiClass() {
        //Flag class
		OntClass place = model.createClass(uriBase + EmojiProperties.PLACE);
		place.setLabel(EmojiProperties.PLACE, null);	
		place.setComment("Emojis Place class", null);
	
	}
}
