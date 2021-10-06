/**
Card is a class that inherits from Games and is responsible for keeping track of the attributes of the card games
This is an example of INHERITANCE   
 */

class Card extends Games{
    
    public Card(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type, double add_on_price){
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
        this.add_on_price = add_on_price;
    }
}


class Magic extends Card{
    public Magic(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type, double add_on_price){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type, add_on_price);       
    }
}

class Pokemon extends Card{
    public Pokemon(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type, double add_on_price){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type, add_on_price);       
    }
}

class Netrunner extends Card{
    public Netrunner(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival, String game_type, double add_on_price){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival, game_type, add_on_price);       
    }
}

