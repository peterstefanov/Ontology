package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class BodyClass extends EmojiClass{

	public BodyClass(){
	}

	public void addEmojiClass() {
        //Body class
		OntClass body = model.createClass(uriBase + EmojiProperties.BODY);
		body.setLabel(EmojiProperties.BODY, null);	
		body.setComment("Emojis body class", null);
		
		OntResource face = model.getOntResource(uriBase + EmojiProperties.FACE);	
		body.addDisjointWith(face);
		
		EnumeratedClass bodyParts = model.createEnumeratedClass(uriBase + "BodyParts", null);
		bodyParts.setLabel("All Emoji's body parts", null);		
		bodyParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.B_HAND, null));
		bodyParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.B_FINGER, null));
		bodyParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.B_HEART, null));
		bodyParts.setSuperClass(body); 
	    
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("hasBodyPart", baseEmoji, bodyParts, true);		
	}
}
