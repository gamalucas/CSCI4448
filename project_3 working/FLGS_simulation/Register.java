/**
Register is a class responsible for keeping track of the attributes of the register.
This is an example of COHESION because it has one clearly defined purpose, which is to create and keep in track of the attributes in resgister. 
*/

public class Register {
    
    double balance;
    int times_added;

    public Register(){
        balance = 0;
        times_added = 0;
    }
}