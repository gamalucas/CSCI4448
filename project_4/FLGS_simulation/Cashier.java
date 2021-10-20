/**
 * Class cashier is dedicated to the functions of the Cashier of the day
 */
import java.util.*;
public class Cashier extends Employee implements Subject{

    String employee_name = "";
    protected StackBehaviour stackBehaviour;
    private List<Observer> observers_list = new ArrayList(); 
    String announcement;
    private List<Take_Command> command_list = new ArrayList<Take_Command>(); 
    

    //Constructor to initialize employee's name
    public Cashier(String name, StackBehaviour stackBehaviour){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
        this.stackBehaviour = stackBehaviour;
    }

    /*
    The following 3 methos ara an exmaple of OBSERVER pattern. 
    */
    public void registerObserver(Observer o){
        observers_list.add(o);
    }

    @Override
    public void removeObserver() {
        observers_list.clear();
    }

    public void notifyObservers(String announcement){
        observers_list.forEach(o -> o.update(announcement));
    }
    
    public void add_command_list(Take_Command command){
        command_list.add(command);		
    }

    public void run_command(String game_name, String cus_name){
        for (Take_Command command : command_list) {
            command.execute_command(game_name, cus_name);
        }
        command_list.clear();
    }

    /**
    Arrive anounces the arrival of an employee and aknowledges the arrival of new games
     */
    public void Arrive(int days, List<Games> shelf){
        announcement = (employee_name + " the cashier has arrived.");
        notifyObservers(announcement);
        for (int i = 0; i < shelf.size(); i++){
            if(shelf.get(i).games_arrival > 0){
                announcement = ("Three " + shelf.get(i).game_name + " games arrived at the store");
                notifyObservers(announcement);
                shelf.get(i).inventory += 3;
                shelf.get(i).games_arrival = 0;
            }
        }
    }

    
    /**
    Count is resposible for counting the money in the register and adding more if the balance is bellow 100. As well as keeping track of how many times money was added.
     */
    public void Count(Register reg){
        announcement = ("Good morning! The amount on the cash register is $" + reg.balance);
        notifyObservers(announcement);
        if (reg.balance < 100){
            reg.balance = 1000;
            reg.times_added++;
            announcement = ("Money was added to the cash register! The balance is now $" + reg.balance);
            notifyObservers(announcement);
        }
    }

