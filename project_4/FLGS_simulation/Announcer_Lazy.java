/*
    This class is an exmaple of OBSERVER pattern. 
    It subscribes from other classes and prints out messages
*/

import java.util.*;

public class Announcer_Lazy extends Employee implements Observer{
    int random = Utility.getRandomNumber(1,3);

    private static Announcer_Lazy lazy_announcer = null; // this is an example of Lazy Instantiation - SINGLETON Pattern
    String employee_name = "";
    private String announcement;


    private Announcer_Lazy(String name, Subject baker, Subject demonstrator){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
        baker.registerObserver(this); //registers the baker as an observer
        demonstrator.registerObserver(this); //registers the demonstrator as an observer
    }


    public static synchronized Announcer_Lazy get_instance(String name, Subject baker, Subject demonstrator){
        if(lazy_announcer == null){
            lazy_announcer = new Announcer_Lazy(name, baker, demonstrator);
        }
        return lazy_announcer;
    }

    public void Emp_set(Subject cashier){
        cashier.registerObserver(this); //register the cashier of the day as an observer
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
