/** 
 * processDog.java - test the Dog class
 * author: Yanni Giftakis
 * edited by: Ivan Belov
 * 
 * This class acts as an engine for
 * processing given .txt file data,
 * turning the data into an object class array,
 * outputting number of records,
 * outputting records,
 * displaying number of dogs ready for adoption,
 * and displaying the oldest and the youngest dog out of them all * 
*/
import java.io.*;
import java.util.*;

public class processDog	{
 @SuppressWarnings("resource")
public static void main (String[] args)
 	throws IOException // yet there are no try catch block implemented
 {
	 Scanner scanFile; // declares a scanner to help open a certain .txt file based on user need
	 Scanner myFileNameScanner = new Scanner(System.in); // declaring and initializing another 
	 
	 @SuppressWarnings("unused")
	String dataFileName;	// helps with data file name facilitation

	 /** 
	  * youngestDog -- stores the age of the youngest dog,
	  * oldestDog -- stores the age of the oldest dog,
	  * linesToSkip -- stores amount of lines too skip
	  * 				in between of output blocks
	  * adoptedDog -- keeping track of number of adopted dogs, 
	  * numDogs -- Keeping track of number of records.
	  */
	 int youngestDog = 99, oldestDog = 0, linesToSkip = 3, adoptedCount = 0, numDogs = 0;
	 
	 /**
	  * verbeTense -- changes verb depending on the amount of dog's age.
	  * mutts -- changes noun to plural or single type.
	  * dogAgeBasedName -- changes from puppy to dog base on the age of the given animal.
	  * 					
	  */
	 String verbTense = null , mutts = null, dogAgeBasedName = null;
	 
	 /**
	  * below code is in charge of outputting
	  * a list of files located in the folder alonside 'src' abd 'bin' folders.
	  */
     File currentDirectory = new File(".");
     getAllFiles(currentDirectory);
     
	 System.out.println("\n \t Welcome to S.P.C.A. pet processing e-tool. \n");
	 System.out.print("\t Please enter the name of the dog data file you wish to process: ");
     
	 scanFile = new Scanner ( new File(dataFileName = myFileNameScanner.next())); // initializing scanFile object
	 /*
	  * Reads first line of a file provided.
	  * First line is suppose to be an int value of records amount.
	  */
	 while (scanFile.hasNext())	{
	 numDogs = scanFile.nextInt(); // read int (elevation of city) - disregard
	 break;
	 }
	 
	 Dog[] dogs = new Dog[numDogs];
	 
	 for ( int i=0; i<dogs.length; i++ )
	 {
		 dogs[i] = new Dog();
		 dogs[i].setName(scanFile.next());
		 dogs[i].setAge(scanFile.nextInt());
		 dogs[i].setAdopted(scanFile.nextBoolean()); }

	scanFile.close(); // close file (to reset file point to top of file)

	 System.out.print("\t Please enter file name to store processed data into: ");
	 File dogDataFile = new File (myFileNameScanner.next());
	 BufferedWriter output = new BufferedWriter(new FileWriter(dogDataFile));
	 /**
	  * Above approach was found posted
	  * here: https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
	  * It is one for Java version 7 and higher
	  */
	 
	 output.write(" \t Totall records: " + numDogs);
	 
	 for ( int y = 0; y < linesToSkip; y++)	{
	 output.newLine();	}
	 /*
	  * Above for loops creates a buffer for
	  * better human readability of the processed file
	  */
	 
	 for ( int i = 0; i < dogs.length; i++)	{
		 int x = i + 1; // skipping the first line
		 output.write(("\n # " + x + " " + dogs[i].toString())+ ".");
		 output.newLine();
		 /**
		  * Above output approach was found 
		  * here: https://stackoverflow.com/questions/13707223/how-to-write-an-array-to-a-file-java#13707602
		  */

		 /**
		  * below code figures what is the maximum age out of all dogs
		  */
		 oldestDog = Math.max(oldestDog, dogs[i].getPersonAge());
		 
		 /** 
		  * below code counts an amount of available dogs for adoption
		  */
		adoptedCount = ((dogs[i].getAdopted() == false) ? ++adoptedCount : adoptedCount);

		 /**
		  * below code is in charge of selecting the minimum age out of the list of all dogs
		  */
		 youngestDog = Math.min(youngestDog, dogs[i].getPersonAge());
	 } // end of for loop
	 
	 for ( int z = 0; z < linesToSkip-1; z++)	{
	 output.newLine();	}
	 /**
	  * Above for loops creates a buffer for
	  * better human readability of the processed file
	  */
	 
		 verbTense = ( ( adoptedCount == 1 ) ? "is ":"are ");
		 mutts = ( ( adoptedCount == 1 ) ? " dog ":" dogs ");
	 
	 output.write("\t Currently there " + verbTense + adoptedCount + mutts + "available for adoption.");
	 
	 for ( int y = 0; y < linesToSkip; y++)	{
	 output.newLine();	}
	 /**
	  * Above for loops creates a buffer for
	  * better human readability of the processed file
	  */
	 dogAgeBasedName = ((youngestDog <= 21) ? "puppy" : "dog");
	 output.write(( ( youngestDog == 0 ) ? "\t The youngest " + dogAgeBasedName + " is less than 7 human years old. ":" "
	 		+ "\t The youngest " + dogAgeBasedName + " is " + youngestDog + " human years old. "));  
	 
	 for ( int y = 0; y < linesToSkip; y++)	{
	 output.newLine();	}
	 dogAgeBasedName = ((oldestDog <= 21) ? "puppy" : "dog");
	 /**
	  * Above for loops creates a buffer for
	  * better human readability of the processed file
	  */
	 output.write(( ( oldestDog == 0 ) ? "\t The oldest " + dogAgeBasedName + " is less than 7 human years old. ":" "
	 		+ "\t The oldest " + dogAgeBasedName + " is " + oldestDog + " human years old. "));  
	 
	 output.close();
	 System.out.print("\n \t The data has been processed. ");
	 System.exit(0);
 }// end of main()
 
 /**
  * getAllFiles()
  * was seen at:
  * https://stackoverflow.com/questions/15482423/how-to-list-the-files-in-current-directory
  * It is edited to show only .txt files with 'Dogs' word in a file name.
  * A part of code envoking this method
  * is located in the main().
  */
 public static void getAllFiles(File currentDirectory)
 {
     File[] filesList = currentDirectory.listFiles();

     for(File f : filesList)
     {
             if(f.isFile())
         {
            	 String fileName = f.getName();
            	 if( fileName.matches("Dogs.*"))
            	 {
            		 System.out.println(f.getName());
            	 } // end of if statement
         } // end of if statement
     } // end of for loop
 } // end of getAllFiles
 
}// end of class
