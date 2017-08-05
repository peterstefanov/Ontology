package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;

public class ObjectResources extends EmojiRestrictions {

	public ObjectResources() {
		super();
	}
	
	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		//Object and Plant annotations usually goes together, deal here only with Object ones
		if (annotationNames.contains(OBJECT) && !annotationNames.contains(PLANT)) {

			ObjectProperty isObject = ObjProperty.getObjectTypeProperty("isObject");
			ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");	
			
			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			OntClass objectRelated = model.getOntClass(uriBase + OBJECT_RELATED);
			cl.addSuperClass(objectRelated);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));

									
			if (annotationNames.contains(PERSON)) {
				OntResource person = model.getOntResource(uriBase + PERSON);
				Restriction relatedToPerson = model.createHasValueRestriction(null, isA, person);
				
				symbolRestriction = addSymbolRestriction(annotationNames, cl, model.createList(new RDFNode[] {relatedToPerson}));
				if (symbolRestriction != null) {
					topicRestriction = addTopicRestriction(annotationNames, cl, symbolRestriction);
					bodyRestriction = addBodyRestriction(annotationNames, cl, topicRestriction);
					foodRestriction = addFoodRestriction(annotationNames, cl, bodyRestriction);				
					colorRestriction = addColorRestriction(annotationNames, cl, foodRestriction);	
					
					RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);
					
					//Anonymous collection of all restrictions
					IntersectionClass intersection = model.createIntersectionClass(null, model.createList(nodeArray));
					cl.addSuperClass(intersection);	
				}

			} else {
				OntResource object = model.getOntResource(uriBase + OBJECT);				
				Restriction relatedToObject = model.createHasValueRestriction(null, isA, object);
				
				symbolRestriction = addSymbolRestriction(annotationNames, cl, model.createList(new RDFNode[] {relatedToObject}));
				if (symbolRestriction != null) {
					topicRestriction = addTopicRestriction(annotationNames, cl, symbolRestriction);
					bodyRestriction = addBodyRestriction(annotationNames, cl, topicRestriction);
					foodRestriction = addFoodRestriction(annotationNames, cl, bodyRestriction);				
					colorRestriction = addColorRestriction(annotationNames, cl, foodRestriction);	
					
					RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);
					
					if (annotationNames.contains(O_BICYCLE)) {

						OntResource bike = model.getOntResource(uriBase + O_BICYCLE);
						Restriction rest = model.createHasValueRestriction(null, isObject, bike);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_BALL)) {
						OntResource ball = model.getOntResource(uriBase + O_BALL);
						Restriction rest = model.createHasValueRestriction(null, isObject, ball);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_GLASS)) {
						OntResource glass = model.getOntResource(uriBase + O_GLASS);
						Restriction rest = model.createHasValueRestriction(null, isObject, glass);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_GLASSES)) {
						OntResource glasses = model.getOntResource(uriBase + O_GLASSES);
						Restriction rest = model.createHasValueRestriction(null, isObject, glasses);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_CLOCK)) {
						OntResource clock = model.getOntResource(uriBase + O_CLOCK);
						Restriction rest = model.createHasValueRestriction(null, isObject, clock);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_BELL)) {
						OntResource bell = model.getOntResource(uriBase + O_BELL);
						Restriction rest = model.createHasValueRestriction(null, isObject, bell);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_BANKNOTE)) {
						OntResource banknote = model.getOntResource(uriBase + O_BANKNOTE);
						Restriction rest = model.createHasValueRestriction(null, isObject, banknote);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else if (annotationNames.contains(O_COMPUTER)) {
						OntResource computer = model.getOntResource(uriBase + O_COMPUTER);
						Restriction rest = model.createHasValueRestriction(null, isObject, computer);
						addAnonymousRestriction(cl, nodeArray, rest);
					} else {						
						cl.remove();
					}

				}
			}
		}
	}
}
