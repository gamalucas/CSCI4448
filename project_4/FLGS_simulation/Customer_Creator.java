public class Customer_Creator extends Customers_Creator_abs{
    @Override
    protected Customers create_customer(String type){
        if (type.equals("Family_Gamer")){
            return new Family_Gamer();
        }
        else if(type.equals("Kid_Gamer")){
            return new Kid_Gamer();
        }
        else if(type.equals("Card_Gamer")){
            return new Card_Gamer();
        }
        else if(type.equals("Board_Gamer")){
            return new Board_Gamer();
        }
        else if(type.equals("Cookie_Monster")){
            return new Cookie_Monster();
        }
        else {
            return null;
        }
    }
}