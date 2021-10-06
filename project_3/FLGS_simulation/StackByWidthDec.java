import java.util.*;


/**
Class that implements StackBehaviour for the implementation of the STRATEGY Pattern. This implements the stack behaviour of Burt
 */
public class StackByWidthDec implements StackBehaviour{

    @Override
    public void stack(List<Games> shelf) {
        Comparator<Games> compareByWidth = (Games o1, Games o2) -> o1.width.compareTo( o2.width );//sets comparator to comapre pile heights
        Collections.sort(shelf, compareByWidth.reversed());  //sorts shelf based on pile height
    }
}