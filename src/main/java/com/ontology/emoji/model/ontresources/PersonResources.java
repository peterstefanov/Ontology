package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFList;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;

public class PersonResources extends EmojiRestrictions {

	public PersonResources() {
		super();
	}
	
	public void addResource(ArrayList<String> entry) {
		
		String className = getClassName(entry);
		ArrayList<String> annotationNames = getAnnotationNames(entry);
		
		//deal only with person annotations, if object exist it will handled in Object class
		if (annotationNames.contains(PERSON) && !annotationNames.contains(OBJECT)) {

			RDFList genderRestriction = null;
			IntersectionClass intersection = null;
			
			OntResource person = model.getOntResource(uriBase + PERSON);
			ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");			
			Restriction relatedTo = model.createHasValueRestriction(null, isA, person);
			
			OntResource personrelated = model.getOntResource(uriBase + PERSON_RELATED);
			
			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			cl.setSuperClass(personrelated);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));

			
			genderRestriction = addGenderRestriction(annotationNames, cl, relatedTo);
			feelingsRestriction = addFeelingsRestriction(annotationNames, cl, genderRestriction);
			facePartsRestriction = addFacePartsRestriction(annotationNames, cl, feelingsRestriction);
			emotionsRestriction = addEmotionsRestriction(annotationNames, cl, facePartsRestriction);
			topicRestriction = addTopicRestriction(annotationNames, cl, emotionsRestriction);
			bodyRestriction = addBodyRestriction(annotationNames, cl, topicRestriction);
			colorRestriction = addColorRestriction(annotationNames, cl, bodyRestriction);
			
			RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);
			
	    if (annotationNames.contains(FACE)) {
	    		    	
			//Face restrictions
			ObjectProperty isFace = ObjProperty.getObjectTypeProperty("isFace");
			OntResource face = model.getOntResource(uriBase + FACE);	
			Restriction withFace = model.createHasValueRestriction(null, isFace, face);
			
			intersection = model.createIntersectionClass(null, model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {withFace})));
	
				cl.addSuperClass(intersection);
			} else {
				//Anonimus collection of all restrictions
				intersection = model.createIntersectionClass(null, model.createList(nodeArray));
				cl.addSuperClass(intersection);
			}
		}
	}

	private RDFList addGenderRestriction(ArrayList<String> annotationNames, OntClass cl, Restriction restriction) {
		//Gender restrictions ageDescription
		ObjectProperty hasGender = ObjProperty.getObjectTypeProperty("hasGender");
		OntResource man = model.getOntResource(uriBase + MAN);
		OntResource woman = model.getOntResource(uriBase + WOMAN);
		
		ObjectProperty ageDescription = ObjProperty.getObjectTypeProperty("ageDescription");
		OntResource old = model.getOntResource(uriBase + AGE_OLD);
		OntResource boy = model.getOntResource(uriBase + AGE_BOY);
		OntResource baby = model.getOntResource(uriBase + AGE_BABY);
		
		if (!annotationNames.contains(COUPLE)) {
			if (annotationNames.contains(MAN) && !annotationNames.contains(AGE_OLD)) {
				Restriction gender = model.createHasValueRestriction(null, hasGender, man);
				return model.createList(new RDFNode[] {gender, restriction});
			} else if (annotationNames.contains(WOMAN) && !annotationNames.contains(AGE_OLD)) {
				Restriction gender = model.createHasValueRestriction(null, hasGender, woman);
				return model.createList(new RDFNode[] {gender, restriction});
			} else if (annotationNames.contains(WOMAN) && annotationNames.contains(AGE_OLD)) {
				Restriction gender = model.createHasValueRestriction(null, hasGender, woman);
				Restriction older = model.createHasValueRestriction(null, ageDescription, old);
				return model.createList(new RDFNode[] { gender, older, restriction});
			} else if (annotationNames.contains(MAN) && annotationNames.contains(AGE_OLD)) {
				Restriction gender = model.createHasValueRestriction(null, hasGender, woman);
				Restriction older = model.createHasValueRestriction(null, ageDescription, old);
				return model.createList(new RDFNode[] {gender, older, restriction});
			} else if (annotationNames.contains(AGE_BOY)) {
				Restriction boyRe = model.createHasValueRestriction(null, ageDescription, boy);
				return model.createList(new RDFNode[] {boyRe, restriction});
			} else if (annotationNames.contains(AGE_BABY)) {
				Restriction babyRe = model.createHasValueRestriction(null, ageDescription, baby);
				return model.createList(new RDFNode[] {babyRe, restriction});
			}
		}
		
		return model.createList(new RDFNode[] {restriction});
	}	
}
