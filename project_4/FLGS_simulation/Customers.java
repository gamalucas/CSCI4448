public abstract class Customers {
    String name;

    public Customers(String name){
        this.name = name;
    }
}

class Family_Gamer extends Customers{
    public Family_Gamer(String name){
        super(name);
    }
}

class Kid_Gamer extends Customers{
    public Kid_Gamer(String name){
        super(name);
    }
}

class Card_Gamer extends Customers{
    public Card_Gamer(String name){
        super(name);
    }
}

class Board_Gamer extends Customers{
    public Board_Gamer(String name){
        super(name);
    }
}

class Cookie_Monster extends Customers{
    public Cookie_Monster(String name){
        super(name);
    }
}
