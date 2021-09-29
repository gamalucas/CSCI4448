import java.util.List;

/**
Games is a class responsible for keeping track of the attributes of each game
This is an example of ABSTRACTION. This class holds general charcteristcs from all games and, therefore, we opted for making it an ABSTRACT class and will not be instanciated.
 */
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
    Double total_sales;
}

abstract class PurchaseDecorator extends Games{
    public void addSubProduct(){
        
    }
    
}

class TokenDecorator extends PurchaseDecorator{
    Games game;

    public TokenDecorator(Games game){
        this.game = game;
    }

    public double price(){
        return game.price + 5.55;
    }
}
