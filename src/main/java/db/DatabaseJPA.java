package db;

import domain.Player;
import exception.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dries
 */
public class DatabaseJPA extends PlayerDatabase {
    
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    
    public DatabaseJPA() throws DatabaseException {
        entityManagerFactory = Persistence.createEntityManagerFactory("PlayerPU");
        entityManager = entityManagerFactory.createEntityManager();
        try {
            Player hazard = new Player("Eden","Hazard",10,5);
            Player debruyne = new Player("Kevin","De Bruyne",7,3);
            Player nainggolan = new Player("Radja","Nainggolan",4,1);
            Player vertonghen = new Player("Jan","Vertonghen",5,1);
            Player courtois = new Player("Thibaut","Courtois",1,0);
            
            addPlayer(hazard);
            addPlayer(debruyne);
            addPlayer(nainggolan);
            addPlayer(vertonghen);
            addPlayer(courtois);
            
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
    }
    private void openConnection(){
        //entityManager = entityManagerFactory.createEntityManager();
    }
    
    private void closeConnection() throws DatabaseException {
        try {
            //entityManager.close();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
    }
    
    @Override
    public List<Player> getPlayers() throws DatabaseException {
        List<Player> players = new ArrayList<>();
        try {
            openConnection();
            players = entityManager.createQuery("Select p from Player p", Player.class).getResultList();
            closeConnection();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
        return players;
    }

    @Override
    public Player getPlayer(Long id) throws DatabaseException {
        Player player;
        try {
            openConnection();
            TypedQuery<Player> q = entityManager.createQuery("Select p from Player p WHERE p.id =?1",Player.class);
            player = q.setParameter(1, id).getSingleResult();
            closeConnection();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
        return player;
    }

    @Override
    public void addPlayer(Player player) throws DatabaseException {
        try {
            openConnection();
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.flush();
            entityManager.getTransaction().commit();
            closeConnection();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
    }

    @Override
    public void removePlayer(Long id) throws DatabaseException {
         try {
            openConnection();
            entityManager.getTransaction().begin();
            Player player = getPlayer(id);
            entityManager.remove(player);
            entityManager.flush();
            entityManager.getTransaction().commit();
            closeConnection();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
    }

    @Override
    public void updatePlayer(Player player) throws DatabaseException {
         try {
            openConnection();
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.flush();
            entityManager.getTransaction().commit();
            closeConnection();
        } catch (Exception e){
            throw new DatabaseException(e.getMessage(),e);
        }
    }
    
}
