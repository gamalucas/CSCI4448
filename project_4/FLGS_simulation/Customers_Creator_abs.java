public abstract class Customers_Creator_abs {
    public Customers takeCustomers(String type){
        Customers customer = create_customer(type);
        return customer;
    }

    protected abstract Customers create_customer(String type);
}
