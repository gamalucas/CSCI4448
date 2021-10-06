import java.util.*;

/**
Class that implements StackBehaviour for the implementation of the STRATEGY Pattern. This implements the stack behaviour of Ernie
 */
public class StackByHeight implements StackBehaviour{

    @Override
    public void stack(List<Games> shelf) {
        for (int i = 0; i < shelf.size(); i++){
            shelf.get(i).pile_height = shelf.get(i).height * shelf.get(i).inventory; //determines the pile height of each game to be stacked
        } 
        Comparator<Games> compareByPH = (Games o1, Games o2) -> o1.pile_height.compareTo( o2.pile_height ); //sets comparator to comapre pile heights
        Collections.sort(shelf, compareByPH); //sorts shelf based on pile height
    }
}