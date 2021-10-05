import java.util.*;
/**
Employee is a class responsible for keeping track of the attributes of the Employess
 */
abstract class Employee {
    private String employee_name; //This is an example of ENCAPSULATION
    
    public String get_employee_name(){ //This is an example of ENCAPSULATION
        return employee_name;
    }

    public void set_employee_name(String name){ //This is an example of ENCAPSULATION
        employee_name = name;
    }


    // public abstract void Arrive(int days, List<Games> shelf);

    // public abstract void Count(Register reg);

    // public abstract void Vacuum(List<Games> shelf, Map<String, Integer> DamageContainer);

    // public abstract void Stack(List<Games> shelf);

    // public abstract void Open(List<Games> shelf, Register reg);

    // public abstract void Order(List<Games> shelf, Register reg);

    // public abstract void Close();




}

