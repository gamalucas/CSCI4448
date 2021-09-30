import java.util.*;  

public class Cashier extends Employee{

    String employee_name = "";
    //Constructor to initialize employee's name
    public Cashier(String name){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
    }
    

    /**
    Arrive anounces the arrival of an employee and aknowledges the arrival of new games
     */
    public void Arrive(int days, List<Games> shelf){
        System.out.println(employee_name + " the cashier has arrived at day " + days);
        for (int i = 0; i < shelf.size(); i++){
            if(shelf.get(i).games_arrival > 0){
                System.out.println("Three " + shelf.get(i).game_name + " games arrived at the store");
                shelf.get(i).inventory += 3;
                shelf.get(i).games_arrival = 0;
            }
        }
    }

    
    /**
    Count is resposible for counting the money in the register and adding more if the balance is bellow 100. As well as keeping track of how many times money was added.
     */
    public void Count(Register reg){
        System.out.println("Good morning! The amount on the cash register is $" + reg.balance);
        if (reg.balance < 100){
            reg.balance = 1000;
            reg.times_added++;
            System.out.println("Money was added to the cash register! The balance is now $" + reg.balance);
        }
    }

    /*
    Vacuum function controls employees behaviour when they are vacuumin the store. It generates the probability of a game being broken by the employee.  When broken, this function removes the game from the inventory and place it on the damage container.
    */
    public void Vacuum(List<Games> shelf, Map<String, Integer> DamageContainer){
        int count = 0;
        System.out.println(employee_name + " is vacuuming the store ");
        int demagePossibility = Utility.getRandomNumber(0, 101); // generate a random number that will reflect in the probability of a employee to break a game while vacumming the store
        int brokenGame = 0;
        brokenGame = Utility.getRandomNumber(0, 12); //generate a random number from 1 to 12 (because there are 12 fixed game titles). The selected number will represent which game to remove
        if(employee_name == "Burt" & demagePossibility >= 0 & demagePossibility <= 10){
                while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                    if(brokenGame == 12){ 
                        brokenGame = 0;
                    }
                    else{
                        brokenGame++;
                    }
                }
            
            shelf.get(brokenGame).inventory--; //subtract broken game from inventory
            count = DamageContainer.get(shelf.get(brokenGame).game_name);
            DamageContainer.put(shelf.get(brokenGame).game_name, count++);
            System.out.println("The game " +  shelf.get(brokenGame).game_name + " is damaged and placed on the Damaged Game Container");
        }
        else if(employee_name == "Ernie" & demagePossibility >= 0 & demagePossibility <= 5){
            while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                if(brokenGame == 12){ 
                    brokenGame = 0;
                }
                else{
                    brokenGame++;
                    }
                }
            shelf.get(brokenGame).inventory--; //subtract broken game from inventory
            count = DamageContainer.get(shelf.get(brokenGame).game_name); //get the current number of a specific broken games
            DamageContainer.put(shelf.get(brokenGame).game_name, (count+1)); //add broken game to broken container
            System.out.println("The game " +  shelf.get(brokenGame).game_name + " is damaged and placed on the Damaged Game Container");
        }
        System.out.println();
    }

    /**
    Stack is resposible for arranging the games in the shelf according to the empoloyee of the day
     */
    public void Stack(List<Games> shelf){
        if(employee_name == "Ernie"){
            for (int i = 0; i < shelf.size(); i++){
                shelf.get(i).pile_height = shelf.get(i).height * shelf.get(i).inventory; //determines the pile height of each game to be stacked
            } 
            Comparator<Games> compareByPH = (Games o1, Games o2) -> o1.pile_height.compareTo( o2.pile_height ); //sets comparator to comapre pile heights
            Collections.sort(shelf, compareByPH); //sorts shelf based on pile height
            for (int i = 0; i < shelf.size(); i++){
                System.out.println("Ernie stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Pile height is: " + shelf.get(i).pile_height + "\"");
            }
        }
        else if(employee_name == "Burt"){
            Comparator<Games> compareByWidth = (Games o1, Games o2) -> o1.width.compareTo( o2.width );//sets comparator to comapre pile heights
            Collections.sort(shelf, compareByWidth.reversed());  //sorts shelf based on pile height
            for (int i = 0; i < shelf.size(); i++){
                System.out.println("Burt stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
            }
        }
        System.out.println();
    }

    /* 
    The Open function is one of the most important functios of the program. It handdles all customer behaviour on the story, including buying a game. It also exists to keep in track of key variables, such as total amount on register, total games sold, etc. 
    */
    public void Open(List<Games> shelf, Register reg){
        System.out.println(employee_name + " opened the store. Welcome!");
        int num_customers = Utility.getRandomNumber(0, 5); //this variable will hold the number of customers 
        System.out.println(num_customers + " customer are in store today!");
        int prob_buying = 0; //this variable holds the probability of a customer buying a game
        int decreaser = 0; //this is a helper variable, it exists to decrease the probility of a game being bought everytime a customer moves to another shelf.
        int num_game_bought = 0; //this variable will hold how many games a customer bought per day. It exists to avoid a customer buying more than 2 games
        boolean bought_game = false; //variable to check if a customer have bought any game
        double addOn_price = 0.0;
        for (int i = 1; i <= num_customers; i++){ //loop throught all customer and perform their operations each one per time
            num_game_bought = 0;
                decreaser = 0;
                bought_game = false;
                for(int k = 0; k < shelf.size(); k++){ //loop throught all shelfs a single customer will take a look
                    if(num_game_bought >= 2){
                        break;
                        // k = shelf.size();
                    }
                    prob_buying = Utility.getRandomNumber(1, 101);
                    if(shelf.get(k).inventory == 0){ //in case a user wants to buy a game from a empty shelf, do nothing and move to the next shelf.
                        // System.out.println("Empty shelf");
                    }
                    else if(prob_buying <= 20-decreaser){ 
                        switch(shelf.get(k).game_name){
                            case "Monopoly":
                                if(prob_buying <= 20){  //prob_buying is already from 1 to 20
                                    Games monopoly = new TokenDecorator(shelf.get(k));
                                    addOn_price += monopoly.price;
                                    System.out.println("PRICE ISSSSS: "+addOn_price);
                                }
                                break;
                            case "Magic":
                            case "Pokémon":
                            case "Netrunner":
                                if(prob_buying <= 4){  //prob_buying is already from 1 to 20, 4 = 20%
                                    new SpecialCardDecorator(shelf.get(k));
                                }
                                break;
                            default:
                                System.out.println("No games added");

                        }
                        System.out.println(employee_name + " sold a " + shelf.get(k).game_name + " to customer " + i + " for $" + shelf.get(k).price + addOn_price);
                        shelf.get(k).inventory--; 
                        reg.balance+= shelf.get(k).price;
                        num_game_bought++;
                        shelf.get(k).units_sold++;
                        bought_game = true;
                    }
                    decreaser = decreaser + 2;
                }
                if(bought_game == false){
                    System.out.println("Customer " + i + " did not buy any game.");
                }
        }
        System.out.println();
    }
    

    /**
    Order function orders new games if the inventory is empty for that game type
     */
    public void Order(List<Games> shelf, Register reg){
        for (int i = 0; i < shelf.size(); i++){ //for every game in the store
            if (shelf.get(i).inventory == 0){ //if the inventory is empty
                System.out.println(employee_name + " bought 3 " + shelf.get(i).game_name + " games for the store.");
                shelf.get(i).games_arrival = 3; //let the program know that there is an order for this game type arriving in the morning.
                reg.balance -= (shelf.get(i).price/2)*3; //charge the store half price for the game
            }
        }
        System.out.println();
    }


/**
Close Function anounces the store is closing
This is an example of a COHESION as this method has one clearly defined purpose
 */
    public void Close(){
        System.out.println(employee_name + " the cashier is leaving and the store is closed.");
    }
}