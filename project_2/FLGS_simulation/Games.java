abstract class Games{
    double price;
    double height;
    double width;
    double lenght;
    int inventory;
    int units_sold;
    int shelf_position;
    String game_name;

    // Constructor Declaration of Class
    public Games(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name){
        this.price = price;
        this.height = height;
        this.width = width;
        this.lenght = lenght;
        this.inventory = inventory;
        this.units_sold = units_sold;
        this.shelf_position = shelf_position;
        this.game_name = game_name;
    }

    //methods 
    public double get_price(){
        return price;
    }
    public double get_height(){
        return height;
    }
    public double get_width(){
        return width;
    }
    public double get_lenght(){
        return lenght;
    }
    public int get_inventory(){
        return inventory;
    }
    public int get_units_sold(){
        return units_sold;
    }
    public int gte_shelf_position(){
        return shelf_position;
    }
    public String get_game_name(){
        return game_name;
    }

    public void set_price(double price){
        this.price = price;
    }


    public static void main(String args[]){
        Family hello = new Family();
        hello.msg();
    }
}
