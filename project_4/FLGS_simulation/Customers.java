public abstract class Customers {
    String name;
    String type;
    int bonus = 0;
    

    // public Customers(){
    //     this.name = name;
    // }
    public String give_name(){
        String name = Store.find_name();
        return name;
    }
}

class Family_Gamer extends Customers{
    public Family_Gamer(){
        name = give_name();
        type = "Family Gamer";
    }
}

class Kid_Gamer extends Customers{
    public Kid_Gamer(){
        name = give_name();
        type = "Kid Gamer";
    }
}

class Card_Gamer extends Customers{
    public Card_Gamer(){
        name = give_name();
        type = "Card Gamer";
    }
}

class Board_Gamer extends Customers{
    public Board_Gamer(){
        name = give_name();
        type = "Board Gamer";
    }
}

class Cookie_Monster extends Customers{
    public Cookie_Monster(){
        name = "CoOkIe MoNstEr";
        type = "Cookie Monster";
    }
}
