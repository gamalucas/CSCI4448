import java.util.*;  
// import java.util.concurrent.ThreadLocalRandom;

class Store{
    // Initializes the objects of the store
    
    static List<Games> shelf = new ArrayList(); //The list shelf is an example of emcapsulation because all data stored in this class is protected and, therefore, can only be accesses by the methosd get() and/or set()
    Map<String, Integer> DamageContainer = new HashMap<String, Integer>(); //damaged container
    int days;
    StackBehaviour stackByHeight = new StackByHeight();
    StackBehaviour stackByWidthDec = new StackByWidthDec();
    StackBehaviour stackByBart = new StackByBart();
    //initializes employees
    Cashier Burt = new Cashier("Burt", stackByWidthDec); // The creation of "Burt" is a unique identifier and this is an example of IDENTITY
    Cashier Ernie = new Cashier("Ernie", stackByHeight);
    Cashier Bart = new Cashier("Bart", stackByBart);
    Cashier empDay;
    Baker Gonger = new Baker("Gonger", 0.0);
    Announcer_Lazy Lazy_Guy;
    Announcer_Eager Eager_Guy;
    int rand_announcer = Utility.getRandomNumber(1, 3);
    boolean robbed = false;
    boolean just_robbed = false;
    int rob_prob;
    static int count_names = 0; //variable to keep in track of how many times we are calling nameSelector and also to help us move through the circular list

    Cookies cookies = new Cookies();
    Register register = new Register(); //register
    static CircularLinkedList name_list = new CircularLinkedList();

    Demonstrator demonstrator;

    
    //games
    Games monopoly = new Monopoly(42.00,10.00,2.00,16.00,3,0,0,"Monopoly",0,0, "Family", 0.0); //This is an example of POLYMORPHISM
    Games clue = new Clue(52.00,15.00,5.00,20.00,3,0,0,"Clue",0,0, "Family", 0.0);
    Games life = new Life(33.00,8.00,3.00,9.00,3,0,0,"Life",0,0, "Family", 0.0);
    Games mousetrap = new Mousetrap(50.00,12.00,4.00,10.00,3,0,0,"Mousetrap",0,0, "Kids", 0.0);
    Games candyland = new Candyland(22.00,7.00,2.00,9.50,3,0,0,"Candyland",0,0, "Kids", 0.0);
    Games connect_Four = new Connect_Four(27.00,17.00,8.00,22.00,3,0,0,"Connect Four",0,0, "Kids", 0.0);
    Games magic = new Magic(5.00,2.00,1.00,2.00,3,0,0,"Magic",0,0, "Card", 0.0);
    Games pokemon = new Pokemon(125.99,1.00,2.00,2.00,3,0,0,"Pok??mon",0,0, "Card", 0.0);
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
        DamageContainer.put("Pok??mon", 0);
        DamageContainer.put("Netrunner", 0);
        DamageContainer.put("Catan", 0);
        DamageContainer.put("Risk", 0);
        DamageContainer.put("Gloomhaven", 0);
        name_list.CreateCircularLinkedList(name_list);
        days = 0;
        demonstrator = new Demonstrator();

        if(rand_announcer ==1){
            Lazy_Guy = Announcer_Lazy.get_instance("Guy", Gonger, demonstrator); // this is an example of Lazy Instatiation - SINGLETON Pattern
        }
        else{
            Eager_Guy = Announcer_Eager.get_instance();
            Eager_Guy.Announcer_set("Guy", Gonger, demonstrator); // this is an example of Eager Instatiation - SINGLETON Pattern
        }
    }

    static public String find_name(){
        String name = name_list.nameSelector(count_names);
        count_names++;
        return name;
    }

    //implements procedure if store is robbed
    public void robbed(){
        System.out.println("Oh no! The store was robbed. They took all of games, money and cookies!");
        robbed = true;
        register.balance = 0;
        cookies.cookies_in_store = 0;
        just_robbed = true;
        //set all games inventory to zero (this simulates that all the games have been robbed)
        for (int i = 0; i < shelf.size(); i++){
            shelf.get(i).inventory = 0;
        }
    }

    public void restock(){
        System.out.println("Day: " + (days + 1) + ". Insurance is paing for the robbed games, money and cookies. The inventory for each game is now 3, money was set to $1000 and cookies to 12. The store is closed while we repair it!");
        //set all games inventory to 3 (this simulates that the insurance have returned all the games)
        for (int i = 0; i < shelf.size(); i++){
            shelf.get(i).inventory = 3;
        }
        cookies.cookies_in_store = 12;
        register.balance = 1000.00;
    }


    /*
    start_day function will initialize the program and call all needed functions inside Cashier.java. It also makes the selection of the employee that will be working on the given day.
    */
    public void start_day(){
        if(just_robbed == false){
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
            if(rand_announcer ==1){
                Lazy_Guy.Emp_set(empDay);
                Lazy_Guy.arrive(days);
            }
            else{
                Eager_Guy.Emp_set(empDay);
                Eager_Guy.arrive(days);
            }
            empDay.Arrive(days, shelf);
            empDay.Count(register);
            Gonger.cookie_drop_off(cookies, register);
            empDay.Vacuum(shelf, DamageContainer);
            empDay.performStack(shelf);
            empDay.Open(shelf, register, cookies, DamageContainer, days, demonstrator);
            demonstrator.finish_day();
            empDay.Order(shelf, register, cookies);
            empDay.Close();
            if(rand_announcer == 1){
                Lazy_Guy.close();
            }
            else{
                Eager_Guy.close();
            }
            if(robbed == false){
                rob_prob = Utility.getRandomNumber(1, 31);
                if (rob_prob == 1){
                    robbed();
                }
            }
        }
        else if(just_robbed == true){
            restock();
            just_robbed = false;
            days++;
        }
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
        for(int i = 1; i <= 30; i++){
            System.out.println("Day [" + (i) + "] " + cookies.cookie_tracker[i] + " cookies sold");
            sum += cookies.cookie_tracker[i];
        }  
        
        System.out.println("Total number of cookies sold: " + sum);

        System.out.println("The cookie moster stole: " + cookies.cookies_stolen);

        System.out.println("Total amount of money paid to Gonger: " + Gonger.baker_register);



        // name_list.traverseList();
    }
}