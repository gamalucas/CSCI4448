import java.util.*;  
// import java.util.concurrent.ThreadLocalRandom;

class Store{
    // Initializes the objects of the store
    
    static List<Games> shelf = new ArrayList(); //The list shelf is an example of emcapsulation because all data stored in this class is protected and, therefore, can only be accesses by the methosd get() and/or set()
    Map<String, Integer> DamageContainer = new HashMap<String, Integer>(); //damaged container
    int days;

    // Instantiates the 
    StackBehaviour stackByHeight = new StackByHeight(); //
    StackBehaviour stackByWidthDec = new StackByWidthDec();
    StackBehaviour stackByBart = new StackByBart();

    //initializes employees
    Cashier Burt = new Cashier("Burt", stackByWidthDec); // The creation of "Burt" is a unique identifier and this is an example of IDENTITY
    Cashier Ernie = new Cashier("Ernie", stackByHeight);
    Cashier Bart = new Cashier("Bart", stackByBart);
    Cashier empDay;
    Baker Gonger = new Baker("Gonger", 0.0);
    Announcer Guy;

    Cookies cookies = new Cookies();
    Register register = new Register(); //register
    
    //games
    Games monopoly = new Monopoly(42.00,10.00,2.00,16.00,3,0,0,"Monopoly",0,0, "Family", 0.0); //This is an example of POLYMORPHISM
    Games clue = new Clue(52.00,15.00,5.00,20.00,3,0,0,"Clue",0,0, "Family", 0.0);
    Games life = new Life(33.00,8.00,3.00,9.00,3,0,0,"Life",0,0, "Family", 0.0);
    Games mousetrap = new Mousetrap(50.00,12.00,4.00,10.00,3,0,0,"Mousetrap",0,0, "Kids", 0.0);
    Games candyland = new Candyland(22.00,7.00,2.00,9.50,3,0,0,"Candyland",0,0, "Kids", 0.0);
    Games connect_Four = new Connect_Four(27.00,17.00,8.00,22.00,3,0,0,"Connect Four",0,0, "Kids", 0.0);
    Games magic = new Magic(5.00,2.00,1.00,2.00,3,0,0,"Magic",0,0, "Card", 0.0);
    Games pokemon = new Pokemon(125.99,1.00,2.00,2.00,3,0,0,"Pokémon",0,0, "Card", 0.0);
    Games netrunner = new Netrunner(12.50,5.00,5.00,7.00,3,0,0,"Netrunner",0,0, "Card", 0.0);
    Games catan = new Catan(15.60,10.50,15.00,17.00,3,0,0,"Catan",0,0, "Board", 0.0);
    Games risk = new Risk(11.00,12.00,5.00,8.00,3,0,0,"Risk",0,0, "Board", 0.0);
    Games gloomhaven = new Gloomhaven(14.50,9.00,7.00,7.00,3,0,0,"Gloomhaven",0,0, "Board", 0.0);

    

    public Store(){
        //add all games Objects to the List shelf
        shelf.add(monopoly);
        shelf.add(clue);
        shelf.add(life);
        shelf.add(mousetrap);
        shelf.add(candyland);
        shelf.add(connect_Four);
        shelf.add(magic);
        shelf.add(pokemon);
        shelf.add(netrunner);
        shelf.add(catan);
        shelf.add(risk);
        shelf.add(gloomhaven);

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


    /*
    start_day function will initialize the program and call all needed functions inside Cashier.java. It also makes the selection of the employee that will be working on the given day.
    */
    public void start_day(){
        int employee_prob =  Utility.getRandomNumber(1, 4);
        days++;
        if(employee_prob == 1){
            empDay = Burt;
        }
        else if(employee_prob == 2){
            empDay = Ernie;
        }
        else{
            empDay = Bart;
        }
        Guy = new Announcer("Guy", empDay, Gonger);
        Guy.arrive(days);
        empDay.Arrive(days, shelf);
        empDay.Count(register);
        Gonger.cookie_drop_off(cookies, register);
        empDay.Vacuum(shelf, DamageContainer);
        empDay.performStack(shelf);
        empDay.Open(shelf, register, cookies, DamageContainer, days);
        empDay.Order(shelf, register, cookies);
        empDay.Close();
        Guy.close();
        
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

        System.out.println("List of cookies sold per day: ");
        int sum = 0;
        for(int i = 0; i < 30; i++){
            System.out.println("Day [" + (i+1) + "] " + cookies.cookie_tracker[i] + " cookies sold");
            sum += cookies.cookie_tracker[i];
        }  
        
        System.out.println("Total number of cookies sold: " + sum);

        System.out.println("The cookie moster stole: " + cookies.cookies_stolen);

        System.out.println("Total amount of money paid to Gonger: " + Gonger.baker_register);
    }
}