package com.ontology.emoji.model;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;

public class BaseEmoji{

	private OntModel model;
	private String uriBase;
	private static OntClass instance = null;


	public static OntClass getInstance() {
		if (instance == null) {
			BaseEmoji be = new BaseEmoji();
			instance = be.getBaseEmoji();
		}
		return instance;
	}
		
	private BaseEmoji(){
		this.model = OntologyModel.getInstance().getModel();
		this.uriBase = OntologyModel.getInstance().getUribase();
	}
	
	public OntClass getBaseEmoji() {
		OntClass cl = model.createClass(uriBase + "Emoji");
		cl.setLabel("Emoji", null);
		cl.addComment("The class of all Emoji types.", null);
		return cl;		
	}
}
