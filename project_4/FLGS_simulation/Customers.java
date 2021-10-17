public abstract class Customers {
    String name;
    int chance_to_appear;

    public Customers(String name, int chance_to_appear){
        this.name = name;
        this.chance_to_appear = chance_to_appear;
    }
}

class Family_Gamer extends Customers{
    public Family_Gamer(String name, int chance_to_appear){
        super(name, chance_to_appear);
    }
}

class Kid_Gamer extends Customers{
    public Kid_Gamer(String name, int chance_to_appear){
        super(name, chance_to_appear);
    }
}

class Card_Gamer extends Customers{
    public Card_Gamer(String name, int chance_to_appear){
        super(name, chance_to_appear);
    }
}

class Board_Gamer extends Customers{
    public Board_Gamer(String name, int chance_to_appear){
        super(name, chance_to_appear);
    }
}

class Cookie_Monster extends Customers{
    public Cookie_Monster(String name, int chance_to_appear){
        super(name, chance_to_appear);
    }
}
