// The work on this file is based on the work of Bruce Montgomery
// import java.text.NumberFormat;
import java.util.*;  

public interface Utility {

   /*
    This function is responsible for generetinga a random number. 
    It was found on the following link: //https://www.baeldung.com/java-generating-random-numbers-in-range
    */
    static int getRandomNumber(int min, int max) { 
        return (int) ((Math.random() * (max - min)) + min);
    }


    // https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
    static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

}