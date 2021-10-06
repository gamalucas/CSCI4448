public class Main{
    public static void main(String args[]){
        Store FLGS = new Store();
        for (int i = 1; i <= 30; i++){
            FLGS.start_day();
            System.out.println("=====================================");
            System.out.println();
        }
        FLGS.printMessages();
    }
}
