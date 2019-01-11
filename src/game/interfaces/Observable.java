package game.interfaces;

public interface Observable {

    void addObserver(Observer observer);

    void removeObservers(Observer observer);

    void updateObservers();
}
