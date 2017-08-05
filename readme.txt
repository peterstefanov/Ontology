1. Build the project: 
   $ mvn clean install
2. To run project: 
  2.1.
   $ mvn exec:java -Dexec.mainClass="com.ontology.emoji.Main" -Dexec.classpathScope=runtime
   Alternatively you can import the project in Eclipse once the project is build (step 1) prior importing it run the command:
   $ mvn eclipse:eclipse
  2.2. 
   $ mvn test 
  2.3.
   $ mvn exec:java  
 3. The EmojiUnicodes.xlsx resides in ../resources/file .
 4. Once the project is run EmojiOntology.owl file will be generated under the root directory.
