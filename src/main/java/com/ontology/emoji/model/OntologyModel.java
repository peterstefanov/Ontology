package com.ontology.emoji.model;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * Create Ontology model and access to {@code uriBase} and the
 * {@code org.apache.jena.ontology.OntModel}.
 * 
 * @author peter
 *
 */
public class OntologyModel {

	public final String uriBase = "http://ontologies/emoji";
	private static OntologyModel instance = null;

	private OntModel model;

	public OntologyModel() {
		OntDocumentManager mgr = new OntDocumentManager();

		OntModelSpec spec = new OntModelSpec(OntModelSpec.OWL_DL_MEM_RDFS_INF);
		spec.setDocumentManager(mgr);
		model = ModelFactory.createOntologyModel(spec);
		model.createOntology(uriBase);
	}

	public static OntologyModel getInstance() {
		if (instance == null) {
			instance = new OntologyModel();
		}
		return instance;
	}

	public String getUribase() {
		return uriBase + "#";
	}

	public OntModel getModel() {
		return model;
	}
}
