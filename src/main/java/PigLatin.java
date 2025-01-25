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
	if (findFirstVowel(sWord) >= 0) { //if there is a vowel, 
	    String piece1 = new String(sWord.substring(0, findFirstVowel(sWord))); //take the first non vowel letters and move it to the back
	    String piece2 = new String(sWord.substring(findFirstVowel(sWord), sWord.length())); // keep the second part after the vowel. 
	    String newString = new String(piece2 + piece1);
	    System.out.println(newString + "ay");
	  }

    	if(findFirstVowel(sWord) == -1) {
	    return newString + "ay";
	    }
	    else {
		return "ERROR!";
   	 }
    }
}//end PigLatin class
