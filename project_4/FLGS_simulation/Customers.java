import java.io.*;
import java.util.*;

/**
Class is part of the FACTORY PATTERN
creates attributes shared by multiple types of customers
 */
public abstract class Customers {
    String name, type;
    String game0, game10, game20 = "";
    List<String> family_list = new ArrayList();
    List<String> kid_list = new ArrayList();
    List<String> card_list = new ArrayList();
    List<String> board_list = new ArrayList();

    public String give_name(){
        String name = Store.find_name();
        return name;
    }
}

/**
Class is responsible for creating the Family Gamer type of customer
Shuffle a list that contains the name of the games of each category to randomly assign each a different bonus probability
 */
class Family_Gamer extends Customers{
    public Family_Gamer(){
        family_list.add("Monopoly");
        family_list.add("Clue");
        family_list.add("Life");
        Collections.shuffle(family_list);
        name = give_name();
        type = "Family";
        game0 = family_list.get(0); // 0% bonus probability of buying the game
        game10 = family_list.get(1); // 10% bonus probability of buying the game
        game20 = family_list.get(2); // 20% bonus probability of buying the game
    }
    
}

/**
Class is responsible for creating the Kid Gamer type of customer
Shuffle a list that contains the name of the games of each category to randomly assign each a different bonus probability
 */
class Kid_Gamer extends Customers{
    public Kid_Gamer(){
        kid_list.add("Mousetrap");
        kid_list.add("Candyland");
        kid_list.add("Connect Four");
        Collections.shuffle(kid_list);
        name = give_name();
        type = "Kids";
        game0 = kid_list.get(0); // 0% bonus probability of buying the game
        game10 = kid_list.get(1); // 10% bonus probability of buying the game
        game20 = kid_list.get(2); // 20% bonus probability of buying the game
    }
}

/**
Class is responsible for creating the Card Gamer type of customer
Shuffle a list that contains the name of the games of each category to randomly assign each a different bonus probability
 */
class Card_Gamer extends Customers{
    public Card_Gamer(){
        card_list.add("Magic");
        card_list.add("Pokémon");
        card_list.add("Netrunner");
        Collections.shuffle(card_list);
        name = give_name();
        type = "Card";
        game0 = card_list.get(0); // 0% bonus probability of buying the game
        game10 = card_list.get(1); // 10% bonus probability of buying the game
        game20 = card_list.get(2); // 20% bonus probability of buying the game
    }
}

/**
Class is responsible for creating the Board Gamer type of customer
Shuffle a list that contains the name of the games of each category to randomly assign each a different bonus probability
 */
class Board_Gamer extends Customers{
    public Board_Gamer(){
        board_list.add("Catan");
        board_list.add("Risk");
        board_list.add("Gloomhaven");
        Collections.shuffle(board_list);
        name = give_name();
        type = "Board";
        game0 = board_list.get(0); // 0% bonus probability of buying the game
        game10 = board_list.get(1); // 10% bonus probability of buying the game
        game20 = board_list.get(2); // 20% bonus probability of buying the game
    }
}

/**
Class is responsible for creating the Cookie Monster type of customer
 */
class Cookie_Monster extends Customers{
    public Cookie_Monster(){
        name = "CoOkIe MoNstEr";
        type = "Cookie Monster";
    }
}
