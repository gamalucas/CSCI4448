import java.util.*;  

// sorts the user input in alphabetical order
class Sorter {
    static boolean notempty = true;

// sorts the string in alphabetical order
    static void sortString(String str){
        System.out.println("You have entered: "+ str);
        char charArray[] = str.toCharArray(); // converts string into array of characters
        Arrays.sort(charArray);
        writeString(charArray);
    }

//takes in user input, checks if it empty and calls the function to sort the string
    static void readString(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, please enter a string: ");
        String str= sc.nextLine(); //user input
        if(str.isEmpty() || str == null){ //checkr
            System.out.println("Empty string");
            notempty = false;
        } 
        else{
            sortString(str);
        }    
    }

//writes to the terminal the sorted string
    static void writeString(char sorted[]){
        System.out.println("Sorted: " +new String(sorted));
        System.out.println("");
    }

//
    public static void main(String args[]){
        while(notempty){
            readString();
        }

    }
}