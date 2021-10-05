import java.util.*;

public class StackByWidthDec implements StackBehaviour{

    @Override
    public void stack(List<Games> shelf) {
        Comparator<Games> compareByWidth = (Games o1, Games o2) -> o1.width.compareTo( o2.width );//sets comparator to comapre pile heights
        Collections.sort(shelf, compareByWidth.reversed());  //sorts shelf based on pile height
        for (int i = 0; i < shelf.size(); i++){
            System.out.println("Burt stacks " + shelf.get(i).inventory + " " + shelf.get(i).game_name + " games in shelf position " + (i+1) + ". Game width is: " + shelf.get(i).width + "\"");
        }
    }
}