import java.util.*;  
import java.util.concurrent.ThreadLocalRandom;



class Ranger {
    // creation of several variables that need to be accessed over differnt methods
    static boolean nonzero = true; // traker to record when the user wants to exit the program by typing 0 0
    static boolean valid1 = false; // checker if the first user input is a valid number according to the requirements
    static boolean valid2 = false; // checker if the second user input is a valid number according to the requirements
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int startV = -1; // start value
    static int endV = 0; // end value
    static Scanner sc = new Scanner(System.in);
    static double mean = 0.0;
    static double sd = 0.0;
    static int arrCount = 0;

/**
method reponsible for checking whether or not the user input is valid according to the requirements
 */
    static int validNumber(String input){
        int number = 0;

        while (true) {
            try {
                number = Integer.parseInt(input); //string input is converted into and integer if possible
                if(number < 0){
                    throw new Exception("Invalid number");
                }
                return number;
            } 
            catch (Exception e) {
                System.out.println("Invalid number, please eneter a positive integer."); //if it can't be converted ask for a valid input
                input = sc.nextLine();
            }
        }
    }

/**
Reads the user input, calls the methods to validate it and checks for a positive range
 */
    static void read(){
        boolean positive = false;
        while(positive == false){
            System.out.println("Please enter a valid range (start value): ");
            String input1 = sc.nextLine(); //user input
            startV = validNumber(input1); //validation call

            System.out.println("End value: ");
            String input2 = sc.nextLine();
            endV = validNumber(input2);

            if (startV == 0 && endV == 0){ //ends the program if both inputs are 0
                nonzero = false;
                return;
            }
            else if(startV <= endV){ //checks if it is a positive range
                positive = true;
            }
        }
    }
    
    /**
    creates random array based on inputs, calculates mean and standard deviation
     */
    static void calculate(){
        double tot = 0.0;
        double sdv = 0.0;
        int length = arr.size();
        System.out.println("Random number array...");
        for (int i = 0; i < 10; i++) { //creates arraylist with random values within range
            arr.add(ThreadLocalRandom.current().nextInt(startV, endV + 1));
            tot += arr.get(i);
        }
        length = arr.size();
        mean = tot / length;
        for (int i = 0; i < length; i++) { //std diviation calculus
            sdv += Math.pow(arr.get(i) - mean, 2);
        }
        sd = Math.sqrt(sdv/length);
        write();
    }

    static void write(){ //prints out array and info
        System.out.println(arr.toString().replaceAll("\\[\\]", ""));
        System.out.println("Mean: " + mean);
        System.out.println("SD: " + sd);
    }

    public static void main(String args[]){
        while(nonzero){
            read();
            if(nonzero){
                while (arr.size() < 100){
                    calculate();
                }
                arr.clear();
            }
        }

    } 
}