    /**
     * Handles all the logic for damaging games in vacuum for each emplyee and the cookie mosnter
     * @param shelf
     * @param DamageContainer
     * @param its_cookie_monster
     */
    public void DamageGames(List<Games> shelf, Map<String, Integer> DamageContainer, boolean its_cookie_monster){
        int count = 0;
        int demagePossibility = Utility.getRandomNumber(0, 101); // generate a random number that will reflect in the probability of a employee to break a game while vacumming the store
        int brokenGame = 0;
        brokenGame = Utility.getRandomNumber(0, 12); //generate a random number from 1 to 12 (because there are 12 fixed game titles). The selected number will represent which game to remove
        if(employee_name == "Burt" & demagePossibility >= 0 & demagePossibility <= 10){ //logic for Burt
                while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                    if(brokenGame == 11){ 
                        brokenGame = 0;
                    }
                    else{
                        brokenGame++;
                    }
                }
            shelf.get(brokenGame).inventory--; //subtract broken game from inventory
            count = DamageContainer.get(shelf.get(brokenGame).game_name); //number of damaged games
            DamageContainer.put(shelf.get(brokenGame).game_name, count++); // adds broken game to the demaged container
            announcement = ("The game " +  shelf.get(brokenGame).game_name + " is damaged and placed on the Damaged Game Container");
            notifyObservers(announcement);
        }
        else if(employee_name == "Ernie" & demagePossibility >= 0 & demagePossibility <= 5){ //logic for Ernie
            while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                if(brokenGame == 11){ 
                    brokenGame = 0;
                }
                else{
                    brokenGame++;
                }
            }
            shelf.get(brokenGame).inventory--; //subtract broken game from inventory
            count = DamageContainer.get(shelf.get(brokenGame).game_name); //get the current number of a specific broken games
            DamageContainer.put(shelf.get(brokenGame).game_name, (count+1)); //add broken game to broken container
            announcement = ("The game " +  shelf.get(brokenGame).game_name + " is damaged and placed on the Damaged Game Container");
            notifyObservers(announcement);
        }
        else if(employee_name == "Bart" & demagePossibility >= 0 & demagePossibility <= 2){ //logic ofr Bart
            while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                if(brokenGame == 11){ 
                    brokenGame = 0;
                }
                else{
                    brokenGame++;
                }
            }
            shelf.get(brokenGame).inventory--; //subtract broken game from inventory
            count = DamageContainer.get(shelf.get(brokenGame).game_name); //get the current number of a specific broken games
            DamageContainer.put(shelf.get(brokenGame).game_name, (count+1)); //add broken game to broken container
            announcement = ("The game " +  shelf.get(brokenGame).game_name + " is damaged and placed on the Damaged Game Container");
            notifyObservers(announcement);
        }
        else if(its_cookie_monster == true){ // logic for the cookie monster
            demagePossibility = Utility.getRandomNumber(1, 7);
            for (int i = 0; i < demagePossibility; i++){
                while(shelf.get(brokenGame).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                    if(brokenGame == 11){ 
                        brokenGame = 0;
                    }
                    else{
                        brokenGame++;
                    }
                }
                shelf.get(brokenGame).inventory--;
                count = DamageContainer.get(shelf.get(brokenGame).game_name); //get the current number of a specific broken games
                DamageContainer.put(shelf.get(brokenGame).game_name, (count+1)); //add broken game to broken container
                announcement = ("The game " +  shelf.get(brokenGame).game_name + " was damaged by the cookie monster and placed on the Damaged Game Container");
                notifyObservers(announcement);
            }
        }
    }

    /*
    Vacuum function controls employees behaviour when they are vacuumin the store. It generates the probability of a game being broken by the employee.  When broken, this function removes the game from the inventory and place it on the damage container.
    */
    public void Vacuum(List<Games> shelf, Map<String, Integer> DamageContainer){
        announcement = (employee_name + " is vacuuming the store ");
        notifyObservers(announcement);
        DamageGames(shelf, DamageContainer, false);
        System.out.println();
    }

    
    /**
    * Calls for the right stack based on the cachier of the day. Part of the implementation of the STRATEGY Pattern.
    */
    public void performStack(List<Games> shelf){
        stackBehaviour.stack(shelf);// calls stack with the cachier of the day's stack strategy
        for (int i = 0; i < shelf.size(); i++){
            announcement = (employee_name + " stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
            notifyObservers(announcement);
        }
    }

    /* 
    The Open function is one of the most important functios of the program. It handdles all customer behaviour on the story, including buying a game. It also exists to keep in track of key variables, such as total amount on register, total games sold, etc. 
    */
    public void Open(List<Games> shelf, Register reg, Cookies cookie, Map<String, Integer> DamageContainer, int days, Demonstrator demonstrator){
        announcement = (employee_name + " opened the store. Welcome!");
        notifyObservers(announcement);

        Demonstrate_Command demonstrate = new Demonstrate_Command(demonstrator);
        Recommend_Command recommend = new Recommend_Command(demonstrator);
        Explain_Command explain = new Explain_Command(demonstrator);
        
        announcement = (demonstrator.employee_name + " the demonstrator arrived at the store!");
        notifyObservers(announcement);


        int prob_buying = 0; //this variable holds the probability of a customer buying a game
        int prob_buying_cookie = 0;
        int decreaser = 0; //this is a helper variable, it exists to decrease the probility of a game being bought everytime a customer moves to another shelf.
        int num_game_bought = 0; //this variable will hold how many games a customer bought per day. It exists to avoid a customer buying more than 2 games
        boolean bought_game = false; //variable to check if a customer have bought any game
        boolean its_cookie_monster = false;
        int bought_cookies = 0;
        int prob_add_on = 0;
        int cookies_tracker_day = 0;
        int prob_customer_appear = 0; //this variable will hold the probability of a customer to appear on store
        List<Customers> todays_customers_list = new ArrayList();
        int prob_bonus_type = 0; //this variable will hold the probability increase of a customer buying a game of its type (ex: Board gamer buying a board game) 
        int prob_asking_demonstrator = 0; //this variable will hold the probability of a customer asking the Demonstrator to perform task
        int command_requests = 0;//this variable will hold how many times a customer is asking a demonstrator to perform an action.
        int demonstrator_used = 0; //this variable will hold  the percentage increase in the probability of a customer buying a game (in case Demonstrator was used) 
        int game_type_num = 0; //this variable will help us to keep in track of which game the customer is being presented by the Demonstrator

        //create customers - Applying FACTORY Pattern
        prob_customer_appear = Utility.getRandomNumber(1, 101);
        if(prob_customer_appear <= 35){ //chance of a Family Gamer appear is of 35%
            Customers_Creator_abs create_customer_family = new Customer_Creator();
            Customers family_gamer = create_customer_family.create_customer("Family_Gamer");
            todays_customers_list.add(family_gamer);
        }
        prob_customer_appear = Utility.getRandomNumber(1, 101);
        if(prob_customer_appear <= 25){ //chance of a Family Gamer appear is of 25%
            Customers_Creator_abs create_customer_kid = new Customer_Creator();
            Customers kid_gamer = create_customer_kid.create_customer("Kid_Gamer");
            todays_customers_list.add(kid_gamer);
        }
        prob_customer_appear = Utility.getRandomNumber(1, 101);
        if(prob_customer_appear <= 75){ //chance of a Card Gamer appear is of 75%
            Customers_Creator_abs create_customer_card = new Customer_Creator();
            Customers card_gamer = create_customer_card.create_customer("Card_Gamer");
            todays_customers_list.add(card_gamer);
        }
        prob_customer_appear = Utility.getRandomNumber(1, 101);
        if(prob_customer_appear <= 60){ //chance of a Board Gamer appear is of 60%
            Customers_Creator_abs create_customer_board = new Customer_Creator();
            Customers board_gamer = create_customer_board.create_customer("Board_Gamer");
            todays_customers_list.add(board_gamer);
        }

        prob_customer_appear = Utility.getRandomNumber(1, 101);
        if(prob_customer_appear <= 2){ //chance of a Cookie Monster appear is of 22%
            Customers_Creator_abs create_customer_monster = new Customer_Creator();
            Customers cookie_monster = create_customer_monster.create_customer("Cookie_Monster");
            todays_customers_list.add(cookie_monster);
            its_cookie_monster = true;
        }

        announcement = (todays_customers_list.size() + " customer are in store today!");
        notifyObservers(announcement);

        for (int i = 0; i < todays_customers_list.size(); i++){ //loop throught all customer and perform their operations each one per time
            if(its_cookie_monster == true && cookie.cookies_in_store == 0){ //check is the customer is a cookie monster and if there are no cookies at the store
                announcement = (employee_name + " said that a cookie monster sadly left the store because there are no cookies.");
                notifyObservers(announcement);
                its_cookie_monster = false;
            }
            //re-set all needed variables for the next custonmer
            num_game_bought = 0;
            decreaser = 0;
            prob_bonus_type = 0;
            bought_game = false;
            command_requests = 0;
            demonstrator_used = 0;

            prob_buying_cookie = Utility.getRandomNumber(1, 101);
            if(its_cookie_monster == true){ // if it is the cookie monster
                announcement = (employee_name + " said that a cookie monster visited the store. Oh no!");
                notifyObservers(announcement);
                cookie.cookies_stolen += cookie.cookies_in_store;
                cookie.cookies_in_store = 0;
                DamageGames(shelf, DamageContainer, true);
                its_cookie_monster = false;
            }
            else{ // no cookie mosnter
                //check if customer wants to invoke the demonstrator or leave store
                prob_asking_demonstrator = Utility.getRandomNumber(1, 101); //generate prob of customer enter the store without issuing a Command Request
                if(prob_asking_demonstrator <= 25){ 
                    //if true, don't make further usage of Demonstrator
                }
                else{
                    prob_asking_demonstrator = Utility.getRandomNumber(1, 101); //generate prob of involking the demonstrator 
                    game_type_num = Utility.getRandomNumber(1, 4);
                    if(prob_asking_demonstrator <= 25 && command_requests <= 3){ //if true, customer will ask Demonstrator to demonstrate a game
                        for(int l = 0; l < shelf.size(); l++){ //get a game to be demonstrated 
                            if(shelf.get(l).game_type  == todays_customers_list.get(i).type && shelf.get(l).inventory != 0 && game_type_num == 1){
                                add_command_list(demonstrate);
                                run_command(shelf.get(l).game_name, todays_customers_list.get(i).name);
                                demonstrator_used = 10;
                                command_requests++;
                                break;
                            }
                            else if(shelf.get(l).game_type == todays_customers_list.get(i).type && shelf.get(l).inventory != 0 && game_type_num != 1){
                                game_type_num--;
                            }
                        }
                    }
                    prob_asking_demonstrator = Utility.getRandomNumber(1, 101); //generate prob of involking the demonstrator 
                    if(prob_asking_demonstrator <= 30 && command_requests <= 3){ //if true, customer will ask Demonstrator to recommend a game
                        for(int l = 0; l < shelf.size(); l++){ //get a game to be demonstrated 
                            if(shelf.get(l).game_type  == todays_customers_list.get(i).type && shelf.get(l).inventory != 0){
                                add_command_list(recommend);
                                run_command(shelf.get(l).game_name, todays_customers_list.get(i).name);
                                demonstrator_used = 10;
                                command_requests++;
                                break;
                            }
                        }
                    }
                    prob_asking_demonstrator = Utility.getRandomNumber(1, 101); //generate prob of involking the demonstrator 
                    if(prob_asking_demonstrator <= 20 && command_requests <= 3){ //if true, customer will ask Demonstrator to recommend a game
                        for(int l = 0; l < shelf.size(); l++){ //get a game to be demonstrated 
                            if(shelf.get(l).game_type  == todays_customers_list.get(i).type && shelf.get(l).inventory != 0){
                                add_command_list(explain);
                                run_command(shelf.get(l).game_name, todays_customers_list.get(i).name);
                                demonstrator_used = 10;
                                command_requests++;
                                break;
                            }
                        }
                    }
                }
                
                if(prob_buying_cookie >= 50){ //prob bigger than 50 means that customer will buy a cookie
                    prob_buying_cookie = Utility.getRandomNumber(1, 4); //calculate how many cookies customer will buy
                    if(prob_buying_cookie <= cookie.cookies_in_store){
                        cookie.cookies_in_store -= prob_buying_cookie;
                        reg.balance += cookie.price * prob_buying_cookie;
                        bought_cookies = 20; // increse the chance by 20%
                        announcement = (employee_name + " sold " + prob_buying_cookie + " cookies today");
                        cookies_tracker_day += prob_buying_cookie;
                        notifyObservers(announcement);
                    }
                    else if(cookie.cookies_in_store <= 0){ // if there are no cookies in the store decrease the chance by 10% 
                        bought_cookies = -10;
                    }
                    else{
                        reg.balance += cookie.price * cookie.cookies_in_store;
                        bought_cookies = 20;
                        announcement = (employee_name + " sold " + cookie.cookies_in_store + " cookies today");
                        notifyObservers(announcement);
                        cookies_tracker_day += cookie.cookies_in_store;
                        cookie.cookies_in_store = 0;
                    }
                }
                for(int k = 0; k < shelf.size(); k++){ //loop throught all shelfs a single customer will take a look
                    prob_bonus_type = 0;
                    if(num_game_bought >= 2){
                        break;
                    }

                    

                    prob_buying = Utility.getRandomNumber(1, 101); 
                    if(shelf.get(k).game_type == todays_customers_list.get(i).type && shelf.get(k).inventory != 0){ //check if the game placed on the shelf that the customer is looking at is of same type. That check exists so we can later increase the probability of a customer buying a game of same type 
                        if(shelf.get(k).game_name == todays_customers_list.get(i).game0){ //game0, game10, and game20 are randomly assigned in the Custonmer class
                            prob_bonus_type = 0; //games pre-registered as game0 will have 0% of increase to the total probability of buying a game
                        }
                        else if(shelf.get(k).game_name == todays_customers_list.get(i).game10){
                            prob_bonus_type = 10; //games pre-registered as game10 will have 10% of increase to the total probability of buying a game
                        }
                        else{
                            prob_bonus_type = 20; //games pre-registered as game20 will have 20% of increase to the total probability of buying a game
                        }
                    }
                    if(shelf.get(k).inventory == 0){ //in case a user wants to buy a game from a empty shelf, do nothing and move to the next shelf.
                        // System.out.println("Empty shelf");
                    }
                    else if(prob_buying <= ((20-decreaser) + bought_cookies + prob_bonus_type + demonstrator_used)){ 
                        prob_add_on = Utility.getRandomNumber(1, 101); //calculate the probability of buying a add on
                        switch(shelf.get(k).game_name){
                            case "Monopoly":
                                if(prob_add_on <= 50){  
                                    Games temp = shelf.get(k); //temp obj to store add on's value
                                    temp = new TokenDecorator(temp); //call decorator
                                    reg.balance += shelf.get(k).price + shelf.get(k).add_on_price; // increase price sale (game price + add on)
                                    shelf.get(k).add_on_price = 0.0; //set add on price to zero for future use
                                }
                                else{ //if no add ons were added, add only game price here
                                    reg.balance += shelf.get(k).price;
                                }
                                break;
    
                            case "Magic":
                            case "Pokémon":
                            case "Netrunner":
                                if(prob_add_on <= 20){
                                    Games temp = shelf.get(k);
                                    temp = new SpecialCardDecorator(temp);
                                    reg.balance += shelf.get(k).price + shelf.get(k).add_on_price; // increase price sale (game price + add on)
                                    shelf.get(k).add_on_price = 0.0; //set add on price to zero for future use
                                }
                                else{ //if no add ons were added, add only game price here
                                    reg.balance += shelf.get(k).price;
                                }
                                break;
    
                            case "Mousetrap":
                                if(prob_add_on <= 30){  
                                    Games temp = shelf.get(k); //temp obj to store add on's value
                                    temp = new SparePartDecorator(temp); //call decorator
                                    reg.balance += shelf.get(k).price + shelf.get(k).add_on_price; // increase price sale (game price + add on)
                                    shelf.get(k).add_on_price = 0.0; //set add on price to zero for future use
                                }
                                else{ //if no add ons were added, add only game price here
                                    reg.balance += shelf.get(k).price;
                                }
                                break;
    
                            case "Gloomhaven":
                                if(prob_add_on <= 20){  
                                    Games temp = shelf.get(k); //temp obj to store add on's value
                                    temp = new MiniaturesDecorator(temp); //call decorator
                                    reg.balance += shelf.get(k).price + shelf.get(k).add_on_price; // increase price sale (game price + add on)
                                    shelf.get(k).add_on_price = 0.0; //set add on price to zero for future use
                                }
                                else{ //if no add ons were added, add only game price here
                                    reg.balance += shelf.get(k).price;
                                }
                                break;
    
                            default:
                                reg.balance+= shelf.get(k).price;
                        }
                        announcement = (employee_name + " sold a " + shelf.get(k).game_name + " to " + todays_customers_list.get(i).name + " for $" + shelf.get(k).price);
                        notifyObservers(announcement);
                        shelf.get(k).inventory--; 
                        num_game_bought++;
                        shelf.get(k).units_sold++;
                        bought_game = true;
                    }
                    decreaser = decreaser + 2;
                }
                if(bought_game == false){
                    announcement = ("Customer " + i + " (" + todays_customers_list.get(i).name + ") did not buy any game.");
                    notifyObservers(announcement);
                }
            }
        }
        todays_customers_list.clear(); //clear list after one day
        cookie.cookie_tracker[days] = cookies_tracker_day;
        announcement = (demonstrator.employee_name + " the demonstrator is leaving the store!");
        notifyObservers(announcement);
        System.out.println();
    }
    

    /**
    Order function orders new games if the inventory is empty for that game type
     */
    public void Order(List<Games> shelf, Register reg, Cookies cookie){
        for (int i = 0; i < shelf.size(); i++){ //for every game in the store
            if (shelf.get(i).inventory == 0){ //if the inventory is empty
                announcement = (employee_name + " bought 3 " + shelf.get(i).game_name + " games for the store.");
                notifyObservers(announcement);
                shelf.get(i).games_arrival = 3; //let the program know that there is an order for this game type arriving in the morning.
                reg.balance -= (shelf.get(i).price/2)*3; //charge the store half price for the game
            }
        }
        //Logic to order more cookies
        if(cookie.cookies_in_store == 0){
            cookie.cookies_package_order += 1;
        }
        else if(cookie.cookies_in_store > 0){
            if(cookie.cookies_package_order > 1){
                cookie.cookies_package_order -= 1;
            }
        }
        System.out.println();
    }


/**
Close Function anounces the store is closing
This is an example of a COHESION as this method has one clearly defined purpose
 */
    public void Close(){
        announcement = (employee_name + " the cashier is leaving the store.");
        notifyObservers(announcement);
        removeObserver();
    }
}