/**
Kids is a class that inherits from Games and is responsible for keeping track of the attributes of the Kids games
This is an example of INHERITANCE   
 */

class Kids extends Games{
    
    public Kids(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type){
        this.price = price;
        this.height = height;
        this.width = width;
        this.lenght = lenght;
        this.inventory = inventory;
        this.units_sold = units_sold;
        this.shelf_position = shelf_position;
        this.game_name = game_name;
        this.pile_height = pile_height;
        this.games_arrival = games_arrival;
        this.game_type = game_type;
    }
}


class Mousetrap extends Kids{
    public Mousetrap(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type);       
    }
}

class Candyland extends Kids{
    public Candyland(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type);       
    }
}

class Connect_Four extends Kids{
    public Connect_Four(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type);       
    }
}
