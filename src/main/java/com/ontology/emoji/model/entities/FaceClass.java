package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class FaceClass extends EmojiClass{


	public FaceClass(){
	}
	
	public void addEmojiClass() {
        //Face class
		OntClass face = model.createClass(uriBase + EmojiProperties.FACE);
		face.setLabel(EmojiProperties.FACE, null);		
		
		EnumeratedClass faceParts = model.createEnumeratedClass(uriBase + EmojiProperties.F_PARTS, null);
		faceParts.setLabel("All Emoji's face parts", null);		
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_NOSE, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_LIPS, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_MOUTH, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_EYE, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_EAR, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_TONGUE, null));
		faceParts.addOneOf(model.createIndividual(uriBase + EmojiProperties.F_BOAR, null));
		faceParts.setSuperClass(face); 

		EnumeratedClass faceExpression = model.createEnumeratedClass(uriBase + EmojiProperties.F_EXPRESSION, null);
		faceExpression.setLabel("All Emoji's face expressions", null);	
		OntClass tear = model.createClass(uriBase + EmojiProperties.F_TEAR);
		tear.setSuperClass(faceExpression); 
		OntClass smile = model.createClass(uriBase + EmojiProperties.F_SMILE);
		smile.setSuperClass(faceExpression); 
		OntClass joy = model.createClass(uriBase + EmojiProperties.F_JOY);
		joy.setSuperClass(faceExpression); 
		faceExpression.addOneOf(tear);
		faceExpression.addOneOf(smile);
		faceExpression.addOneOf(joy);
		faceExpression.setSuperClass(face); 		
	    
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("isFace", baseEmoji, face, true);
	    op.addObjectProperty("faceWith", baseEmoji, faceExpression, true);
	    op.addObjectProperty("hasFacePart", baseEmoji, faceParts, true);
	    ObjectProperty isFace = ObjProperty.getObjectTypeProperty("isFace");
	    ObjectProperty faceWith = ObjProperty.getObjectTypeProperty("faceWith");
	    ObjectProperty hasFacePart = ObjProperty.getObjectTypeProperty("hasFacePart");    	    
	    isFace.addSubProperty(faceWith);	
	    isFace.addSubProperty(hasFacePart);		
	}
}
