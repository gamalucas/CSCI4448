public class Register {
    
    double balance;
    int times_added;

    public Register(){
        balance = 0;
        times_added = 0;
    }

    //methods
    public double get_balance(){
        return balance;
    }

    public int get_times_added(){
        return times_added;
    }

    public void set_balance(){
        this.balance =  balance;
    }

    public void set_times_added(){
        this.times_added = times_added;
    }
}
