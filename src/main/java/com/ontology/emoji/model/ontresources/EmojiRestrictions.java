package com.ontology.emoji.model.ontresources;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.ontology.Restriction;
import org.apache.jena.rdf.model.RDFList;
import org.apache.jena.rdf.model.RDFNode;

import com.ontology.emoji.model.DataTypeProperty;
import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class EmojiRestrictions extends EmojiResourceImpl{


	public EmojiRestrictions() {
		super();
	}
		
	/**
	 * Checks for country annotation, if such exists assert object property
	 * hasCountry with appropriate value.
	 * 
	 * @param annotationNames
	 * @param individual
	 */
	protected void assertCountry(ArrayList<String> annotationNames, Individual individual) {
		
		ObjectProperty hasCountry = ObjProperty.getObjectTypeProperty("hasCountry");
		ObjectProperty isAFlagOf = ObjProperty.getObjectTypeProperty("isAFlagOf");
		if (annotationNames.contains(EmojiProperties.ITALY)) {	
			OntResource italy = model.getOntResource(uriBase + EmojiProperties.ITALY);
			individual.setPropertyValue(hasCountry, italy);
			individual.setPropertyValue(isAFlagOf, italy);
		} else if (annotationNames.contains(EmojiProperties.AMERICA)) {	
			OntResource america = model.getOntResource(uriBase + EmojiProperties.AMERICA);
			individual.setPropertyValue(hasCountry, america);
			individual.setPropertyValue(isAFlagOf, america);
		} else if (annotationNames.contains(EmojiProperties.CHINA)) {	
			OntResource china = model.getOntResource(uriBase + EmojiProperties.CHINA);
			individual.setPropertyValue(hasCountry, china);
			individual.setPropertyValue(isAFlagOf, china);
		} else if (annotationNames.contains(EmojiProperties.JAPAN)) {	
			OntResource japan = model.getOntResource(uriBase + EmojiProperties.JAPAN);
			individual.setPropertyValue(hasCountry, japan);
			individual.setPropertyValue(isAFlagOf, japan);
		} else if (annotationNames.contains(EmojiProperties.FRANCE)) {	
			OntResource france = model.getOntResource(uriBase + EmojiProperties.FRANCE);
			individual.setPropertyValue(hasCountry, france);
			individual.setPropertyValue(isAFlagOf, france);
		} else if (annotationNames.contains(EmojiProperties.GERMANY)) {	
			OntResource germany = model.getOntResource(uriBase + EmojiProperties.GERMANY);
			individual.setPropertyValue(hasCountry, germany);
			individual.setPropertyValue(isAFlagOf, germany);
		} else if (annotationNames.contains(EmojiProperties.RUSSIA)) {	
			OntResource russia = model.getOntResource(uriBase + EmojiProperties.RUSSIA);
			individual.setPropertyValue(hasCountry, russia);
			individual.setPropertyValue(isAFlagOf, russia);
		} else if (annotationNames.contains(EmojiProperties.UK)) {	
			OntResource uk = model.getOntResource(uriBase + EmojiProperties.UK);
			individual.setPropertyValue(hasCountry, uk);
			individual.setPropertyValue(isAFlagOf, uk);
		} else if (annotationNames.contains(EmojiProperties.SPAIN)) {	
			OntResource spain = model.getOntResource(uriBase + EmojiProperties.SPAIN);
			individual.setPropertyValue(hasCountry, spain);
			individual.setPropertyValue(isAFlagOf, spain);
		} else if (annotationNames.contains(EmojiProperties.SOUTH_KOREA)) {	
			OntResource sk = model.getOntResource(uriBase + EmojiProperties.SOUTH_KOREA);
			individual.setPropertyValue(hasCountry, sk);
			individual.setPropertyValue(isAFlagOf, sk);
		}	
	}
	
	/**
	 * Checks for color annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addColorRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);
		ObjectProperty col = ObjProperty.getObjectTypeProperty("hasColor");
		
		if (annotationNames.contains(EmojiProperties.C_GREEN)) {	
			OntResource green = model.getOntResource(uriBase + EmojiProperties.C_GREEN);
			return getRestrictions(nodeArray, col, green);
		} else if (annotationNames.contains(EmojiProperties.C_RED)) {	
			OntResource red = model.getOntResource(uriBase + EmojiProperties.C_RED);
			return getRestrictions(nodeArray, col, red);
		} else if (annotationNames.contains(EmojiProperties.C_YELLOW)) {	
			OntResource yellow = model.getOntResource(uriBase + EmojiProperties.C_YELLOW);
			return getRestrictions(nodeArray, col, yellow);
		} else if (annotationNames.contains(EmojiProperties.C_BLUE)) {	
			OntResource blue = model.getOntResource(uriBase + EmojiProperties.C_BLUE);
			return getRestrictions(nodeArray, col, blue);
		} else if (annotationNames.contains(EmojiProperties.C_BLACK)) {	
			OntResource black = model.getOntResource(uriBase + EmojiProperties.C_BLACK);
			return getRestrictions(nodeArray, col, black);
		} else if (annotationNames.contains(EmojiProperties.C_WHITE)) {	
			OntResource white = model.getOntResource(uriBase + EmojiProperties.C_WHITE);
			return getRestrictions(nodeArray, col, white);
		} else if (annotationNames.contains(EmojiProperties.C_PURPLE)) {	
			OntResource purple = model.getOntResource(uriBase + EmojiProperties.C_PURPLE);
			return getRestrictions(nodeArray, col, purple);
		}	
		return restriction;
	}
	
	/**
	 * Checks for food annotation, if such exists add the restriction to the RDFList.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addFoodRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);		
		
		if (annotationNames.contains(FOOD)){
			
			DatatypeProperty canBeEaten = DataTypeProperty.getDataTypeProperty("canBeEaten");

			ObjectProperty isFoodRelated = ObjProperty.getObjectTypeProperty("isFoodRelated");
			OntClass food = model.getOntClass(uriBase + FOOD);
			Restriction foodRestriction = model.createHasValueRestriction(null, isFoodRelated, food);

			if (annotationNames.contains(FOOD_FRUIT)) {
				cl.addLiteral(canBeEaten, true);
				ObjectProperty isFruit = ObjProperty.getObjectTypeProperty("isFruit");
				if (annotationNames.contains(FF_PEACH)) {				
					OntResource peach = model.getOntResource(uriBase + FF_PEACH);
					return getRestrictions(nodeArray, foodRestriction, isFruit, peach);
				} else if (annotationNames.contains(FF_BANANA)) {
					OntResource ban = model.getOntResource(uriBase + FF_BANANA);
					return getRestrictions(nodeArray, foodRestriction, isFruit, ban);
				} else if (annotationNames.contains(FF_GRAPE)) {
					OntResource grape = model.getOntResource(uriBase + FF_GRAPE);
					return getRestrictions(nodeArray, foodRestriction, isFruit, grape);
				} else if (annotationNames.contains(FF_APPLE)) {
					OntResource apple = model.getOntResource(uriBase + FF_APPLE);
					return getRestrictions(nodeArray, foodRestriction, isFruit, apple);
				} else if (annotationNames.contains(FF_LEMON)) {
					OntResource lemon = model.getOntResource(uriBase + FF_LEMON);
					return getRestrictions(nodeArray, foodRestriction, isFruit, lemon);
				} else if (annotationNames.contains(FF_MELON)) {
					OntResource melon = model.getOntResource(uriBase + FF_MELON);
					return getRestrictions(nodeArray, foodRestriction, isFruit, melon);
				} else if (annotationNames.contains(FF_PEAR)) {
					OntResource pear = model.getOntResource(uriBase + FF_PEAR);
					return getRestrictions(nodeArray, foodRestriction, isFruit, pear);
				} else if (annotationNames.contains(FF_PINEAPPLE)) {
					OntResource pin = model.getOntResource(uriBase + FF_PINEAPPLE);
					return getRestrictions(nodeArray, foodRestriction, isFruit, pin);
				} else if (annotationNames.contains(FF_STRAWBERRT)) {
					OntResource straw = model.getOntResource(uriBase + FF_STRAWBERRT);
					return getRestrictions(nodeArray, foodRestriction, isFruit, straw);
				} else if (annotationNames.contains(FF_TANGERINE)) {
					OntResource tan = model.getOntResource(uriBase + FF_TANGERINE);
					return getRestrictions(nodeArray, foodRestriction, isFruit, tan);
				} else if (annotationNames.contains(FF_WATERMELON)) {
					OntResource water = model.getOntResource(uriBase + FF_WATERMELON);
					return getRestrictions(nodeArray, foodRestriction, isFruit, water);
				}
			} else if (annotationNames.contains(FOOD_VEGETABLE)) {
				cl.addLiteral(canBeEaten, true);
				ObjectProperty isVegetable = ObjProperty.getObjectTypeProperty("isVegetable");
				
				if (annotationNames.contains(V_TOMATO)) {
					OntResource tom = model.getOntResource(uriBase + V_TOMATO);
					return getRestrictions(nodeArray, foodRestriction, isVegetable, tom);
				} else if (annotationNames.contains(V_AUBERGINE)) {
					OntResource aub = model.getOntResource(uriBase + V_AUBERGINE);
					return getRestrictions(nodeArray, foodRestriction, isVegetable, aub);
				}
			} else if (annotationNames.contains(FOOD_DESSERT)) {
				cl.addLiteral(canBeEaten, true);
				ObjectProperty isDessert = ObjProperty.getObjectTypeProperty("isDessert");
				
				if (annotationNames.contains(D_STICK)) {
					OntResource stick = model.getOntResource(uriBase + D_STICK);
					return getRestrictions(nodeArray, foodRestriction, isDessert, stick);
				} else if (annotationNames.contains(D_ICECREAM)) {
					OntResource ice = model.getOntResource(uriBase + D_ICECREAM);
					return getRestrictions(nodeArray, foodRestriction, isDessert, ice);
				} else if (annotationNames.contains(D_DONUT)) {
					OntResource donut = model.getOntResource(uriBase + D_DONUT);
					return getRestrictions(nodeArray, foodRestriction, isDessert, donut);
				} else if (annotationNames.contains(D_COOKIE)) {
					OntResource cookie = model.getOntResource(uriBase + D_COOKIE);
					return getRestrictions(nodeArray, foodRestriction, isDessert, cookie);
				} else if (annotationNames.contains(D_CAKE)) {
					OntResource cake = model.getOntResource(uriBase + D_CAKE);
					return getRestrictions(nodeArray, foodRestriction, isDessert, cake);
				} else if (annotationNames.contains(D_CHOCOLATE)) {
					OntResource choc = model.getOntResource(uriBase + D_CHOCOLATE);
					return getRestrictions(nodeArray, foodRestriction, isDessert, choc);
				} else if (annotationNames.contains(D_CANDY)) {
					OntResource candy = model.getOntResource(uriBase + D_CANDY);
					return getRestrictions(nodeArray, foodRestriction, isDessert, candy);
				}
			} else {
				return model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {foodRestriction}));
			}
		}		
		return restriction;
	}

	/**
	 * Checks for body annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addBodyRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);
		//Body restrictions
		ObjectProperty hasBodyPart = ObjProperty.getObjectTypeProperty("hasBodyPart");
		if (annotationNames.contains(BODY) && !annotationNames.contains(FACE)) {
			if (annotationNames.contains(B_HAND)) {
				OntResource hand = model.getOntResource(uriBase + B_HAND);
				return getRestrictions(nodeArray, hasBodyPart, hand);
			} else if (annotationNames.contains(B_FINGER)) {
				OntResource finger = model.getOntResource(uriBase + B_FINGER);
				return getRestrictions(nodeArray, hasBodyPart, finger);
			} else if (annotationNames.contains(B_HEART)) {
				OntResource heart = model.getOntResource(uriBase + B_HEART);
				return getRestrictions(nodeArray, hasBodyPart, heart);
			}
		} else if (annotationNames.contains(B_HAND) && !annotationNames.contains(FACE)) {
				OntResource hand = model.getOntResource(uriBase + B_HAND);
				return getRestrictions(nodeArray, hasBodyPart, hand);
		} else if (annotationNames.contains(B_FINGER) && !annotationNames.contains(FACE)) {
				OntResource finger = model.getOntResource(uriBase + B_FINGER);
				return getRestrictions(nodeArray, hasBodyPart, finger);
		} else if (annotationNames.contains(B_HEART) && !annotationNames.contains(FACE)) {
				OntResource heart = model.getOntResource(uriBase + B_HEART);
				return getRestrictions(nodeArray, hasBodyPart, heart);
		}
		return restriction;

	}
	
	/**
	 * Checks for emotions annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addEmotionsRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);		
		ObjectProperty hasEmotion = ObjProperty.getObjectTypeProperty("hasEmotion");
		
        if (annotationNames.contains(EmojiProperties.E_CRY)) {
			OntResource cry = model.getOntResource(uriBase + EmojiProperties.E_CRY);
			return getRestrictions(nodeArray, hasEmotion, cry);
		} else if (annotationNames.contains(EmojiProperties.E_SURPRISED)) {
			OntResource surprised = model.getOntResource(uriBase + EmojiProperties.E_SURPRISED);
			return getRestrictions(nodeArray, hasEmotion, surprised);
		} else if (annotationNames.contains(EmojiProperties.E_MAD)) {
			OntResource mad = model.getOntResource(uriBase + EmojiProperties.E_MAD);
			return getRestrictions(nodeArray, hasEmotion, mad);
		} else if (annotationNames.contains(EmojiProperties.E_LOVE)) {
			OntResource love = model.getOntResource(uriBase + EmojiProperties.E_LOVE);
			return getRestrictions(nodeArray, hasEmotion, love);
		} else if (annotationNames.contains(EmojiProperties.E_KISS)) {
			OntResource kiss = model.getOntResource(uriBase + EmojiProperties.E_KISS);
			return getRestrictions(nodeArray, hasEmotion, kiss);
		} else if (annotationNames.contains(EmojiProperties.E_SAD)) {
			OntResource sad = model.getOntResource(uriBase + EmojiProperties.E_SAD);
			return getRestrictions(nodeArray, hasEmotion, sad);
		} else if (annotationNames.contains(EmojiProperties.E_FEAR)) {
			OntResource fear = model.getOntResource(uriBase + EmojiProperties.E_FEAR);
			return getRestrictions(nodeArray, hasEmotion, fear);
		} else if (annotationNames.contains(EmojiProperties.E_DISAPPOINTED)) {
			OntResource disappointed = model.getOntResource(uriBase + EmojiProperties.E_DISAPPOINTED);
			return getRestrictions(nodeArray, hasEmotion, disappointed);
		}
			
		return restriction;
	}
	
	/**
	 * Checks for topics annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addTopicRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);		
		ObjectProperty hasTopic = ObjProperty.getObjectTypeProperty("hasTopic");
		
		if (annotationNames.contains(EmojiProperties.T_ROMANCE)) {
			OntResource romance = model.getOntResource(uriBase + EmojiProperties.T_ROMANCE);
			return getRestrictions(nodeArray, hasTopic, romance);			
		} else if (annotationNames.contains(EmojiProperties.T_COMIC)) {
			OntResource comic = model.getOntResource(uriBase + EmojiProperties.T_COMIC);
			return getRestrictions(nodeArray, hasTopic, comic);
		} else if (annotationNames.contains(EmojiProperties.T_SPORT)) {
			OntResource sport = model.getOntResource(uriBase + EmojiProperties.T_SPORT);
			return getRestrictions(nodeArray, hasTopic, sport);
		}  else if (annotationNames.contains(EmojiProperties.T_MUSIC)) {
			OntResource music = model.getOntResource(uriBase + EmojiProperties.T_MUSIC);
			return getRestrictions(nodeArray, hasTopic, music);
		} else if (annotationNames.contains(EmojiProperties.T_DRINK)) {
			OntResource drink = model.getOntResource(uriBase + EmojiProperties.T_DRINK);
			return getRestrictions(nodeArray, hasTopic, drink);
		} else if (annotationNames.contains(EmojiProperties.T_EDUCATION)) {
			OntResource education = model.getOntResource(uriBase + EmojiProperties.T_EDUCATION);
			return getRestrictions(nodeArray, hasTopic, education);
		} else if (annotationNames.contains(EmojiProperties.T_TRAVEL)) {
			OntResource travel = model.getOntResource(uriBase + EmojiProperties.T_TRAVEL);
			return getRestrictions(nodeArray, hasTopic, travel);
		}
		
		return restriction;
	}
	
	/**
	 * Checks for feelings annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addFeelingsRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);	    	    
		ObjectProperty hasFeelings = ObjProperty.getObjectTypeProperty("hasFeelings");
		
		if (annotationNames.contains(EmojiProperties.F_HEAR)) {	
			OntResource hear = model.getOntResource(uriBase + EmojiProperties.F_HEAR);
			return getRestrictions(nodeArray, hasFeelings, hear);
		} else if (annotationNames.contains(EmojiProperties.F_SEE)) {	
			OntResource see = model.getOntResource(uriBase + EmojiProperties.F_SEE);
			return getRestrictions(nodeArray, hasFeelings, see);
		} else if (annotationNames.contains(EmojiProperties.F_COOL)) {	
			OntResource cool = model.getOntResource(uriBase + EmojiProperties.F_COOL);
			return getRestrictions(nodeArray, hasFeelings, cool);
		} else if (annotationNames.contains(EmojiProperties.F_TASTE)) {	
			OntResource taste = model.getOntResource(uriBase + EmojiProperties.F_TASTE);
			return getRestrictions(nodeArray, hasFeelings, taste);
		} else if (annotationNames.contains(EmojiProperties.F_HOT)) {	
			OntResource hot = model.getOntResource(uriBase + EmojiProperties.F_HOT);
			return getRestrictions(nodeArray, hasFeelings, hot);
		} else if (annotationNames.contains(EmojiProperties.F_SPEAK)) {	
			OntResource speak = model.getOntResource(uriBase + EmojiProperties.F_SPEAK);
			return getRestrictions(nodeArray, hasFeelings, speak);
		} else if (annotationNames.contains(EmojiProperties.F_COLD)) {	
			OntResource cold = model.getOntResource(uriBase + EmojiProperties.F_COLD);
			return getRestrictions(nodeArray, hasFeelings, cold);
		}
		return restriction;
	}
	
	/**
	 * Checks for symbol annotation, if such exists add it to the RDFList with
	 * restrictions.
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addSymbolRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);	    	    
		ObjectProperty isSymbol = ObjProperty.getObjectTypeProperty("isSymbol");
		
		if (annotationNames.contains(EmojiProperties.SYMBOL) && annotationNames.contains(EmojiProperties.S_ZODIAC) &&
				annotationNames.contains(EmojiProperties.S_TIME)) {	
			addZodiacIndividuals(cl, annotationNames);
			return null;
		} else if (annotationNames.contains(EmojiProperties.SYMBOL) && annotationNames.contains(EmojiProperties.S_WORD) &&
				annotationNames.contains(EmojiProperties.S_JAPANESE)) {	
			OntResource japanese = model.getOntResource(uriBase + EmojiProperties.S_JAPANESE);
			OntClass ideographicCharacters = model.getOntClass(uriBase + "IdeographicCharacters");
			DatatypeProperty isIdeographicCharacter = DataTypeProperty.getDataTypeProperty("isIdeographicCharacter");
			String classN = cl.getLocalName();
			String comments = cl.getComment(null);
			cl.remove();
			Individual ind = model.createIndividual(uriBase + classN, ideographicCharacters);
			ind.setLabel(classN, null);
			ind.setComment(comments, null);
			ind.addLiteral(isIdeographicCharacter, true);
			ind.addProperty(isSymbol, japanese);
			return null;
		} else if (annotationNames.contains(EmojiProperties.SYMBOL) && annotationNames.contains(EmojiProperties.S_WORD) &&
				 annotationNames.contains(EmojiProperties.S_CHINESE)) {	
			OntResource chinese = model.getOntResource(uriBase + EmojiProperties.S_CHINESE);
			OntClass ideographicCharacters = model.getOntClass(uriBase + "IdeographicCharacters");
			DatatypeProperty isIdeographicCharacter = DataTypeProperty.getDataTypeProperty("isIdeographicCharacter");
			String classN = cl.getLocalName();
			String comments = cl.getComment(null);
			cl.remove();
			Individual ind = model.createIndividual(uriBase + classN, ideographicCharacters);
			ind.setLabel(classN, null);
			ind.setComment(comments, null);
			ind.addLiteral(isIdeographicCharacter, true);
			ind.addProperty(isSymbol, chinese);
			return null;
		} else if (annotationNames.contains(EmojiProperties.S_GEOMETRIC) && annotationNames.contains(EmojiProperties.G_DIMANOD)) {	
			OntResource dimond = model.getOntResource(uriBase + EmojiProperties.G_DIMANOD);
			addPropertiesToGeometricIndividual(cl, dimond);
			return null;
		} else if (annotationNames.contains(EmojiProperties.S_GEOMETRIC) && annotationNames.contains(EmojiProperties.G_CIRCLE)) {	
			OntResource circle = model.getOntResource(uriBase + EmojiProperties.G_CIRCLE);
			addPropertiesToGeometricIndividual(cl, circle);
			return null;
		} else if (annotationNames.contains(EmojiProperties.S_GEOMETRIC) && annotationNames.contains(EmojiProperties.G_SQUARE)) {	
			OntResource square = model.getOntResource(uriBase + EmojiProperties.G_SQUARE);
			addPropertiesToGeometricIndividual(cl, square);
			return null;
		} else if (annotationNames.contains(EmojiProperties.S_TIME)) {	
			OntResource time = model.getOntResource(uriBase + EmojiProperties.S_TIME);
			String timeFormat = getTime(annotationNames);
			if (timeFormat != null) {
				OntClass timeRelated = model.getOntClass(uriBase + EmojiProperties.S_TIME_RELATED);
				DatatypeProperty showsTime = DataTypeProperty.getDataTypeProperty("showsTime");
				String classN = cl.getLocalName();
				String comments = cl.getComment(null);
				cl.remove();
				Individual ind = model.createIndividual(uriBase + classN, timeRelated);
				ind.setLabel(classN, null);
				ind.setComment(comments, null);
				ind.addLiteral(showsTime, timeFormat);
				ind.addProperty(isSymbol, time);
				return null;
			}								
			return getRestrictions(nodeArray, isSymbol, time);
		} else if (annotationNames.contains(EmojiProperties.S_SIGN)) {	
			OntResource sign = model.getOntResource(uriBase + EmojiProperties.S_SIGN);
			return getRestrictions(nodeArray, isSymbol, sign);
		} else if (annotationNames.contains(EmojiProperties.S_WORD)) {	
			OntResource word = model.getOntResource(uriBase + EmojiProperties.S_WORD);
			OntResource keycap = model.getOntResource(uriBase + EmojiProperties.S_KEYCAP);
			String digit = getDigit(annotationNames);
			if (annotationNames.contains(EmojiProperties.S_KEYCAP) && digit != null ) {	
				OntClass keycapRelated = model.getOntClass(uriBase + EmojiProperties.S_KEYCAP_RELATED);
				DatatypeProperty hasNumber = DataTypeProperty.getDataTypeProperty("hasNumber");
				String classN = cl.getLocalName();
				String comments = cl.getComment(null);
				cl.remove();
				Individual ind = model.createIndividual(uriBase + classN, keycapRelated);
				ind.setLabel(classN, null);
				ind.setComment(comments, null);
				ind.addLiteral(hasNumber, digit);
				ind.addProperty(isSymbol, keycap);
				return null;
			} else {
				return getRestrictions(nodeArray, isSymbol, word);
			}
		}
		return restriction;
	}
	
	/**
	 *Checks for Face parts annotation, if such exists add it to the RDFList with
	 * restrictions
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 *            - previous restriction
	 * @return RDFList restriction
	 */
	protected RDFList addFacePartsRestriction(ArrayList<String> annotationNames, OntClass cl, RDFList restriction) {
		
		RDFNode[] nodeArray = getRestrictionsAsArray(restriction);		
		ObjectProperty hasFacePart = ObjProperty.getObjectTypeProperty("hasFacePart");
		ObjectProperty faceWith = ObjProperty.getObjectTypeProperty("faceWith");
		
		if (annotationNames.contains(EmojiProperties.F_NOSE)) {	
			OntResource nose = model.getOntResource(uriBase + EmojiProperties.F_NOSE);
			return getRestrictions(nodeArray, hasFacePart, nose);
		} else if (annotationNames.contains(EmojiProperties.F_LIPS)) {	
			OntResource lips = model.getOntResource(uriBase + EmojiProperties.F_LIPS);
			return getRestrictions(nodeArray, hasFacePart, lips);
		} else if (annotationNames.contains(EmojiProperties.F_MOUTH)) {	
			OntResource mouth = model.getOntResource(uriBase + EmojiProperties.F_MOUTH);
			return getRestrictions(nodeArray, hasFacePart, mouth);
		} else if (annotationNames.contains(EmojiProperties.F_EYE)) {	
			OntResource eye = model.getOntResource(uriBase + EmojiProperties.F_EYE);
			return getRestrictions(nodeArray, hasFacePart, eye);
		} else if (annotationNames.contains(EmojiProperties.F_EAR)) {	
			OntResource eye = model.getOntResource(uriBase + EmojiProperties.F_EAR);
			return getRestrictions(nodeArray, hasFacePart, eye);
		} else if (annotationNames.contains(EmojiProperties.F_TONGUE)) {	
			OntResource tongue = model.getOntResource(uriBase + EmojiProperties.F_TONGUE);
			return getRestrictions(nodeArray, hasFacePart, tongue);
		} else if (annotationNames.contains(EmojiProperties.F_TEAR) && !annotationNames.contains(EmojiProperties.F_JOY)) {	
			OntResource tear = model.getOntResource(uriBase + EmojiProperties.F_TEAR);
			return getRestrictions(nodeArray, faceWith, tear);
		} else if (annotationNames.contains(EmojiProperties.F_SMILE)) {	
			OntResource smile = model.getOntResource(uriBase + EmojiProperties.F_SMILE);
			return getRestrictions(nodeArray, faceWith, smile);
		} else if (annotationNames.contains(EmojiProperties.F_JOY) && annotationNames.contains(EmojiProperties.F_TEAR)) {	
			OntClass fe = model.getOntClass(uriBase + EmojiProperties.F_EXPRESSION);
			OntResource joy = model.getOntResource(uriBase + EmojiProperties.F_JOY);
			OntResource tear = model.getOntResource(uriBase + EmojiProperties.F_TEAR);
			IntersectionClass both = model.createIntersectionClass(null,
					model.createList(new RDFNode[] {joy, tear}));
			fe.addSubClass(both);
			Restriction tjRest = model.createAllValuesFromRestriction(null, faceWith, both);					
			return model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {tjRest}));
		} else if (annotationNames.contains(EmojiProperties.F_BOAR)) {	
			OntResource boar = model.getOntResource(uriBase + EmojiProperties.F_BOAR);
			return getRestrictions(nodeArray, hasFacePart, boar);
		}
		return restriction;
	}
	
	/**
	 * Checks for insects annotation and add an Object property value. 
	 * 
	 * @param annotationNames
	 * @param cl
	 * @param restriction
	 */
	protected void addInsectRestriction(ArrayList<String> annotationNames, Individual ind) {
		ObjectProperty isInsect = ObjProperty.getObjectTypeProperty("isInsect");

		if (annotationNames.contains(EmojiProperties.INSECT_BUG)) {
			OntResource bug = model.getOntResource(uriBase + EmojiProperties.INSECT_BUG);
			ind.setPropertyValue(isInsect, bug);
		} else if (annotationNames.contains(EmojiProperties.INSECT_BEE)) {
			OntResource bee = model.getOntResource(uriBase + EmojiProperties.INSECT_BEE);
			ind.setPropertyValue(isInsect, bee);
		} else if (annotationNames.contains(EmojiProperties.INSECT_BEETLE)) {
			OntResource beetle = model.getOntResource(uriBase + EmojiProperties.INSECT_BEETLE);
			ind.setPropertyValue(isInsect, beetle);
		}  else if (annotationNames.contains(EmojiProperties.INSECT_ANT)) {
			OntResource ant = model.getOntResource(uriBase + EmojiProperties.INSECT_ANT);
			ind.setPropertyValue(isInsect, ant);
		} 
	}
	
	/**
	 * Add an anonymous restriction to the class. Make the restriction to be a
	 * super class of it.
	 * 
	 * @param cl
	 * @param nodeArray
	 * @param rest
	 */
	protected void addAnonymousRestriction(OntClass cl, RDFNode[] nodeArray, Restriction rest) {
		IntersectionClass intersection = model.createIntersectionClass(null,
				model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {rest})));
		cl.addSuperClass(intersection);
	}
	
	/**
	 * Add one Restriction the RDFList
	 * @param nodeArray
	 * @param hasEmotion
	 * @param surprised
	 * @return RDFList with restrictions
	 */
	private RDFList getRestrictions(RDFNode[] nodeArray, ObjectProperty isProperty, OntResource value) {
		Restriction surprisedRest = model.createHasValueRestriction(null, isProperty, value);					
		return model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {surprisedRest}));
	}
	
	/**
	 * Add two restriction to the RDFList.
	 * @param nodeArray
	 * @param restriction
	 * @param isProperty
	 * @param value
	 * @return RDFList with Restrictions
	 */
	private RDFList getRestrictions(RDFNode[] nodeArray, Restriction restriction, ObjectProperty isProperty,
			OntResource value) {
		Restriction rest = model.createHasValueRestriction(null, isProperty, value);
		return model.createList((RDFNode[])ArrayUtils.addAll(nodeArray, new RDFNode[] {restriction, rest}));
	}
	

	/**
	 * Add zodiacs individuals
	 * @param cl
	 * @param annotationNames
	 */
	private void addZodiacIndividuals(OntClass cl, ArrayList<String> annotationNames) {

		if (annotationNames.contains(EmojiProperties.Z_ARIES)) {
			OntResource aries = model.getOntResource(uriBase + EmojiProperties.Z_ARIES);
			addPropertiesToZodiacIndividual(cl, aries);
		} else if (annotationNames.contains(EmojiProperties.Z_TAURUS)) {
			OntResource taurus = model.getOntResource(uriBase + EmojiProperties.Z_TAURUS);
			addPropertiesToZodiacIndividual(cl, taurus);
		} else if (annotationNames.contains(EmojiProperties.Z_GEMINI)) {
			OntResource gemini = model.getOntResource(uriBase + EmojiProperties.Z_GEMINI);
			addPropertiesToZodiacIndividual(cl, gemini);
		} else if (annotationNames.contains(EmojiProperties.Z_LEO)) {
			OntResource leo = model.getOntResource(uriBase + EmojiProperties.Z_LEO);
			addPropertiesToZodiacIndividual(cl, leo);
		} else if (annotationNames.contains(EmojiProperties.Z_LIBRA)) {
			OntResource libra = model.getOntResource(uriBase + EmojiProperties.Z_LIBRA);
			addPropertiesToZodiacIndividual(cl, libra);
		} else if (annotationNames.contains(EmojiProperties.Z_CAPRICORN)) {
			OntResource capr = model.getOntResource(uriBase + EmojiProperties.Z_CAPRICORN);
			addPropertiesToZodiacIndividual(cl,capr);
		} else if (annotationNames.contains(EmojiProperties.Z_CANCER)) {
			OntResource can = model.getOntResource(uriBase + EmojiProperties.Z_CANCER);
			addPropertiesToZodiacIndividual(cl, can);
		} else if (annotationNames.contains(EmojiProperties.Z_AQUARIUS)) {
			OntResource aq = model.getOntResource(uriBase + EmojiProperties.Z_AQUARIUS);
			addPropertiesToZodiacIndividual(cl, aq);
		} else if (annotationNames.contains(EmojiProperties.Z_VIRGIN)) {
			OntResource virg = model.getOntResource(uriBase + EmojiProperties.Z_VIRGIN);
			addPropertiesToZodiacIndividual(cl, virg);
		} else if (annotationNames.contains(EmojiProperties.Z_PISCES)) {
			OntResource pisces = model.getOntResource(uriBase + EmojiProperties.Z_PISCES);
			addPropertiesToZodiacIndividual(cl, pisces);
		} else if (annotationNames.contains(EmojiProperties.Z_SCORPIUS)) {
			OntResource scorp = model.getOntResource(uriBase + EmojiProperties.Z_SCORPIUS);
			addPropertiesToZodiacIndividual(cl, scorp);
		} else if (annotationNames.contains(EmojiProperties.Z_SAGITTARIUS)) {
			OntResource sagi = model.getOntResource(uriBase + EmojiProperties.Z_SAGITTARIUS);
			addPropertiesToZodiacIndividual(cl, sagi);
	}		
}
	
	/**
	 * Add to particular zodiac individual data and object properties.
	 * @param cl
	 * @param value
	 */
	private void addPropertiesToZodiacIndividual(OntClass cl, OntResource value) {
		ObjectProperty hasZodiac = ObjProperty.getObjectTypeProperty("hasZodiac");
		ObjectProperty isSymbol = ObjProperty.getObjectTypeProperty("isSymbol");
		OntResource zodiac = model.getOntResource(uriBase + EmojiProperties.S_ZODIAC);
		OntClass zodiacSymbols = model.getOntClass(uriBase + "ZodiacSymbols");
		DatatypeProperty isZodiacSymbols = DataTypeProperty.getDataTypeProperty("isZodiacSymbol");
		String classN = cl.getLocalName();
		String comments = cl.getComment(null);
		cl.remove();
		Individual ind = model.createIndividual(uriBase + classN, zodiacSymbols);
		ind.setLabel(classN, null);
		ind.setComment(comments, null);
		ind.addLiteral(isZodiacSymbols, true);
		ind.addProperty(hasZodiac, value);
		ind.addProperty(isSymbol, zodiac);
	}
	
	/**
	 * Add to particular geometric Individual data and object properties value.
	 * 
	 * @param cl
	 * @param dimond
	 */
	private void addPropertiesToGeometricIndividual(OntClass cl, OntResource dimond) {
		ObjectProperty hasShape = ObjProperty.getObjectTypeProperty("hasShape");
		OntClass geometricSymbols = model.getOntClass(uriBase + "GeometricSymbols");
		DatatypeProperty isGeometricSymbol = DataTypeProperty.getDataTypeProperty("isGeometricSymbol");
		String classN = cl.getLocalName();
		String comments = cl.getComment(null);
		cl.remove();
		Individual ind = model.createIndividual(uriBase + classN, geometricSymbols);
		ind.setLabel(classN, null);
		ind.setComment(comments, null);
		ind.addLiteral(isGeometricSymbol, true);
		ind.addProperty(hasShape, dimond);
	}
	
	/**
	 * Check if annotation is a number and return it. Use regex.
	 * 
	 * @param annotationNames
	 * @return
	 */
	private String getDigit(ArrayList<String> annotationNames) {	
		for (String str : annotationNames) {
			if (str.matches("-?\\d+(\\.\\d+)?")) {
				return str;
			}			
		}
		return null;
	}
	
	/**
	 * Check if annotation contains a String in a format (11:22,3:45) and if so
	 * return it.
	 * 
	 * @param annotationNames
	 * @return
	 */
	private String getTime(ArrayList<String> annotationNames) {
		for (String str : annotationNames) {
			if (str.contains(":")) {
				return str;
			}			
		}
		return null;
	}
}

