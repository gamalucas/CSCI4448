/**
 * Class is dedicated to the functions of the Baker
 */

import java.util.*;

public class Baker extends Employee implements Subject{
    String employee_name = "";
    double baker_register = 0.0;
    private List<Observer> observers_list = new ArrayList(); 
    String announcement;

    //Constructor to initialize employee's name
    public Baker(String name, double baker_register){
        set_employee_name(name);
        this.baker_register = baker_register;
        employee_name = get_employee_name();
    }

    /*
        The following 3 methos ara an exmaple of OBSERVER pattern. 
    */
    public void registerObserver(Observer o){
        observers_list.add(o);
    }

    @Override
    public void removeObserver() {
        observers_list.clear();
    }

    public void notifyObservers(String announcement){
        observers_list.forEach(o -> o.update(announcement));
    }

    /**
     * responsible for dropping off the cookies at the store every day
     * @param cookies
     * @param reg
     */
    public void cookie_drop_off(Cookies cookies, Register reg){
        announcement = ("Gonger the baker has arrived a the store");
        notifyObservers(announcement);
        int qnt_cookie_deliver = 12 * cookies.cookies_package_order;
        cookies.cookies_in_store = qnt_cookie_deliver;

        double amount_due = (qnt_cookie_deliver * cookies.price)/2;
        reg.balance -= amount_due;
        baker_register += amount_due;
        announcement = (employee_name + " droped off " + cookies.cookies_package_order + " cookie packeges.");
        notifyObservers(announcement);
        announcement = (employee_name + " received $" + amount_due);
        notifyObservers(announcement);
        announcement = (employee_name + " is leaving the store for today.");
        notifyObservers(announcement);
        removeObserver();
    }
    
}
