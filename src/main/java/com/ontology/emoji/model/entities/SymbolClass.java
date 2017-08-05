package com.ontology.emoji.model.entities;

import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.OntClass;

import com.ontology.emoji.model.ObjProperty;
import com.ontology.emoji.model.ontresources.emojiresources.EmojiProperties;

public class SymbolClass extends EmojiClass {

	public SymbolClass() {

	}
	
	public void addEmojiClass() {
		OntClass symbolRelated = model.createClass(uriBase +  EmojiProperties.SYMBOL_RELATED);
		symbolRelated.setLabel(EmojiProperties.SYMBOL_RELATED, null);		
		symbolRelated.setComment("All symbol related emojis", null);
		symbolRelated.addSuperClass(baseEmoji);	
		
		EnumeratedClass symbol = model.createEnumeratedClass(uriBase +  EmojiProperties.SYMBOL, null);
		symbol.setLabel(EmojiProperties.SYMBOL, null);	
		symbol.setComment("All symbols", null);
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_TIME, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_WORD, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_SIGN, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_KEYCAP, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_JAPANESE, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_CHINESE, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_GEOMETRIC, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.G_SQUARE, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.G_DIMANOD, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.G_CIRCLE, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.S_ZODIAC, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_ARIES, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_TAURUS, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_GEMINI, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_LEO, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_LIBRA, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_CAPRICORN, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_CANCER, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_AQUARIUS, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_VIRGIN, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_PISCES, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_SCORPIUS, null));
		symbol.addOneOf(model.createIndividual(uriBase + EmojiProperties.Z_SAGITTARIUS, null));
		
		OntClass ideographicCharacters = model.createClass(uriBase + "IdeographicCharacters");
		ideographicCharacters.setLabel("IdeographicCharacters", null);	
		ideographicCharacters.setComment("All Ideographic Characters related emojis.", null);
		ideographicCharacters.setSuperClass(symbolRelated);
		
		OntClass geometricSymbols = model.createClass(uriBase + "GeometricSymbols");
		geometricSymbols.setLabel("GeometricSymbols", null);	
		geometricSymbols.setComment("All Geometric Symbol related emojis.", null);
		geometricSymbols.setSuperClass(symbolRelated);
		
		OntClass zodiacSymbols = model.createClass(uriBase + "ZodiacSymbols");
		zodiacSymbols.setLabel("ZodiacSymbols", null);	
		zodiacSymbols.setComment("All Zodiacs Symbol related emojis.", null);
		zodiacSymbols.setSuperClass(symbolRelated);
		
		OntClass timeRelated = model.createClass(uriBase + EmojiProperties.S_TIME_RELATED);
		timeRelated.setLabel(EmojiProperties.S_TIME_RELATED, null);	
		timeRelated.setComment("All Time related emojis, representing the time.", null);
		timeRelated.setSuperClass(baseEmoji);
		
		OntClass keycap = model.createClass(uriBase + EmojiProperties.S_KEYCAP_RELATED);
		keycap.setLabel(EmojiProperties.S_KEYCAP_RELATED, null);	
		keycap.setComment("All Keycap related emojis", null);
		keycap.setSuperClass(baseEmoji);

	    ObjProperty op = ObjProperty.getInstance();
	    op.addObjectProperty("isSymbol", baseEmoji, symbol, true);		
	    op.addObjectProperty("hasShape", baseEmoji, symbol, true);
	    op.addObjectProperty("hasZodiac", baseEmoji, symbol, true);
	}
}
