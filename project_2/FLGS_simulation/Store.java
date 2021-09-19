import java.util.*;  
import java.util.concurrent.ThreadLocalRandom;

class Store{
    static List<String> shelf;
    String[] initial_list = {"positionZero","Monopoly","Monopoly","Monopoly","Clue", "Clue", "Clue", "Life","Life","Life"};
    Integer[] monopolyPosition = {1,2,3};
    Integer[] cluePosition = {4,5,6};
    Integer[] lifePosition = {7,8,9};

    public Store(){
        Family Monopoly = new Family(42.00,10.00,2.00,16.00,3,0,monopolyPosition,"Monopoly");
        Family Clue = new Family(52.00,15.00,5.00,20.00,3,0,cluePosition,"Clue");
        Family Life = new Family(33.00,8.00,3.00,9.00,3,0,lifePosition,"Life");
        shelf = Arrays.asList(initial_list);

        Cashier Burt = new Cashier();
        Cashier Ernie = new Cashier();
    }

    public boolean choose_employee(){
        return ThreadLocalRandom.current().nextBoolean();
    }

    public void start_day(){
        employeeOption = choose_employee();
    }
    public static void main(String args[]){
        Store FLGS = new Store();
    }
}