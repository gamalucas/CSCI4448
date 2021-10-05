import java.util.*;

public class StackByBart implements StackBehaviour{

    @Override
    public void stack(List<Games> shelf) {
        Comparator<Games> compareByWidth = (Games o1, Games o2) -> o1.width.compareTo( o2.width );//sets comparator to comapre pile heights
        Collections.sort(shelf, compareByWidth.reversed());  //sorts shelf based on pile height
        int ones = 0;
        for (int i = 0; i < shelf.size(); i++){
            if (shelf.get(i).inventory == 1){
                ones++;
            }
            // System.out.println("Bart stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
        }
        for(int j = 0 ; j < ones; j++){
            for (int i = 0; i < shelf.size(); i++){
                if (shelf.get(i).inventory == 1 && i < shelf.size()-1){
                    Games temp = shelf.get(i);
                    shelf.set(i, shelf.get(i+1));
                    shelf.set(i+1, temp);
                }
            }
        }
        for (int i = 0; i < shelf.size(); i++){
            System.out.println("Bart stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
        }
    }
}