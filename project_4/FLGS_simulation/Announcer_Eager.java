/*
    This class is an exmaple of OBSERVER pattern. 
    It subscribes from other classes and prints out messages
*/

import java.util.*;

public class Announcer_Eager extends Employee implements Observer{
    private static Announcer_Eager eager_announcer = new Announcer_Eager(); // this is an example of Eager Instatiation - SINGLETON Pattern
    String employee_name = "";
    private String announcement;

    private Announcer_Eager() {}


    public void Announcer_set(String name, Subject cashier, Subject baker){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
        cashier.registerObserver(this); //register the cashier of the day as an observer
        baker.registerObserver(this); //registers the baker as an observer
    }

    public static synchronized Announcer_Eager get_instance(){
        return eager_announcer;

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
