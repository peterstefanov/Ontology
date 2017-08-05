package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.BaseEmoji;
import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.OntologyModel;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class EmojiClass {

	protected OntModel model;
	protected OntClass baseEmoji;
	protected String uriBase;

	public EmojiClass(){
		this.model = OntologyModel.getInstance().getModel();
		this.uriBase = OntologyModel.getInstance().getUribase();
		this.baseEmoji = BaseEmoji.getInstance();
	}
		
	public void addEmojiClass() {
		//Flag class
		OntClass flagClass = model.createClass(uriBase + EmojiProperties.FLAG);
		flagClass.setLabel(EmojiProperties.FLAG, null);
		flagClass.setComment("Emojis Flag class", null);
		flagClass.addSuperClass(baseEmoji);

		
		EnumeratedClass countries = model.createEnumeratedClass(uriBase + EmojiProperties.COUNTRIES, null);
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.ITALY, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.AMERICA, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.CHINA, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.JAPAN, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.FRANCE, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.GERMANY, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.RUSSIA, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.UK, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.SPAIN, null));
		countries.addOneOf(model.createIndividual(uriBase + EmojiProperties.SOUTH_KOREA, null));
			
		ObjProperty op = ObjProperty.getInstance();
		op.addObjectProperty("hasCountry", baseEmoji, countries, true);
		
		//Age class		
		EnumeratedClass ageClass = model.createEnumeratedClass(uriBase + EmojiProperties.AGE, null);
		ageClass.setLabel(EmojiProperties.AGE, null);
		ageClass.addOneOf(model.createIndividual(uriBase + EmojiProperties.AGE_OLD, null));
		ageClass.addOneOf(model.createIndividual(uriBase + EmojiProperties.AGE_BABY, null));
		ageClass.addOneOf(model.createIndividual(uriBase + EmojiProperties.AGE_BOY, null));
			
		op.addObjectProperty("ageDescription", baseEmoji, ageClass, true);
		op.addObjectProperty("isA", baseEmoji, baseEmoji, false);
		op.addObjectProperty("isAFlagOf", baseEmoji, countries, true);
	}
	
	public static Individual getIndividual(RDFNode rdf) {
		Individual result = null;
			if (rdf != null && rdf.canAs(Individual.class)) {
				result = (Individual) rdf.as(Individual.class);
			} else {
				System.err.println("getIndividual: Could not read individual with URI ");
			}

		return result;
	}
}
