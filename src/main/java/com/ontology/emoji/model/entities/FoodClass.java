package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class FoodClass extends EmojiClass {

	public FoodClass(){

	}
	
	public void addEmojiClass() {
		OntClass food = model.createClass(uriBase +  EmojiProperties.FOOD);
		food.setComment("Food class", null);
		food.setLabel(EmojiProperties.FOOD, null);
		
		EnumeratedClass fruit = model.createEnumeratedClass(uriBase +  EmojiProperties.FOOD_FRUIT, null);
		fruit.setLabel(EmojiProperties.FOOD_FRUIT, null);	
		fruit.setComment("All fruit emojis", null);
		fruit.setSuperClass(food);
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_PEACH, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_BANANA, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_GRAPE, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_APPLE, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_LEMON, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_MELON, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_PEAR, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_PINEAPPLE, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_STRAWBERRT, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_TANGERINE, null));
		fruit.addOneOf(model.createIndividual(uriBase + EmojiProperties.FF_WATERMELON, null));
		
		
		EnumeratedClass veg = model.createEnumeratedClass(uriBase +  EmojiProperties.FOOD_VEGETABLE, null);
		veg.setLabel(EmojiProperties.FOOD_VEGETABLE, null);	
		veg.setComment("All vegetables emojis", null);
		veg.setSuperClass(food);
		veg.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_TOMATO, null));
		veg.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_AUBERGINE, null));	
		
		EnumeratedClass dessert = model.createEnumeratedClass(uriBase +  EmojiProperties.FOOD_DESSERT, null);
		dessert.setLabel(EmojiProperties.FOOD_DESSERT, null);	
		dessert.setComment("All desserts emojis", null);
		dessert.setSuperClass(food);
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_STICK, null));
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_ICECREAM, null));	
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_DONUT, null));
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_COOKIE, null));
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_CAKE, null));
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_CHOCOLATE, null));
		dessert.addOneOf(model.createIndividual(uriBase + EmojiProperties.D_CANDY, null));
		
	    ObjProperty op = ObjProperty.getInstance();
	    
	    op.addObjectProperty("isFoodRelated", baseEmoji, food, false);
	    op.addObjectProperty("isFruit", baseEmoji, fruit, true);	
	    op.addObjectProperty("isVegetable", baseEmoji, veg, true);
	    op.addObjectProperty("isDessert", baseEmoji, dessert, true);
	    ObjectProperty isFoodRelated = ObjProperty.getObjectTypeProperty("isFoodRelated");
	    ObjectProperty isFruit = ObjProperty.getObjectTypeProperty("isFruit");
	    ObjectProperty isVegetable = ObjProperty.getObjectTypeProperty("isVegetable");
	    ObjectProperty isDessert = ObjProperty.getObjectTypeProperty("isDessert");
	    isFoodRelated.addSubProperty(isFruit);
	    isFoodRelated.addSubProperty(isVegetable);
	    isFoodRelated.addSubProperty(isDessert);
	}
}
