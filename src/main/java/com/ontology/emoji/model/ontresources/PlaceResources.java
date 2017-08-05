package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.BaseEmoji;
import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;

public class PlaceResources  extends EmojiRestrictions {

	public PlaceResources() {
		super();
	}

	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);
		

		if (annotationNames.contains(PLACE)) {
			
			ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");
			OntClass place = model.getOntClass(uriBase + PLACE);
			place.addSuperClass(BaseEmoji.getInstance());

			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			cl.addSuperClass(place);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));

			Restriction relatedToPlace = model.createHasValueRestriction(null, isA, place);

			foodRestriction = addFoodRestriction(annotationNames, cl, model.createList(new RDFNode[] { relatedToPlace }));
			feelingsRestriction = addFeelingsRestriction(annotationNames, cl, foodRestriction);
			emotionsRestriction = addEmotionsRestriction(annotationNames, cl, feelingsRestriction);
			topicRestriction = addTopicRestriction(annotationNames, cl, emotionsRestriction);

			RDFNode[] nodeArray = getRestrictionsAsArray(topicRestriction);

			// Anonymous collection of all restrictions
			IntersectionClass intersection = model.createIntersectionClass(null, model.createList(nodeArray));
			cl.addSuperClass(intersection);
		}
	}
}
