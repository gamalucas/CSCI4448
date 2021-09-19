import java.util.ArrayList;
import java.util.Arrays;

class Family extends Games{
    
    public Family(double price, double height, double width, double lenght, int inventory, int units_sold, Integer[] shelf_position, String game_name){
        this.price = price;
        this.height = height;
        this.width = width;
        this.lenght = lenght;
        this.inventory = inventory;
        this.units_sold = units_sold;
        this.shelf_position = Arrays.asList(shelf_position);
        this.game_name = game_name;
    }
    public void msg(){
        System.out.println("Hello");

    }
}
