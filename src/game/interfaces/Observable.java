package game.interfaces;

public interface Observable {

    /**
     * Method for add Observers
     * @param observer Class implement intetrface Observer
     */
    void addObserver(Observer observer);

    /**
     * Method for remove Observers
     * @param observer Class implement intetrface Observer
     */
    void removeObservers(Observer observer);

    /**
     * Method for update Observers
     */
    void updateObservers();
}
