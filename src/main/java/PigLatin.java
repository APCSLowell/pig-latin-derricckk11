import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	     for(int i = 0; i < sWord.length(); i++){
    
	    if(sWord.substring(i, i + 1).equals("a") || sWord.substring(i, i + 1).equals("e") || sWord.substring(i, i + 1).equals("i") || sWord.substring(i, i + 1).equals("o") || sWord.substring(i, i + 1).equals("u")){
	      
	      
	      return i;
	      
	    }
	    
	  }
        return -1;
    }

    public String pigLatin(String sWord) {
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord

	String piece1 = new String(sWord.substring(0, 1)); //take the first non vowel letters and move it to the back
	String pieceQU = newString(sWord.substring(0,2));
	String piece2 = new String(sWord.substring(1, sWord.length())); // keep the second part after the vowel.

	    if(piece1.equals("a") || piece1.equals("e") || piece1.equals("i") || piece1.equals("o") || piece1.equals("u")){
		    return sWord + "way";
	    }


	    if(pieceQU.equals("qu")){

		String newQUstring = new String(sWord.substring(2, sWord.length()) + pieceQU + "ay");
		return newQUstring; 
		    
	    }

	    if(findFirstVowel(sWord) > 0){

		String consonantCluster = sWord.substring(0, findFirstVowel(sWord));
		String restOfTheWord = sWord.substring(findFirstVowel(sWord));
		    return restOfTheWord + consonantCluster + "ay";
		    
		    
	    }

	    return sWord + "ay";

    } //end of the piglatin string function
   	

}//end PigLatin class
