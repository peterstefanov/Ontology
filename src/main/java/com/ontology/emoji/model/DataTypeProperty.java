package com.ontology.emoji.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;

public class DataTypeProperty {

	private OntModel model;
	private String uriBase;
	private static DatatypeProperty property;
	private static Map<String, DatatypeProperty> properties = new HashMap<String, DatatypeProperty>();
	private static DataTypeProperty instance;
	
	private DataTypeProperty(){
		this.model = OntologyModel.getInstance().getModel();
		this.uriBase = OntologyModel.getInstance().getUribase();
	}
	
	public static DataTypeProperty getInstance() {
		if (instance == null) {
			DataTypeProperty be = new DataTypeProperty();
			instance = be;
		}
		return instance;
	}
	
	/**
	 * Create data type property, either functional or not.
	 * @param propertyName
	 * @param range
	 * @param functional
	 */
	public void addDataTypeProperty(String propertyName, Resource range, boolean functional) {	
		property = model.createDatatypeProperty(uriBase + propertyName, functional);
		property.setDomain(BaseEmoji.getInstance());
		property.setRange(range);	
		add(propertyName, property);
	}

	private void add(String propertyName, DatatypeProperty property) {
		properties.put(propertyName, property);		
	}
	
	public static DatatypeProperty getDataTypeProperty(String propertyName) {
		DatatypeProperty result = properties.get(propertyName);
		
		if (result != null) {
			return result;
		}
				
		return null;
	}
}