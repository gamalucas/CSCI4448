import java.util.List;

abstract class Games{
    double price;
    double height;
    Double width;
    double lenght;
    int inventory;
    int units_sold;
    int shelf_position;
    String game_name;
    Double pile_height;
    int games_arrival;


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
    // public int get_shelf_position(){
    //     return shelf_position;
    // }
    public String get_game_name(){
        return game_name;
    }

    public void set_price(double price){
        this.price = price;
    }

    public void set_height(double height){
        this.height = height;
    }

    public void set_width(double width){
        this.width = width;
    }

    public void set_lenght(double lenght){
        this.lenght = lenght;
    }

    public void set_inventory(int inventory){
        this.inventory = inventory;
    }

    public void set_units_sold(int units_sold){
        this.units_sold = units_sold;
    }

    // public void set_shelf_position(int shelf_position){
    //     this.shelf_position = shelf_position;
    // }

    public void set_game_name(String game_name){
        this.game_name = game_name;
    }

}
