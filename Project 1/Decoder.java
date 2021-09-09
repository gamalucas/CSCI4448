import java.util.*; 
import java.util.Scanner;  

class Decoder{

    static void decode(int asciiArray[], int size){ //this function exists to decode the user input into ASCII char
        for(int i = 0; i < size; i++){
            //check for lower case
            if(asciiArray[i] >= 97 & asciiArray[i] <= 122){
                char c = (char)asciiArray[i];
                System.out.print("Code: " + asciiArray[i] + "   ");
                System.out.print("Type: Lower case" + "   ");
                System.out.println("ASCII Char: " + c);
            }
            //check for upper case
            else if(asciiArray[i] >= 65 & asciiArray[i] <= 90){
                char c = (char)asciiArray[i];
                System.out.print("Code: " + asciiArray[i] + "   ");
                System.out.print("Type: Upper case" + "   ");
                System.out.println("ASCII Char: " + c);
            }
            //check for digit 
            else if(asciiArray[i] >= 48 & asciiArray[i] <= 57){
                char c = (char)asciiArray[i];
                System.out.print("Code: " + asciiArray[i] + "   ");
                System.out.print("Type: Digit" + "   ");
                System.out.println("ASCII Char: " + c);
            }
            //check for white space - DOES NOT COVER TAB
            else if(asciiArray[i] == 0 || asciiArray[i] == 8 || asciiArray[i] == 32){
                char c = (char)asciiArray[i];
                System.out.print("Code: " + asciiArray[i] + "   ");
                System.out.print("Type: White Space" + "   ");
                System.out.println("ASCII Char: " + c + "(white space)");
            }
            ////check for Special Character
            else if((asciiArray[i] >= 33 & asciiArray[i] <= 47) || (asciiArray[i] >= 58 & asciiArray[i] <= 63) || (asciiArray[i] >= 91 & asciiArray[i] <= 94) || (asciiArray[i] >= 123 & asciiArray[i] <= 125)){
                char c = (char)asciiArray[i];
                System.out.print("Code: " + asciiArray[i] + "   ");
                System.out.print("Type: Special Character" + "   ");
                System.out.println("ASCII Char: " + c);
            }
            //else, cases that were not asked to cover
            else{
                System.out.println("No cases avaiable for code: " + asciiArray[i]);
            }
        }
    }

    static void takeInput(){ //this function takeInput exits to simply take user's input (numeric only) so later on we can decode it into ASCII char
        Scanner sc = new Scanner(System.in);
        int[] asciiArray = new int[100];
        int n;
        System.out.println("Hello, please enter the number of elements you want to analyze: "); //ask the user to input how many ASCII values they want the program to decode. This exist so we have the exact number to loop through the array and populate it
        n = sc.nextInt();

        System.out.println("Enter the elements of the array: ");  
        for(int i = 0; i < n; i++){ //loop through the array and populate it with user input
            asciiArray[i]=sc.nextInt();  
        }

        decode(asciiArray, n); 
  
    }
    public static void main(String args[]){ // main should only initiate the program
        takeInput();
    }
}