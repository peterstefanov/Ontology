package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.rdf.model.RDFList;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.EmojiModelBuider;
import com.ontology.emoji.model.OntologyModel;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiResources;

public class EmojiResourceImpl extends EmojiResources implements EmojiProperties{

	protected OntModel model;
	protected String uriBase;
	protected ArrayList<ArrayList<String>> allEntry;
	protected ArrayList<String> rowEntry;
	protected EmojiModelBuider emojiClasses;
	protected RDFList topicRestriction = null;
	protected RDFList foodRestriction = null;
	protected RDFList feelingsRestriction = null;
	protected RDFList colorRestriction = null;
	protected RDFList facePartsRestriction = null;
	protected RDFList emotionsRestriction = null;
	protected RDFList bodyRestriction = null;
	protected RDFList symbolRestriction = null;
	
	public EmojiResourceImpl(){
		OntologyModel model = OntologyModel.getInstance();
		this.model = model.getModel();
		this.uriBase = model.getUribase();
	}

	public EmojiResourceImpl(ArrayList<ArrayList<String>> allEntry, EmojiModelBuider ec){
		this.allEntry = allEntry;
		this.emojiClasses = ec;
		OntologyModel model = OntologyModel.getInstance();
		this.model = model.getModel();
		this.uriBase = model.getUribase();
	}
	
	public void addResources() {
		PlantResources plant = new PlantResources();
		PersonResources person = new PersonResources();
		ObjectResources object = new ObjectResources();
		AnimalResources animal = new AnimalResources();
		FlagResources flag = new FlagResources();
		VehicleResources vehicle = new VehicleResources();
		PlaceResources place = new PlaceResources();
		SymbolResources symbol = new SymbolResources();
		
		long time = System.currentTimeMillis();

		for (ArrayList<String> entry : allEntry) {
			symbol.addResource(entry);
		}
		System.out.println("Symbol Related Resources added..................................................");
		
		for (ArrayList<String> entry : allEntry) {					
			flag.addResource(entry);	
		}	
		System.out.println("Flag Related Resources added....................................................");

		
		for (ArrayList<String> entry : allEntry) {					
			plant.addResource(entry);	
		}	
		System.out.println("Plant Related Resources added...................................................");
		
		for (ArrayList<String> entry : allEntry) {
			String className = getClassName(entry);	
			if (!isResourceExist(className)) {
				person.addResource(entry);
			}				
		}
		System.out.println("Person Related Resources added..................................................");

		for (ArrayList<String> entry : allEntry) {
			String className = getClassName(entry);	
			if (!isResourceExist(className)) {
				object.addResource(entry);
			}				
		}
		System.out.println("Object Related Resources added..................................................");

		for (ArrayList<String> entry : allEntry) {
			String className = getClassName(entry);	
			if (!isResourceExist(className)) {
				animal.addResource(entry);
			}				
		}
		System.out.println("Animal Related Resources added..................................................");
		
		for (ArrayList<String> entry : allEntry) {
			String className = getClassName(entry);	
			if (!isResourceExist(className)) {
				vehicle.addResource(entry);
			}
		}
		System.out.println("Vehicle Related Resources added.................................................");	
		
		for (ArrayList<String> entry : allEntry) {
			String className = getClassName(entry);	
			if (!isResourceExist(className)) {
				place.addResource(entry);
			}
		}
		System.out.println("Place Related Resources added...................................................");	
		long timeTaken = System.currentTimeMillis() - time;
		System.out.println("Time taken: " + timeTaken + "ms");
	}
	

	/**
	 * Returns true if OntResource null or no OntResource with given name. 
	 * @param str
	 * @param res
	 * @return boolean
	 */
	public boolean isResourceExist(String className) {
		OntResource res = model.getOntResource(uriBase + className);
		if (res == null) {
			return false;
		}
		if (res != null && !res.getLocalName().equals(className)) {
			return false;
		}
		return true;
	}

	/**
	 * Return all Restrictions from the RDFList as RDFNode Array.
	 * @param restriction
	 * @return Array of RDFNode[]
	 */
	public RDFNode[] getRestrictionsAsArray(RDFList restriction) {
		
		if (restriction == null) {
			return new RDFNode[]{};
		}
		
		RDFNode[] nodeArray = new RDFNode[restriction.size()];
		RDFNode[] tmp = null;
		for (int i = 0; i < restriction.size(); i ++) {
			if (restriction.get(i).canAs(RDFList.class)) {				
				RDFList list = getRDFList(restriction.get(i));
				tmp = new RDFNode[list.size()];
				for (int y = 0; y < list.size(); y ++) {
					tmp[y] = list.get(y);
				}
			} else {
				nodeArray[i] = restriction.get(i);
			}
		}
		
		//remove null entries
	    List<RDFNode> list = new ArrayList<RDFNode>();
	    for(RDFNode n : nodeArray) {
	       if(n != null) {
	          list.add(n);
	       }
	    }
	    nodeArray = list.toArray(new RDFNode[list.size()]);
		
	    if (tmp != null) {		

			RDFNode[] both = (RDFNode[])ArrayUtils.addAll(tmp, nodeArray);
			nodeArray = both;
		}
		return nodeArray;
	}
	
	/**
	 * If RDFNode is an instance of RDFList return it. 
	 * @param rdf
	 * @return
	 */
	private static RDFList getRDFList(RDFNode rdf) {
		RDFList result = null;
			if (rdf != null && rdf.canAs(RDFList.class)) {
				result = (RDFList) rdf.as(RDFList.class);
			} else {
				System.err.println("getRDFList: Could not read individual with URI ");
			}

		return result;
	}
	
	@Override
	public void addResource(ArrayList<String> entry) {
		// Derived classes implement it
	}		
}
	

