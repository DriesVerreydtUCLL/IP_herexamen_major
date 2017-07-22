package service;

import db.Database;
import db.DatabaseFactory;
import domain.Player;
import exception.DatabaseException;
import exception.ServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dries
 */
public class PlayerService {
    
    private Database db;
    
    public PlayerService(String dbType) throws ServiceException{
        try {
            db = DatabaseFactory.getDatabase(dbType);
        } catch (DatabaseException e){
            throw new ServiceException("Error while setting up the service database.",e);
        }
    }
    
    public List<Player> getPlayers() throws ServiceException {
        List<Player> players = new ArrayList<>();
        try {
            players = db.getPlayers();
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
        return players;
    }
    
    public void addPlayer(Player player) throws ServiceException {
        try{
            db.addPlayer(player);
        } catch (DatabaseException e){
            throw new ServiceException("Error while adding player in the database.",e);
        }
    }
    
    public void removePlayer(Long id) throws ServiceException {
        try{
            db.removePlayer(id);
        } catch (DatabaseException e){
            throw new ServiceException("Error while removing player in the database.",e);
        }
    }
    
    public void updatePlayer(Player player) throws ServiceException {
        try{
            db.updatePlayer(player);
        } catch (DatabaseException e){
            throw new ServiceException("Error while updating player in the database.",e);
        }
    }
    
    public double getAvgGoals() throws ServiceException {
        List<Player> players = getPlayers();
        int goals = 0;
        int numberOfPlayers = players.size();
        double avgGoals = 0.0;
        for(Player p : players){
            goals += p.getGoals();
        }
        if(numberOfPlayers != 0){
            avgGoals = goals / numberOfPlayers;
        }
        return avgGoals;
    }
    
    public Player getTopScorer() throws ServiceException {
        List<Player> players = getPlayers();
        Player topScorer = null;
        int maxGoals = 0;
        for(Player p : players){
            if(p.getGoals() > maxGoals){
                topScorer = p;
                maxGoals = p.getGoals();
            }
        }
        return topScorer;
    }
}
