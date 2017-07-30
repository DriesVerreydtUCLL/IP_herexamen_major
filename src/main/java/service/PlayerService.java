package service;

import db.PlayerDatabase;
import db.DatabaseFactory;
import domain.Player;
import exception.DatabaseException;
import exception.ServiceException;
import java.util.List;

/**
 *
 * @author Dries
 */
public class PlayerService {
    
    private PlayerDatabase db;
    
    public PlayerService(String dbType) throws ServiceException{
        try {
            db = DatabaseFactory.getDatabase(dbType);
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }
    
    public List<Player> getPlayers() throws ServiceException {
        try {
            List<Player> players = db.getPlayers();
            return players;
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }
    
    public Player getPlayer(Long id) throws ServiceException {
        try {
            Player player = db.getPlayer(id);
            return player;
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }
    
    public void addPlayer(Player player) throws ServiceException {
        try{
            db.addPlayer(player);
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }
    
    public void removePlayer(Long id) throws ServiceException {
        try{
            db.removePlayer(id);
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
        }
    }
    
    public void updatePlayer(Player player) throws ServiceException {
        try{
            db.updatePlayer(player);
        } catch (DatabaseException e){
            throw new ServiceException(e.getMessage(),e);
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
