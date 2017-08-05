package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class ObjectClass extends EmojiClass {

	public ObjectClass(){}
	
	public void addEmojiClass() {
        
		OntClass objectRelated = model.createClass(uriBase + EmojiProperties.OBJECT_RELATED);
		objectRelated.setComment("All object related Emojis ", null);	
		objectRelated.addSuperClass(baseEmoji);
		
		EnumeratedClass objects = model.createEnumeratedClass(uriBase + EmojiProperties.OBJECT, null);
		objects.setComment("All Emoji's objects", null);	
		objects.setLabel(EmojiProperties.OBJECT, null);	
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_BICYCLE, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_BALL, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_GLASSES, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_GLASS, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_CLOCK, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_BELL, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_BANKNOTE, null));
		objects.addOneOf(model.createIndividual(uriBase + EmojiProperties.O_COMPUTER, null));

	    
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("isObject", baseEmoji, objects, true);			
	}
}
