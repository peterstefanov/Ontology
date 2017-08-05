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

public class VehicleResources extends EmojiRestrictions {

	public VehicleResources() {
		super();
	}
	
	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");
		ObjectProperty isVehicle = ObjProperty.getObjectTypeProperty("isVehicle");
		
		if (annotationNames.contains(VEHICLE)) {

			OntClass vehicleRelated = model.getOntClass(uriBase + VEHICLE_RELATED);
			OntClass vehicle = model.getOntClass(uriBase + VEHICLE);

			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			cl.addSuperClass(vehicleRelated);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));

			Restriction relatedToVehicle = model.createHasValueRestriction(null, isA, vehicle);

			topicRestriction = addTopicRestriction(annotationNames, cl, model.createList(new RDFNode[] { relatedToVehicle }));
			RDFNode[] nodeArray = getRestrictionsAsArray(topicRestriction);

			if (annotationNames.contains(V_CAR)) {

				OntResource car = model.getOntResource(uriBase + V_CAR);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, car);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_TRUCK)) {
				OntResource truck = model.getOntResource(uriBase + V_TRUCK);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, truck);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_TRAM)) {
				OntResource tram = model.getOntResource(uriBase + V_TRAM);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, tram);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_TROLLEYBUS)) {
				OntResource trol = model.getOntResource(uriBase + V_TROLLEYBUS);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, trol);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_BUS)) {
				OntResource bus = model.getOntResource(uriBase + V_BUS);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, bus);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_TRACTOR)) {
				OntResource trac = model.getOntResource(uriBase + V_TRACTOR);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, trac);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_BOAT)) {
				OntResource boat = model.getOntResource(uriBase + V_BOAT);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, boat);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_ROCKET)) {
				OntResource rocket = model.getOntResource(uriBase + V_ROCKET);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, rocket);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_SHIP)) {
				OntResource ship = model.getOntResource(uriBase + V_SHIP);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, ship);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(V_AIRPLANE)) {
				OntResource plane = model.getOntResource(uriBase + V_AIRPLANE);
				Restriction rest = model.createHasValueRestriction(null, isVehicle, plane);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else {				
				IntersectionClass intersection = model.createIntersectionClass(null, model.createList(nodeArray));
				cl.addSuperClass(intersection);	
			}
		}
	}
}
