package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class PersonClass extends EmojiClass{


	public PersonClass(){
	}

	public void addEmojiClass() {
		
		OntClass person = model.createClass(uriBase + EmojiProperties.PERSON);
		person.setLabel(EmojiProperties.PERSON, null);		
		person.setComment("Person class", null);
		
		OntClass personrelated = model.createClass(uriBase + EmojiProperties.PERSON_RELATED);
		personrelated.setLabel(EmojiProperties.PERSON_RELATED, null);		
		personrelated.setComment("All person related Emojis", null);
		personrelated.setSuperClass(baseEmoji);
		
		OntResource animalRelated = model.getOntResource(uriBase + EmojiProperties.ANIMAL_RELATED);	
		person.addDisjointWith(animalRelated);

		//Gender
		OntClass gender = model.createClass();
		Individual man = gender.createIndividual(uriBase + EmojiProperties.MAN);
		Individual woman = gender.createIndividual(uriBase + EmojiProperties.WOMAN);
		man.addDifferentFrom(woman);
		woman.addDifferentFrom(man);
		gender.remove();
		
		EnumeratedClass personGender = model.createEnumeratedClass(uriBase + EmojiProperties.PERSON_GENDER, null);
		personGender.setLabel("Person Emoji's gender", null);		
		personGender.addOneOf(man);
		personGender.addOneOf(woman);
		personGender.setSuperClass(person);
		
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("hasGender", baseEmoji, personGender, true);			    		
	}
}
