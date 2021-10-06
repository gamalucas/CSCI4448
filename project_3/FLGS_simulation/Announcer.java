/*
    This class is an exmaple of OBSERVER pattern. 
    It subscribes from other classes and prints out messages
*/

import java.util.*;

public class Announcer extends Employee implements Observer{
    String employee_name = "";
    private String announcement;


    public Announcer(String name, Subject cashier, Subject baker){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
        cashier.registerObserver(this); //register the cashier of the day as an observer
        baker.registerObserver(this); //registers the baker as an observer
    }

    public void arrive(int day){ // Guys arrival
        System.out.println(employee_name + " arrived on day " + day);
    }

    public void announce(){ //prints whatver message is passed to it to the terminal
        System.out.println("Guy says: " + announcement);
    }

    public void close(){ // Guys exit
        System.out.println(employee_name + " is leaving the store.");
    }

    public void update(String announcement){
        this.announcement = announcement;
        announce();
    }

}
