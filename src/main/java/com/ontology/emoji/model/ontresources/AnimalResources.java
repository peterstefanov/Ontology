package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;

public class AnimalResources extends EmojiRestrictions {


	public AnimalResources() {
		super();
	}
	
	public void addResource(ArrayList<String> entry) {
		String className = getClassName(entry);

		ArrayList<String> annotationNames = getAnnotationNames(entry);

		if (annotationNames.contains(NATURE) && annotationNames.contains(ANIMAL) && 
				!annotationNames.contains(S_ZODIAC) && !annotationNames.contains(S_TIME)) {

			OntClass cl = model.createClass(uriBase + className);
			cl.setLabel(className, null);
			cl.setComment(entry.get(4), null);
			
			OntResource animal = model.getOntResource(uriBase + ANIMAL);
			ObjectProperty isA = ObjProperty.getObjectTypeProperty("isA");			
			Restriction relatedToAnimal = model.createHasValueRestriction(null, isA, animal);
			
			ObjectProperty isAnimal = ObjProperty.getObjectTypeProperty("isAnimal");
					
			OntResource face = model.getOntResource(uriBase + FACE);
			ObjectProperty isFace = ObjProperty.getObjectTypeProperty("isFace");
			OntClass animalRelated = model.getOntClass(uriBase + ANIMAL_RELATED);
			cl.addSuperClass(animalRelated);
			cl.addLiteral(DataTypeProperty.getDataTypeProperty("hasUnicode"), getUnicode(entry));
			
			feelingsRestriction = addFeelingsRestriction(annotationNames, cl, model.createList(new RDFNode[] {relatedToAnimal}));
			facePartsRestriction = addFacePartsRestriction(annotationNames, cl, feelingsRestriction);
			emotionsRestriction = addEmotionsRestriction(annotationNames, cl, facePartsRestriction);
			topicRestriction = addTopicRestriction(annotationNames, cl, emotionsRestriction);
			bodyRestriction = addBodyRestriction(annotationNames, cl, topicRestriction);
			colorRestriction = addColorRestriction(annotationNames, cl, bodyRestriction);
			
			RDFNode[] nodeArray = getRestrictionsAsArray(colorRestriction);			
			
			if (annotationNames.contains(A_CAT) ) {
				
				OntResource cat = model.getOntResource(uriBase + A_CAT);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, cat);
				addAnonymousRestriction(cl, nodeArray, rest);

			} else if (annotationNames.contains(A_DOG)) {
				OntResource dog = model.getOntResource(uriBase + A_DOG);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, dog);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_INSECT)) {
				OntResource insect = model.getOntResource(uriBase + A_INSECT);
				cl.remove();
				Individual ind = model.createIndividual(uriBase + className, null);
				ind.setLabel(className, null);
				ind.setComment(entry.get(4), null);
				ind.setPropertyValue(isAnimal, insect);
				addInsectRestriction(annotationNames, ind);			

			} else if (annotationNames.contains(A_MONKEY)) {
				OntResource monkey = model.getOntResource(uriBase + A_MONKEY);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, monkey);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_CAMEL)) {
				OntClass camelClass = model.createClass(uriBase + A_CAMEL);
				camelClass.addSuperClass(((OntClass) animalRelated));
				OntResource camel = model.getOntResource(uriBase + A_CAMEL);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, camel);
				cl.addSuperClass(rest);
				cl.addSuperClass(camelClass);

			} else if (annotationNames.contains(A_CHICK)) {
				OntResource chick = model.getOntResource(uriBase + A_CHICK);
				cl.remove();
				assertPropertyToIndividual(entry, className, chick);

			} else if (annotationNames.contains(A_FISH)) {
				OntResource fish = model.getOntResource(uriBase + A_FISH);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, fish);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_COW)) {
				OntResource cow = model.getOntResource(uriBase + A_COW);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, cow);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_DOLPHIN)) {
				OntResource dolphin = model.getOntResource(uriBase + A_DOLPHIN);
				cl.remove();
				assertPropertyToIndividual(entry, className, dolphin);
			} else if (annotationNames.contains(A_BEAR)) {
				OntResource bear = model.getOntResource(uriBase + A_BEAR);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, bear);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_BIRD)) {
				OntResource bird = model.getOntResource(uriBase + A_BIRD);
				cl.remove();
				assertPropertyToIndividual(entry, className, bird);
			} else if (annotationNames.contains(A_HORSE)) {
				OntResource horse = model.getOntResource(uriBase + A_HORSE);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, horse);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_MOUSE)) {
				OntResource mouse = model.getOntResource(uriBase + A_MOUSE);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, mouse);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_RABIT)) {
				OntResource rabit = model.getOntResource(uriBase + A_RABIT);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, rabit);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_TIGER)) {
				OntResource tiger = model.getOntResource(uriBase + A_TIGER);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, tiger);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_PIG)) {
				OntResource pig = model.getOntResource(uriBase + A_PIG);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, pig);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_DRAGON)) {
				OntResource dragon = model.getOntResource(uriBase + A_DRAGON);
				Restriction rest = model.createHasValueRestriction(null, isAnimal, dragon);
				addAnonymousRestriction(cl, nodeArray, rest);
			} else if (annotationNames.contains(A_CROCODILE)) {							
				OntResource croc = model.getOntResource(uriBase + A_CROCODILE);
				cl.remove();
				assertPropertyToIndividual(entry, className, croc);
			} else if (annotationNames.contains(A_ELEPHANT)) {							
				OntResource elep = model.getOntResource(uriBase + A_ELEPHANT);
				cl.remove();
				assertPropertyToIndividual(entry, className, elep);
			} else if (annotationNames.contains(A_GOAT)) {							
				OntResource goat = model.getOntResource(uriBase + A_GOAT);
				cl.remove();
				assertPropertyToIndividual(entry, className, goat);
			} else if (annotationNames.contains(A_HAMSTER)) {							
				OntResource ham = model.getOntResource(uriBase + A_HAMSTER);
				cl.remove();
				assertPropertyToIndividual(entry, className, ham);
			} else if (annotationNames.contains(A_LEOPARD)) {							
				OntResource leo = model.getOntResource(uriBase + A_LEOPARD);
				cl.remove();
				assertPropertyToIndividual(entry, className, leo);
			} else if (annotationNames.contains(A_OCTOPUS)) {							
				OntResource oct = model.getOntResource(uriBase + A_OCTOPUS);
				cl.remove();
				assertPropertyToIndividual(entry, className, oct);
			} else if (annotationNames.contains(A_PENGUIN)) {							
				OntResource pen = model.getOntResource(uriBase + A_PENGUIN);
				cl.remove();
				assertPropertyToIndividual(entry, className, pen);
			} else if (annotationNames.contains(A_RAM)) {							
				OntResource ram = model.getOntResource(uriBase + A_RAM);
				cl.remove();
				assertPropertyToIndividual(entry, className, ram);
			} else if (annotationNames.contains(A_RAT)) {							
				OntResource rat = model.getOntResource(uriBase + A_RAT);
				cl.remove();
				assertPropertyToIndividual(entry, className, rat);
			} else if (annotationNames.contains(A_ROOSTER)) {							
				OntResource roo = model.getOntResource(uriBase + A_ROOSTER);
				cl.remove();
				assertPropertyToIndividual(entry, className, roo);
			} else if (annotationNames.contains(A_FROG)) {							
				OntResource frog = model.getOntResource(uriBase + A_FROG);
				cl.remove();
				Individual ind = model.createIndividual(uriBase + className, null);
				ind.setLabel(className, null);
				ind.setComment(entry.get(4), null);
				ind.setPropertyValue(isAnimal, frog);
				ind.setPropertyValue(isFace, face);
			} else if (annotationNames.contains(A_CHICKEN)) {							
				OntResource chicken = model.getOntResource(uriBase + A_CHICKEN);
				cl.remove();
				assertPropertyToIndividual(entry, className, chicken);
			} else if (annotationNames.contains(A_SNAIL)) {							
				OntResource snail = model.getOntResource(uriBase + A_SNAIL);
				cl.remove();
				assertPropertyToIndividual(entry, className, snail);
			} else if (annotationNames.contains(A_SHEEP)) {							
				OntResource sheep = model.getOntResource(uriBase + A_SHEEP);
				cl.remove();
				assertPropertyToIndividual(entry, className, sheep);
			} else if (annotationNames.contains(A_SNAKE)) {							
				OntResource snake = model.getOntResource(uriBase + A_SNAKE);
				cl.remove();
				assertPropertyToIndividual(entry, className, snake);
			} else if (annotationNames.contains(A_TURTLE)) {							
				OntResource tur = model.getOntResource(uriBase + A_TURTLE);
				cl.remove();
				assertPropertyToIndividual(entry, className, tur);
			} else if (annotationNames.contains(A_WHALE)) {							
				OntResource wha = model.getOntResource(uriBase + A_WHALE);
				cl.remove();
				assertPropertyToIndividual(entry, className, wha);
			} else {
				//add anonymous collection of all restrictions to the class
				IntersectionClass intersection = model.createIntersectionClass(null, model.createList(nodeArray));
				cl.addSuperClass(intersection);
			}
		}
	}

	/**
	 * Remove the class and create Individual, assert property isAnimal.
	 * @param entry
	 * @param className
	 * @param resource
	 */
	private void assertPropertyToIndividual(ArrayList<String> entry, String className, OntResource resource) {
		ObjectProperty isAnimal = ObjProperty.getObjectTypeProperty("isAnimal");
		Individual ind = model.createIndividual(uriBase + className, null);
		ind.setLabel(className, null);
		ind.setComment(entry.get(4), null);
		ind.setPropertyValue(isAnimal, resource);
	}
}
