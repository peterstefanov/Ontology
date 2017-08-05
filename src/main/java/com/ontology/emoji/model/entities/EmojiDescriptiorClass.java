package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class EmojiDescriptiorClass extends EmojiClass{


	public EmojiDescriptiorClass(){
	}
	
	public void addEmojiClass() {

		OntClass emojiDescriptor = model.createClass(uriBase + EmojiProperties.E_DESCRIPTOR);
		emojiDescriptor.setLabel(EmojiProperties.E_DESCRIPTOR, null);
		emojiDescriptor.setComment("made EmojiDescriptor unionType of color and emotion", null);
		
		OntClass color = model.createClass();
		Individual green = color.createIndividual(uriBase + EmojiProperties.C_GREEN);
		Individual red = color.createIndividual(uriBase + EmojiProperties.C_RED);
		Individual yellow = color.createIndividual(uriBase + EmojiProperties.C_YELLOW);
		Individual blue = color.createIndividual(uriBase + EmojiProperties.C_BLUE);
		Individual black = color.createIndividual(uriBase + EmojiProperties.C_BLACK);
		Individual white = color.createIndividual(uriBase + EmojiProperties.C_WHITE);
		Individual purple = color.createIndividual(uriBase + EmojiProperties.C_PURPLE);
		color.remove();
		
		EnumeratedClass emojiColor = model.createEnumeratedClass(uriBase + "EmojiColor", null);
		emojiColor.setLabel("All Emoji's colors", null);		
		emojiColor.addOneOf(green);
		emojiColor.addOneOf(red);
		emojiColor.addOneOf(yellow);
		emojiColor.addOneOf(blue);
		emojiColor.addOneOf(black);
		emojiColor.addOneOf(white);
		emojiColor.addOneOf(purple);
		emojiColor.setSuperClass(emojiDescriptor);
		
		//Emoji Emotions		
		EnumeratedClass emojiEmotion = model.createEnumeratedClass(uriBase + "EmojiEmotion", null);
		emojiEmotion.setLabel("All Emoji's emotions", null);
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_MAD, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_LOVE, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_KISS, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_CRY, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_SAD, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_FEAR, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_SURPRISED, null));
		emojiEmotion.addOneOf(model.createIndividual(uriBase + EmojiProperties.E_DISAPPOINTED, null));
		emojiEmotion.setSuperClass(emojiDescriptor);	
		
		//Emoji Feelings		
		EnumeratedClass emojiFeelings = model.createEnumeratedClass(uriBase + "EmojiFeelings", null);
		emojiFeelings.setLabel("All Emoji's feelings", null);
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_HEAR, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_SEE, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_COOL, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_TASTE, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_HOT, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_SPEAK, null));
		emojiFeelings.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_COLD, null));

		emojiFeelings.setSuperClass(emojiDescriptor);	
	   
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("hasEmojiDescriptor", baseEmoji, emojiDescriptor, false);
	    op.addObjectProperty("hasColor", baseEmoji, emojiColor, true);
	    op.addObjectProperty("hasEmotion", baseEmoji, emojiEmotion, true);
	    op.addObjectProperty("hasFeelings", baseEmoji, emojiFeelings, true);
	    ObjectProperty hasEmojiDescProperty = ObjProperty.getObjectTypeProperty("hasEmojiDescriptor");
	    ObjectProperty hasColorProperty = ObjProperty.getObjectTypeProperty("hasColor");
	    ObjectProperty hasEmotion = ObjProperty.getObjectTypeProperty("hasEmotion");
	    ObjectProperty hasFeelings = ObjProperty.getObjectTypeProperty("hasFeelings");
	    hasEmojiDescProperty.addSubProperty(hasColorProperty);
	    hasEmojiDescProperty.addSubProperty(hasEmotion);
	    hasEmojiDescProperty.addSubProperty(hasFeelings);
		
	}
}
