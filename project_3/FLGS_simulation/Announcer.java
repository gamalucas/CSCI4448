import java.util.*;

public class Announcer extends Employee implements Observer{
    String employee_name = "";
    private String announcement;


    public Announcer(String name, Subject cashier, Subject baker){ //This is an example of ENCAPSULATION
        set_employee_name(name);
        employee_name = get_employee_name();
        cashier.registerObserver(this);
        baker.registerObserver(this);
    }

    public void arrive(int day){
        System.out.println(employee_name + " arrived on day " + day);
    }

    public void announce(){
        System.out.println("Guy says: " + announcement);
    }

    public void close(){
        System.out.println(employee_name + " is leaving the store.");
    }

    public void update(String announcement){
        this.announcement = announcement;
        announce();
    }

}
