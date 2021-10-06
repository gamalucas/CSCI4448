/**
 * Class to keep track of the cookies
 */

public class Cookies{
    int cookies_in_store;
    int cookies_package_order;
    double price;
    int[] cookie_tracker;
    int cookies_stolen;

    public Cookies(){
        cookies_in_store = 0;
        cookies_package_order = 1;
        price = 6.0;
        cookie_tracker = new int[31];
        cookies_stolen = 0;
    }
}

