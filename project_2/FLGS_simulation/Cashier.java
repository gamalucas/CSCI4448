import java.util.*;  

public class Cashier extends Employee{

    public Cashier(String name){
        this.employee_name = name;
    }

    // public void test(int dayss){
    //     System.out.println(employee_name + " the cahsier has arrived at day " + dayss);
    // }
    
    public int getRandomNumber(int min, int max) { //https://www.baeldung.com/java-generating-random-numbers-in-range
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void Arrive(int days, List<Games> shelf){
        System.out.println(employee_name + " the cahsier has arrived at day " + days);
        for (int i = 0; i < shelf.size(); i++){
            if(shelf.get(i).games_arrival > 0){
                System.out.println("Three " + shelf.get(i).game_name + " games arrived at the store");
                shelf.get(i).inventory += 3;
            }
        }
        
    }

    public void Count(Register reg){
        System.out.println("Good morning! The amount on the cash register is $" + reg.balance);
        if (reg.balance < 100){
            reg.balance = 1000;
        }
        System.out.println("Money was added to the chash register! The balance is now $" + reg.balance);
    }

    public void Vacuum(List<Games> shelf, Map<String, Integer> DamageContainer){
        System.out.println(employee_name + " is vacuuming the store ");
        int demagePossibility = getRandomNumber(0, 101);
        if(employee_name == "Burt" & demagePossibility >= 0 & demagePossibility <= 10){
            //generate a random number from 1 to 12 (because there are 12 fixed game titles). The selected number will represent which game to remove
            demagePossibility = getRandomNumber(0, 13); 
            while(shelf.get(demagePossibility).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                if(demagePossibility == 12){ 
                    demagePossibility = 0;
                }
                else{
                    demagePossibility++;
                }
            }
            shelf.get(demagePossibility).inventory--;
            int count = DamageContainer.get(shelf.get(demagePossibility).game_name);
            DamageContainer.put(shelf.get(demagePossibility).game_name, count++);
            System.out.println("The game " +  shelf.get(demagePossibility).game_name + " is damaged and placed on the Damaged Game Container");
        }
        else if(employee_name == "Ernie" & demagePossibility >= 0 & demagePossibility <= 5){
            //generate a random number from 1 to 12 (because there are 12 fixed game titles). The selected number will represent which game to remove
            demagePossibility = getRandomNumber(0, 13);
            while(shelf.get(demagePossibility).inventory == 0){ //check if the index game selected are still on inventory, if not, remove the next game on list
                if(demagePossibility == 12){
                    demagePossibility = 0;
                }
                else{
                    demagePossibility++;
                }
            }
            shelf.get(demagePossibility).inventory--;
            int count = DamageContainer.get(shelf.get(demagePossibility).game_name);
            DamageContainer.put(shelf.get(demagePossibility).game_name, count++);
            System.out.println("The game " +  shelf.get(demagePossibility).game_name + " is damaged and placed on the Damaged Game Container");
        }

    }

    public void Stack(List<Games> shelf){
        if(employee_name == "Ernie"){
            for (int i = 0; i < shelf.size(); i++){
                shelf.get(i).pile_height = shelf.get(i).height * shelf.get(i).inventory;
            } 
            Comparator<Games> compareByPH = (Games o1, Games o2) -> o1.pile_height.compareTo( o2.pile_height );
            Collections.sort(shelf, compareByPH);   
            for (int i = 0; i < shelf.size(); i++){
                System.out.println("Ernie stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Pile height is: " + shelf.get(i).pile_height + "\"");
            }
        }
        else if(employee_name == "Burt"){
            Comparator<Games> compareByWidth = (Games o1, Games o2) -> o1.width.compareTo( o2.width );
            Collections.sort(shelf, compareByWidth.reversed());  
            for (int i = 0; i < shelf.size(); i++){
                System.out.println("Burt stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
            }
        }
    }

    public void Open(List<Games> shelf, Register reg){
        System.out.println(employee_name + " opened the store. Welcome!");
        int num_costomers = getRandomNumber(0, 5);
        System.out.println(num_costomers + " customer are in store today!");
        int prob_buying = 0;
        int decreaser = 0;
        int num_game_bought = 0;
        int customer_num = 1;
        boolean bought_game = false;
        for (int i = 0; i <= num_costomers; i++){
            num_game_bought = 0;
            while(num_game_bought < 3 && customer_num <= num_costomers){
                decreaser = 0;
                bought_game = false;
                for(int k = 0; k < shelf.size(); k++){
                    prob_buying = getRandomNumber(0, 101);
                    if(shelf.get(i).inventory == 0){
                        // System.out.println("Empty shelf");
                    }
                    else if(prob_buying <= 20-decreaser){
                        System.out.println(employee_name + " sold a " + shelf.get(k).game_name + " to customer " + customer_num + " for $" + shelf.get(k).price);
                        shelf.get(k).inventory--;
                        reg.balance+= shelf.get(k).price;
                        num_game_bought++;
                        shelf.get(k).units_sold++;
                        bought_game = true;
                    }
                    decreaser = decreaser + 2;
                }
                if(bought_game == false){
                    System.out.println("Customer " + customer_num + " did not buy any game.");
                }
                customer_num++;
            }
        }
    }
    
    public void Order(List<Games> shelf, Register reg){
        for (int i = 0; i < shelf.size(); i++){
            if (shelf.get(i).inventory == 0){
                System.out.println(employee_name + " bought 3 " + shelf.get(i).game_name + " games for the store.");
                shelf.get(i).games_arrival = 3;
                reg.balance -= (shelf.get(i).price/2)*3;
                // System.out.println("cost: " + (shelf.get(i).price/2)*3);
            }
        }
    }

    public void Close(){
        System.out.println(employee_name + " the cashier is leaving and the store is closed.");
    }
}