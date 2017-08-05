package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class TopicClass extends EmojiClass {

	public void addEmojiClass() {		
		
		EnumeratedClass topic = model.createEnumeratedClass(uriBase + EmojiProperties.TOPIC, null);
		topic.setComment("All Emoji's topics", null);
		topic.setLabel(EmojiProperties.TOPIC, null);		
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_ROMANCE, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_COMIC, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_MUSIC, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_SPORT, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_DRINK, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_EDUCATION, null));
		topic.addOneOf(model.createIndividual(uriBase + EmojiProperties.T_TRAVEL, null));
        topic.setSuperClass(topic); 

	    
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("hasTopic", baseEmoji, topic, true);	
	}
}
