package com.ontology.emoji.model;

import org.apache.jena.vocabulary.XSD;

import com.ontology.emoji.model.entities.*;

public class EmojiModelBuider{
	
	public void buildHierarchy() {	
		EmojiClass emoji = new EmojiClass();
		emoji.addEmojiClass();
		
        //add data property - hasUnicode String
		DataTypeProperty dp = DataTypeProperty.getInstance();
        dp.addDataTypeProperty("hasUnicode", XSD.xstring, true);
        
        //add data property - hasNumber    
        dp.addDataTypeProperty("hasNumber", XSD.xstring, true);

        //add data property - canBeEaten    
        dp.addDataTypeProperty("canBeEaten", XSD.xboolean, false);	
		
		//add data type property - isIdeaographicCharacter - boolean  
        dp.addDataTypeProperty("isIdeographicCharacter", XSD.xboolean, false);
		
		//add data type property - isGeometricSymbols - boolean 
        dp.addDataTypeProperty("isGeometricSymbol", XSD.xboolean, false);
		
		//add data type property - isZodiacSymbols - boolean
        dp.addDataTypeProperty("isZodiacSymbol", XSD.xboolean, false);
		
        //add data property - showsTime String
		dp.addDataTypeProperty("showsTime", XSD.xstring, true);
        
		//create Face class
		new FaceClass().addEmojiClass();
		 
        //create Emoji Descriptor class
        new EmojiDescriptiorClass().addEmojiClass();
        
        //create Body class
        new BodyClass().addEmojiClass();
		
        //create Animal class
        new AnimalClass().addEmojiClass();

        //create Person class
        new PersonClass().addEmojiClass();
		
        //create Object class
        new ObjectClass().addEmojiClass();
        
        //create Topic class
        new TopicClass().addEmojiClass();
        
        //create Place class
        new PlaceClass().addEmojiClass();        
        
        //create Plant class
        new PlantClass().addEmojiClass();
        
        //create Food class
        new FoodClass().addEmojiClass();		
        
        //create Symbol class
        new SymbolClass().addEmojiClass();
        
        //create Vehicle class
        new VehicleClass().addEmojiClass();
	}
}
