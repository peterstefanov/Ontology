package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;

public class SymbolResources extends EmojiRestrictions {

	public SymbolResources() {
		super();
	}

	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");

		if (annotationNames.contains(SYMBOL) || annotationNames.contains(S_TIME) ||
				annotationNames.contains(S_WORD) || annotationNames.contains(S_SIGN)) {

			OntClass symbolRelated = model.getOntClass(uriBase + SYMBOL_RELATED);
			OntClass symbol = model.getOntClass(uriBase + SYMBOL);

			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			cl.addSuperClass(symbolRelated);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));

			Restriction relatedToSymbol = model.createHasValueRestriction(null, isA, symbol);

			symbolRestriction = addSymbolRestriction(annotationNames, cl, model.createList(new RDFNode[] { relatedToSymbol }));
			if (symbolRestriction != null) {
				feelingsRestriction = addFeelingsRestriction(annotationNames, cl, symbolRestriction);
				emotionsRestriction = addEmotionsRestriction(annotationNames, cl, feelingsRestriction);
				topicRestriction = addTopicRestriction(annotationNames, cl, emotionsRestriction);
				colorRestriction = addColorRestriction(annotationNames, cl, topicRestriction);

				RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);

				// Anonymous collection of all restrictions
				IntersectionClass intersection = model.createIntersectionClass(null, model.createList(nodeArray));
				cl.addSuperClass(intersection);
			}
		}
	}
}
