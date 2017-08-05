package com.ontology.emoji.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ontology.emoji.model.EmojiModelBuider;
import com.ontology.emoji.model.ontresources.EmojiResourceImpl;

public class ReadFile {
	
	private static Logger log = Logger.getLogger(ReadFile.class.getName());
	private String filePath;
	private EmojiResourceImpl oResource;
	private ArrayList<String> rowEntry;
	private ArrayList<ArrayList<String>> allEntry = new ArrayList<ArrayList<String>>();
	
	public ReadFile(String filePath) {		
		this.filePath = filePath;
	}	

	public void readInput() {	
		InputStream in = ReadFile.class.getClassLoader().getResourceAsStream(filePath);
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook (in);
			log.error("FileNotFoundException: ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		    log.error("FileNotFoundException: ", e);
		      
		} catch (IOException e) {
			e.printStackTrace();
		    log.error("IOException", e);
		}      

        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIterator = mySheet.iterator();
        
        //build the hierarchy - main classes
        EmojiModelBuider mc = new EmojiModelBuider();
        mc.buildHierarchy();
        
        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //ignore the column's title name
            if(row.getRowNum() == 0)
            	continue;
            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            rowEntry = new ArrayList<String>();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                	rowEntry.add(cell.getStringCellValue());
                    break;
                default :
             
                }             
            }
            add(rowEntry);                     
        }

        //build the ontology
        oResource = new EmojiResourceImpl(allEntry, mc);
        oResource.addResources(); 
        //write owl file
		WriteFile wf = new WriteFile();
		wf.writeOutput();
	}

	private void add(ArrayList<String> entry) {
		allEntry.add(entry);		
	}	
}