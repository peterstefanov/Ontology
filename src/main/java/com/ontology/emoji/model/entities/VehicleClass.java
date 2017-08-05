package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class VehicleClass  extends EmojiClass {

	public VehicleClass(){}
	
	public void addEmojiClass() {
		OntClass vehicleRelated = model.createClass(uriBase + EmojiProperties.VEHICLE_RELATED);
		vehicleRelated.setComment("All vehicle related Emojis ", null);	
		vehicleRelated.addSuperClass(baseEmoji);
		
		EnumeratedClass vehicle = model.createEnumeratedClass(uriBase + EmojiProperties.VEHICLE, null);
		vehicle.setComment("All Emoji's vehicles", null);	
		vehicle.setLabel(EmojiProperties.VEHICLE, null);	
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_CAR, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_TRUCK, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_TRAM, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_TROLLEYBUS, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_BUS, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_TRACTOR, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_BOAT, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_ROCKET, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_SHIP, null));
		vehicle.addOneOf(model.createIndividual(uriBase + EmojiProperties.V_AIRPLANE, null));

	    
	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("isVehicle", baseEmoji, vehicle, true);	   		
	}
}
