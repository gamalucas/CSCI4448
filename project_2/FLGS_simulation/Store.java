import java.util.*;  
import java.util.concurrent.ThreadLocalRandom;

class Store{
    // Initializes the objects of the store
    
    static List<Games> shelf = new ArrayList(); //The list shelf is an example of emcapsulation because all data stored in this class is protected and, therefore, can only be accesses by the methosd get() and/or set()
    Map<String, Integer> DamageContainer = new HashMap<String, Integer>(); //damaged container
    int days;
    //initializes employees
    Cashier Burt = new Cashier("Burt"); // The creation of "Burt" is a unique identifier and this is an example of IDENTITY
    Cashier Ernie = new Cashier("Ernie");
    Cashier empDay = new Cashier("");

    Register register = new Register(); //register
    //games
    Games Monopoly = new Family(42.00,10.00,2.00,16.00,3,0,0,"Monopoly",0,0); //This is an example of POLYMORPHISM
    Games Clue = new Family(52.00,15.00,5.00,20.00,3,0,0,"Clue",0,0);
    Games Life = new Family(33.00,8.00,3.00,9.00,3,0,0,"Life",0,0);
    Games Mousetrap = new Kids(50.00,12.00,4.00,10.00,3,0,0,"Mousetrap",0,0);
    Games Candyland = new Kids(22.00,7.00,2.00,9.50,3,0,0,"Candyland",0,0);
    Games Connect_Four = new Kids(27.00,17.00,8.00,22.00,3,0,0,"Connect Four",0,0);
    Games Magic = new Card(5.00,2.00,1.00,2.00,3,0,0,"Magic",0,0);
    Games Pokemon = new Card(125.99,1.00,2.00,2.00,3,0,0,"Pokémon",0,0);
    Games Netrunner = new Card(12.50,5.00,5.00,7.00,3,0,0,"Netrunner",0,0);
    Games Catan = new Board(15.60,10.50,15.00,17.00,3,0,0,"Catan",0,0);
    Games Risk = new Board(11.00,12.00,5.00,8.00,3,0,0,"Risk",0,0);
    Games Gloomhaven = new Board(14.50,9.00,7.00,7.00,3,0,0,"Gloomhaven",0,0);



    public Store(){
        //add all games Objects to the List shelf
        shelf.add(Monopoly);
        shelf.add(Clue);
        shelf.add(Life);
        shelf.add(Mousetrap);
        shelf.add(Candyland);
        shelf.add(Connect_Four);
        shelf.add(Magic);
        shelf.add(Pokemon);
        shelf.add(Netrunner);
        shelf.add(Catan);
        shelf.add(Risk);
        shelf.add(Gloomhaven);

        //add all games to the Map damage container. Added by the key (game name) followed by the number of games broken (at first 0 because this is in the constructor)
        DamageContainer.put("Monopoly", 0);
        DamageContainer.put("Clue", 0);
        DamageContainer.put("Life", 0);
        DamageContainer.put("Mousetrap", 0);
        DamageContainer.put("Candyland", 0);
        DamageContainer.put("Connect Four", 0);
        DamageContainer.put("Magic", 0);
        DamageContainer.put("Pokémon", 0);
        DamageContainer.put("Netrunner", 0);
        DamageContainer.put("Catan", 0);
        DamageContainer.put("Risk", 0);
        DamageContainer.put("Gloomhaven", 0);
        days = 0;
    }

/**
Chooses the employee of the day based on a boolean random variable
 */
    public boolean choose_employee(){
        return ThreadLocalRandom.current().nextBoolean();
    }


    /*
    start_day function will initialize the program and call all needed functions inside Cashier.java. It also makes the selection of the employee that will be working on the given day.
    */
    public void start_day(){
        boolean employeeOption = choose_employee(); //true for Burt and false for Ernie
        days++;
        if(employeeOption == true){
            empDay = Burt;
        }
        else if(employeeOption == false){
            empDay = Ernie;
        }
        empDay.Arrive(days, shelf);  
        empDay.Count(register);
        empDay.Vacuum(shelf, DamageContainer);
        empDay.Stack(shelf);
        empDay.Open(shelf, register);
        empDay.Order(shelf, register);
        empDay.Close();
        
    }

//prints the final messages of the game
    public void printMessages(){
        System.out.println("After 30 days, here is the summary of the store: ");
        System.out.println("Games on inventory: ");
        for(int i = 0; i < shelf.size(); i++){
            System.out.println(shelf.get(i).game_name + ": " + shelf.get(i).inventory + " games on inventory.");
        }
        System.out.println();
        System.out.println("Games sold: ");
        for(int i = 0; i < shelf.size(); i++){
            System.out.println(shelf.get(i).game_name + ": " + shelf.get(i).units_sold + " games sold.");
        }
        System.out.println();
        System.out.println("Total sales: ");
        for(int i = 0; i < shelf.size(); i++){
            System.out.println(shelf.get(i).game_name + ": $" + (shelf.get(i).units_sold * shelf.get(i).price) + ".");
        }
        System.out.println();
        System.out.println("Damage Container: ");
        for(int i = 0; i < DamageContainer.size(); i++){
            System.out.println(shelf.get(i).game_name + ": "+ DamageContainer.get(shelf.get(i).game_name));
        }
        System.out.println();
        System.out.println("Cash Register Blance: " + register.balance);
        System.out.println("Times money was added to the registerd: " + register.times_added);
        
    }
    public static void main(String args[]){
        Store FLGS = new Store();
        for (int i = 1; i <= 30; i++){
            FLGS.start_day();
            System.out.println("=====================================");
            System.out.println();
        }
        FLGS.printMessages();
       
    }
}