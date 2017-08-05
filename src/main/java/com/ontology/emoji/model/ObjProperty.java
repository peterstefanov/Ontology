package com.ontology.emoji.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;

public class ObjProperty {

	private OntModel model;
	private String uriBase;
	private ObjectProperty property;
	
	private static Map<String, ObjectProperty> properties = new HashMap<String, ObjectProperty>();
	private static ObjProperty instance;


	public static ObjProperty getInstance() {
		if (instance == null) {
			ObjProperty be = new ObjProperty();
			instance = be;
		}
		return instance;
	}


	private ObjProperty () {
		this.model = OntologyModel.getInstance().getModel();
		this.uriBase = OntologyModel.getInstance().getUribase();
	}
	
	/**
	 * Create object property, either functional or not.
	 * @param objectName
	 * @param domain
	 * @param range
	 * @param functional - true or false
	 */
	public void addObjectProperty(String objectName, Resource domain, Resource range, boolean functional) {		
		property = model.createObjectProperty(uriBase + objectName, functional);
		if (domain != null) {
			property.setDomain(domain);
		}
		
		property.setRange(range);	
		add(objectName, property);
	}
	
	private void add(String propertyName, ObjectProperty property) {
		properties.put(propertyName, property);		
	}
	
	public static ObjectProperty getObjectTypeProperty(String propertyName) {
		ObjectProperty result = properties.get(propertyName);
		
		if (result != null) {
			return result;
		}
				
		return null;
	}
}
