package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.DataTypeProperty;

public class FlagResources extends EmojiRestrictions {

	public FlagResources() {
		super();
	}

	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		// special case other and flags are all countries flags
		if (annotationNames.contains(OTHER) && annotationNames.contains(FLAG)) {

			OntClass flagClass = model.getOntClass(uriBase + FLAG);
			Individual individual = model.createIndividual(uriBase + className, flagClass);
			individual.setLabel(className, null);
			individual.setComment(entry.get(4), null);
			individual.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));
			assertCountry(annotationNames, individual);
		}
	}
}
