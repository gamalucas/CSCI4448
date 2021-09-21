import java.util.*;  
import java.util.concurrent.ThreadLocalRandom;

class Store{
    static List<Games> shelf = new ArrayList();
    Map<String, Integer> DamageContainer = new HashMap<String, Integer>();
    int days;
    Cashier Burt = new Cashier("Burt");
    Cashier Ernie = new Cashier("Ernie");
    Cashier empDay = new Cashier("");
    Register register = new Register();
    Family Monopoly = new Family(42.00,10.00,2.00,16.00,3,0,0,"Monopoly",0,0);
    Family Clue = new Family(52.00,15.00,5.00,20.00,3,0,0,"Clue",0,0);
    Family Life = new Family(33.00,8.00,3.00,9.00,3,0,0,"Life",0,0);
    Kids Mousetrap = new Kids(50.00,12.00,4.00,10.00,3,0,0,"Mousetrap",0,0);
    Kids Candyland = new Kids(22.00,7.00,2.00,9.50,3,0,0,"Candyland",0,0);
    Kids Connect_Four = new Kids(27.00,17.00,8.00,22.00,3,0,0,"Connect Four",0,0);
    Card Magic = new Card(5.00,2.00,1.00,2.00,3,0,0,"Magic",0,0);
    Card Pokemon = new Card(125.99,1.00,2.00,2.00,3,0,0,"Pokémon",0,0);
    Card Netrunner = new Card(12.50,5.00,5.00,7.00,3,0,0,"Netrunner",0,0);
    Board Catan = new Board(15.60,10.50,15.00,17.00,3,0,0,"Catan",0,0);
    Board Risk = new Board(11.00,12.00,5.00,8.00,3,0,0,"Risk",0,0);
    Board Gloomhaven = new Board(14.50,9.00,7.00,7.00,3,0,0,"Gloomhaven",0,0);



    public Store(){
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

    public boolean choose_employee(){
        return ThreadLocalRandom.current().nextBoolean();
    }

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
    public static void main(String args[]){
        Store FLGS = new Store();
        FLGS.start_day();
    }
}