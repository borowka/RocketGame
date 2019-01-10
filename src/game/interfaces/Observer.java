package game.interfaces;

import game.data.MovementStateHolder;

public interface Observer {

    void update(MovementStateHolder movementStateHolder);
}
