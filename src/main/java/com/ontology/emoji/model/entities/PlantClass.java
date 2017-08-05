package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class PlantClass extends EmojiClass {

	public PlantClass(){

	}
	
	public void addEmojiClass() {
		
		OntClass plantRelated = model.createClass(uriBase +  EmojiProperties.PLANT_RELATED);
		plantRelated.setLabel(EmojiProperties.PLANT_RELATED, null);		
		plantRelated.setComment("All plant related emojis", null);
		plantRelated.addSuperClass(baseEmoji);	
		
		OntClass plant = model.createClass(uriBase +  EmojiProperties.PLANT);
		plant.setComment("Plant class", null);
		plant.setLabel(EmojiProperties.PLANT, null);
		
		EnumeratedClass flower = model.createEnumeratedClass(uriBase +  EmojiProperties.PLANT_FLOWER, null);
		flower.setLabel(EmojiProperties.PLANT_FLOWER, null);	
		flower.setComment("All flowers emojis", null);
		flower.setSuperClass(plant);
		flower.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_ROSE, null));
		flower.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_HIBISCUS, null));
		flower.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_SUNFLOWER, null));
		flower.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_TULIP, null));
		flower.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_CHERRY, null));
		
		EnumeratedClass tree = model.createEnumeratedClass(uriBase +  EmojiProperties.PLANT_TREE, null);
		tree.setLabel(EmojiProperties.PLANT_TREE, null);	
		tree.setComment("All trees emojis", null);
		tree.setSuperClass(plant);
		tree.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_PALM, null));
		tree.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_EVERGREEN, null));
					
		
	    ObjProperty op = ObjProperty.getInstance();
	    
	    op.addObjectProperty("plantEmoji", baseEmoji, plant, false);
	    op.addObjectProperty("isFlower", baseEmoji, flower, true);	
	    op.addObjectProperty("isTree", baseEmoji, tree, true);	    
	    ObjectProperty plantEmoji = ObjProperty.getObjectTypeProperty("plantEmoji");
	    ObjectProperty isFlower = ObjProperty.getObjectTypeProperty("isFlower");
	    ObjectProperty isTree = ObjProperty.getObjectTypeProperty("isTree");
	    plantEmoji.addSubProperty(isFlower);
	    plantEmoji.addSubProperty(isTree);
	}
}
