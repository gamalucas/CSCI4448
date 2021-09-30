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
    String game_type;
}

abstract class PurchaseDecorator extends Games{
    public abstract double addSubProductCost(); //this is saying that all other decorator classes must implement a fucntion to add a sub product/
    
}

class TokenDecorator extends PurchaseDecorator{
    Games game; //holding a reference to the game object 

    public TokenDecorator(Games game){
        this.game = game; //whenever this constructor is being used, we are taking a already existed game (Monopoly in this case). This is our base obj and we are holding a reference to it
        addSubProductCost();
    }

    public double addSubProductCost(){
        return game.price + 5.59; //increase monopoly price upon token buy request
    }
}


class SpecialCardDecorator extends PurchaseDecorator{
    Games game; //holding a reference to the game object 

    public SpecialCardDecorator(Games game){
        this.game = game; //whenever this constructor is being used, we are taking a already existed game (Monopoly in this case). This is our base obj and we are holding a reference to it
        addSubProductCost();
    }

    public double addSubProductCost(){
        int num = Utility.getRandomNumber(1,7);
        System.out.println("CARDSSSSSSS: " + game.price);
        game.price += (9.99 * num); //increase monopoly price upon token buy request
        System.out.println("CARDSSSSSSS22222222222222: " + game.price);
        return 1.0;


    }
}
