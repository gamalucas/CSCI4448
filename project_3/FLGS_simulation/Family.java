/**
Family is a class that inherits from Games and is responsible for keeping track of the attributes of the Family games
This is an example of INHERITANCE   
 */

class Family extends Games{
    
    public Family(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival){
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
    }
}


class Monopoly extends Family{
    public Monopoly(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival);       
    }
}

class Clue extends Family{
    public Clue(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival);       
    }
}

class Life extends Family{
    public Life(double price, double height, double width, double lenght, int inventory, int units_sold, int shelf_position, String game_name, double pile_height, int games_arrival){
        super(price, height, width, lenght, inventory, units_sold, shelf_position, game_name, pile_height, games_arrival);       
    }
}
