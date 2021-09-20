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

    public void Arrive(int days){
        System.out.println(employee_name + " the cahsier has arrived at day " + days);
        //test(days);
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
        int demagePossibility = getRandomNumber(0, 100);
        if(employee_name == "Burt" & demagePossibility >= 0 & demagePossibility <= 10){
            //generate a random number from 1 to 12 (because there are 12 fixed game titles). The selected number will represent which game to remove
            demagePossibility = getRandomNumber(0, 12);
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
            demagePossibility = getRandomNumber(0, 12);
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
        double[] phs = {0,0,0};
        double ph = 0;
        if(employee_name == "Ernie"){
            for (int i = 0; i < shelf.size(); i++){
                shelf.get(i).pile_height = shelf.get(i).height * shelf.get(i).inventory;
                phs[i] = shelf.get(i).pile_height;
            }
            System.out.println("HELLO " + shelf.get(0).pile_height);
        }
    }
}