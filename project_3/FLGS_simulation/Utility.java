// The work on this file is based on the work of Bruce Montgomery
import java.text.NumberFormat;
import java.util.*;  

public interface Utility {

   /*
    This function is responsible for generetinga a random number. 
    It was found on the following link: //https://www.baeldung.com/java-generating-random-numbers-in-range
    */
    static int getRandomNumber(int min, int max) { 
        return (int) ((Math.random() * (max - min)) + min);
    }

}