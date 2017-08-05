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

public class PlantResources extends EmojiRestrictions {

	public PlantResources() {
		super();
	}

	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		if (annotationNames.contains(NATURE) && annotationNames.contains(PLANT)) {

			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			
			OntResource plant = model.getOntResource(uriBase + PLANT);
			ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");			
			Restriction relatedToPlant = model.createHasValueRestriction(null, isA, plant);
						
			OntClass plantRelated = model.getOntClass(uriBase + PLANT_RELATED);
			cl.addSuperClass(plantRelated);

			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));
			
			topicRestriction = addTopicRestriction(annotationNames, cl, model.createList(new RDFNode[] {relatedToPlant}));
			foodRestriction = addFoodRestriction(annotationNames, cl, topicRestriction);
			colorRestriction = addColorRestriction(annotationNames, cl, foodRestriction);
			
			RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);	
			
			if (annotationNames.contains(PLANT_FLOWER)) {
				ObjectProperty isFlower = ObjProperty.getObjectTypeProperty("isFlower");
				if (annotationNames.contains(F_ROSE)) {
					OntResource rose = model.getOntResource(uriBase + F_ROSE);
					Restriction rest = model.createHasValueRestriction(null, isFlower, rose);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else if (annotationNames.contains(F_HIBISCUS)) {
					OntResource hibi = model.getOntResource(uriBase + F_HIBISCUS);
					Restriction rest = model.createHasValueRestriction(null, isFlower, hibi);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else if (annotationNames.contains(F_SUNFLOWER)) {
					OntResource sun = model.getOntResource(uriBase + F_SUNFLOWER);
					Restriction rest = model.createHasValueRestriction(null, isFlower, sun);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else if (annotationNames.contains(F_TULIP)) {
					OntResource tulip = model.getOntResource(uriBase + F_TULIP);
					Restriction rest = model.createHasValueRestriction(null, isFlower, tulip);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else if (annotationNames.contains(F_CHERRY)) {
					OntResource cherry = model.getOntResource(uriBase + F_CHERRY);
					Restriction rest = model.createHasValueRestriction(null, isFlower, cherry);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else {
					//if it is a flower but non of these above, anyway 
					//add anonymous collection of all restrictions to the class
					IntersectionClass intersection = model.createIntersectionClass(null,
							model.createList(nodeArray));
					cl.addSuperClass(intersection);
				}
			} else if (annotationNames.contains(PLANT_TREE)){
				ObjectProperty isTree = ObjProperty.getObjectTypeProperty("isTree");
				if (annotationNames.contains(T_PALM)) {
					OntResource palm = model.getOntResource(uriBase + T_PALM);
					Restriction rest = model.createHasValueRestriction(null, isTree, palm);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else if (annotationNames.contains(T_EVERGREEN)) {
					OntResource green = model.getOntResource(uriBase + T_EVERGREEN);
					Restriction rest = model.createHasValueRestriction(null, isTree, green);
					addAnonymousRestriction(cl, nodeArray, rest);
				} else {
					//if it is a tree but non of these above, anyway 
					//add anonymous collection of all restrictions to the class
					IntersectionClass intersection = model.createIntersectionClass(null,
							model.createList(nodeArray));
					cl.addSuperClass(intersection);
				}

			} else {
				//add anonymous collection of all restrictions to the class
				IntersectionClass intersection = model.createIntersectionClass(null,
						model.createList(nodeArray));
				cl.addSuperClass(intersection);
			}
		}
	}
}
