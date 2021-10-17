public class Customer_Creator extends Customers_Creator_abs{
    @Override
    protected Customers create_customer(String type){
        if (type.equals("Family_Gamer")){
            return new Family_Gamer("name", 30);
        }
    }
}