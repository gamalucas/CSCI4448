import java.util.*;

public class Baker extends Employee{
    String employee_name = "";
    double baker_register = 0.0;
    double cookie_price = 0.0;

    //Constructor to initialize employee's name
    public Baker(String name, double baker_register, double cookie_price){
        set_employee_name(name);
        this.baker_register = baker_register;
        this.cookie_price = cookie_price;
        employee_name = get_employee_name();
    }

    public void cookie_drop_off(int cookies_on_store, Register reg, int cookies_package_order){
        int qnt_cookie_deliver = 12 * cookies_package_order;
        cookies_on_store = qnt_cookie_deliver;

        double amount_due = (qnt_cookie_deliver * cookie_price)/2;
        reg.balance -= amount_due;
        baker_register += amount_due;
    }
    
}
