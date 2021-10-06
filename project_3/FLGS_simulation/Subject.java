/*
    This class is an exmaple of OBSERVER pattern. 
*/

public interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver();
    public void notifyObservers(String announcement);
    
}
