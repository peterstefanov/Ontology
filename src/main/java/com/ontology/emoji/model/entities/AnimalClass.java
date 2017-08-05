package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class AnimalClass extends EmojiClass {


	public AnimalClass(){

	}
	
	public void addEmojiClass() {
		
		OntClass animalRelated = model.createClass(uriBase +  EmojiProperties.ANIMAL_RELATED);
		animalRelated.setLabel(EmojiProperties.ANIMAL_RELATED, null);		
		animalRelated.setComment("All animal Related class", null);
		animalRelated.addSuperClass(baseEmoji);		
		
		EnumeratedClass animal = model.createEnumeratedClass(uriBase +  EmojiProperties.ANIMAL, null);
		animal.setLabel(EmojiProperties.ANIMAL, null);	
		animal.setComment("All animals", null);
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_CAT, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_DOG, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_MONKEY, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_CAMEL, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_CHICK, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_FISH, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_CROCODILE, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_COW, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_DOLPHIN, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_BEAR, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_BIRD, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_HORSE, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_MOUSE, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_RABIT, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_TIGER, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_DRAGON, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_PIG, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_INSECT, null));		
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_CHICKEN, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_ELEPHANT, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_FROG, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_GOAT, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_HAMSTER, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_LEOPARD, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_OCTOPUS, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_PENGUIN, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_RAM, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_RAT, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_ROOSTER, null));	
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_SNAIL, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_SHEEP, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_SNAKE, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_TURTLE, null));
		animal.addOneOf(model.createIndividual(uriBase + EmojiProperties.A_WHALE, null));
		
		EnumeratedClass insects = model.createEnumeratedClass(uriBase + EmojiProperties.INSECTS, null);
		insects.setLabel(EmojiProperties.INSECTS, null);	
		insects.setComment("All insects", null);
		insects.setSuperClass(animal);
		insects.addOneOf(model.createIndividual(uriBase + EmojiProperties.INSECT_ANT, null));
		insects.addOneOf(model.createIndividual(uriBase + EmojiProperties.INSECT_BUG, null));
		insects.addOneOf(model.createIndividual(uriBase + EmojiProperties.INSECT_BEE, null));
		insects.addOneOf(model.createIndividual(uriBase + EmojiProperties.INSECT_BEETLE, null));
		
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("isAnimal", baseEmoji, animal, false);		
	    op.addObjectProperty("isInsect", baseEmoji, insects, false);	
	    
	    ObjectProperty isAnimal = ObjProperty.getObjectTypeProperty("isAnimal");
	    ObjectProperty isInsect = ObjProperty.getObjectTypeProperty("isInsect");
	    isAnimal.addSubProperty(isInsect);
	}
}
