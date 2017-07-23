package db;

import domain.Player;
import exception.DatabaseException;
import java.util.List;

/**
 *
 * @author Dries
 */
public abstract class PlayerDatabase {
    
    public abstract List<Player> getPlayers() throws DatabaseException;
    public abstract Player getPlayer(Long id) throws DatabaseException;
    public abstract void addPlayer(Player player) throws DatabaseException;
    public abstract void removePlayer(Long id) throws DatabaseException;
    public abstract void updatePlayer(Player player) throws DatabaseException;
    
}
