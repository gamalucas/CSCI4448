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
    Family Monopoly = new Family(42.00,10.00,2.00,16.00,3,0,0,"Monopoly",0);
    Family Clue = new Family(52.00,15.00,5.00,20.00,3,0,0,"Clue",0);
    Family Life = new Family(33.00,8.00,3.00,9.00,3,0,0,"Life",0);



    public Store(){
        shelf.add(Monopoly);
        shelf.add(Clue);
        shelf.add(Life);
        DamageContainer.put("Monopoly", 0);
        DamageContainer.put("Clue", 0);
        DamageContainer.put("Life", 0);
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
        empDay.Arrive(days);  
        empDay.Count(register);
        empDay.Vacuum(shelf, DamageContainer);
        empDay.Stack(shelf);
        
    }
    public static void main(String args[]){
        Store FLGS = new Store();
        FLGS.start_day();
    }
}