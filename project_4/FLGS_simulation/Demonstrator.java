import java.util.*;

public class Demonstrator extends Employee implements Subject{
    String employee_name = "";
    private List<Observer> observers_list = new ArrayList();
    String announcement;

    public Demonstrator(String name){
        name = give_name();
        set_employee_name(name);
        employee_name = get_employee_name();
    }

    public String give_name(){
        String name = Store.find_name();
        return name;
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

    public void demonstrate(String game_name, String cus_name){
        announcement = (employee_name + " is demonstrating " + game_name + " to " + cus_name);
        notifyObservers(announcement);
    }

    public void recommend(String game_name, String cus_name){
        announcement = (employee_name + " is recommending " + game_name + " to " + cus_name);
        notifyObservers(announcement);
    }

    public void explain(String game_name, String cus_name){
        announcement = (employee_name + " is explaning " + game_name + " to " + cus_name);
        notifyObservers(announcement);
    }
}

class Demonstrate_Command implements Take_Command{
    private Demonstrator demonstrator;
    public Demonstrate_Command(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }
    @Override
    public void execute_command(String game_name, String cus_name){
        demonstrator.demonstrate(game_name, cus_name);
    }
}

class Recommend_Command implements Take_Command{
    private Demonstrator demonstrator;
    public Recommend_Command(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }
    @Override
    public void execute_command(String game_name, String cus_name){
        demonstrator.recommend(game_name, cus_name);
    }
}

class Explain_Command implements Take_Command{
    private Demonstrator demonstrator;
    public Explain_Command(Demonstrator demonstrator){
        this.demonstrator = demonstrator;
    }
    @Override
    public void execute_command(String game_name, String cus_name){
        demonstrator.explain(game_name, cus_name);
    }
}